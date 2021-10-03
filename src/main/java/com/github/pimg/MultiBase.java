package com.github.pimg;


import com.github.pimg.dataformat.Base64;
import com.github.pimg.encoder.DataDecoder;
import com.github.pimg.encoder.DataEncoder;

public class MultiBase {

	public static Encoder getBase64Encoder() {
		return new Encoder(new Base64());
	}

	public static Decoder getBase64Decoder() {
		return new Decoder(new Base64());
	}

	public static class Encoder implements DataEncoder{

		private final DataEncoder dataEncoder;

		private Encoder(DataEncoder dataEncoder) {
			this.dataEncoder = dataEncoder;
		}

		@Override
		public String encode(byte[] bytes) {
			return dataEncoder.encode(bytes);
		}
	}

	public static class Decoder implements DataDecoder{
		private final DataDecoder dataDecoder;

		public Decoder(DataDecoder dataDecoder) {
			this.dataDecoder = dataDecoder;
		}

		@Override
		public byte[] decode(String string) {
			return dataDecoder.decode(string);
		}
	}


}


