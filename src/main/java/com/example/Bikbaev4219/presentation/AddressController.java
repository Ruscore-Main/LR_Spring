package com.example.Bikbaev4219.presentation;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
public class AddressController {
    private ConcurrentMap<String, String> addressBook = new
            ConcurrentHashMap<>();
    @PostMapping("/addresses")
    public void postAddress(@RequestParam String name,
                            @RequestParam String address) {
        addressBook.put(name, address);
    }

    @GetMapping("/addresses")
    public ConcurrentMap<String, String> getAddressBook() {
        return addressBook;
    }

    @DeleteMapping("/addresses")
    public String removeAddress(@RequestParam String name) {
        addressBook.remove(name);
        return name + " removed from address book!";
    }
}