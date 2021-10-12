package com.github.pimg.multibase.encoder;

public interface DataEncoder {
	public String encodeToString(byte[] bytes);
	public byte[] encode(byte[] bytes);
}
