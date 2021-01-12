package com.corpo.coliseum.domain.service.impl;

import com.corpo.coliseum.api.resource.input.CorporationInput;
import com.corpo.coliseum.domain.service.CorporationService;
import com.corpo.coliseum.domain.service.UserService;
import com.corpo.coliseum.api.dto.CorporationDTO;
import com.corpo.coliseum.api.mapper.exception.UserException;
import com.corpo.coliseum.domain.entity.Corporation;
import com.corpo.coliseum.domain.entity.User;
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
    public void create(CorporationInput corporationInput) {
        Corporation.builder()
                .name(corporationInput.name)
                .sport(corporationInput.sport)
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
