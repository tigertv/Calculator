package ru.tigertv.calculator.operation;

import ru.tigertv.calculator.model.CalcModel;

public interface ICalculatorOperation {
	void calculate(CalcModel model);
	String symbol();
	boolean isUnaryOperation();
}
