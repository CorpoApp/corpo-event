package com.corpo.coliseum.domain.service;

import com.corpo.coliseum.api.dto.UserDTO;
import com.corpo.coliseum.api.mapper.exception.UserException;

public interface UserService {

    void signUp(String mail, String name) throws UserException;
    UserDTO findUSer(String mail);
    Boolean userAlreadySignIn(String mail);

}
