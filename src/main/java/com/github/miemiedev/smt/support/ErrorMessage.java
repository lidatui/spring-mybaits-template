package com.github.miemiedev.smt.support;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ErrorMessage {

    private String error = "unknown error";

    public ErrorMessage() {
    }

    public ErrorMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "error='" + error + '\'' +
                '}';
    }
}
