package com.corpo.coliseum.domain.nrt;


import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class FeatureRunnerTest {

    @Karate.Test
    Karate testQuotes() {
        return Karate.run("classpath:feature").relativeTo(getClass());
    }

}
