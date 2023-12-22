package com.cli.calculator.command.operation;

import com.cli.calculator.command.Command;
import com.cli.calculator.command.validator.CommandValidator;
import com.cli.calculator.model.Result;

public class DivisionCommand implements Command, CommandValidator {
    @Override
    public Result execute(String[] command) throws Exception {
        if(isValidate(command)){
            double div = Double.parseDouble(command[1]);
            if(div == 0){
                return Result.builder().message("The Division of numbers is: ").result(div).build();
            }
            for(int i = 2; i < command.length; i++){
                if(Double.parseDouble(command[i]) == 0){
                    throw new Exception("Number cannot divide by zero");
                }else {
                    div /= Double.parseDouble(command[i]);
                }
            }
            return Result.builder().message("The Division of numbers is: ").result(div).build();
        }
        return Result.builder().message("Please enter valid input!").build();
    }

    @Override
    public boolean isValidate(String[] argument) throws Exception {
        if(!argument[0].equals("div") || argument.length < 3){
            throw new Exception("Minimum two number required for division operation!");
        }else {
            return true;
        }
    }
}
