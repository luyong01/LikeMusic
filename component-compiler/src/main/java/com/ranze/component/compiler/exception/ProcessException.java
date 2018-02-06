package com.ranze.component.compiler.exception;

public class ProcessException extends Exception {
    public ProcessException(String msg) {
        super(msg);
    }

    public ProcessException(Throwable throwable) {
        super(throwable);
    }
}
