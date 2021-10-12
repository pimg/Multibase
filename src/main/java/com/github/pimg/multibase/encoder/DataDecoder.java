package com.github.pimg.multibase.encoder;

public interface DataDecoder {
	public byte[] decode(String string);
	public byte[] decode(byte[] bytes);
}
