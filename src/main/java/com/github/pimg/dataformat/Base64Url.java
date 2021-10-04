package com.github.pimg.dataformat;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Base64Url implements Dataformat{
	@Override
	public byte[] decode(String string) {
		return java.util.Base64.getUrlDecoder().decode(string.substring(1));
	}

	@Override
	public byte[] decode(byte[] bytes) {
		return java.util.Base64.getUrlDecoder().decode(Arrays.copyOfRange(bytes, 1, bytes.length));
	}

	@Override
	public String encodeToString(byte[] bytes) {
		return "u" + java.util.Base64.getUrlEncoder().encodeToString(bytes);
	}

	@Override
	public byte[] encode(byte[] bytes) {
		byte[] base64Prefix = "m".getBytes(StandardCharsets.UTF_8);
		byte[] encodedBytes = java.util.Base64.getUrlEncoder().encode(bytes);
		byte[] multibaseBytes = new byte[base64Prefix.length + encodedBytes.length];
		System.arraycopy(base64Prefix, 0, multibaseBytes, 0, base64Prefix.length);
		System.arraycopy(encodedBytes, 0, multibaseBytes, base64Prefix.length, encodedBytes.length);
		return multibaseBytes;
	}
}
