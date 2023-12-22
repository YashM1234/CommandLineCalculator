package com.cli.calculator.command.operation;

import com.cli.calculator.command.Command;
import com.cli.calculator.command.validator.CommandValidator;
import com.cli.calculator.model.Result;

public class EvenCommand implements Command, CommandValidator {
    @Override
    public Result execute(String[] command) throws Exception {
        if(isValidate(command)){
            for(int i = 1; i < command.length; i++){
                if(Integer.parseInt(command[i])%2 == 0){
                    System.out.println(command[i] + " is Even Number!");
                }else{
                    System.out.println(command[i] + " is odd Number!");
                }
            }
            return Result.builder().message("Success!").build();
        }
        return Result.builder().message("Please enter valid input!").build();
    }

    @Override
    public boolean isValidate(String[] argument) throws Exception {
        if(!argument[0].equals("even") || argument.length < 3){
            throw new Exception("Minimum two number required to perform even operation!");
        }else {
            return true;
        }
    }
}
