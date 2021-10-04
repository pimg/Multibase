package com.github.pimg.encoder;

public interface DataEncoder {
	public String encodeToString(byte[] bytes);
	public byte[] encode(byte[] bytes);
}
