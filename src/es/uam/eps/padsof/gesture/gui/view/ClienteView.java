package es.uam.eps.padsof.gesture.gui.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.PoliticaNotificacion;
import es.uam.eps.padsof.gesture.gui.controller.Controller;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class ClienteView extends View {
	private static final long serialVersionUID = 7511588629854862824L;
	private final JTextField nombreFld;
	private final JTextField apellidosFld;
	private final JTextField emailFld;
	private final JTextField direccionFld;
	private final JTextField codigoPostalFld;
	private final JComboBox<PoliticaNotificacion> politicaNotificacionCombo;
	private final JButton registrarBtn;
	
	public ClienteView(Cliente cliente, boolean editable){
		setLayout(new BorderLayout());
		
		SpringLayout layout = new SpringLayout();
		JPanel formPanel = new JPanel(layout);
		
		JLabel nombreLbl = new JLabel("Nombre:");
		nombreFld = new JTextField(cliente.getNombre());
		nombreFld.setColumns(16);
		nombreFld.setEnabled(editable);
		nombreFld.setActionCommand("nombre changed");
		JLabel apellidosLbl = new JLabel("Apellidos:");
		apellidosFld = new JTextField(cliente.getApellido());
		apellidosFld.setColumns(16);
		apellidosFld.setEnabled(editable);
		nombreFld.setActionCommand("apellidos changed");
		JLabel emailLbl = new JLabel("E-mail:");
		emailFld = new JTextField(cliente.getEmail());
		emailFld.setColumns(16);
		emailFld.setEnabled(editable);
		nombreFld.setActionCommand("email changed");
		JLabel direccionLbl = new JLabel("Direccion:");
		direccionFld = new JTextField(cliente.getDireccion());
		direccionFld.setColumns(16);
		direccionFld.setEnabled(editable);
		JLabel codigoPostalLbl = new JLabel("Codigo Postal:");
		codigoPostalFld = new JTextField(cliente.getCodigoPostal());
		codigoPostalFld.setColumns(16);
		codigoPostalFld.setEnabled(editable);
		
		JLabel politicaNotificacionLbl = new JLabel("Política de notificación:");
		politicaNotificacionCombo = new JComboBox<>(PoliticaNotificacion.values());
		politicaNotificacionCombo.setEnabled(editable);
		
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
		if(editable == true){
			registrarBtn.setActionCommand("registrar click");
			registrarClientePanel.add(registrarBtn);
			add(registrarClientePanel, BorderLayout.SOUTH);	
		}
		setMinimumSize(new Dimension(300, 80));
		setMaximumSize(new Dimension(300, 80));
	}

	@Override
	public void setControlador(Controller c) {
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
