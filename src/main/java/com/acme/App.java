package com.acme;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.jboss.logging.Logger;

@QuarkusMain
public class App {

    private static final Logger LOG = Logger.getLogger(App.class);

    public static void main(String ... args) {
        LOG.info("Running App method");
        Quarkus.run(args);
    }
}