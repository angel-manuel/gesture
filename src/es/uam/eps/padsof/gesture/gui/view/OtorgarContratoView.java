package es.uam.eps.padsof.gesture.gui.view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.Contrato;
import es.uam.eps.padsof.gesture.ContratoEstandar;
import es.uam.eps.padsof.gesture.ContratoPreferente;
import es.uam.eps.padsof.gesture.gui.controller.Controller;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class OtorgarContratoView extends View {

	public final JComboBox<String> tipoCombo;
	public final JLabel costeLbl;
	public final JButton otoBtn;

	public OtorgarContratoView(Cliente cliente) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new JLabel("Otorgando contrato a " + cliente.toString()));
		String[] comboOpts = { "Estandar", "Preferente" };
		this.add(tipoCombo = new JComboBox<String>(comboOpts));
		this.add(costeLbl = new JLabel("Coste: " + ContratoEstandar.PRECIO));
		tipoCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				switch ((String)e.getItem()) {
				case "Estandar":
					costeLbl.setText("Coste: " + ContratoEstandar.PRECIO);
					break;
				case "Preferente":
					costeLbl.setText("Coste: " + ContratoPreferente.PRECIO);
					break;
				}
			}
		});
		
		this.add(otoBtn = new JButton("Otorgar"));
	}
	
	public void setControlador(final Controller c) {
		otoBtn.addActionListener(c);
	}

	public Contrato getContrato() {
		if (tipoCombo.getSelectedIndex() == 0) {
			return new ContratoEstandar();
		} else {
			return new ContratoPreferente();
		}
	}
}
