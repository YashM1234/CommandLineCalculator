package com.cli.calculator.command.operation;

import com.cli.calculator.command.Command;
import com.cli.calculator.command.validator.CommandValidator;
import com.cli.calculator.model.Result;

public class MinCommand implements Command, CommandValidator {
    @Override
    public Result execute(String[] command) throws Exception {
        if(isValidate(command)){
            double min = Double.parseDouble(command[1]);
            for(int i = 2; i < command.length; i++){
                if(min > Double.parseDouble(command[i])){
                    min = Double.parseDouble(command[i]);
                }
            }
            return Result.builder().message("The Minimum number among all is: ").result(min).build();
        }
        return Result.builder().message("Please enter valid input!").build();
    }

    @Override
    public boolean isValidate(String[] argument) throws Exception {
        if(!argument[0].equals("min") || argument.length < 3){
            throw new Exception("Minimum two number required find minimum among numbers!");
        }else {
            return true;
        }
    }
}
