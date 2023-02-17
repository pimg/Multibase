package com.github.pimg.multibase.dataformat;

import java.math.BigInteger;

public class Binary implements Dataformat {
    @Override
    public byte[] decode(String string) {
        return new BigInteger(string, 2).toByteArray();
    }

    @Override
    public byte[] decode(byte[] bytes) {
        return decode(new String(bytes));
    }

    @Override
    public String encodeToString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte singleByte: bytes) {
            String binaryString = String.format("%8s", Integer.toBinaryString(singleByte & 0xFF)).replace(' ', '0');
            builder.append(binaryString);
        }
        return builder.toString();
    }

    @Override
    public byte[] encode(byte[] bytes) {
        return encodeToString(bytes).getBytes();
    }
}
