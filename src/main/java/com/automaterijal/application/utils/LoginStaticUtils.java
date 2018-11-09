package com.automaterijal.application.utils;

import lombok.experimental.UtilityClass;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@UtilityClass
public class LoginStaticUtils {

    public String md5Password(final String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (final NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        final byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

        final StringBuilder sb = new StringBuilder();
        for (final byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return  sb.toString();
    }
}
