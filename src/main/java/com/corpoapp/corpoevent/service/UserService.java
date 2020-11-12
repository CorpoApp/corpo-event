package com.corpoapp.corpoevent.service;

import com.corpoapp.corpoevent.dto.UserDTO;
import com.corpoapp.corpoevent.exceptions.mapper.UserException;

public interface UserService {

    void signUp(String mail, String name) throws UserException;
    UserDTO findUSer(String mail);
    Boolean userAlreadySignIn(String mail);

}
