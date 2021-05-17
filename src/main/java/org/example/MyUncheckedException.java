package org.example;

public class MyUncheckedException extends RuntimeException {

    public MyUncheckedException(String msg) {
        super(msg);
    }

    public MyUncheckedException() {
    }
}
