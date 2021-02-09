package com.corpo.coliseum.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private String mail;
    private String name;
    private List<CorporationDTO> corporationList;

}
