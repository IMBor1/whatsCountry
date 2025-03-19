package org.example.repository;

import org.example.model.CountryCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CountryCodeRepository extends JpaRepository<CountryCode, Long> {
    List<CountryCode> findByTelCodeStartingWith(String telCode);
} 