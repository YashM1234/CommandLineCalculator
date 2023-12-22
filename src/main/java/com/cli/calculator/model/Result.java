package com.cli.calculator.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class Result {
    String message;
    double result;
}
