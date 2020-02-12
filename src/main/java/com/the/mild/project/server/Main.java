package com.the.mild.project.server;

import static com.the.mild.project.server.ResourceConfig.SERVICE_NAME;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP com.the.mild.project.server will listen on
    public static final String BASE_URI = "http://localhost:8080/"+ SERVICE_NAME + "/";

    /**
     * Starts Grizzly HTTP com.the.mild.project.server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP com.the.mild.project.server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.example package
        final ResourceConfig rc = new ResourceConfig().packages("com.the.mild.project.server.resources");

        // create and start a new instance of grizzly http com.the.mild.project.server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at %sapplication.wadl\nHit enter to stop it...",
                                         BASE_URI));
        System.in.read();
        server.shutdownNow();
    }
}

