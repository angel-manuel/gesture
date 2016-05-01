package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import es.uam.eps.padsof.gesture.gui.view.View;

public abstract class Controller implements ActionListener {
	protected View view;
	
	public Controller(View view) {
		this.view = view;
		this.view.setControlador(this);
	}
	
	public JPanel getView() {
		return view;
	}
	
	public void detachView() {
		view = null;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {}
}
