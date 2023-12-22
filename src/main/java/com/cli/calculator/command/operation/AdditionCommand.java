package com.cli.calculator.command.operation;

import com.cli.calculator.command.Command;
import com.cli.calculator.command.validator.CommandValidator;
import com.cli.calculator.model.Result;

public class AdditionCommand implements Command, CommandValidator{
    @Override
    public Result execute(String[] command) throws Exception {
        if(isValidate(command)){
            double sum = Double.parseDouble(command[1]);
            for(int i = 2; i < command.length; i++){
                sum += Double.parseDouble(command[i]);
            }
            return Result.builder().message("The Addition of numbers is: ").result(sum).build();
        }
        return Result.builder().message("Please enter valid input!").build();
    }

    @Override
    public boolean isValidate(String[] argument) throws Exception {
        if(!argument[0].equals("add") || argument.length < 3){
            throw new Exception("Minimum two number required for add operation!");
        }else {
            return true;
        }
    }
}
