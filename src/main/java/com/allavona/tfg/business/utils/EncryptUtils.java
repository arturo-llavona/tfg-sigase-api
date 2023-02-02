package com.allavona.tfg.business.utils;

import org.springframework.util.DigestUtils;

public class EncryptUtils {
    public static String encrypt(final String text) {
        return DigestUtils.md5DigestAsHex(text.getBytes());
    }
}
