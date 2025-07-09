package com.thales.bffagendador_tarefas.InfraStructure.Exceptions;

public class ConflictException extends RuntimeException{
    public ConflictException(String mensagem){
        super(mensagem);
    }

    public ConflictException(String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }
}
