package dev.maxwell_lt.rest;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.security.Principal;

@Path("/hello")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class HelloService {

    @Inject
    private Principal principal;

    @GET
    public HelloResponse hello() {
        return new HelloResponse("Hello World!");
    }

    @GET
    @Path("auth")
    @RolesAllowed("users")
    public HelloResponse auth() {
        return new HelloResponse("Hello, " + principal.getName() + "!");
    }
}
