package com.iteriam.calculator.services;

import com.iteriam.calculator.exception.OperationException;
import com.iteriam.calculator.model.Operation;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    private final List<Operation> operations;

    @Autowired
    public CalculatorServiceImpl(List<Operation> operations){
        this.operations = operations;
    }

    private final TracerImpl tracer = new TracerImpl();

    @Override
    public BigDecimal calculate(final BigDecimal operator1, final BigDecimal operator2, final String type) throws OperationException {
        try {
            Operation operation = null;

            for (Operation op : operations) {
                operation = op.isThis(type);
                if (Objects.nonNull(operation)) {
                    break;
                }
            }
            return operation.calculate(operator1, operator2);
        }
        catch (Exception e){
            throw new OperationException("Operation Not supported " + type,e);
        }
    }
}
