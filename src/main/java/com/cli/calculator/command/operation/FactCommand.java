package com.cli.calculator.command.operation;

import com.cli.calculator.command.Command;
import com.cli.calculator.command.validator.CommandValidator;
import com.cli.calculator.model.Result;

public class FactCommand implements Command, CommandValidator {
    @Override
    public Result execute(String[] command) throws Exception {
        if(isValidate(command)){
            long fact;
            for(int i = 1; i < command.length; i++){
                fact = factOf(Integer.parseInt(command[i]));
                System.out.println("Factorial of " + command[i] + " is " + fact);
            }
            return Result.builder().message("Exit").build();
        }
        return Result.builder().message("Please enter valid input!").build();
    }

    private long factOf(long number) throws Exception {
        if(number < 0){
            throw new Exception("Please enter non-negative number");
        }
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * factOf(number - 1);
    }

    @Override
    public boolean isValidate(String[] argument) throws Exception {
        if(!argument[0].equals("fact") || argument.length < 2){
            throw new Exception("Minimum one number required to find factorial!");
        }else {
            return true;
        }
    }
}
