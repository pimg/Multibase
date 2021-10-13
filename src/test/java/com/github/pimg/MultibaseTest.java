package com.github.pimg;

import com.github.pimg.multibase.Multibase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultibaseTest {

	@Test
	public void testEncodeEmptyBytes() {
		assertThrows(IllegalArgumentException.class, () -> Multibase.getBase58Encoder().encodeToString(new byte[]{}));
	}

	@Test
	public void testEncodeNull() {
		assertThrows(IllegalArgumentException.class, () -> Multibase.getBase58Encoder().encodeToString(null));
	}

	@Test
	public void decodeNull() {
		String testString = null;
		assertThrows(IllegalArgumentException.class, () -> Multibase.getBase64Decoder().decode(testString));
	}

	@Test
	public void decodeEmptyString() {
		assertThrows(IllegalArgumentException.class, () -> Multibase.getBase64Decoder().decode(""));
	}
}
