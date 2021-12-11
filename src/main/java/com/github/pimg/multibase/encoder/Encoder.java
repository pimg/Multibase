package com.github.pimg.multibase.encoder;

import com.github.pimg.multibase.dataformat.util.MultibaseBytes;

import java.nio.charset.StandardCharsets;

public class Encoder implements DataEncoder {

	private final DataEncoder dataEncoder;
	private final String prefix;

	public Encoder(DataEncoder dataEncoder, String prefix) {
		this.dataEncoder = dataEncoder;
		this.prefix = prefix;
	}

	@Override
	public String encodeToString(byte[] bytes) {
		if (bytes == null || bytes.length < 1) {
			throw new IllegalArgumentException();
		}

		return prefix + dataEncoder.encodeToString(bytes);
	}

	@Override
	public byte[] encode(byte[] bytes) {
		if (bytes == null || bytes.length < 1) {
			throw new IllegalArgumentException();
		}

		return MultibaseBytes.concatenateByteArrays(prefix.getBytes(StandardCharsets.US_ASCII), dataEncoder.encode(bytes));
	}
}
