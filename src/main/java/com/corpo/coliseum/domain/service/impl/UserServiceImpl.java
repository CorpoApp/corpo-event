package com.corpo.coliseum.domain.service.impl;

import com.corpo.coliseum.domain.entity.User;
import com.corpo.coliseum.domain.exception.ModelNotFoundException;
import com.corpo.coliseum.domain.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Override
    @Transactional
    public User signUp(User user) {
        user.persist();
        return user;
    }

    @Override
    @Transactional
    public User findByMail(String mail) throws ModelNotFoundException {
        final User user = User.findByMail(mail)
                .orElseThrow(() -> new ModelNotFoundException("User not found !", User.class));
        return user;
    }

}
