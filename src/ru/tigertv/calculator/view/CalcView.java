package ru.tigertv.calculator.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ru.tigertv.calculator.MyObservable;
import ru.tigertv.calculator.model.CalcModel;

public class CalcView {
	private CalcModel model;
	private JFrame frame;
	
	private JTextField textbox = new JTextField();
	private JPanel panel;
	private JPanel operationPanel;
	private JPanel numbersPanel;
	
	public MyObservable buttonClicked = new MyObservable();
	public MyObservable numberClicked = new MyObservable();
	public MyObservable operationClicked = new MyObservable();
	
	public CalcView (CalcModel model) {
		this.model = model;
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350,350);
		frame.setResizable(false);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		frame.setContentPane(mainPanel);
		
		JPanel displayPanel = new JPanel();
		displayPanel.setBackground(Color.GREEN);
		
		JPanel keyPad = new JPanel();
		keyPad.setBackground(Color.BLUE);
		
		mainPanel.add(displayPanel, BorderLayout.NORTH);
		mainPanel.add(keyPad);
		
		panel = new JPanel(new GridLayout(4,3,3,3));
		operationPanel = new JPanel(new GridLayout(4,1,3,3));
		numbersPanel = new JPanel(new GridLayout(4,3,3,3));
		
		keyPad.add(numbersPanel);
		keyPad.add(operationPanel);
		keyPad.add(panel);
		
		textbox.setPreferredSize(new Dimension(300,50));
		textbox.setText("0");
		textbox.setHorizontalAlignment(SwingConstants.RIGHT);
		textbox.setFont(new Font("Arial", 0, 40));
		//textbox.setEditable(false);
		textbox.setFocusable(false);
		displayPanel.add(textbox);

		ActionListener buttonHander;
		
		// numbers
		buttonHander = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				numberClicked.change();
				numberClicked.notifyObservers(e.getActionCommand());
			}
		};
		
		for (int i=1;i<11;i++) {
			JButton button = addButtonOnPanel(numbersPanel, String.valueOf(i % 10));
			button.addActionListener(buttonHander);
		}
		
		// operations
		buttonHander = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				operationClicked.change();
				operationClicked.notifyObservers(e.getActionCommand());
			}
		};

		addButtonOnPanel(operationPanel, "+").addActionListener(buttonHander);
		addButtonOnPanel(operationPanel, "-").addActionListener(buttonHander);
		addButtonOnPanel(operationPanel, "/").addActionListener(buttonHander);
		addButtonOnPanel(operationPanel, "*").addActionListener(buttonHander);
		
		buttonHander = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked.change();
				buttonClicked.notifyObservers(e.getActionCommand());
			}
		};
		
		addButtonOnPanel(panel, "C").addActionListener(buttonHander);
		addButtonOnPanel(panel, "=").addActionListener(buttonHander);
	}
	
	public void show() {
		frame.setVisible(true);
	}
	
	private JButton addButtonOnPanel(JPanel panel, String text) {
		JButton button = new JButton(text);
		button.setPreferredSize(new Dimension(50,50));
		button.setFocusPainted(false);
		button.setMargin(new Insets(0, 0, 0, 0));
		panel.add(button);
		return button;
	}
	
	public String getDisplayText() {
		return textbox.getText();
	}

	public void setDisplayText(String text) {
		textbox.setText(text);
	}
	
}
