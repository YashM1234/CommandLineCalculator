package com.cli.calculator.command.validator;

public interface CommandValidator {
    boolean isValidate(String[] argument) throws Exception;
}
