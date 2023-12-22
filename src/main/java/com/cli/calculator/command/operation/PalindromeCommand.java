package com.cli.calculator.command.operation;

import com.cli.calculator.command.Command;
import com.cli.calculator.command.validator.CommandValidator;
import com.cli.calculator.model.Result;

public class PalindromeCommand implements Command, CommandValidator {
    @Override
    public Result execute(String[] command) throws Exception {
        if(isValidate(command)){
            for(int i = 1; i < command.length; i++){
                if(isPalindrome(Integer.parseInt(command[i]))){
                    System.out.println(Integer.valueOf(command[i]) + " is palindrome number");
                }else{
                    System.out.println(Integer.valueOf(command[i]) + " is not a palindrome number");

                }
            }
            return Result.builder().message("Exit").build();
        }
        return Result.builder().message("Please enter valid input!").build();
    }

    private boolean isPalindrome(int number) {
        int reverseNum = 0;
        int temp = number;

        while (temp != 0) {
            reverseNum = reverseNum * 10 + temp % 10;
            temp = temp / 10;
        }

        return reverseNum == number;
    }

    @Override
    public boolean isValidate(String[] argument) throws Exception {
        if(!argument[0].equals("palindrome") || argument.length < 2){
            throw new Exception("Minimum one number required to check palindrome number or not!");
        }else {
            return true;
        }
    }


}
