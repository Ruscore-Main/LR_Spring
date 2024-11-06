package com.example.Bikbaev4219;

import org.springframework.stereotype.Component;
import java.util.Random;
@Component
public class PasswordGenerator {
    private static final String CHARACTERS =
            "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random random = new Random();
    public String generate(int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            result.append(CHARACTERS.charAt(index));
        }
        return result.toString();
    }
}