package com.example.Bikbaev4219;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException(String cause) {
        super(cause);
    }
}

