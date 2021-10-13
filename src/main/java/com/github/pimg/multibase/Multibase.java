package com.github.pimg.multibase;


import com.github.pimg.multibase.dataformat.Base58;
import com.github.pimg.multibase.dataformat.Base64;
import com.github.pimg.multibase.dataformat.Base64Url;
import com.github.pimg.multibase.encoder.DataDecoder;
import com.github.pimg.multibase.encoder.DataEncoder;

public class Multibase {

	public static Encoder getBase64Encoder() {
		return new Encoder(new Base64());
	}

	public static Decoder getBase64Decoder() {
		return new Decoder(new Base64());
	}

	public static Encoder getBase64UrlEncoder() {
		return new Encoder(new Base64Url());
	}

	public static Decoder getBase64UrlDecoder() {
		return new Decoder(new Base64Url());
	}

	public static Encoder getBase58Encoder() {
		return new Encoder(new Base58());
	}

	public static Decoder getBase58Decoder() {
		return new Decoder(new Base58());
	}

	public static class Encoder implements DataEncoder {

		private final DataEncoder dataEncoder;

		private Encoder(DataEncoder dataEncoder) {
			this.dataEncoder = dataEncoder;
		}

		@Override
		public String encodeToString(byte[] bytes) {
			if (bytes == null || bytes.length < 1) {
				throw new IllegalArgumentException();
			}

			return dataEncoder.encodeToString(bytes);
		}

		@Override
		public byte[] encode(byte[] bytes) {
			if (bytes == null || bytes.length < 1) {
				throw new IllegalArgumentException();
			}

			return dataEncoder.encode(bytes);
		}
	}

	//TODO migrate Multibase prefix to this level to make the implementations pure encodings
	public static class Decoder implements DataDecoder {

		private final DataDecoder dataDecoder;
		//TODO private final String prefix;

		private Decoder(DataDecoder dataDecoder) {
			this.dataDecoder = dataDecoder;
		}

		@Override
		public byte[] decode(String string) {
			if (string == null || string.isEmpty()) {
				throw new IllegalArgumentException();
			}

			return dataDecoder.decode(string);
		}

		@Override
		public byte[] decode(byte[] bytes) {
			if (bytes == null || bytes.length < 1) {
				throw new IllegalArgumentException();
			}

			return dataDecoder.decode(bytes);
		}
	}

}


