package dev.maltexto.boh.service;

import java.util.List;

import dev.maltexto.boh.dao.FornecedorDAO;
import dev.maltexto.boh.entity.Fornecedor;
import dev.maltexto.boh.exception.GenericApiException;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

public class FornecedorService {

    @Inject
    private FornecedorDAO fornecedorDAO;

    public List<Fornecedor> findAll() {
        return fornecedorDAO.findAll();
    }

    public Fornecedor findById(Long id) {
        Fornecedor fornecedorExistente = fornecedorDAO.findById(id);
        if (fornecedorExistente == null) {
            throw new GenericApiException(
                    "Fornecedor Inexistente",
                    Response.Status.NOT_FOUND);
        }

        return fornecedorExistente;
    }

    public Fornecedor save(Fornecedor fornecedor) {
        Fornecedor fornecedorComMesmoCnpj = fornecedorDAO.findOneByCnpj(fornecedor.getCpnj());
        if (fornecedorComMesmoCnpj != null) {
            throw new GenericApiException(
                    "Já existe um fornecedor com este CNPJ",
                    Response.Status.CONFLICT);
        }

        return fornecedorDAO.save(fornecedor);
    }

    public Fornecedor delete(Long id) {
        Fornecedor fornecedorExistente = fornecedorDAO.findById(id);
        if (fornecedorExistente == null) {
            throw new GenericApiException(
                    "Fornecedor Inexistente",
                    Response.Status.NOT_FOUND);
        }

        return fornecedorDAO.delete(fornecedorExistente);
    }

    public Fornecedor update(Long id, Fornecedor fornecedor) {
        Fornecedor fornecedorExistente = fornecedorDAO.findById(id);
        if (fornecedorExistente == null) {
            throw new GenericApiException(
                    "Fornecedor Inexistente",
                    Response.Status.NOT_FOUND);
        }

        return fornecedorDAO.update(fornecedorExistente);
    }

}
