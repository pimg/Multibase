package com.github.pimg.multibase.dataformat;

public class Base64  implements Dataformat {
	@Override
	public byte[] decode(String string) {
		return java.util.Base64.getDecoder().decode(string);
	}

	@Override
	public byte[] decode(byte[] bytes) {
		return java.util.Base64.getDecoder().decode(bytes);
	}

	@Override
	public String encodeToString(byte[] bytes) {
		return java.util.Base64.getEncoder().encodeToString(bytes);
	}

	@Override
	public byte[] encode(byte[] bytes) {
		return java.util.Base64.getEncoder().encode(bytes);
	}

}
