package com.github.pimg.multibase;

public enum MultibaseEncodings {
	BASE64("m"),
	BASE64_URL("u"),
	BASE58("z"),
	HEX("f");

	private final String prefixString;

	MultibaseEncodings(String prefixString) {
		this.prefixString = prefixString;
	}

	@Override
	public String toString() {
		return this.prefixString;
	}

}
