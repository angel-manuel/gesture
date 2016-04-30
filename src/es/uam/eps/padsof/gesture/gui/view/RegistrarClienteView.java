package es.uam.eps.padsof.gesture.gui.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import es.uam.eps.padsof.gesture.PoliticaNotificacion;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class RegistrarClienteView extends JPanel{
	private static final long serialVersionUID = 7511588629854862824L;
	private final JTextField nombreFld;
	private final JTextField apellidosFld;
	private final JTextField emailFld;
	private final JTextField direccionFld;
	private final JTextField codigoPostalFld;
	private final JComboBox<PoliticaNotificacion> politicaNotificacionCombo;
	private final JButton registrarBtn;
	
	public RegistrarClienteView(){
setLayout(new BorderLayout());
		
		SpringLayout layout = new SpringLayout();
		JPanel formPanel = new JPanel(layout);
		
		JLabel nombreLbl = new JLabel("Nombre:");
		nombreFld = new JTextField("");
		nombreFld.setColumns(16);
		nombreFld.setActionCommand("nombre changed");
		JLabel apellidosLbl = new JLabel("Apellidos:");
		apellidosFld = new JTextField("");
		apellidosFld.setColumns(16);
		nombreFld.setActionCommand("apellidos changed");
		JLabel emailLbl = new JLabel("E-mail:");
		emailFld = new JTextField("");
		emailFld.setColumns(16);
		nombreFld.setActionCommand("email changed");
		JLabel direccionLbl = new JLabel("Direccion:");
		direccionFld = new JTextField("");
		direccionFld.setColumns(16);
		JLabel codigoPostalLbl = new JLabel("Codigo Postal:");
		codigoPostalFld = new JTextField("");
		codigoPostalFld.setColumns(16);
		
		JLabel politicaNotificacionLbl = new JLabel("Política de notificación:");
		politicaNotificacionCombo = new JComboBox<>(PoliticaNotificacion.values());
		
		layout.putConstraint(SpringLayout.WEST, nombreLbl, 20, SpringLayout.WEST, formPanel);
		layout.putConstraint(SpringLayout.NORTH, nombreLbl, 20, SpringLayout.NORTH, formPanel);
		layout.putConstraint(SpringLayout.NORTH, nombreFld, 0, SpringLayout.NORTH, nombreLbl);

		layout.putConstraint(SpringLayout.WEST, nombreFld, 160, SpringLayout.EAST, nombreLbl);
		
		layout.putConstraint(SpringLayout.WEST, apellidosFld, 0, SpringLayout.WEST, nombreFld);
		layout.putConstraint(SpringLayout.WEST, apellidosLbl, 0, SpringLayout.WEST, nombreLbl);
		layout.putConstraint(SpringLayout.WEST, emailFld, 0, SpringLayout.WEST, nombreFld);
		layout.putConstraint(SpringLayout.WEST, emailLbl, 0, SpringLayout.WEST, nombreLbl);
		layout.putConstraint(SpringLayout.WEST, direccionFld, 0, SpringLayout.WEST, nombreFld);
		layout.putConstraint(SpringLayout.WEST, direccionLbl, 0, SpringLayout.WEST, nombreLbl);
		layout.putConstraint(SpringLayout.WEST, codigoPostalFld, 0, SpringLayout.WEST, nombreFld);
		layout.putConstraint(SpringLayout.WEST, codigoPostalLbl, 0, SpringLayout.WEST, nombreLbl);
		layout.putConstraint(SpringLayout.WEST, politicaNotificacionCombo, 0, SpringLayout.WEST, nombreFld);
		layout.putConstraint(SpringLayout.WEST, politicaNotificacionLbl, 0, SpringLayout.WEST, nombreLbl);
		
		layout.putConstraint(SpringLayout.NORTH, apellidosFld, 10, SpringLayout.SOUTH, nombreFld);
		layout.putConstraint(SpringLayout.NORTH, emailFld, 10, SpringLayout.SOUTH, apellidosFld);
		layout.putConstraint(SpringLayout.NORTH, direccionFld, 10, SpringLayout.SOUTH, emailFld);
		layout.putConstraint(SpringLayout.NORTH, codigoPostalFld, 10, SpringLayout.SOUTH, direccionFld);
		layout.putConstraint(SpringLayout.NORTH, politicaNotificacionCombo, 10, SpringLayout.SOUTH, codigoPostalFld);
		
		layout.putConstraint(SpringLayout.BASELINE, nombreLbl, 0, SpringLayout.BASELINE, nombreFld);
		layout.putConstraint(SpringLayout.BASELINE, apellidosLbl, 0, SpringLayout.BASELINE, apellidosFld);
		layout.putConstraint(SpringLayout.BASELINE, emailLbl, 0, SpringLayout.BASELINE, emailFld);
		layout.putConstraint(SpringLayout.BASELINE, direccionLbl, 0, SpringLayout.BASELINE, direccionFld);
		layout.putConstraint(SpringLayout.BASELINE, codigoPostalLbl, 0, SpringLayout.BASELINE, codigoPostalFld);
		layout.putConstraint(SpringLayout.BASELINE, politicaNotificacionLbl, 0, SpringLayout.BASELINE, politicaNotificacionCombo);
		
		formPanel.add(nombreLbl);
		formPanel.add(nombreFld);
		formPanel.add(apellidosLbl);
		formPanel.add(apellidosFld);
		formPanel.add(emailLbl);
		formPanel.add(emailFld);
		formPanel.add(direccionLbl);
		formPanel.add(direccionFld);
		formPanel.add(codigoPostalLbl);
		formPanel.add(codigoPostalFld);
		formPanel.add(politicaNotificacionLbl);
		formPanel.add(politicaNotificacionCombo);
		
		formPanel.setPreferredSize(new Dimension(600, 400));
		
		add(formPanel, BorderLayout.CENTER);
		
		JPanel registrarClientePanel = new JPanel();
		registrarBtn = new JButton("Registrar");
		registrarBtn.setActionCommand("registrar click");
		registrarClientePanel.add(registrarBtn);
		add(registrarClientePanel, BorderLayout.SOUTH);
		
		setMinimumSize(new Dimension(300, 80));
		setMaximumSize(new Dimension(300, 80));
	}

	public void setControlador(ActionListener c) {
		nombreFld.addActionListener(c);
		apellidosFld.addActionListener(c);
		emailFld.addActionListener(c);
		registrarBtn.addActionListener(c);
	}
	
	public String getNombre() {
		return nombreFld.getText();
	}
	
	public String getApellidos() {
		return apellidosFld.getText();
	}
	
	public String getEmail() {
		return emailFld.getText();
	}
	
	public String getDireccion() {
		return direccionFld.getText();
	}
	
	public String getCodigoPostal() {
		return codigoPostalFld.getText();
	}
	
	public PoliticaNotificacion getPoliticaNotificacion() {
		return politicaNotificacionCombo.getItemAt(politicaNotificacionCombo.getSelectedIndex());
	}
}
