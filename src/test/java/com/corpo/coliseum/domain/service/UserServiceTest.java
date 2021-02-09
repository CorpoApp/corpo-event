package com.corpo.coliseum.domain.service;

import com.corpo.coliseum.domain.entity.User;
import com.corpo.coliseum.domain.exception.ModelNotFoundException;
import com.corpo.coliseum.domain.service.configuration.PostgresResource;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
@QuarkusTestResource(PostgresResource.class)
public class UserServiceTest {

    @Inject
    UserService userService;

    private static final String USER_MAIL = "test@localhost.com";
    private static final String USER_NAME = "user name";

    @Test
    public void testSignUp() throws ModelNotFoundException {
        User user = User.builder()
                .mail(USER_MAIL)
                .name(USER_NAME)
                .build();
        userService.signUp(user);
        Assert.assertNotNull(userService.findByMail(USER_MAIL));
    }

}
