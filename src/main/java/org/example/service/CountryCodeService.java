package org.example.service;

import org.example.model.CountryCode;
import java.util.List;

public interface CountryCodeService {
    List<CountryCode> findCountryByPhoneNumber(String phoneNumber);
}
