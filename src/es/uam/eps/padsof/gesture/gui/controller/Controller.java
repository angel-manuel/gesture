package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

public abstract class Controller implements ActionListener {
	public abstract JPanel getView();
	public abstract void detachView();
}
