package ru.tigertv.calculator.model;

import ru.tigertv.calculator.model.CalcModel;
import ru.tigertv.calculator.operation.AdditionOperation;
import ru.tigertv.calculator.operation.DivisionOperation;
import ru.tigertv.calculator.operation.ICalculatorOperation;
import ru.tigertv.calculator.operation.MultiplicationOperation;
import ru.tigertv.calculator.operation.SubtractionOperation;

public class SimpleCalcModelBuilder extends CalcModelBuilder {

	@Override
	protected void addOperations(CalcModel model) {
		ICalculatorOperation op;
		
		op = new AdditionOperation();
		model.addOperation(op);
		
		op = new SubtractionOperation();
		model.addOperation(op);
		
		op = new MultiplicationOperation();
		model.addOperation(op);
		
		op = new DivisionOperation();
		model.addOperation(op);
	}
}
