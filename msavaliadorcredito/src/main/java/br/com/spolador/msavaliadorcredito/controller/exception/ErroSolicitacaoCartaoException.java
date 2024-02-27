package br.com.spolador.msavaliadorcredito.controller.exception;

public class ErroSolicitacaoCartaoException extends RuntimeException{
    public ErroSolicitacaoCartaoException(String message) {
        super(message);
    }
}
