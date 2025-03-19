package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.example.model.CountryCode;
import org.example.service.CountryCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phone")
@RequiredArgsConstructor
public class PhoneNumberController {
    private final CountryCodeService countryCodeService;

    @GetMapping("/country")
    public ResponseEntity<CountryCode> getCountryByPhoneNumber(@RequestParam String phoneNumber) {
        CountryCode country = countryCodeService.findCountryByPhoneNumber(phoneNumber);
        return ResponseEntity.ok(country);
    }


} 