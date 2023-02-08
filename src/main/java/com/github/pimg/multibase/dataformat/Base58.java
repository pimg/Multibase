package com.github.pimg.multibase.dataformat;

import com.github.pimg.multibase.dataformat.util.MultibaseBytes;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Base58 implements Dataformat{

	private static final char[] ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();

	@Override
	public byte[] decode(String string) {
		char[] reversedCharacters = new StringBuilder(string).reverse().toString().toCharArray();

		BigInteger base10Buffer = convertToBase10(reversedCharacters);

		int leadingZeroCount = getLeadingZeroCount(string);
		byte[] decodedBytes;
		if(leadingZeroCount > 0) {
			decodedBytes = padDecodedBytesWithZeros(base10Buffer.toByteArray(), leadingZeroCount);
		} else {
			decodedBytes = base10Buffer.toByteArray();
		}

		return decodedBytes;
	}

	private BigInteger convertToBase10(char[] reversedCharacters) {
		BigInteger base10Buffer = BigInteger.ZERO;

		for (int i = 0; i < reversedCharacters.length; i++) {
			int index = Arrays.binarySearch(ALPHABET, reversedCharacters[i]);
			BigInteger base10Char = (BigInteger.valueOf(ALPHABET.length).pow(i)).multiply(BigInteger.valueOf(index));
			base10Buffer = base10Buffer.add(base10Char);
		}
		return base10Buffer;
	}

	private byte[] padDecodedBytesWithZeros(byte[] decodedBytes, int leadingZeroCount) {
		byte[] decodedZeroBytes = new byte[leadingZeroCount];
		for (int i = 0; i < leadingZeroCount; i++) {
			decodedZeroBytes[i] = (byte)0x0;
		}
		return MultibaseBytes.concatenateByteArrays(decodedZeroBytes,decodedBytes);
	}

	private int getLeadingZeroCount(String string) {
		int leadingZeroCount = 0;
		for (char letter: string.toCharArray()) {
			if(letter == '1') {
				leadingZeroCount++;
			} else {
				break;
			}
		}
		return leadingZeroCount;
	}

	@Override
	public byte[] decode(byte[] bytes) {

		return decode(new String(bytes));
	}

	@Override
	public byte[] encode(byte[] bytes) {
		return encodeToString(bytes).getBytes(StandardCharsets.UTF_8);
	}

	@Override
	public String encodeToString(byte[] bytes) {
		StringBuilder encodingBuffer = new StringBuilder();

		BigInteger base256Message = new BigInteger(bytes);

		encodeBase58(base256Message, encodingBuffer);

		encodeLeadingZeros(bytes, encodingBuffer);

		return encodingBuffer.toString();
	}

	private void encodeBase58(BigInteger base256Message, StringBuilder encodingBuffer) {
		BigInteger messageBuffer = base256Message;
		while(messageBuffer.compareTo(BigInteger.ZERO) > 0) {
			BigInteger remainder = messageBuffer.mod(BigInteger.valueOf(ALPHABET.length));
			messageBuffer = messageBuffer.divide(BigInteger.valueOf(ALPHABET.length));
			encodingBuffer.insert(0, ALPHABET[remainder.intValue()]);
		}
	}

	private void encodeLeadingZeros(byte[] bytes, StringBuilder encodingBuffer) {
		for (byte singleByte: bytes) {
			if(singleByte == 0x0){
				encodingBuffer.insert(0, ALPHABET[0]);
			} else {
				break;
			}
		}
	}

}
