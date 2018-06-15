package ru.tigertv.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ru.tigertv.calculator.model.CalcModel;
import ru.tigertv.calculator.model.SimpleCalcModelBuilder;

class CalcModelTest {

	@Test
	void testAddition() {
		CalcModel calc = new SimpleCalcModelBuilder().create();
		
		String op = "+";
		calc.setOperation(op);
		calc.setSecondOperand("6");
		calc.doOperation();
		String result = calc.getResult();
		assertEquals("6", result);
		
		calc.doOperation();
		result = calc.getResult();
		assertEquals("12", result);
	}
	
	@Test
	void testSubtraction() {
		CalcModel calc = new SimpleCalcModelBuilder().create();
		
		String op = "-";
		calc.setOperation(op);
		calc.setSecondOperand("5");
		calc.doOperation();
		String result = calc.getResult();
		assertEquals("-5", result);
	}
	
	@Test
	void testMultiplication() {
		CalcModel calc = new SimpleCalcModelBuilder().create();
		calc.setFirstOperand("3");
		
		String op = "*";
		calc.setOperation(op);
		
		calc.setSecondOperand("5");
		calc.doOperation();
		String result = calc.getResult();
		assertEquals("15", result);
	}
	
	@Test
	void testDivision() {
		CalcModel calc = new SimpleCalcModelBuilder().create();
		calc.setFirstOperand("15");
		
		String op = "/";
		calc.setOperation(op);
		
		calc.setSecondOperand("5");
		calc.doOperation();
		String result = calc.getResult();
		assertEquals("3", result);
	}
	
	@Test
	void testNoCurrentOperation() {
		CalcModel calc = new CalcModel();
		
		try {
			calc.doOperation();
		} catch(Exception e) {
			fail("Exception");
		}
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
