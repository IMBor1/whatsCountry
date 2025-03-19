package org.example.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "country_codes")
public class CountryCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String country;

    @Column(name = "tel_code", nullable = false)
    private String telCode;

    @Column(name = "code_length")
    private Integer codeLength;
} 