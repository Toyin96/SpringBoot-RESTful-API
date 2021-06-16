package com.payroll.web.exceptions;

public class EmployeeDoesNotExistException extends Throwable{

    public EmployeeDoesNotExistException() {
    }

    public EmployeeDoesNotExistException(String message) {
        super(message);
    }

    public EmployeeDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
