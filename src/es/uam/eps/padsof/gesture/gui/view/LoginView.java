package es.uam.eps.padsof.gesture.gui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class LoginView extends JPanel {
	public static final String USER_CHANGED_COMMAND = "user changed";
	
	private final JTextField userFld;
	private final JPasswordField passFld;
	private final JButton loginBtn;
	
	public LoginView() {
		setLayout(new BorderLayout());
		
		SpringLayout layout = new SpringLayout();
		JPanel formPanel = new JPanel(layout);
		
		JLabel userLbl = new JLabel("Username:");
		userFld = new JTextField("");
		userFld.setColumns(16);
		JLabel passLbl = new JLabel("Password:");
		passFld = new JPasswordField("");
		passFld.setColumns(16);
		
		layout.putConstraint(SpringLayout.WEST, userLbl, 20, SpringLayout.WEST, formPanel);
		//layout.putConstraint(SpringLayout.NORTH, userLbl, 8, SpringLayout.NORTH, formPanel);
		
		layout.putConstraint(SpringLayout.WEST, userFld, 8, SpringLayout.EAST, userLbl);
		layout.putConstraint(SpringLayout.NORTH, userFld, 5, SpringLayout.NORTH, formPanel);
		
		layout.putConstraint(SpringLayout.WEST, passFld, 0, SpringLayout.WEST, userFld);
		layout.putConstraint(SpringLayout.WEST, passLbl, 0, SpringLayout.WEST, userLbl);
		
		//layout.putConstraint(SpringLayout.NORTH, passLbl, 15, SpringLayout.SOUTH, userLbl);
		layout.putConstraint(SpringLayout.NORTH, passFld, 10, SpringLayout.SOUTH, userFld);
		
		layout.putConstraint(SpringLayout.BASELINE, userLbl, 0, SpringLayout.BASELINE, userFld);
		layout.putConstraint(SpringLayout.BASELINE, passLbl, 0, SpringLayout.BASELINE, passFld);
		
		formPanel.add(userLbl);
		formPanel.add(userFld);
		formPanel.add(passLbl);
		formPanel.add(passFld);
		
		formPanel.setPreferredSize(new Dimension(200, 50));
		
		add(formPanel, BorderLayout.CENTER);
		
		JPanel loginPanel = new JPanel();
		loginBtn = new JButton("Login");
		loginPanel.add(loginBtn);
		add(loginPanel, BorderLayout.SOUTH);
		
		setPreferredSize(new Dimension(300, 80));
		/*
		setMinimumSize(new Dimension(300, 80));
		setMaximumSize(new Dimension(300, 80));*/
	}
	
	public void setControlador(final ActionListener c) {
		userFld.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) { change();}
			public void removeUpdate(DocumentEvent e) { change(); }
			public void insertUpdate(DocumentEvent e) { change(); }
			public void change() {
			   c.actionPerformed(new ActionEvent(userFld, ActionEvent.ACTION_LAST, USER_CHANGED_COMMAND));
			}
		});
		
		loginBtn.addActionListener(c);
	}
	
	public String getNombre() {
		return userFld.getText();
	}

	public String getContraseña() {
		return new StringBuilder().append(passFld.getPassword()).toString();
	}
	
	public void setClienteStatus(boolean correct) {
		if (correct) {
			userFld.setBackground(new Color(20, 170, 0));
		} else {
			userFld.setBackground(new Color(255, 255, 255));
		}
	}
}
