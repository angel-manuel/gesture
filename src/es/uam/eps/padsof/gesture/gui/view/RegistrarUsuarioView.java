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
public class RegistrarUsuarioView extends View{

	private static final long serialVersionUID = 6104809181652659712L;
	public static final String USER_CHANGED_COMMAND = "user changed";
	private final JTextField nombreFld;
	private final JPasswordField passFld;
	private final JButton registrarBtn;
	
	public RegistrarUsuarioView(){
		setLayout(new BorderLayout());
		SpringLayout layout = new SpringLayout();
		JPanel formPanel = new JPanel(layout);
		
		JLabel nombreLbl = new JLabel("Username: ");
		nombreFld = new JTextField("");
		nombreFld.setColumns(16);
		JLabel passLbl = new JLabel("Password: ");
		passFld = new JPasswordField("");
		passFld.setColumns(16);
		
		layout.putConstraint(SpringLayout.WEST, nombreLbl, 20, SpringLayout.WEST, formPanel);
		//layout.putConstraint(SpringLayout.NORTH, userLbl, 8, SpringLayout.NORTH, formPanel);
		
		layout.putConstraint(SpringLayout.WEST, nombreFld, 8, SpringLayout.EAST, nombreLbl);
		layout.putConstraint(SpringLayout.NORTH, nombreFld, 5, SpringLayout.NORTH, formPanel);
		
		layout.putConstraint(SpringLayout.WEST, passFld, 0, SpringLayout.WEST, nombreFld);
		layout.putConstraint(SpringLayout.WEST, passLbl, 0, SpringLayout.WEST, nombreLbl);
		
		//layout.putConstraint(SpringLayout.NORTH, passLbl, 15, SpringLayout.SOUTH, userLbl);
		layout.putConstraint(SpringLayout.NORTH, passFld, 10, SpringLayout.SOUTH, nombreFld);
		
		layout.putConstraint(SpringLayout.BASELINE, nombreLbl, 0, SpringLayout.BASELINE, nombreFld);
		layout.putConstraint(SpringLayout.BASELINE, passLbl, 0, SpringLayout.BASELINE, passFld);
		
		formPanel.add(nombreLbl);
		formPanel.add(nombreFld);
		formPanel.add(passLbl);
		formPanel.add(passFld);
		
		formPanel.setPreferredSize(new Dimension(200, 50));
		
		add(formPanel, BorderLayout.CENTER);
		
		JPanel registrarPanel = new JPanel();
		registrarBtn = new JButton("Registrar");
		registrarPanel.add(registrarBtn);
		add(registrarPanel, BorderLayout.SOUTH);
		
		setPreferredSize(new Dimension(300, 80));
	}
	
	public void setControlador(final ActionListener c){
		nombreFld.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) { change();}
			public void removeUpdate(DocumentEvent e) { change(); }
			public void insertUpdate(DocumentEvent e) { change(); }
			public void change() {
			   c.actionPerformed(new ActionEvent(nombreFld, ActionEvent.ACTION_LAST, USER_CHANGED_COMMAND));
			}
		});
		
		registrarBtn.addActionListener(c);
	}
	
	public String getNombre(){
		return nombreFld.getText();
	}
	
	public String getPassword() {
		return new StringBuilder().append(passFld.getPassword()).toString();
	}
	
	public void setUsuarioStatus(boolean correct) {
		if (!correct) {
			nombreFld.setBackground(new Color(20, 170, 0));
		} else {
			nombreFld.setBackground(new Color(255, 255, 255));
		}
	}

}
