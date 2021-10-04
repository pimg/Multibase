package com.github.pimg.dataformat;

public class Base64  implements Dataformat {
	@Override
	public byte[] decode(String string) {
		return java.util.Base64.getDecoder().decode(string.substring(1));
	}

	@Override
	public String encode(byte[] bytes) {
		return "m" + java.util.Base64.getEncoder().encodeToString(bytes);
	}

}
