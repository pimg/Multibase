package com.github.pimg;


import com.github.pimg.dataformat.Base64;
import com.github.pimg.dataformat.Base64Url;
import com.github.pimg.encoder.DataDecoder;
import com.github.pimg.encoder.DataEncoder;

public class MultiBase {

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

	public static class Encoder implements DataEncoder{

		private final DataEncoder dataEncoder;

		private Encoder(DataEncoder dataEncoder) {
			this.dataEncoder = dataEncoder;
		}

		@Override
		public String encodeToString(byte[] bytes) {
			return dataEncoder.encodeToString(bytes);
		}

		@Override
		public byte[] encode(byte[] bytes) {
			return dataEncoder.encode(bytes);
		}
	}

	//TODO migrate Multibase prefix to this level to make the implementations pure encodings
	public static class Decoder implements DataDecoder{
		private final DataDecoder dataDecoder;
		//TODO private final String prefix;

		private Decoder(DataDecoder dataDecoder) {
			this.dataDecoder = dataDecoder;
		}

		@Override
		public byte[] decode(String string) {
			return dataDecoder.decode(string);
		}

		@Override
		public byte[] decode(byte[] bytes) {
			return dataDecoder.decode(bytes);
		}
	}


}


