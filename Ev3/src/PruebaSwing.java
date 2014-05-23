import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PruebaSwing extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaSwing frame = new PruebaSwing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PruebaSwing() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PruebaSwing.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 4, true), "ALOHA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 255)));
		panel.setBackground(Color.ORANGE);
		panel.setBounds(21, 11, 389, 87);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.LIGHT_GRAY);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(33, 137, 198, 119);
		contentPane.add(panel_1);
		
		JLabel lblHola = new JLabel("Hola");
		panel_1.add(lblHola);
		lblHola.setVerticalAlignment(SwingConstants.TOP);
		lblHola.setForeground(Color.WHITE);
		lblHola.setBackground(Color.WHITE);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("escribe texto");
		passwordField.setBounds(275, 150, 96, 20);
		contentPane.add(passwordField);
		
		comboBox = new JComboBox();
		comboBox.setToolTipText("selecciona");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.addItem("Hola");
				comboBox.addItem("Adios");
			}
		});
		comboBox.setBounds(241, 212, 150, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Saludo");
		lblNewLabel.setBounds(299, 187, 46, 14);
		contentPane.add(lblNewLabel);
		panel.setVisible(true);
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
}
