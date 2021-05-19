package com.iteriam.calculator.mapper;

import com.iteriam.calculator.model.*;
import org.springframework.stereotype.Component;

@Component
public class OperationMapper {
    public Operation initializeOperation(Operator operator){
        switch (operator){
            case ADD:
                return new Addition();
            case SUBSTRACTION:
                return new Substraction();
            case MULTIPLICATION:
                return new Multiplication();
            case DIVISION:
                return new Division();
            default:
                return null;
        }
    }
}
