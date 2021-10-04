package com.github.pimg.dataformat.util;

public class MultibaseBytes {
	public static byte[] createMultiBaseByteArr(byte[] prefixBytes, byte[] encodedBytes) {
		byte[] multibaseBytes = new byte[prefixBytes.length + encodedBytes.length];
		System.arraycopy(prefixBytes, 0, multibaseBytes, 0, prefixBytes.length);
		System.arraycopy(encodedBytes, 0, multibaseBytes, prefixBytes.length, encodedBytes.length);
		return multibaseBytes;
	}
}
