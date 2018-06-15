package ru.tigertv.calculator.model;

import ru.tigertv.calculator.model.CalcModel;

public abstract class CalcModelBuilder {

	// Template method
	public final CalcModel create() {
		CalcModel model = new CalcModel();		
		addOperations(model);
		return model;
	}
	
	protected abstract void addOperations(CalcModel model);
}