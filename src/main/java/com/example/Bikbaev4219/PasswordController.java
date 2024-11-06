package com.example.Bikbaev4219;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PasswordController {
    @GetMapping("getPassword")
    public String generatePassword() {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        return  passwordGenerator.generate(10);
    }

    @PostMapping("getPassword")
    public String generateLengthPassword(@RequestParam("length") String lengthParam) {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        try {
            int length = Integer.parseInt(lengthParam);

            if (length > 100) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The password must be less than 100 characters long");
            }

            return passwordGenerator.generate(length);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Length must be number");
        }
    }
}
