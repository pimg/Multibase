package com.github.pimg.dataformat;

import com.github.pimg.encoder.DataDecoder;
import com.github.pimg.encoder.DataEncoder;

public class Base64  implements DataEncoder, DataDecoder {

	@Override
	public String encode(byte[] bytes) {
		return "m" + java.util.Base64.getEncoder().encodeToString(bytes);
	}


	@Override
	public byte[] decode(String string) {
		return java.util.Base64.getDecoder().decode(string.substring(1));
	}
}
