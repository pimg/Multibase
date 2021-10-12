package com.github.pimg.dataformat.util;

public class MultibaseBytes {
	public static byte[] concatenateByteArrays(byte[] prefixBytes, byte[] encodedBytes) {
		byte[] concatenatedBytes = new byte[prefixBytes.length + encodedBytes.length];
		System.arraycopy(prefixBytes, 0, concatenatedBytes, 0, prefixBytes.length);
		System.arraycopy(encodedBytes, 0, concatenatedBytes, prefixBytes.length, encodedBytes.length);
		return concatenatedBytes;
	}
}
