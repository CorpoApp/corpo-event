package com.corpo.coliseum.domain.service;

import com.corpo.coliseum.api.dto.UserDTO;
import com.corpo.coliseum.api.mapper.exception.UserException;
import com.corpo.coliseum.domain.entity.User;
import com.corpo.coliseum.domain.exception.ModelNotFoundException;

import javax.validation.Valid;

public interface UserService {

    User signUp(@Valid User user);
    User findByMail(String mail) throws ModelNotFoundException;

}
