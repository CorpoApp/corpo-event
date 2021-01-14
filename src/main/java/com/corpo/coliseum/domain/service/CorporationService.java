package com.corpo.coliseum.domain.service;

import com.corpo.coliseum.api.dto.CorporationDTO;
import com.corpo.coliseum.api.mapper.exception.UserException;
import com.corpo.coliseum.api.resource.input.CorporationInput;

import java.util.List;

public interface CorporationService {

    List<CorporationDTO> getAll();
    void create(CorporationInput corporationInput);
    void remove(CorporationInput corporationInput);
    void register(String name, String mail) throws UserException;
}
