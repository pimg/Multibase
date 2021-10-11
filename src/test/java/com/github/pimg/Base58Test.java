package com.github.pimg;

import com.github.pimg.dataformat.Base58;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Base58Test {

	private final Base58 base58 = new Base58();

	@Test
	public void testBase58Encode() throws Exception {
		String testStr = "Foo";
		String encodedString =  base58.encodeToString(testStr.getBytes(StandardCharsets.UTF_8));
		assertEquals("QfC2", encodedString);
	}

	@Test
	public void testBase58EncodeHelloWorld() throws Exception {
		String testStr = "Hello World!";
		String encodedString = base58.encodeToString(testStr.getBytes(StandardCharsets.UTF_8));
		assertEquals("2NEpo7TZRRrLZSi2U", encodedString);
	}

	@Test
	public void testBase58EncodeFullAlphabet() throws Exception {
		String testStr = "The quick brown fox jumps over the lazy dog.";
		String encodedString = base58.encodeToString(testStr.getBytes(StandardCharsets.UTF_8));
		assertEquals("USm3fpXnKG5EUBx2ndxBDMPVciP5hGey2Jh4NDv6gmeo1LkMeiKrLJUUBk6Z", encodedString);
	}

	@Test
	public void testBase58EncodeLeadingZeros() throws Exception {
		byte[] testByteArr = {0,0,111,111};
		base58.encodeToString(testByteArr);
	}

	@Test
	public void testBase58EncodeMiddleZeros() throws Exception {
		byte[] testByteArr = {48, 0,0,111,111};
		base58.encodeToString(testByteArr);
	}
}
