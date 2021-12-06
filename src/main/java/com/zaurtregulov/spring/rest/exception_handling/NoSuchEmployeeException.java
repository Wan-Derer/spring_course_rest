package com.zaurtregulov.spring.rest.exception_handling;

public class NoSuchEmployeeException extends RuntimeException{

  private final String message;

  public NoSuchEmployeeException(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
