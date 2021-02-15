package com.uds.horbac.core.exceptions;

public class ApiException extends RuntimeException{
	private static final long serialVersionUID = 1L;
    private String msg;

    public ApiException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
