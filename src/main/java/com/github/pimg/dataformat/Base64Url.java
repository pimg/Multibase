package com.github.pimg.dataformat;

public class Base64Url implements Dataformat{
	@Override
	public byte[] decode(String string) {
		return java.util.Base64.getUrlDecoder().decode(string.substring(1));
	}

	@Override
	public String encode(byte[] bytes) {
		return "u" + java.util.Base64.getUrlEncoder().encodeToString(bytes);
	}
}
