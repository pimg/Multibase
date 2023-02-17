package com.github.pimg;

import com.github.pimg.multibase.Multibase;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MultibaseBinaryTest {

    @Test
    void testEncodeToString() {
        String testString = "hello world";

        String result = Multibase.BINARY.getEncoder().encodeToString(testString.getBytes(StandardCharsets.UTF_8));
        assertEquals("00110100001100101011011000110110001101111001000000111011101101111011100100110110001100100", result);
    }

    @Test
    void testEncodeFullAlphabetToString() {
        String testString = "The quick brown fox jumps over the lazy dog.";
        String result = Multibase.BINARY.getEncoder().encodeToString(testString.getBytes(StandardCharsets.UTF_8));
        assertEquals("00101010001101000011001010010000001110001011101010110100101100011011010110010000001100010011100100110111101110111011011100010000001100110011011110111100000100000011010100111010101101101011100000111001100100000011011110111011001100101011100100010000001110100011010000110010100100000011011000110000101111010011110010010000001100100011011110110011100101110", result);
    }

    @Test
    void testEncodeToBytes() {
        String testString = "hello world";

        byte[] result = Multibase.BINARY.getEncoder().encode(testString.getBytes(StandardCharsets.UTF_8));
        assertArrayEquals("00110100001100101011011000110110001101111001000000111011101101111011100100110110001100100".getBytes(), result);
    }

    @Test
    void testDecodeString() {
        String testBinaryString = "00110100001100101011011000110110001101111001000000111011101101111011100100110110001100100";
        byte[] result = Multibase.BINARY.getDecoder().decode(testBinaryString);
        assertArrayEquals("hello world".getBytes(), result);
    }

    @Test
    void testDecodeFullAlphabetToString() {
        String testBinaryString = "00101010001101000011001010010000001110001011101010110100101100011011010110010000001100010011100100110111101110111011011100010000001100110011011110111100000100000011010100111010101101101011100000111001100100000011011110111011001100101011100100010000001110100011010000110010100100000011011000110000101111010011110010010000001100100011011110110011100101110";
        byte[] result = Multibase.BINARY.getDecoder().decode(testBinaryString);
        assertArrayEquals("The quick brown fox jumps over the lazy dog.".getBytes(), result);
    }

    @Test
    void testDecodeByteArray() {
        byte[] testBinaryInput = "00110100001100101011011000110110001101111001000000111011101101111011100100110110001100100".getBytes();
        byte[] result = Multibase.BINARY.getDecoder().decode(testBinaryInput);
        assertArrayEquals("hello world".getBytes(), result);
    }
}
