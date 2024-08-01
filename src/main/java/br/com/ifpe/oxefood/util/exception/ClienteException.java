package br.com.ifpe.oxefood.util.exception;

public class ClienteException extends RuntimeException{

    public static final String MSG_NUMERO_NAO_TEM_DDD_81 = "O número de telefone não tem o DDD 81";
    
    public ClienteException(String msg) {

        super(String.format(msg));
        }
    
}
