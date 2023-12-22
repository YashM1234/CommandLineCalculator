package com.cli.calculator.command.operation;

import com.cli.calculator.command.Command;
import com.cli.calculator.model.Result;

public class ExitCommand implements Command {
    @Override
    public Result execute(String[] command) {
        System.exit(0);
        return null;
    }
}
