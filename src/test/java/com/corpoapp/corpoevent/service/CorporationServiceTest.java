package com.corpoapp.corpoevent.service;

import com.corpoapp.corpoevent.dto.CorporationDTO;
import com.corpoapp.corpoevent.entity.Corporation;
import com.corpoapp.corpoevent.entity.User;
import com.corpoapp.corpoevent.exceptions.mapper.UserException;
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
        corporationService.create("test", "boules");
        corporationService.create("test2", "boules2");
        Assert.assertTrue(corporationService.getAll().size() == 2);
    }

    @Test
    public void testCreate(){
        Assert.assertTrue(corporationService.getAll().isEmpty());
        corporationService.create("test", "boules");
        Assert.assertTrue(corporationService.getAll().size() == 1);
    }

    @Test
    public void testDelete(){
        corporationService.create("test", "boules");
        Assert.assertFalse(corporationService.getAll().isEmpty());
        corporationService.remove("test", "boules");
        Assert.assertTrue(corporationService.getAll().isEmpty());
    }

    @Test
    public void testRegister() throws UserException {
        corporationService.create("test", "boules");
        userService.signUp("test@decathlon.com", "testUser");
        corporationService.register("test", "test@decathlon.com");

        CorporationDTO result = corporationService.getAll().get(0);
        Assert.assertFalse(result.getUserList().isEmpty());
        Assert.assertTrue(result.getUserList().get(0).getName().equals("testUser"));
    }
}
