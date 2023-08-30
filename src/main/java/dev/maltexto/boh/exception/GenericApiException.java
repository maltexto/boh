package dev.maltexto.boh.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class GenericApiException extends WebApplicationException {
    public GenericApiException(String message, Response.Status status) {
        super(Response.status(status).entity(message).build());
    }
}
