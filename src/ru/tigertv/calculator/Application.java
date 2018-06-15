package ru.tigertv.calculator;

import ru.tigertv.calculator.controller.CalcController;
import ru.tigertv.calculator.model.CalcModel;
import ru.tigertv.calculator.model.CalcModelBuilder;
import ru.tigertv.calculator.model.SimpleCalcModelBuilder;
import ru.tigertv.calculator.view.CalcView;

public class Application {

	public static void main(String[] args) {
		CalcModelBuilder builder = new SimpleCalcModelBuilder();
		
		CalcModel model = builder.create();
		CalcView view = new CalcView(model);
		CalcController calc = new CalcController(model, view);
		
		calc.run();
	}

}