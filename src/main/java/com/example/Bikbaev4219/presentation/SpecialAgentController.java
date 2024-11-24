package com.example.Bikbaev4219.presentation;

import com.example.Bikbaev4219.SpecialAgent;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class SpecialAgentController {
    @GetMapping("/agents/{id}")
    ResponseEntity<String> validateAgentPathVariable(@PathVariable("id") @Min(1) int id) {
        return ResponseEntity.ok("Agent id is valid.");
    }

    @GetMapping("/agents")
    ResponseEntity<String> validateAgentRequestParam(
            @RequestParam("code") @Pattern(regexp = "[0-9]{1,3}") String code) {
                    return ResponseEntity.ok("Agent code is valid.");
    }

    @PostMapping("/agent")
    public ResponseEntity<String> validate(@Valid @RequestBody SpecialAgent agent) {
        return ResponseEntity.ok("Agent info is valid.");
    }
}