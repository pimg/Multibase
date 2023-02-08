package com.github.pimg;

import com.github.pimg.multibase.Multibase;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MultibaseOctalTest {

    @Test
    void testStringDecode() {
        String testString = "7164 150 151 163 40 151 163 40 141 40 164 145 163 164";

        byte[] result = Multibase.OCTAL.getDecoder().decode(testString);
        assertEquals("this is a test", new String(result, StandardCharsets.UTF_8));
    }

    @Test
    void testDecodeFullAlphabetString() {
        String testString = "7124 150 145 40 161 165 151 143 153 40 142 162 157 167 156 40 146 157 170 40 152 165 155 160 163 40 157 166 145 162 40 164 150 145 40 154 141 172 171 40 144 157 147 56";
        byte[] result = Multibase.OCTAL.getDecoder().decode(testString);
        assertEquals("The quick brown fox jumps over the lazy dog.", new String(result, StandardCharsets.UTF_8));
    }

    @Test
    void testByteDecode() {
        String testString = "7164 150 151 163 40 151 163 40 141 40 164 145 163 164";

        byte[] result = Multibase.OCTAL.getDecoder().decode(testString.getBytes());
        assertEquals("this is a test", new String(result, StandardCharsets.UTF_8));
    }

    @Test
    void testEncodeToString() {
        String testString = "bar";

        String result = Multibase.OCTAL.getEncoder().encodeToString(testString.getBytes(StandardCharsets.UTF_8));
        assertEquals("7142 141 162", result);
    }

    @Test
    void testEncodeFullAlphabetToString() {
        String testString = "The quick brown fox jumps over the lazy dog.";

        String result = Multibase.OCTAL.getEncoder().encodeToString(testString.getBytes());
        assertEquals("7124 150 145 40 161 165 151 143 153 40 142 162 157 167 156 40 146 157 170 40 152 165 155 160 163 40 157 166 145 162 40 164 150 145 40 154 141 172 171 40 144 157 147 56", result);
    }

    @Test
    void testEncodeFullAlpabetToBytes() {
        String testString = "The quick brown fox jumps over the lazy dog.";

        byte[] result = Multibase.OCTAL.getEncoder().encode(testString.getBytes(StandardCharsets.UTF_8));
        assertArrayEquals("7124 150 145 40 161 165 151 143 153 40 142 162 157 167 156 40 146 157 170 40 152 165 155 160 163 40 157 166 145 162 40 164 150 145 40 154 141 172 171 40 144 157 147 56".getBytes(StandardCharsets.UTF_8), result);
    }
}
