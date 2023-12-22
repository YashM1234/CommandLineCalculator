package com.cli.calculator.command.operation;

import com.cli.calculator.command.Command;
import com.cli.calculator.command.validator.CommandValidator;
import com.cli.calculator.model.Result;

public class MaxCommand implements Command, CommandValidator {
    @Override
    public Result execute(String[] command) throws Exception {
        if(isValidate(command)){
            double max = Double.parseDouble(command[1]);
            for(int i = 2; i < command.length; i++){
                if(max < Double.parseDouble(command[i])){
                    max = Double.parseDouble(command[i]);
                }
            }
            return Result.builder().message("The Maximum number among all is: ").result(max).build();
        }
        return Result.builder().message("Please enter valid input!").build();
    }

    @Override
    public boolean isValidate(String[] argument) throws Exception {
        if(!argument[0].equals("max") || argument.length < 3){
            throw new Exception("Minimum two number required find maximum among numbers!");
        }else {
            return true;
        }
    }
}
