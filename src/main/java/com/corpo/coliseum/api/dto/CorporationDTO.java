package com.corpo.coliseum.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class CorporationDTO {

    private String name;
    private String sport;
    public List<UserDTO> userList;
}

