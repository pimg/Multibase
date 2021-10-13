package com.github.pimg;

import com.github.pimg.multibase.Multibase;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HexTest {

	@Test
	public void testEncodeString() {
		String testStr = "Foo";
		String hexEncodedString = Multibase.getHexEncoder().encodeToString(testStr.getBytes(StandardCharsets.US_ASCII));
		assertEquals("f466f6f", hexEncodedString);
	}

	@Test
	public void testEncodeFullAlphabetString() {
		String testStr = "The quick brown fox jumps over the lazy dog.";
		String hexEncodedString = Multibase.getHexEncoder().encodeToString(testStr.getBytes(StandardCharsets.US_ASCII));
		assertEquals("f54686520717569636b2062726f776e20666f78206a756d7073206f76657220746865206c617a7920646f672e", hexEncodedString);
	}

	@Test
	public void testEncodeByteArr() {
		String testStr = "Foo";
		byte[] hexEncodedByteArr = Multibase.getHexEncoder().encode(testStr.getBytes(StandardCharsets.US_ASCII));
		assertArrayEquals("f466f6f".getBytes(StandardCharsets.US_ASCII), hexEncodedByteArr);
	}

	@Test
	public void testDecodeString() {
		String testHexStr = "f466f6f";
		byte[] decodedByteArr = Multibase.getHexDecoder().decode(testHexStr);
		assertArrayEquals("Foo".getBytes(StandardCharsets.US_ASCII), decodedByteArr);

	}

}
