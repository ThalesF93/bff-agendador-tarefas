package com.thales.bffagendador_tarefas.InfraStructure.client.Config;

import com.thales.bffagendador_tarefas.InfraStructure.Exceptions.BusinessException;
import com.thales.bffagendador_tarefas.InfraStructure.Exceptions.ConflictException;
import com.thales.bffagendador_tarefas.InfraStructure.Exceptions.ResourceNotFoundException;
import com.thales.bffagendador_tarefas.InfraStructure.Exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {


    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()){
            case 409:
                return new ConflictException("Erro: atributo já existente");
            case 403:
                return new ResourceNotFoundException("Erro: Atributo nao encontrado");
            case 401:
                return new UnauthorizedException("Erro: Usuario não autorizado");
            default:
                return new BusinessException("Erro de servidor");

        }
    }
}
