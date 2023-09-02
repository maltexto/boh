package dev.maltexto.boh.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("ping")
public class Ping {
    @GET
    public Response ping() {
        return Response.ok("pong").build();
    }
}
