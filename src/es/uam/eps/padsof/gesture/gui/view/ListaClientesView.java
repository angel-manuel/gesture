package es.uam.eps.padsof.gesture.gui.view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import es.uam.eps.padsof.gesture.Cliente;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class ListaClientesView extends View {

	private static final long serialVersionUID = 3013456589547186563L;
	
	private final JList<Cliente> cliLst;
	private final List<Cliente> clientes;
	private List<Consumer<Cliente>> selectionListeners = new ArrayList<>();

	public ListaClientesView(List<Cliente> clientes) {
		this.clientes = clientes;
		
		cliLst = new JList<Cliente>(clientes.stream().collect(Collectors.toCollection(Vector::new)));
	
		cliLst.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Cliente cliSel = getSelectedCliente();
				if (!e.getValueIsAdjusting()) {
					for (Consumer<Cliente> listener: selectionListeners) {
						listener.accept(cliSel);
					}
				}
			}
		});
		
		cliLst.setPreferredSize(new Dimension(400, 500));
		
		this.add(new JScrollPane(cliLst));
	}
	
	public Cliente getSelectedCliente() {
		int selectedInd = cliLst.getSelectedIndex();
		
		if (selectedInd >= 0) {
			return clientes.get(selectedInd);
		} else {
			return null;
		}
	}

	public void addClientSelectedListener(Consumer<Cliente> listener) {
		selectionListeners.add(listener);
	}
}
