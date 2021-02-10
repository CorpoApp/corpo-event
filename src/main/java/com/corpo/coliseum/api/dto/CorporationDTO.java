package com.corpo.coliseum.api.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.util.List;

@Data
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class CorporationDTO {

    private String name;
    private String sport;
    private List<UserDTO> userList;
}

