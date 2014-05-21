package exportarTablas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ExportarDeMySQL extends JFrame {

	private JPanel contentPane;
	private JTextField textIP;
	private JTextField textUsuario;
	private JTextField textContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExportarDeMySQL frame = new ExportarDeMySQL();
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
	public ExportarDeMySQL() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textIP = new JTextField();
		textIP.setBounds(202, 58, 127, 20);
		contentPane.add(textIP);
		textIP.setColumns(10);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(202, 118, 127, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		textContrasenia = new JTextField();
		textContrasenia.setBounds(202, 186, 127, 20);
		contentPane.add(textContrasenia);
		textContrasenia.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a");
		lblNewLabel.setBounds(74, 189, 68, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setBounds(74, 121, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblIpMysql = new JLabel("IP MySQL");
		lblIpMysql.setBounds(74, 61, 46, 14);
		contentPane.add(lblIpMysql);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BaseDatos BD=new BaseDatos(textIP.getText(), textUsuario.getText(), textContrasenia.getText());
				try {
					BD.extraerTabla("sakila", "actor", null);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConectar.setBounds(139, 233, 89, 23);
		contentPane.add(btnConectar);
	}
	
}
