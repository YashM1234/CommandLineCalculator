package com.cli.calculator.command.operation;

import com.cli.calculator.command.Command;
import com.cli.calculator.command.validator.CommandValidator;
import com.cli.calculator.model.Result;

public class AvgCommand implements Command, CommandValidator {
    @Override
    public Result execute(String[] command) throws Exception {
        if(isValidate(command)){
            double sum = Double.parseDouble(command[1]);
            double avg;
            for(int i = 2; i < command.length; i++){
                sum += Double.parseDouble(command[i]);
            }
            avg = sum / (command.length-1);
            return Result.builder().message("The Average of numbers is: ").result(avg).build();
        }
        return Result.builder().message("Please enter valid input!").build();
    }

    @Override
    public boolean isValidate(String[] argument) throws Exception {
        if(!argument[0].equals("avg") || argument.length < 2){
            throw new Exception("Minimum one number required to perform average operation!");
        }else {
            return true;
        }
    }
}
