package com.bonolomonale.demo.controller;

import com.bonolomonale.demo.service.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class CountryFlagsController {

    private final CountryService countryService;

    @Autowired
    public CountryFlagsController(CountryService countryFlagService) {
        this.countryService = countryFlagService;
    }


    @GetMapping("/all")
    public ResponseEntity getAllCountries() throws JsonProcessingException {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getCountryDetails(@PathVariable String name) {
        return ResponseEntity.ok(countryService.getCountryDetails(name));
    }
}
