package com.github.pimg.dataformat;

import java.math.BigInteger;

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
	public String encodeToString(byte[] bytes) {

		String encodingBuffer = new String();
		BigInteger bigInteger = new BigInteger(bytes);

		while(bigInteger.compareTo(BigInteger.ZERO) > 0) {
			BigInteger remainder = bigInteger.mod(BigInteger.valueOf(58));
			bigInteger = bigInteger.divide(BigInteger.valueOf(58));
			encodingBuffer = ALPHABET[remainder.intValue()] + encodingBuffer;
		}

		for (byte bt:bytes) {
			if(bt == 0x0){
				encodingBuffer = ALPHABET[0] + encodingBuffer;
			} else {
				break;
			}
		}

		return encodingBuffer;
	}


	@Override
	public byte[] encode(byte[] bytes) {
		return new byte[0];
	}
}
