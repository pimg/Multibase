package com.github.pimg;

import com.github.pimg.multibase.Multibase;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HexTest {

	@Test
	void testEncodeString() {
		String testStr = "Foo";
		String hexEncodedString = Multibase.HEX.getEncoder().encodeToString(testStr.getBytes(StandardCharsets.UTF_8));
		assertEquals("f466f6f", hexEncodedString);
	}

	@Test
	void testEncodeFullAlphabetString() {
		String testStr = "The quick brown fox jumps over the lazy dog.";
		String hexEncodedString = Multibase.HEX.getEncoder().encodeToString(testStr.getBytes(StandardCharsets.UTF_8));
		assertEquals("f54686520717569636b2062726f776e20666f78206a756d7073206f76657220746865206c617a7920646f672e", hexEncodedString);
	}

	@Test
	void testEncodeByteArr() {
		String testStr = "Foo";
		byte[] hexEncodedByteArr = Multibase.HEX.getEncoder().encode(testStr.getBytes(StandardCharsets.UTF_8));
		assertArrayEquals("f466f6f".getBytes(StandardCharsets.UTF_8), hexEncodedByteArr);
	}

	@Test
	void testDecodeString() {
		String testHexStr = "f466f6f";
		byte[] decodedByteArr = Multibase.HEX.getDecoder().decode(testHexStr);
		assertArrayEquals("Foo".getBytes(StandardCharsets.UTF_8), decodedByteArr);

	}

}
