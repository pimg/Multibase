package com.github.pimg.multibase;


import com.github.pimg.multibase.dataformat.Base58;
import com.github.pimg.multibase.dataformat.Base64;
import com.github.pimg.multibase.dataformat.Base64Url;
import com.github.pimg.multibase.dataformat.Hex;
import com.github.pimg.multibase.dataformat.util.MultibaseBytes;
import com.github.pimg.multibase.encoder.DataDecoder;
import com.github.pimg.multibase.encoder.DataEncoder;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Multibase {

	public static Encoder getBase64Encoder() {
		return new Encoder(new Base64(), MultibaseEncodings.BASE64.toString());
	}

	public static Decoder getBase64Decoder() {
		return new Decoder(new Base64());
	}

	public static Encoder getBase64UrlEncoder() {
		return new Encoder(new Base64Url(), MultibaseEncodings.BASE64_URL.toString());
	}

	public static Decoder getBase64UrlDecoder() {
		return new Decoder(new Base64Url());
	}

	public static Encoder getBase58Encoder() {
		return new Encoder(new Base58(), MultibaseEncodings.BASE58.toString());
	}

	public static Decoder getBase58Decoder() {
		return new Decoder(new Base58());
	}

	public static Encoder getHexEncoder() {
		return new Encoder(new Hex(), MultibaseEncodings.HEX.toString());
	}

	public static Decoder getHexDecoder() {
		return new Decoder(new Hex());
	}

	public static class Encoder implements DataEncoder {

		private final DataEncoder dataEncoder;
		private final String prefix;

		private Encoder(DataEncoder dataEncoder, String prefix) {
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

	public static class Decoder implements DataDecoder {

		private final DataDecoder dataDecoder;

		private Decoder(DataDecoder dataDecoder) {
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

}


