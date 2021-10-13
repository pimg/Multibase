package com.github.pimg.multibase.dataformat;

import com.github.pimg.multibase.dataformat.util.MultibaseBytes;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Base64Url implements Dataformat{
	@Override
	public byte[] decode(String string) {
		return java.util.Base64.getUrlDecoder().decode(string);
	}

	@Override
	public byte[] decode(byte[] bytes) {
		return java.util.Base64.getUrlDecoder().decode(bytes);
	}

	@Override
	public String encodeToString(byte[] bytes) {
		return java.util.Base64.getUrlEncoder().encodeToString(bytes);
	}

	@Override
	public byte[] encode(byte[] bytes) {
		return java.util.Base64.getUrlEncoder().encode(bytes);
	}
}
