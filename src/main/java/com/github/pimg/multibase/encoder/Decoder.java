package com.github.pimg.multibase.encoder;

import com.github.pimg.multibase.encoder.DataDecoder;

import java.util.Arrays;

public class Decoder implements DataDecoder {

	private final DataDecoder dataDecoder;

	public Decoder(DataDecoder dataDecoder) {
		this.dataDecoder = dataDecoder;
	}

	@Override
	public byte[] decode(String string) {
		if (string == null || string.isEmpty()) {
			throw new IllegalArgumentException();
		}

		return dataDecoder.decode(string.substring(1));
	}

	@Override
	public byte[] decode(byte[] bytes) {
		if (bytes == null || bytes.length < 1) {
			throw new IllegalArgumentException();
		}

		return dataDecoder.decode(Arrays.copyOfRange(bytes, 1, bytes.length));
	}
}
