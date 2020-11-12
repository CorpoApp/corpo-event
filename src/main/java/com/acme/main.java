package com.acme;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;

@QuarkusMain
public class main {

    public static void main(String ... args) {
        System.out.println("Running main method");
        Quarkus.run(args);
    }

    @Produces
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}