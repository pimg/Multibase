package com.github.pimg;

import com.github.pimg.multibase.encoder.Decoder;
import com.github.pimg.multibase.encoder.Encoder;
import com.github.pimg.multibase.Multibase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultibaseTest {

	@Test
	void testEncodeEmptyBytes() {
		Encoder encoder = Multibase.BASE58.getEncoder();
		assertThrows(IllegalArgumentException.class, () -> encoder.encodeToString(new byte[]{}));
	}

	@Test
	void testEncodeNull() {
		Encoder encoder = Multibase.BASE58.getEncoder();
		assertThrows(IllegalArgumentException.class, () -> encoder.encodeToString(null));
	}

	@Test
	void decodeNull() {
		String testString = null;
		Decoder decoder = Multibase.BASE64.getDecoder();
		assertThrows(IllegalArgumentException.class, () -> decoder.decode(testString));
	}

	@Test
	void decodeEmptyString() {
		Decoder decoder = Multibase.BASE64.getDecoder();
		assertThrows(IllegalArgumentException.class, () -> decoder.decode(""));
	}
}
