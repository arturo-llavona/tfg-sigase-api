package com.allavona.tfg.business.utils;

import org.springframework.util.DigestUtils;

public class EncryptUtils {
    // Método que encripta en md5 el texto que se le pase como parámetro.
    public static String encrypt(final String text) {
        return DigestUtils.md5DigestAsHex(text.getBytes());
    }
}
