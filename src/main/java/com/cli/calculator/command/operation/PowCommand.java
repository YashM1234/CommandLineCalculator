package com.cli.calculator.command.operation;

import com.cli.calculator.command.Command;
import com.cli.calculator.command.validator.CommandValidator;
import com.cli.calculator.model.Result;

public class PowCommand implements Command, CommandValidator {
    @Override
    public Result execute(String[] command) throws Exception {
        if(isValidate(command)){
            double pow = 1;
            for(int i = 0; i < Double.parseDouble(command[2]); i++){
                pow = Double.parseDouble(command[1]) * pow;
            }
            return Result.builder().message("The Multiplication of numbers is: ").result(pow).build();
        }
        return Result.builder().message("Please enter valid input!").build();
    }

    @Override
    public boolean isValidate(String[] argument) throws Exception {
        if(!argument[0].equals("pow") || argument.length < 3){
            throw new Exception("Minimum two number required to find power of any number!");
        }else {
            return true;
        }
    }
}
