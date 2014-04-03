package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.SwingConstants;

public class MiPrimerWB extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textContador;
	int cont=1;
	private JTextField cadena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiPrimerWB frame = new MiPrimerWB();
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
	public MiPrimerWB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 467);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblCodigo = new JLabel("Ruta");
		lblCodigo.setBackground(new Color(255, 192, 203));
		lblCodigo.setForeground(Color.BLUE);
		lblCodigo.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCodigo.setBounds(66, 69, 80, 34);
		contentPane.add(lblCodigo);
		lblCodigo.setOpaque(true);
		
		textCodigo = new JTextField();
		textCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCodigo.setBounds(148, 69, 326, 35);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JButton btnBoton = new JButton("Seleccionar");
		btnBoton.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser("C:/");
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int seleccion =fc.showDialog(contentPane,"Seleccionar");
				if(seleccion ==JFileChooser.APPROVE_OPTION)
				textCodigo.setText(fc.getSelectedFile().getAbsolutePath());
			}
		});
		btnBoton.setBackground(new Color(255, 182, 193));
		btnBoton.setForeground(new Color(0, 0, 128));
		btnBoton.setBounds(193, 129, 235, 35);
		contentPane.add(btnBoton);
		btnBoton.setOpaque(true);
		
		JButton btnPincha = new JButton("Pincha");
		btnPincha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textContador.setText(String.valueOf(cont));
				cont++;
			}
		});
		btnPincha.setBackground(new Color(255, 20, 147));
		btnPincha.setVerticalAlignment(SwingConstants.TOP);
		btnPincha.setForeground(new Color(127, 255, 0));
		btnPincha.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPincha.setBounds(175, 221, 120, 49);
		contentPane.add(btnPincha);
		
		textContador = new JTextField();
		textContador.setText("0");
		textContador.setEditable(false);
		textContador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textContador.setColumns(10);
		textContador.setBounds(165, 175, 153, 35);
		contentPane.add(textContador);
		
		JLabel lblContador = new JLabel("Contador");
		lblContador.setOpaque(true);
		lblContador.setForeground(Color.BLUE);
		lblContador.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblContador.setBackground(new Color(199, 21, 133));
		lblContador.setBounds(67, 175, 99, 34);
		contentPane.add(lblContador);
		
		cadena = new JTextField();
		cadena.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cadena.setColumns(10);
		cadena.setBounds(66, 281, 131, 35);
		contentPane.add(cadena);
		
		JButton btnAadirX = new JButton("Añadir x");
		btnAadirX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t=cadena.getText();
				t=t+"x";
				cadena.setText(t);
			}
		});
		btnAadirX.setVerticalAlignment(SwingConstants.TOP);
		btnAadirX.setForeground(new Color(127, 255, 0));
		btnAadirX.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAadirX.setBackground(new Color(255, 20, 147));
		btnAadirX.setBounds(76, 327, 109, 31);
		contentPane.add(btnAadirX);
		
		
	}
}
