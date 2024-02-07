package com.myblog.myblog11;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncrypt {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //it has a method called encode() which can encode any password
        System.out.println(passwordEncoder.encode("testing"));
    }
}
