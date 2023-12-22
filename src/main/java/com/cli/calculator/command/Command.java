package com.cli.calculator.command;

import com.cli.calculator.model.Result;

public interface Command {
    Result execute(String[] command) throws Exception;;
}
