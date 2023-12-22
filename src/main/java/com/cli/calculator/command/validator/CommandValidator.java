package com.cli.calculator.command.validator;

public interface CommandValidator {
    public boolean isValidate(String[] argument) throws Exception;
}
