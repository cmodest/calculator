package com.iteriam.calculator.model;

public enum Operator {
    ADD("+"),
    SUBSTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private String symbol;

    private static final Operator[] operators =new Operator[]{ADD,SUBSTRACTION,MULTIPLICATION,DIVISION};

    private String getSymbol(){
        return this.symbol;
    }

    Operator(String symbol){
        this.symbol = symbol;
    }

    public static Operator getOperator(String operator){
        for (Operator item : operators){
            if(item.name().equals(operator.toUpperCase()) || item.getSymbol().equals(operator)){
                return item;
            }
        }

        throw new RuntimeException("Operation not supported.");
    }
}
