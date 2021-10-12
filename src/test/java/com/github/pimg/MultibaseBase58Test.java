package com.github.pimg;

import com.github.pimg.multibase.Multibase;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultibaseBase58Test {

	@Test
	public void testBase58Encode() throws Exception {
		String testStr = "Foo";
		String encodedString =  Multibase.getBase58Encoder().encodeToString(testStr.getBytes(StandardCharsets.UTF_8));
		assertEquals("zQfC2", encodedString);
	}

	@Test
	public void testBase58EncodeHelloWorld() throws Exception {
		String testStr = "Hello World!";
		String encodedString = Multibase.getBase58Encoder().encodeToString(testStr.getBytes(StandardCharsets.UTF_8));
		assertEquals("z2NEpo7TZRRrLZSi2U", encodedString);
	}

	@Test
	public void testBase58EncodeHelloWorldToByteArray() throws Exception {
		String testStr = "Hello World!";
		byte[] encodedbytes = Multibase.getBase58Encoder().encode(testStr.getBytes(StandardCharsets.UTF_8));
		assertArrayEquals("z2NEpo7TZRRrLZSi2U".getBytes(StandardCharsets.UTF_8), encodedbytes);
	}

	@Test
	public void testBase58EncodeFullAlphabet() throws Exception {
		String testStr = "The quick brown fox jumps over the lazy dog.";
		String encodedString = Multibase.getBase58Encoder().encodeToString(testStr.getBytes(StandardCharsets.UTF_8));
		assertEquals("zUSm3fpXnKG5EUBx2ndxBDMPVciP5hGey2Jh4NDv6gmeo1LkMeiKrLJUUBk6Z", encodedString);
	}

	@Test
	public void testBase58EncodeLeadingZeros() throws Exception {
		byte[] testByteArr = {0,0,111,111};
		String encodedString = Multibase.getBase58Encoder().encodeToString(testByteArr);
		assertEquals("z119Ur", encodedString);
	}

	@Test
	public void testBase58EncodeMiddleZeros() throws Exception {
		byte[] testByteArr = {48, 0,0,111,111};
		String encodedString = Multibase.getBase58Encoder().encodeToString(testByteArr);
		assertEquals("z6R6WzL6", encodedString);
	}

	@Test
	public void testBase58Decode() throws Exception {
		String testStr = "zQfC2";
		String decodedString =  new String(Multibase.getBase58Decoder().decode(testStr));
		assertEquals("Foo", decodedString);
	}

	@Test
	public void testBase58DecodeLeadingZeros() throws Exception {
		String testStr = "z119Ur";
		byte[] testByteArr = {0,0,111,111};
		byte[] decodedBytes = Multibase.getBase58Decoder().decode(testStr);
		assertArrayEquals(testByteArr, decodedBytes);
	}

	@Test
	public void testBase58DecodeBytes() throws Exception {
		String testStr = "zQfC2";
		String decodedString =  new String(Multibase.getBase58Decoder().decode(testStr.getBytes(StandardCharsets.UTF_8)));
		assertEquals("Foo", decodedString);
	}

}
