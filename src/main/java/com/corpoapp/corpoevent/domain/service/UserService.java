package com.corpoapp.corpoevent.domain.service;

import com.corpoapp.corpoevent.api.dto.UserDTO;
import com.corpoapp.corpoevent.api.mapper.exception.UserException;

public interface UserService {

    void signUp(String mail, String name) throws UserException;
    UserDTO findUSer(String mail);
    Boolean userAlreadySignIn(String mail);

}
