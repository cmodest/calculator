package com.iteriam.calculator.services;

import com.iteriam.calculator.mapper.OperationMapper;
import com.iteriam.calculator.model.Operation;
import com.iteriam.calculator.model.Operator;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    private String operationType = "";
    private TracerImpl tracer = new TracerImpl();

    @Autowired
    private OperationMapper operationMapper;

    @Override
    public BigDecimal calculate(final BigDecimal operator1, final BigDecimal operator2, final String type){

        Operator operator = Operator.getOperator(type);

        Operation operation = operationMapper.initializeOperation(operator);
        return operation.calculate(operator1,operator2);
    }
}
