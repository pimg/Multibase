package com.github.pimg;

import com.github.pimg.multibase.Multibase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultibaseTest {

	@Test
	void testEncodeEmptyBytes() {
		Multibase.Encoder encoder = Multibase.getBase58Encoder();
		assertThrows(IllegalArgumentException.class, () -> encoder.encodeToString(new byte[]{}));
	}

	@Test
	void testEncodeNull() {
		Multibase.Encoder encoder = Multibase.getBase58Encoder();
		assertThrows(IllegalArgumentException.class, () -> encoder.encodeToString(null));
	}

	@Test
	void decodeNull() {
		String testString = null;
		Multibase.Decoder decoder = Multibase.getBase64Decoder();
		assertThrows(IllegalArgumentException.class, () -> decoder.decode(testString));
	}

	@Test
	void decodeEmptyString() {
		Multibase.Decoder decoder = Multibase.getBase64Decoder();
		assertThrows(IllegalArgumentException.class, () -> decoder.decode(""));
	}
}
