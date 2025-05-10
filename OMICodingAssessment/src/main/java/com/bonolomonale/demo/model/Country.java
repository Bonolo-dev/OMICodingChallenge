package com.bonolomonale.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    @JsonProperty("name")
    private Name name;
    @JsonProperty("flags")
    private Flags flags;

}
