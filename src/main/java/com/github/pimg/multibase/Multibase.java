package com.github.pimg.multibase;

import com.github.pimg.multibase.dataformat.*;
import com.github.pimg.multibase.encoder.Decoder;
import com.github.pimg.multibase.encoder.Encoder;

public enum Multibase {
	BASE64(new Base64(), "m"),
	BASE64_URL(new Base64Url(), "u"),
	BASE58(new Base58(), "z"),
	HEX(new Hex(), "f"),

	OCTAL(new Octal(), "7");

	private final Dataformat dataformat;
	private final String prefixString;

	Multibase(Dataformat dataformat, String prefixString) {
		this.dataformat = dataformat;
		this.prefixString = prefixString;
	}

	public Decoder getDecoder() {
		return new Decoder(dataformat);
	}

	public Encoder getEncoder() {
		return new Encoder(dataformat, prefixString);
	}

}
