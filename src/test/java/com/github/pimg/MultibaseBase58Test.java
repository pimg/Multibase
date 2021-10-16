package com.github.pimg;

import com.github.pimg.multibase.Multibase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MultibaseBase58Test {

	private static Stream<Arguments> provideParameters() {
		return Stream.of(
			Arguments.of("Foo", "zQfC2"),
			Arguments.of("Hello World!", "z2NEpo7TZRRrLZSi2U"),
			Arguments.of("The quick brown fox jumps over the lazy dog.", "zUSm3fpXnKG5EUBx2ndxBDMPVciP5hGey2Jh4NDv6gmeo1LkMeiKrLJUUBk6Z")
		);
	}

	@ParameterizedTest(name = "Encode base58 {0}")
	@MethodSource("provideParameters")
	void testBase58Encodeparameterized(String testStr, String expectedStr) {
		String encodedString = Multibase.BASE58.getEncoder().encodeToString(testStr.getBytes(StandardCharsets.US_ASCII));
		assertEquals(expectedStr, encodedString);
	}

	@Test
	void testBase58EncodeHelloWorldToByteArray() throws Exception {
		String testStr = "Hello World!";
		byte[] encodedBytes = Multibase.BASE58.getEncoder().encode(testStr.getBytes(StandardCharsets.US_ASCII));
		assertArrayEquals("z2NEpo7TZRRrLZSi2U".getBytes(StandardCharsets.US_ASCII), encodedBytes);
	}

	@Test
	void testBase58EncodeLeadingZeros() throws Exception {
		byte[] testByteArr = {0,0,111,111};
		String encodedString = Multibase.BASE58.getEncoder().encodeToString(testByteArr);
		assertEquals("z119Ur", encodedString);
	}

	@Test
	void testBase58EncodeMiddleZeros() throws Exception {
		byte[] testByteArr = {48, 0,0,111,111};
		String encodedString = Multibase.BASE58.getEncoder().encodeToString(testByteArr);
		assertEquals("z6R6WzL6", encodedString);
	}

	@Test
	void testBase58Decode() throws Exception {
		String testStr = "zQfC2";
		String decodedString =  new String(Multibase.BASE58.getDecoder().decode(testStr));
		assertEquals("Foo", decodedString);
	}

	@Test
	void testBase58DecodeLeadingZeros() throws Exception {
		String testStr = "z119Ur";
		byte[] testByteArr = {0,0,111,111};
		byte[] decodedBytes = Multibase.BASE58.getDecoder().decode(testStr);
		assertArrayEquals(testByteArr, decodedBytes);
	}

	@Test
	void testBase58DecodeBytes() throws Exception {
		String testStr = "zQfC2";
		String decodedString =  new String(Multibase.BASE58.getDecoder().decode(testStr.getBytes(StandardCharsets.US_ASCII)));
		assertEquals("Foo", decodedString);
	}

}
