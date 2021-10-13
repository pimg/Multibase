package com.github.pimg.multibase.dataformat;

import java.nio.charset.StandardCharsets;

public class Hex implements Dataformat{

	@Override
	public byte[] decode(String string) {
		StringBuilder decodedBuffer = new StringBuilder();

		for (int i = 0; i < string.length(); i += 2) {
			String str = string.substring(i, i + 2);
			decodedBuffer.append((char) Integer.parseInt(str, 16));
		}

		return decodedBuffer.toString().getBytes(StandardCharsets.US_ASCII);
	}

	@Override
	public byte[] decode(byte[] bytes) {
		return decode(new String(bytes));
	}

	@Override
	public String encodeToString(byte[] bytes) {
		StringBuffer hexBuffer = new StringBuffer();
		for (byte singleByte:bytes) {
			hexBuffer.append(Integer.toHexString(singleByte));
		}
		return hexBuffer.toString();
	}

	@Override
	public byte[] encode(byte[] bytes) {
		return encodeToString(bytes).getBytes(StandardCharsets.UTF_8);
	}

}
