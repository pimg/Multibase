package com.github.pimg.dataformat;

public class Base58 implements Dataformat{


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
		//https://tools.ietf.org/id/draft-msporny-base58-01.html
		//https://github.com/bitcoinj/bitcoinj/blob/master/core/src/main/java/org/bitcoinj/core/Base58.java
		//https://medium.com/concerning-pharo/understanding-base58-encoding-23e673e37ff6
		char[] ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();
		int zeroCounter = 0;
//		byte encodingFlag = (byte)0x0;
		Boolean encodingFlag = false;
		for (byte bt: bytes) {
			if (!encodingFlag && bt == 0x0) {
				System.out.println("found leading zero.");
				zeroCounter++;
			} else {
				encodingFlag = true;
				System.out.println("no leading zero found.");
			}

		}
		System.out.println("Zero counter: " + zeroCounter);
		return null;
	}

	@Override
	public byte[] encode(byte[] bytes) {
		return new byte[0];
	}
}
