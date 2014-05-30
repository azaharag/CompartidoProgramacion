package jTable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class JTableComboBox extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField ip;
	private JTextField usuario;
	private JPasswordField password;
	private BaseDatos bd;
	private DefaultTableModel dtm;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableComboBox frame = new JTableComboBox();
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
	public JTableComboBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 174, 555, 207);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		comboBox = new JComboBox();
		comboBox.addItem("Todas");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox.setBounds(10, 392, 200, 25);
		contentPane.add(comboBox);
		
		JButton btnMostrarTabla = new JButton("Mostrar info");
		btnMostrarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnMostrarTabla.setBounds(263, 392, 135, 23);
		contentPane.add(btnMostrarTabla);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 555, 152);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIp = new JLabel("IP:");
		lblIp.setBounds(10, 27, 60, 14);
		panel.add(lblIp);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 68, 60, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 109, 60, 14);
		panel.add(lblContrasea);
		
		ip = new JTextField();
		ip.setText("172.25.245.53");
		ip.setBounds(97, 23, 106, 21);
		panel.add(ip);
		ip.setColumns(10);
		
		usuario = new JTextField();
		usuario.setText("root");
		usuario.setBounds(97, 66, 106, 21);
		panel.add(usuario);
		usuario.setColumns(10);
		
		JButton btnConectar = new JButton("Conectar");
		getRootPane().setDefaultButton(btnConectar);
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bd=new BaseDatos(ip.getText(),usuario.getText(),String.valueOf(password.getPassword()));
				ArrayList<String> col=bd.dameColumnas("sakila", "actor");
				String []cabecera=new String[col.size()];
				ResultSet rs;
				Object [] datos;
				for(int i=0;i<col.size();i++)
				{
					cabecera[i]=col.get(i);
				}
				dtm=new DefaultTableModel(null,cabecera);
				try {
					rs=bd.extraerDatos("sakila","actor");
					ResultSetMetaData rsmd=rs.getMetaData();
					datos=new Object[rsmd.getColumnCount()];
					while(rs.next())
					{
						for(int i=0;i<rsmd.getColumnCount();i++)
						{
							datos[i]=rs.getString(i+1);
						}
						dtm.addRow(datos);
					}
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				table.setModel(dtm);
			}
		});
		btnConectar.setBounds(306, 20, 145, 29);
		panel.add(btnConectar);
		
		password = new JPasswordField();
		password.setBounds(97, 106, 106, 21);
		panel.add(password);
		
		JButton btnDesconectar = new JButton("Desconectar");
		btnDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bd.desconectar();
			}
		});
		btnDesconectar.setBounds(306, 87, 145, 29);
		panel.add(btnDesconectar);
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
}
