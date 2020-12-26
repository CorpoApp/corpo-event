package com.corpo.coliseum.domain.service;

import com.corpo.coliseum.api.dto.CorporationDTO;
import com.corpo.coliseum.api.mapper.exception.UserException;

import java.util.List;

public interface CorporationService {

    List<CorporationDTO> getAll();
    void create(String name, String sport);
    void remove(String name, String sport);
    void register(String name, String mail) throws UserException;
}
