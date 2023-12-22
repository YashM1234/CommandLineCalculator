package com.cli.calculator.command.operation;

import com.cli.calculator.command.Command;
import com.cli.calculator.command.validator.CommandValidator;
import com.cli.calculator.model.Result;

public class SquareCommand implements Command, CommandValidator {

    @Override
    public Result execute(String[] command) throws Exception {
        if(isValidate(command)){
            double square = 1;
            for(int i = 1; i < command.length; i++){
                square = Double.parseDouble(command[i]) * Double.parseDouble(command[i]);
                System.out.println("The square of " + command[i] + " is " + square);
            }
            return Result.builder().message("Exit").build();
        }
        return Result.builder().message("Please enter valid input!").build();
    }

    @Override
    public boolean isValidate(String[] argument) throws Exception {
        if(!argument[0].equals("square") || argument.length < 2){
            throw new Exception("Minimum one number required to find square!");
        }else {
            return true;
        }
    }
}
