package com.corpo.coliseum.api.resource.input;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
public class CorporationInput {

    @NotBlank
    public String name;

    @NotBlank
    public String sport;
}
