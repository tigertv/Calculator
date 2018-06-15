package ru.tigertv.calculator.operation;

import java.math.BigInteger;

import ru.tigertv.calculator.model.CalcModel;

public class MultiplicationOperation implements ICalculatorOperation {

	@Override
	public void calculate(CalcModel model) {
		BigInteger result = new BigInteger(model.getFirstOperand());
		BigInteger second = new BigInteger(model.getSecondOperand());
		result = result.multiply(second);
		
		model.setResult(result.toString());
	}
	@Override
	public String symbol() {
		return "*";
	}
	@Override
	public boolean isUnaryOperation() {
		// TODO Auto-generated method stub
		return false;
	}

}