package com.corpo.coliseum.domain.service.configuration;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Collections;
import java.util.Map;

public class PostgresResource implements QuarkusTestResourceLifecycleManager {

    static PostgreSQLContainer<?> db = new PostgreSQLContainer<>("postgres:13")
            .withDatabaseName("corpoapp")
            .withUsername("corpoapp")
            .withPassword("corpoapp")
            .withClasspathResourceMapping("init.sql",
                    "/docker-entrypoint-initdb.d/init.sql",
                    BindMode.READ_ONLY);;

    @Override
    public Map<String, String> start() {
        db.start();
        return Collections.singletonMap(
                "quarkus.datasource.jdbc.url", db.getJdbcUrl()
        );
    }

    @Override
    public void stop() {
        db.stop();
    }
}