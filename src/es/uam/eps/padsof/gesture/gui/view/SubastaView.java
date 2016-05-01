package es.uam.eps.padsof.gesture.gui.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import es.uam.eps.padsof.gesture.gui.controller.Controller;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class SubastaView extends View {
	private static final long serialVersionUID = 1967547261297876738L;
	private final JTextField precioSalidaFld;
	private final JTextField objetoFld;
	private final JSpinner duracion;
	private final JButton iniciarBtn;
	
	public SubastaView(){
		setLayout(new BorderLayout());
		
		SpringLayout layout = new SpringLayout();
		JPanel formPanel = new JPanel(layout);
		
		JLabel precioSalidaLbl = new JLabel("Precio de salida (en €): ");
		precioSalidaFld = new JTextField("");
		precioSalidaFld.setColumns(16);
		JLabel objetoLbl = new JLabel("Objeto a subastar: ");
		objetoFld = new JTextField("");
		objetoFld.setColumns(16);
		JLabel duracionLbl = new JLabel("Duración de la subasta (en días): ");
		duracion = new JSpinner();
		duracion.setSize(10, 20);
		
		layout.putConstraint(SpringLayout.WEST, precioSalidaLbl, 20, SpringLayout.WEST, formPanel);
		layout.putConstraint(SpringLayout.NORTH, precioSalidaLbl, 20, SpringLayout.NORTH, formPanel);
		layout.putConstraint(SpringLayout.NORTH, precioSalidaFld, 0, SpringLayout.NORTH, precioSalidaLbl);

		layout.putConstraint(SpringLayout.WEST, precioSalidaFld, 160, SpringLayout.EAST, precioSalidaLbl);
		
		layout.putConstraint(SpringLayout.WEST, objetoFld, 0, SpringLayout.WEST, precioSalidaFld);
		layout.putConstraint(SpringLayout.WEST, objetoLbl, 0, SpringLayout.WEST, precioSalidaLbl);
		layout.putConstraint(SpringLayout.WEST, duracion, 0, SpringLayout.WEST, precioSalidaFld);
		layout.putConstraint(SpringLayout.WEST, duracionLbl, 0, SpringLayout.WEST, precioSalidaLbl);
		
		layout.putConstraint(SpringLayout.NORTH, objetoFld, 10, SpringLayout.SOUTH, precioSalidaFld);
		layout.putConstraint(SpringLayout.NORTH, duracion, 10, SpringLayout.SOUTH, objetoFld);
		
		layout.putConstraint(SpringLayout.BASELINE, precioSalidaLbl, 0, SpringLayout.BASELINE, precioSalidaFld);
		layout.putConstraint(SpringLayout.BASELINE, objetoLbl, 0, SpringLayout.BASELINE, objetoFld);
		layout.putConstraint(SpringLayout.BASELINE, duracionLbl, 0, SpringLayout.BASELINE, duracion);
		
		formPanel.add(precioSalidaLbl);
		formPanel.add(precioSalidaFld);
		formPanel.add(objetoLbl);
		formPanel.add(objetoFld);
		formPanel.add(duracionLbl);
		formPanel.add(duracion);
		
		formPanel.setPreferredSize(new Dimension(200, 50));
		
		add(formPanel, BorderLayout.CENTER);
		
		JPanel subastaPanel = new JPanel();
		iniciarBtn = new JButton("Iniciar Subasta");
		subastaPanel.add(iniciarBtn);
		add(subastaPanel, BorderLayout.SOUTH);
		
		setPreferredSize(new Dimension(300, 80));
	}
	
	@Override
	public void setControlador(Controller c) {
		precioSalidaFld.addActionListener(c);
		objetoFld.addActionListener(c);
	}
	
	public String getPrecioSalida(){
		return precioSalidaFld.getText();
	}
	
	public String getObjetoSubasta(){
		return objetoFld.getText();
	}
	
	public int getDuracionSubasta(){
		return (int) duracion.getValue();
	}
}
