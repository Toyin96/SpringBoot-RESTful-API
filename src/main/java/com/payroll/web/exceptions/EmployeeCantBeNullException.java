package com.payroll.web.exceptions;

public class EmployeeCantBeNullException extends Throwable{
    public EmployeeCantBeNullException() {
    }

    public EmployeeCantBeNullException(String message) {
        super(message);
    }

    public EmployeeCantBeNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
