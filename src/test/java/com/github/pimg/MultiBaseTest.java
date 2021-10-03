package com.github.pimg;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiBaseTest {

	@Test
	public void base64EncodeTest() throws Exception {
		String testString = "this is a test string";
		String encodedString = MultiBase.getBase64Encoder().encode(testString.getBytes(StandardCharsets.UTF_8));
		assertEquals("mdGhpcyBpcyBhIHRlc3Qgc3RyaW5n", encodedString);
	}

	@Test
	public void base64UrlEncodeTest() throws Exception {
		String testString = "mdGhpcyBpcyBhIHRlc3Qgc3RyaW5n";
		byte[] decodedString = MultiBase.getBase64Decoder().decode(testString);
		assertEquals("this is a test string", new String(decodedString, StandardCharsets.UTF_8));
	}
}
