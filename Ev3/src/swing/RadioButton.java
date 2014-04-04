package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class RadioButton extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton btn1;
	private JRadioButton btn2;
	private JRadioButton btn3;
	private JTextArea textArea;
	private JLabel lblObservaciones;
	private JScrollPane scrollPane;
	private JCheckBox chckbxVerObservaciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioButton frame = new RadioButton();
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
	public RadioButton() {
		setTitle("Pruebas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn1 = new JRadioButton("Botón1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				informaEstado();
			}
		});
		buttonGroup.add(btn1);
		btn1.setBounds(22, 25, 109, 23);
		contentPane.add(btn1);
		
		btn2 = new JRadioButton("Botón2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				informaEstado();
			}
		});
		buttonGroup.add(btn2);
		btn2.setBounds(22, 75, 109, 23);
		contentPane.add(btn2);
		
		btn3 = new JRadioButton("Botón3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				informaEstado();
			}
		});
		btn3.setSelected(true);
		buttonGroup.add(btn3);
		btn3.setBounds(22, 125, 109, 23);
		contentPane.add(btn3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(205, 25, 227, 123);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setBackground(Color.ORANGE);
		textArea.setVisible(false);
		
		lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(272, 4, 96, 14);
		contentPane.add(lblObservaciones);
		lblObservaciones.setVisible(false);
		
		chckbxVerObservaciones = new JCheckBox("Ver Observaciones");
		chckbxVerObservaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxVerObservaciones.isSelected())
				{
					lblObservaciones.setVisible(true);
					scrollPane.setVisible(true);
					textArea.setVisible(true);
				}
				else
				{
					lblObservaciones.setVisible(false);
					scrollPane.setVisible(false);
					textArea.setVisible(false);
				}
				
			}
		});
		chckbxVerObservaciones.setBounds(272, 166, 136, 23);
		contentPane.add(chckbxVerObservaciones);
	}
	protected void informaEstado() {
		JOptionPane.showMessageDialog(contentPane, "Botón1: "+btn1.isSelected()+"\n"+"Botón2: "+btn2.isSelected()+"\n"
		+"Botón3: "+btn3.isSelected());
	}

	public JRadioButton getBtn1() {
		return btn1;
	}
	public JRadioButton getBtn2() {
		return btn2;
	}
	public JRadioButton getBtn3() {
		return btn3;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	public JLabel getLblObservaciones() {
		return lblObservaciones;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public JCheckBox getChckbxVerObservaciones() {
		return chckbxVerObservaciones;
	}
}
