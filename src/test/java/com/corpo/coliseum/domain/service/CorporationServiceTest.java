package com.corpo.coliseum.domain.service;

import com.corpo.coliseum.domain.entity.Corporation;
import com.corpo.coliseum.domain.exception.ModelNotFoundException;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusTest
public class CorporationServiceTest {

    @Inject
    CorporationService corporationService;

    @Spy
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

    @BeforeEach
    public void setUp() {
        PanacheMock.mock(Corporation.class);
    }

    @Test
    public void getAll_should_return_empty_list() {
        //Arrange
        Mockito.when(Corporation.listAll()).thenReturn(Collections.emptyList());

        //Act
        List<Corporation> corporations = corporationService.getAll();

        //Assert
        assertEquals(0, corporations.size());
    }

    @Test
    public void getAll_should_return_list() {
        //Arrange
        Mockito.when(Corporation.listAll())
                .thenReturn(Arrays.asList(FIRST_CORPORATION, SECOND_CORPORATION,THIRD_CORPORATION));

        //Act
        List<Corporation> corporations = corporationService.getAll();

        //Assert
        assertEquals(3, corporations.size());
    }

    @Test
    public void findByName_should_Throw_Exception() {
        //Arrange
        Mockito.when(Corporation.findByName("Corporation"))
                .thenReturn(Optional.empty());

        //Act / Assert
        assertThrows(ModelNotFoundException.class,() -> corporationService.findByName("Corporation"));

    }

    @Test
    public void findByName_should_return_First_Corporation() throws ModelNotFoundException {
        //Arrange
        Mockito.when(Corporation.findByName("Corporation 1"))
                .thenReturn(Optional.of(FIRST_CORPORATION));

        //Act
        Corporation corporation = corporationService.findByName("Corporation 1");

        //Assert
        assertEquals(FIRST_CORPORATION, corporation);
    }

    @Test
    public void create_should_be_ok() {
        //Arrange
        Corporation testCorporation = Mockito.mock(Corporation.class);
        testCorporation.name = "Corporation 1";
        testCorporation.sport = "Sport 1";
        Mockito.doNothing().when(testCorporation).persist();

        //Act
        Corporation corporation = corporationService.create(testCorporation);

        //Assert
        assertEquals(testCorporation, corporation);
    }

    @Test
    public void create_with_invalid_corporation_should_fail() {
        //Arrange
        Corporation testCorporation = Mockito.mock(Corporation.class);
        testCorporation.name = "Corporation 1";

        //Act
        Corporation corporation = corporationService.create(testCorporation);

        //Assert
        assertEquals(testCorporation, corporation);
    }

}
