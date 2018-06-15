package ru.tigertv.calculator.controller;

import java.util.Observable;
import java.util.Observer;

import ru.tigertv.calculator.model.CalcModel;
import ru.tigertv.calculator.view.CalcView;

public class CalcController {
	private CalcModel model;
	private CalcView view;
	private boolean doUseSecondOperand = false;
	private boolean doBeginNextNumber = true;
	
	public CalcController(CalcModel model, CalcView view) {
		this.model = model;
		this.view = view;
		init();
	}
	
	private void init() {
		addObserverToModel();
		observeView();
	}
	
	private void observeView() {
		CalcController controller = this;
		
		Observer a;
		
		a  = new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				String textOnButton = arg.toString();
				if (textOnButton == "=") {
					if (controller.doUseSecondOperand) {
						String x = view.getDisplayText();
						model.setSecondOperand(x);
					}
					model.doOperation();
					controller.doUseSecondOperand = false;
					controller.doBeginNextNumber = true;
					
				} else if (textOnButton == "C") {
					model.reset();
				}
			}
		};
		
		view.buttonClicked.addObserver(a);
		
		// numbers
		a  = new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				String text;
				if (doBeginNextNumber) {
					text = arg.toString();
					doBeginNextNumber = false;
				} else {
					text = view.getDisplayText() + arg.toString();
				}
				
				view.setDisplayText(text);
			}
		};
		
		view.numberClicked.addObserver(a);
		
		// operations
		a  = new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				String op = arg.toString();
				String x = view.getDisplayText();
				model.setFirstOperand(x);
				model.setOperation(op);
				controller.doUseSecondOperand = true;
				controller.doBeginNextNumber = true;
			}
		};
		
		view.operationClicked.addObserver(a);
	}
	
	public void run() {
		view.show();
	}
	
	private void addObserverToModel() {
		Observer a  = new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				String text = (String) arg; 
				view.setDisplayText(text);
			}
		};

		model.resultChanged.addObserver(a);
	}
	
}
