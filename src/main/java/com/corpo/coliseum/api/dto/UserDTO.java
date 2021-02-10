package com.corpo.coliseum.api.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.util.List;

@Data
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class UserDTO {

    private String mail;
    private String name;
    private List<CorporationDTO> corporationList;

}
