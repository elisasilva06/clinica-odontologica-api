package br.uema.clinica_odontologica_api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL) // "errors" só aparece no JSON quando existir
public class ErrorResponse {

    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String message;
    private Map<String, String> errors;

    // Construtor antigo (usado pelo 404 e 500)
    public ErrorResponse(
            LocalDateTime timestamp,
            Integer status,
            String error,
            String message) {

        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    // Construtor novo (usado pelo 400, com os erros por campo)
    public ErrorResponse(
            LocalDateTime timestamp,
            Integer status,
            String error,
            String message,
            Map<String, String> errors) {

        this(timestamp, status, error, message);
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}