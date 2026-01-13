package br.com.erudio.spring_boot_and_java_erudio.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details ) {
}
