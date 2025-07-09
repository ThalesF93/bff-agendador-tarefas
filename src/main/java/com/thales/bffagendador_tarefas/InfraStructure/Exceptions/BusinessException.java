package com.thales.bffagendador_tarefas.InfraStructure.Exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }
}
