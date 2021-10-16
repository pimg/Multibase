package com.github.pimg;

import com.github.pimg.multibase.Multibase;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MultibaseBase64Test {

	@Test
	void base64EncodeTest() throws Exception {
		String testString = "this is a test string";
		String encodedString = Multibase.BASE64.getEncoder().encodeToString(testString.getBytes(StandardCharsets.US_ASCII));
		assertEquals("mdGhpcyBpcyBhIHRlc3Qgc3RyaW5n", encodedString);
	}

	@Test
	void base64EncodeToBytesTest() throws Exception {
		String testString = "this is a test string";
		byte[] encodedString = Multibase.BASE64.getEncoder().encode(testString.getBytes(StandardCharsets.US_ASCII));
		assertEquals("mdGhpcyBpcyBhIHRlc3Qgc3RyaW5n", new String(encodedString, StandardCharsets.US_ASCII));
	}

	@Test
	void base64DecodeTest() throws Exception {
		String testString = "mdGhpcyBpcyBhIHRlc3Qgc3RyaW5n";
		byte[] decodedString = Multibase.BASE64.getDecoder().decode(testString);
		assertEquals("this is a test string", new String(decodedString, StandardCharsets.US_ASCII));
	}

	@Test
	void base64DecodeFromBytesTest() throws Exception {
		String testString = "mdGhpcyBpcyBhIHRlc3Qgc3RyaW5n";
		byte[] decodedString = Multibase.BASE64.getDecoder().decode(testString.getBytes(StandardCharsets.US_ASCII));
		assertEquals("this is a test string", new String(decodedString, StandardCharsets.US_ASCII));
	}

	@Test
	void base64UrlEncodeTest() throws Exception {
		String testString = "this is a test string";
		String encodedString = Multibase.BASE64_URL.getEncoder().encodeToString(testString.getBytes(StandardCharsets.US_ASCII));
		assertEquals("udGhpcyBpcyBhIHRlc3Qgc3RyaW5n", encodedString);
	}

	@Test
	void base64UrlEncodeToBytesTest() throws Exception {
		String testString = "this is a test string";
		byte[] encodedString = Multibase.BASE64_URL.getEncoder().encode(testString.getBytes(StandardCharsets.US_ASCII));
		assertEquals("udGhpcyBpcyBhIHRlc3Qgc3RyaW5n", new String(encodedString, StandardCharsets.US_ASCII));
	}

	@Test
	void base64UrlDecodeTest() throws Exception {
		String testString = "udGhpcyBpcyBhIHRlc3Qgc3RyaW5n";
		byte[] decodedString = Multibase.BASE64_URL.getDecoder().decode(testString);
		assertEquals("this is a test string", new String(decodedString, StandardCharsets.US_ASCII));
	}

	@Test
	void base64UrlDecodeFromBytesTest() throws Exception {
		String testString = "mdGhpcyBpcyBhIHRlc3Qgc3RyaW5n";
		byte[] decodedString = Multibase.BASE64_URL.getDecoder().decode(testString.getBytes(StandardCharsets.US_ASCII));
		assertEquals("this is a test string", new String(decodedString, StandardCharsets.US_ASCII));
	}
}
