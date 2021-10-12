package com.github.pimg.dataformat;

import com.github.pimg.dataformat.util.MultibaseBytes;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Base64  implements Dataformat {
	@Override
	public byte[] decode(String string) {
		return java.util.Base64.getDecoder().decode(string.substring(1));
	}

	@Override
	public byte[] decode(byte[] bytes) {
		return java.util.Base64.getDecoder().decode(Arrays.copyOfRange(bytes, 1, bytes.length));
	}

	@Override
	public String encodeToString(byte[] bytes) {
		return "m" + java.util.Base64.getEncoder().encodeToString(bytes);
	}

	@Override
	public byte[] encode(byte[] bytes) {
		byte[] base64Prefix = "m".getBytes(StandardCharsets.UTF_8);
		byte[] encodedBytes = java.util.Base64.getEncoder().encode(bytes);
		return MultibaseBytes.concatenateByteArrays(base64Prefix, encodedBytes);
	}

}
