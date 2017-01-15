package com.springframework3rd.exceptions;

public class NoFixedDepositFoundException extends RuntimeException {
    private static final long serialVersionUID = 437902588438864637L;

    public NoFixedDepositFoundException(String msg) {
        super(msg);
    }
}
