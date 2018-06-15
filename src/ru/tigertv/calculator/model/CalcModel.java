package ru.tigertv.calculator.model;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Set;

import ru.tigertv.calculator.MyObservable;
import ru.tigertv.calculator.operation.ICalculatorOperation;
import ru.tigertv.calculator.operation.NoOperation;

public class CalcModel {
	
	private HashMap<String,ICalculatorOperation> operations = new HashMap<>();
	private ICalculatorOperation binaryOperation;
	//private ICalcOperation unaryOperation;
	
	private BigInteger result = new BigInteger("0");
	
	private BigInteger firstOperand = new BigInteger("0");
	private BigInteger secondOperand = new BigInteger("0");
	
	public MyObservable resultChanged = new MyObservable();
	
	public CalcModel() {
		ICalculatorOperation op = new NoOperation();
		operations.put(op.symbol(), op);
		binaryOperation = op;
	}
	
	public void reset() {
		setFirstOperand("0");
		setSecondOperand("0");
		setResult("0");
	}
	
	public void setResult(String result) {
		this.result = new BigInteger(result);
		this.firstOperand = new BigInteger(result);
		
		resultChanged.change();
		resultChanged.notifyObservers(getResult());
	}
	
	public String getResult() {
		return result.toString();
	}
	
	public void setFirstOperand(String x) {
		firstOperand = new BigInteger(x);
	}
	
	public String getFirstOperand() {
		return firstOperand.toString();
	}
	
	public void setSecondOperand(String x) {
		secondOperand = new BigInteger(x);
	}
	
	public String getSecondOperand() {
		return secondOperand.toString();
	}
	
	public void doOperation() {
		if (binaryOperation == null) return;
		binaryOperation.calculate(this);
	}
	
	public Set<String> getOperations() {
		return operations.keySet();
	}
	
	public void addOperation(ICalculatorOperation op) {
		operations.put(op.symbol(), op);
	}
	
	public void setOperation(String operation) {
		ICalculatorOperation op = operations.get(operation);
		if (op == null) return;
		
		if (op.isUnaryOperation()) {
			op.calculate(this);
		} else {
			binaryOperation = op;
		}
		
	}
	
	
	
}
