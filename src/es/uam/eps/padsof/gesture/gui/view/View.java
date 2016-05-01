package es.uam.eps.padsof.gesture.gui.view;

import javax.swing.JPanel;

import es.uam.eps.padsof.gesture.gui.controller.Controller;

public abstract class View extends JPanel {
	private static final long serialVersionUID = 7678354182067227949L;

	public void setControlador(Controller c) {};
}
