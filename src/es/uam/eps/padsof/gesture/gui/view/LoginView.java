package es.uam.eps.padsof.gesture.gui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import es.uam.eps.padsof.gesture.gui.controller.Controller;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class LoginView extends View {
	private static final long serialVersionUID = 437834601322500829L;

	public static final String USER_CHANGED_COMMAND = "user changed";
	
	private final JTextField userFld;
	private final JPasswordField passFld;
	private final JButton loginBtn;
	
	public LoginView() {
		JLabel gestureLbl = new JLabel("Gesture");
		gestureLbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		JLabel userLbl = new JLabel("Username:");
		userFld = new JTextField("");
		userFld.setColumns(16);
		JLabel passLbl = new JLabel("Password:");
		passFld = new JPasswordField("");
		passFld.setColumns(16);
		
		SpringLayout layout = new SpringLayout();
		JPanel formPanel = this;
		setLayout(layout);

		loginBtn = new JButton("Login");
		
		formPanel.add(gestureLbl);
		formPanel.add(userLbl);
		formPanel.add(userFld);
		formPanel.add(passLbl);
		formPanel.add(passFld);
		formPanel.add(loginBtn);
		
		layout.putConstraint(SpringLayout.SOUTH, gestureLbl, -20, SpringLayout.VERTICAL_CENTER, formPanel);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, gestureLbl, 0, SpringLayout.HORIZONTAL_CENTER, formPanel);
		
		layout.putConstraint(SpringLayout.WEST, userFld, 0, SpringLayout.HORIZONTAL_CENTER, formPanel);
		layout.putConstraint(SpringLayout.SOUTH, userFld, 0, SpringLayout.VERTICAL_CENTER, formPanel);
		layout.putConstraint(SpringLayout.BASELINE, userLbl, 0, SpringLayout.BASELINE, userFld);
		layout.putConstraint(SpringLayout.BASELINE, passLbl, 0, SpringLayout.BASELINE, passFld);
		layout.putConstraint(SpringLayout.EAST, userLbl, -10, SpringLayout.WEST, userFld);
		layout.putConstraint(SpringLayout.EAST, passLbl, -10, SpringLayout.WEST, passFld);
		layout.putConstraint(SpringLayout.WEST, passFld, 0, SpringLayout.WEST, userFld);
		layout.putConstraint(SpringLayout.NORTH, passFld, 10, SpringLayout.SOUTH, userFld);
		layout.putConstraint(SpringLayout.NORTH, loginBtn, 15, SpringLayout.SOUTH, passFld);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, loginBtn, 0, SpringLayout.HORIZONTAL_CENTER, formPanel);
		
		//layout.putConstraint(SpringLayout.EAST, formPanel, 0, SpringLayout.EAST, userFld);
		
		Dimension minSize = layout.minimumLayoutSize(formPanel);
		formPanel.setMinimumSize(minSize);
		formPanel.setPreferredSize(new Dimension(400, 200));
		formPanel.setBorder(new LineBorder(new Color(200, 80, 0), 10));
	}
	
	@Override
	public void setControlador(final Controller c) {
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
