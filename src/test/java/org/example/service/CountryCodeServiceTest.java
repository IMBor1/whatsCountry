package org.example.service;

import org.example.model.CountryCode;
import org.example.repository.CountryCodeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CountryCodeServiceTest {

    @Mock
    private CountryCodeRepository repository;

    @InjectMocks
    private CountryCodeServiceImpl service;

    private CountryCode russia;
    private CountryCode usa;

    @BeforeEach
    void setUp() {
        russia = new CountryCode();
        russia.setCountry("Russia");
        russia.setTelCode("+7");
        russia.setCodeLength(1);

        usa = new CountryCode();
        usa.setCountry("United States");
        usa.setTelCode("+1");
        usa.setCodeLength(1);
    }

    @Test
    void findCountryByPhoneNumber_ValidRussianNumber_ReturnsRussia() {
        when(repository.findByTelCodeStartingWith(anyString()))
                .thenReturn(Arrays.asList(russia, usa));

        List<CountryCode> result = service.findCountryByPhoneNumber("+79001234567");

        assertFalse(result.isEmpty());
        assertEquals("Russia", result.get(0).getCountry());
        assertEquals("+7", result.get(0).getTelCode());
    }

    @Test
    void findCountryByPhoneNumber_ValidUSNumber_ReturnsUSA() {
        when(repository.findByTelCodeStartingWith(anyString()))
                .thenReturn(Arrays.asList(russia, usa));

        List<CountryCode> result = service.findCountryByPhoneNumber("+12125551234");

        assertFalse(result.isEmpty());
        assertEquals("United States", result.get(0).getCountry());
        assertEquals("+1", result.get(0).getTelCode());
    }

    @Test
    void findCountryByPhoneNumber_InvalidNumber_ThrowsException() {
        when(repository.findByTelCodeStartingWith(anyString()))
                .thenReturn(Arrays.asList(russia, usa));

        assertThrows(RuntimeException.class, () -> 
            service.findCountryByPhoneNumber("+99999999999")
        );
    }
} 