package com.corpo.coliseum.domain.service;

import com.corpo.coliseum.api.mapper.exception.UserException;
import com.corpo.coliseum.domain.entity.Corporation;
import com.corpo.coliseum.domain.exception.ModelNotFoundException;

import javax.validation.Valid;
import java.util.List;

public interface CorporationService {

    List<Corporation> getAll();
    Corporation findByName(String name) throws ModelNotFoundException;
    Corporation create(@Valid Corporation corporation);
    void remove(String name) throws ModelNotFoundException;
    void register(String name, String mail) throws UserException, ModelNotFoundException;
}
