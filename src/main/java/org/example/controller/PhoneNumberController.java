package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.model.CountryCode;
import org.example.service.CountryCodeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/phone")
@RequiredArgsConstructor
@Tag(name = "Phone Number API", description = "API для определения страны по номеру телефона")
@CrossOrigin(origins = "*")
public class PhoneNumberController {
    private final CountryCodeService countryCodeService;

    @GetMapping(value = "/country", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Определить страну по номеру телефона")
    public List<CountryCode> getCountryByPhoneNumber(
            @Parameter(description = "Номер телефона (например, +79001234567)")
            @RequestParam String phoneNumber) {
        return countryCodeService.findCountryByPhoneNumber(phoneNumber);
    }
} 