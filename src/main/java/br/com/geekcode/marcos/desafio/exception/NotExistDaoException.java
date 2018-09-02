package br.com.geekcode.marcos.desafio.exception;

public class NotExistDaoException extends RuntimeException {

    public NotExistDaoException(String message) {
        super(message);
    }
}
