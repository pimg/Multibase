package com.github.pimg;

import com.github.pimg.multibase.Multibase;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultibaseBase64Test {

	@Test
	public void base64EncodeTest() throws Exception {
		String testString = "this is a test string";
		String encodedString = Multibase.getBase64Encoder().encodeToString(testString.getBytes(StandardCharsets.US_ASCII));
		assertEquals("mdGhpcyBpcyBhIHRlc3Qgc3RyaW5n", encodedString);
	}

	@Test
	public void base64EncodeToBytesTest() throws Exception {
		String testString = "this is a test string";
		byte[] encodedString = Multibase.getBase64Encoder().encode(testString.getBytes(StandardCharsets.US_ASCII));
		assertEquals("mdGhpcyBpcyBhIHRlc3Qgc3RyaW5n", new String(encodedString, StandardCharsets.US_ASCII));
	}

	@Test
	public void base64DecodeTest() throws Exception {
		String testString = "mdGhpcyBpcyBhIHRlc3Qgc3RyaW5n";
		byte[] decodedString = Multibase.getBase64Decoder().decode(testString);
		assertEquals("this is a test string", new String(decodedString, StandardCharsets.US_ASCII));
	}

	@Test
	public void base64DecodeFromBytesTest() throws Exception {
		String testString = "mdGhpcyBpcyBhIHRlc3Qgc3RyaW5n";
		byte[] decodedString = Multibase.getBase64Decoder().decode(testString.getBytes(StandardCharsets.US_ASCII));
		assertEquals("this is a test string", new String(decodedString, StandardCharsets.US_ASCII));
	}

	@Test
	public void base64UrlEncodeTest() throws Exception {
		String testString = "this is a test string";
		String encodedString = Multibase.getBase64UrlEncoder().encodeToString(testString.getBytes(StandardCharsets.US_ASCII));
		assertEquals("udGhpcyBpcyBhIHRlc3Qgc3RyaW5n", encodedString);
	}

	@Test
	public void base64UrlEncodeToBytesTest() throws Exception {
		String testString = "this is a test string";
		byte[] encodedString = Multibase.getBase64UrlEncoder().encode(testString.getBytes(StandardCharsets.US_ASCII));
		assertEquals("udGhpcyBpcyBhIHRlc3Qgc3RyaW5n", new String(encodedString, StandardCharsets.US_ASCII));
	}

	@Test
	public void base64UrlDecodeTest() throws Exception {
		String testString = "udGhpcyBpcyBhIHRlc3Qgc3RyaW5n";
		byte[] decodedString = Multibase.getBase64UrlDecoder().decode(testString);
		assertEquals("this is a test string", new String(decodedString, StandardCharsets.US_ASCII));
	}

	@Test
	public void base64UrlDecodeFromBytesTest() throws Exception {
		String testString = "mdGhpcyBpcyBhIHRlc3Qgc3RyaW5n";
		byte[] decodedString = Multibase.getBase64UrlDecoder().decode(testString.getBytes(StandardCharsets.US_ASCII));
		assertEquals("this is a test string", new String(decodedString, StandardCharsets.US_ASCII));
	}
}
