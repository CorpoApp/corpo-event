package com.corpoapp.corpoevent.domain.service;

import com.corpoapp.corpoevent.api.dto.CorporationDTO;
import com.corpoapp.corpoevent.api.mapper.exception.UserException;

import java.util.List;

public interface CorporationService {

    List<CorporationDTO> getAll();
    void create(String name, String sport);
    void remove(String name, String sport);
    void register(String name, String mail) throws UserException;
}
