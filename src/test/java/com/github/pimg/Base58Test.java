package com.github.pimg;

import com.github.pimg.dataformat.Base58;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

public class Base58Test {

	private final Base58 base58 = new Base58();

	@Test
	public void testBase58Encode() throws Exception {
		String testStr = "Foo";
		base58.encodeToString(testStr.getBytes(StandardCharsets.UTF_8));
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
