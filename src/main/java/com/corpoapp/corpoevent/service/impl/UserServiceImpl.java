package com.corpoapp.corpoevent.service.impl;

import com.corpoapp.corpoevent.dto.UserDTO;
import com.corpoapp.corpoevent.entity.User;
import com.corpoapp.corpoevent.exceptions.mapper.UserException;
import com.corpoapp.corpoevent.service.UserService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    ModelMapper modelMapper;

    @Override
    @Transactional
    public void signUp(String mail, String name) throws UserException {
        if(!userAlreadySignIn(mail)){
            User.builder()
                    .mail(mail)
                    .name(name)
                    .build().persist();
        } else {
            throw new UserException("User already registered");
        }
    }

    @Override
    @Transactional
    public UserDTO findUSer(String mail) {
        User user = User.find("mail = ?1", mail).firstResult();
        if(user != null) {
            return modelMapper.map(user, UserDTO.class);
        }
        return null;
    }

    @Override
    public Boolean userAlreadySignIn(String mail) {
        if(findUSer(mail) == null){
            return false;
        } else {
            return true;
        }
    }
}
