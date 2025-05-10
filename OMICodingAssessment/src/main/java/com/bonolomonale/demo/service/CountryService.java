package com.bonolomonale.demo.service;

import com.bonolomonale.demo.model.Country;
import com.bonolomonale.demo.model.CountryDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryService {
    private final RestTemplate restTemplate;

    private final String BASE_URL = "https://restcountries.com/v3.1";
    @Autowired
    public CountryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Country> getAllCountries() {
        String url = BASE_URL + "/all";
        Country[] countries = restTemplate.getForObject(url, Country[].class);
        assert countries != null;
        return Arrays.asList(countries);
    }

    public String getCountryDetails(String name){
        String url = BASE_URL + "/name/" + name;
        String countryDetails = restTemplate.getForObject(url, String.class);
        assert countryDetails != null;
        return countryDetails;
    }
}
