package com.github.pimg.dataformat;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class Base58 implements Dataformat{
	//https://tools.ietf.org/id/draft-msporny-base58-01.html
	//https://github.com/bitcoinj/bitcoinj/blob/master/core/src/main/java/org/bitcoinj/core/Base58.java
	//https://medium.com/concerning-pharo/understanding-base58-encoding-23e673e37ff6
	//https://learnmeabitcoin.com/technical/base58

	private static final char[] ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();

	@Override
	public byte[] decode(String string) {
		return new byte[0];
	}

	@Override
	public byte[] decode(byte[] bytes) {
		return new byte[0];
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
			BigInteger remainder = messageBuffer.mod(BigInteger.valueOf(58));
			messageBuffer = messageBuffer.divide(BigInteger.valueOf(58));
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
