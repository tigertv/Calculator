package ru.tigertv.calculator;

import java.util.Observable;

public class MyObservable extends Observable {
	public void change() {
		setChanged();
	}
}
