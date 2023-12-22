package com.cli.calculator;

import com.cli.calculator.command.Command;
import com.cli.calculator.command.operation.*;
import com.cli.calculator.model.Result;

import java.util.Scanner;

public class CommandLineCalculatorApp {
    private static final Scanner inputCmd = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Command Line Calculator!");
        while (true){
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("Man Page: ");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("add <numbers>");
            System.out.println("sub <numbers>");
            System.out.println("multi <numbers");
            System.out.println("div <numbers>");
            System.out.println("fact <numbers>");
            System.out.println("palindrome <numbers>");
            System.out.println("prime <numbers");
            System.out.println("pow <numbers>");
            System.out.println("square <numbers>");
            System.out.println("max <numbers>");
            System.out.println("min <numbers>");
            System.out.println("avg <numbers");
            System.out.println("even <numbers>");
            System.out.println("odd <numbers>");
            System.out.println("exit");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("Enter command: ");
            String userInput = inputCmd.nextLine();

            String[] command = userInput.split(" ");

            Command commandName = findCommand(command[0]);
            if(commandName == null) {
                System.err.println("Enter valid Command with proper arguments!");
                continue;
            }
            try{
                Result result = commandName.execute(command);
                System.err.println(result.getMessage() + result.getResult());
            }catch(Exception ex){
                System.err.println(ex.getMessage());
            }
        }
    }

    private static Command findCommand(String commandName) {
        return switch (commandName) {
            case "add" -> new AdditionCommand();
            case "sub" -> new SubtractionCommand();
            case "multi" -> new MultiplicationCommand();
            case "div" -> new DivisionCommand();
            case "fact" -> new FactCommand();
            case "palindrome" -> new PalindromeCommand();
            case "prime" -> new PrimeCommand();
            case "pow" -> new PowCommand();
            case "square" -> new SquareCommand();
            case "max" -> new MaxCommand();
            case "min" -> new MinCommand();
            case "avg" -> new AvgCommand();
            case "even" -> new EvenCommand();
            case "odd" -> new OddCommand();
            case "exit" -> new ExitCommand();
            default -> null;
        };
    }
}