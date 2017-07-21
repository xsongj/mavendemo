package com.example.patterns.factory;

/**
 * Created by louyuting on 17/1/6.
 */
public class DivFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationDiv();
    }
}
