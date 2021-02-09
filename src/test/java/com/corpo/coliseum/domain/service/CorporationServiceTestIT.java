package com.corpo.coliseum.domain.service;

import com.corpo.coliseum.domain.entity.Corporation;
import com.corpo.coliseum.domain.exception.ModelNotFoundException;
import com.corpo.coliseum.domain.service.configuration.PostgresResource;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@QuarkusTestResource(PostgresResource.class)
public class CorporationServiceTestIT {

   @Inject
    CorporationService corporationService;

    private static final Corporation FIRST_CORPORATION = Corporation
            .builder()
            .name("Corporation 1")
            .sport("Sport 1")
            .build();
    private static final Corporation SECOND_CORPORATION = Corporation
            .builder()
            .name("Corporation 2")
            .sport("Sport 2")
            .build();
    private static final Corporation THIRD_CORPORATION = Corporation
            .builder()
            .name("Corporation 3")
            .sport("Sport 3")
            .build();

    @Test
    public void runAllTests() throws ModelNotFoundException {
        testGetAll();
        testCreate();
        testDelete();
    }

    private void testGetAll(){
        assertEquals(0, corporationService.getAll().size());
        corporationService.create(FIRST_CORPORATION);
        corporationService.create(SECOND_CORPORATION);
        assertEquals(2, corporationService.getAll().size());
    }

    private void testCreate(){
        corporationService.create(THIRD_CORPORATION);
        assertEquals(3, corporationService.getAll().size());
    }

    private void testDelete() throws ModelNotFoundException {
        corporationService.remove("Corporation 3");
        assertEquals(2, corporationService.getAll().size());
    }

}
