package com.corpo.coliseum.domain.nrt;


import com.corpo.coliseum.domain.entity.User;
import com.corpo.coliseum.domain.service.UserService;
import com.corpo.coliseum.domain.service.configuration.PostgresResource;
import com.intuit.karate.junit5.Karate;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

import javax.inject.Inject;

@QuarkusTest
@QuarkusTestResource(PostgresResource.class)
public class FeatureRunnerTest {

    @Inject
    UserService userService;

    @Karate.Test
    Karate testQuotes() {
        //Create test user for testing
        userService.signUp(User.builder().name("test").mail("test@test.com").build());
        return Karate.run("classpath:feature").relativeTo(getClass());
    }

}
