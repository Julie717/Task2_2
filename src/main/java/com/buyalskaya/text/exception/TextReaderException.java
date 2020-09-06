package com.buyalskaya.text.exception;

public class TextReaderException extends Exception {
    public TextReaderException() {
    }

    public TextReaderException(String message) {
        super(message);
    }

    public TextReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextReaderException(Throwable cause) {
        super(cause);
    }
}