package com.github.pimg.dataformat;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Base58 implements Dataformat{
	//https://tools.ietf.org/id/draft-msporny-base58-01.html
	//https://github.com/bitcoinj/bitcoinj/blob/master/core/src/main/java/org/bitcoinj/core/Base58.java
	//https://medium.com/concerning-pharo/understanding-base58-encoding-23e673e37ff6
	//https://learnmeabitcoin.com/technical/base58

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
//		byte[] fullDecodedBytes = Arrays.copyOf(decodedBytes, decodedBytes.length + leadingZeroCount);
		byte[] fullDecodedBytes = new byte[decodedBytes.length + leadingZeroCount];
		for (int i = 0; i < leadingZeroCount; i++) {
			fullDecodedBytes[i] = (byte)0x0;
		}
		for (int i = leadingZeroCount; i<fullDecodedBytes.length; i++) {
			fullDecodedBytes[i] = decodedBytes[i-leadingZeroCount];
		}
		return fullDecodedBytes;
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
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(bytes);
		return decode(stringBuffer.toString());
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
