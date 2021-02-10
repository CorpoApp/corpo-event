package com.corpo.coliseum.domain.service.impl;

import com.corpo.coliseum.api.resource.corporation.RegisterUserToCorportationInput;
import com.corpo.coliseum.domain.entity.Corporation;
import com.corpo.coliseum.domain.entity.User;
import com.corpo.coliseum.domain.exception.ModelNotFoundException;
import com.corpo.coliseum.domain.service.CorporationService;
import com.corpo.coliseum.domain.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
public class CorporationServiceImpl implements CorporationService {

    private final UserService userService;

    @Inject
    public CorporationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<Corporation> getAll() {
        return Corporation.listAll();
    }

    @Override
    public Corporation findByName(String name) throws ModelNotFoundException {
        return Corporation.findByName(name)
                .orElseThrow(() -> new ModelNotFoundException("Corporation not found !", Corporation.class));
    }

    @Override
    @Transactional
    public Corporation create(@Valid Corporation corporation) {
        corporation.persist();
        return corporation;
    }

    @Override
    @Transactional
    public void remove(String name) throws ModelNotFoundException {
        final Corporation corporation = Corporation.findByName(name)
                .orElseThrow(() -> new ModelNotFoundException("Corporation not found !", Corporation.class));
        corporation.delete();
    }

    @Override
    @Transactional
    public void register(RegisterUserToCorportationInput registerUserToCorportationInput) throws ModelNotFoundException {
        final Corporation corporation = findByName(registerUserToCorportationInput.getCorporationName());
        final User user = userService.findByMail(registerUserToCorportationInput.getUserMail());
        corporation.userList.add(user);
        user.corporationList.add(corporation);
        corporation.persist();
        user.persist();
    }
}
