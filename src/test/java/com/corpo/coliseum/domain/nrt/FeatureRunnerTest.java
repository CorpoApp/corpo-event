package com.corpo.coliseum.domain.nrt;


import com.corpo.coliseum.domain.service.configuration.PostgresResource;
import com.intuit.karate.junit5.Karate;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@QuarkusTestResource(PostgresResource.class)
public class FeatureRunnerTest {

    @Karate.Test
    Karate testQuotes() {
        return Karate.run("classpath:feature").relativeTo(getClass());
    }

}
