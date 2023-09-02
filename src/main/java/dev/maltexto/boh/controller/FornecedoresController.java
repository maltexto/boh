package dev.maltexto.boh.controller;

import dev.maltexto.boh.entity.Fornecedor;
import dev.maltexto.boh.service.FornecedorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("fornecedores")
public class FornecedoresController {

    @Inject
    private FornecedorService fornecedorService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Response findAll() {
        return Response.ok(fornecedorService.findAll()).build();
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response findOneById(@PathParam("id") Long id) {
        return Response.ok(fornecedorService.findById(id)).build();
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public Response create(Fornecedor fornecedor) {
        return Response
                .status(Response.Status.CREATED)
                .entity(fornecedorService.save(fornecedor))
                .build();
    }

    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public Response update(@PathParam("id") Long id, Fornecedor fornecedor) {
        return Response.ok(fornecedorService.update(id, fornecedor)).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public Response delete(@PathParam("id") Long id) {
        return Response.ok(fornecedorService.delete(id)).build();
    }
}
