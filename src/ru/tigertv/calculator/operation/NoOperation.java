package ru.tigertv.calculator.operation;

import ru.tigertv.calculator.model.CalcModel;

public class NoOperation implements ICalculatorOperation {

	@Override
	public void calculate(CalcModel model) {
		// do nothing
	}
	@Override
	public String symbol() {
		return "";
	}
	@Override
	public boolean isUnaryOperation() {
		// TODO Auto-generated method stub
		return false;
	}

}
