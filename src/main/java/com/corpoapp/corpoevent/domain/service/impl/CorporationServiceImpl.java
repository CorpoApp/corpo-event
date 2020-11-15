package com.corpoapp.corpoevent.domain.service.impl;

import com.corpoapp.corpoevent.api.dto.CorporationDTO;
import com.corpoapp.corpoevent.api.mapper.exception.UserException;
import com.corpoapp.corpoevent.domain.entity.Corporation;
import com.corpoapp.corpoevent.domain.entity.User;
import com.corpoapp.corpoevent.domain.service.CorporationService;
import com.corpoapp.corpoevent.domain.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CorporationServiceImpl implements CorporationService {

    @Inject
    ModelMapper modelMapper;

    @Inject
    UserService userService;

    @Override
    public List<CorporationDTO> getAll() {
        return modelMapper.map(Corporation.listAll(), new TypeToken<List<CorporationDTO>>() {}.getType());
    }

    @Override
    @Transactional
    public void create(String name, String sport) {
        Corporation.builder()
                .name(name)
                .sport(sport)
                .build()
                .persist();
    }

    @Override
    @Transactional
    public void remove(String name, String sport) {
        Corporation.delete("name = ?1 and sport = ?2", name, sport);
    }

    @Override
    public void register(String name, String mail) throws UserException {
        if(userService.userAlreadySignIn(mail)){
            Corporation corporation = Corporation.find("name = ?1", name).firstResult();
            User user = User.find("mail = ?1", mail).firstResult();
            if(corporation != null && user != null){
                corporation.userList.add(user);
                corporation.persist();
            }
        } else {
            throw new UserException("User not registered");
        }
    }
}
