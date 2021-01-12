package com.corpo.coliseum.domain.service;

import com.corpo.coliseum.api.dto.CorporationDTO;
import com.corpo.coliseum.api.mapper.exception.UserException;
import com.corpo.coliseum.api.resource.input.CorporationInput;
import com.corpo.coliseum.domain.entity.Corporation;
import com.corpo.coliseum.domain.entity.User;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.wildfly.common.Assert;

import javax.inject.Inject;
import javax.transaction.Transactional;

@Testcontainers
@QuarkusTest
public class CorporationServiceTest {

    @Inject
    CorporationService corporationService;

    @Inject
    UserService userService;

    @BeforeEach
    @Transactional
    public void setUp(){
        User.deleteAll();
        Corporation.deleteAll();
    }

    @Test
    public void testGetAll(){
        Assert.assertTrue(corporationService.getAll().isEmpty());
        corporationService.create(new CorporationInput("test", "boules"));
        corporationService.create(new CorporationInput("test2", "boules2"));
        Assert.assertTrue(corporationService.getAll().size() == 2);
    }

    @Test
    public void testCreate(){
        Assert.assertTrue(corporationService.getAll().isEmpty());
        corporationService.create(new CorporationInput("test", "boules"));
        Assert.assertTrue(corporationService.getAll().size() == 1);
    }

    @Test
    public void testDelete(){
        corporationService.create(new CorporationInput("test", "boules"));
        Assert.assertFalse(corporationService.getAll().isEmpty());
        corporationService.remove("test", "boules");
        Assert.assertTrue(corporationService.getAll().isEmpty());
    }

    @Test
    public void testRegister() throws UserException {
        corporationService.create(new CorporationInput("test", "boules"));
        userService.signUp("test@localhost.com", "testUser");
        corporationService.register("test", "test@localhost.com");

        CorporationDTO result = corporationService.getAll().get(0);
        Assert.assertFalse(result.getUserList().isEmpty());
        Assert.assertTrue(result.getUserList().get(0).getName().equals("testUser"));
    }
}
