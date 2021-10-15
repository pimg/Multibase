package com.github.pimg.multibase.dataformat.util;

public class MultibaseBytes {

	private MultibaseBytes() {
		throw new IllegalStateException("Methods should be accessed in a static way.");
	}

	public static byte[] concatenateByteArrays(byte[] prefixBytes, byte[] encodedBytes) {
		byte[] concatenatedBytes = new byte[prefixBytes.length + encodedBytes.length];
		System.arraycopy(prefixBytes, 0, concatenatedBytes, 0, prefixBytes.length);
		System.arraycopy(encodedBytes, 0, concatenatedBytes, prefixBytes.length, encodedBytes.length);
		return concatenatedBytes;
	}
}
