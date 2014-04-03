package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class CheckBox extends JFrame {

	private JPanel contentPane;
	private JCheckBox check1;
	private JCheckBox check2;
	private JCheckBox check3;
	String t="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBox frame = new CheckBox();
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
	public CheckBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Lucida Console", Font.PLAIN, 22));
		lblPaciente.setBounds(145, 11, 162, 35);
		contentPane.add(lblPaciente);
		
		check1 = new JCheckBox("Fumador");
		check1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(check1.isSelected()==true)
					t="Es fumador";
				else
					t="No es fumador";
				JOptionPane.showMessageDialog(contentPane, t);
			}
		});
		check1.setBounds(37, 49, 97, 23);
		contentPane.add(check1);
		
		check2 = new JCheckBox("Privado");
		check2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(check2.isSelected()==true)
					t="De sanidad privada";
				else
					t="De sanidad publica";
				JOptionPane.showMessageDialog(contentPane, t);
			}
		});
		check2.setBounds(37, 121, 97, 23);
		contentPane.add(check2);
		
		check3 = new JCheckBox("Vida Sedentaria");
		check3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(check3.isSelected()==true)
					t="Lleva una vida Sedentaria";
				else
					t="Lleva una vida Activa";
				JOptionPane.showMessageDialog(contentPane, t);
			}
		});
		check3.setBounds(37, 193, 114, 23);
		contentPane.add(check3);
	}
	public JCheckBox getCheck1() {
		return check1;
	}
	public JCheckBox getCheck2() {
		return check2;
	}
	public JCheckBox getCheck3() {
		return check3;
	}
}
