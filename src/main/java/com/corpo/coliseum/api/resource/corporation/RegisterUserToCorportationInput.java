package com.corpo.coliseum.api.resource.corporation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserToCorportationInput {

    private String corporationName;
    private String userMail;

}
