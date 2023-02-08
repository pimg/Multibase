package com.github.pimg.multibase.dataformat;

import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Octal implements Dataformat {

    @Override
    public byte[] decode(String string) {

        StringTokenizer tokeniser = new StringTokenizer(string);
        int len = tokeniser.countTokens();
        int[] octalArray = new int[len];
        byte[] octalByteArray = new byte[len];

        for (int i = 0; tokeniser.hasMoreTokens(); i++) {
            octalArray[i] = Integer.parseInt(tokeniser.nextToken(), 8);
            octalByteArray[i] = (byte) octalArray[i];
        }
        return octalByteArray;
    }

    @Override
    public byte[] decode(byte[] bytes) {
        return decode(new String(bytes));
    }

    @Override
    public String encodeToString(byte[] bytes) {
        return IntStream
                .range(0, bytes.length)
                .map(i -> bytes[i])
                .boxed()
                .map(Integer::toOctalString)
                .collect(Collectors.joining(" "));
    }

    @Override
    public byte[] encode(byte[] bytes) {
        return encodeToString(bytes).getBytes(StandardCharsets.US_ASCII);
    }
}
