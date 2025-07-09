package com.thales.bffagendador_tarefas.InfraStructure.Exceptions;

import javax.naming.AuthenticationException;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String mensagem) {
        super(mensagem);
    }


}
