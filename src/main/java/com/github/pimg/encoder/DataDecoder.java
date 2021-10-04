package com.github.pimg.encoder;

public interface DataDecoder {
	public byte[] decode(String string);
	public byte[] decode(byte[] bytes);
}
