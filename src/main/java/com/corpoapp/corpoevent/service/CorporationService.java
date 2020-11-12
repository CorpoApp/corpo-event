package com.corpoapp.corpoevent.service;

import com.corpoapp.corpoevent.dto.CorporationDTO;
import com.corpoapp.corpoevent.exceptions.mapper.UserException;

import java.util.List;

public interface CorporationService {

    List<CorporationDTO> getAll();
    void create(String name, String sport);
    void remove(String name, String sport);
    void register(String name, String mail) throws UserException;
}
