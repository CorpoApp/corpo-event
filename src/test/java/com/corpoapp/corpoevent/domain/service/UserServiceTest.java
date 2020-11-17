package com.corpoapp.corpoevent.domain.service;

import com.corpoapp.corpoevent.api.mapper.exception.UserException;
import com.corpoapp.corpoevent.domain.entity.User;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.inject.Inject;
import javax.transaction.Transactional;

@Testcontainers
@QuarkusTest
public class UserServiceTest {

    @Inject
    UserService userService;

    @BeforeEach
    @Transactional
    public void setUp(){
        User.deleteAll();
    }


    private String USER_MAIL = "test@localhost.com";

    @Test
    public void testSignUp() throws UserException {
        Assert.assertNull(userService.findUSer(USER_MAIL));
        userService.signUp(USER_MAIL, "test");
        Assert.assertNotNull(userService.findUSer(USER_MAIL));
    }

    @Test
    public void testAlreadySignUp() throws UserException {
        userService.signUp(USER_MAIL, "test");
        Assertions.assertThrows(UserException.class, () -> {
            userService.signUp(USER_MAIL, "test2");
        });
    }
}
