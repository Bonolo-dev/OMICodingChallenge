package com.bonolomonale.demo.service;

import com.bonolomonale.demo.model.Country;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CountryService countryService;

    @Test
    public void testGetAllCountries() {
        Country country1 = new Country();

        Country country2 = new Country();

        Country[] mockCountries = new Country[]{country1, country2};
        when(restTemplate.getForObject("https://restcountries.com/v3.1/all", Country[].class)).thenReturn(mockCountries);

        List<Country> countries = countryService.getAllCountries();

        assertNotNull(countries);
        assertEquals(2, countries.size());
    }

    @Test
    public void testGetCountryDetails() {
        String mockCountryDetails = "{\"name\":\"South Africa\"}";
        when(restTemplate.getForObject("https://restcountries.com/v3.1/name/South Africa", String.class))
                .thenReturn(mockCountryDetails);

        String countryDetails = countryService.getCountryDetails("South Africa");

        assertNotNull(countryDetails);
        assertEquals("{\"name\":\"South Africa\"}", countryDetails);
    }
}
