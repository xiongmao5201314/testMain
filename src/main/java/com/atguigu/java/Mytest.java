package com.atguigu.java;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Mytest {
    public static void main(String[] args) {
        Instant now = Instant.now();

        OffsetDateTime atOffset = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(atOffset);

    }
}
