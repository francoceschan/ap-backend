package com.ap.backend;


import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptionTest {

    @Test
    void bcryptTest(){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("admin");
        System.out.println(hashedPassword);

        System.out.println(passwordEncoder.matches("admin",hashedPassword));
        System.out.println(passwordEncoder.matches("aDmin",hashedPassword));

    }
}
