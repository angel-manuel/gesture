package es.uam.eps.padsof.gesture.gui.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;
/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class AutoView extends View {
	private static final long serialVersionUID = -9187517647646743956L;
	private final JPanel panel_2 = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public AutoView() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(16);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_1.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(16);
		panel_1.add(passwordField);
		add(panel_2);
		
		JButton btnNewButton = new JButton("New button");
		panel_2.add(btnNewButton);

	}

}
