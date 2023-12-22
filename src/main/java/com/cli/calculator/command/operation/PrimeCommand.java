package com.cli.calculator.command.operation;

import com.cli.calculator.command.Command;
import com.cli.calculator.command.validator.CommandValidator;
import com.cli.calculator.model.Result;

public class PrimeCommand implements Command, CommandValidator {
    @Override
    public Result execute(String[] command) throws Exception {
        if(isValidate(command)){
            for(int i = 1; i < command.length; i++){
                if(checkPrime(Integer.parseInt(command[i]))){
                    System.out.println(command[i] + " is prime number! ");
                }else{
                    System.out.println(command[i] + " is not a prime number! ");

                }
            }
            return Result.builder().message("End").build();
        }
        return Result.builder().message("Please enter valid input!").build();
    }

    public static boolean checkPrime(int num){
        if(num == 0 || num == 1){
            return false;
        }
        if(num == 2 || num == 3){
            return true;
        }
        if(num % 2 == 0 || num % 3 == 0){
            return false;
        }
        for(int d = 5; d <= Math.sqrt(num); d = d + 6){
            if(num % d == 0 || num % (d + 2) == 0){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isValidate(String[] argument) throws Exception {
        if(!argument[0].equals("prime") || argument.length < 2){
            throw new Exception("Minimum one number required to find prime value!");
        }else {
            return true;
        }
    }

}
