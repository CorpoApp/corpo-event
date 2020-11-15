package com.acme;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class App {

    public static void main(String ... args) {
        System.out.println("Running App method");
        Quarkus.run(args);
    }
}