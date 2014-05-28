package importarTablas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.SQLException;

public class importarCSV extends JFrame {

	private JPanel contentPane;
	private JTextField IP;
	private JTextField usuario;
	private JPasswordField password;
	private JPanel csv;
	private JLabel foto;
	private JTextField fichero;
	public BaseDatos bd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					importarCSV frame = new importarCSV();
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
	public importarCSV() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(importarCSV.class.getResource("/jdbcTablaCSV/bien.png")));
		setTitle("Importar CSV");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 139), 3, true), "Conexi\u00F3n", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 255, 255)));
		panel.setForeground(Color.WHITE);
		panel.setBounds(10, 11, 477, 194);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Direcci\u00F3n IP:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 38, 83, 14);
		panel.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblUsuario.setBounds(10, 90, 83, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblContrasea.setBounds(10, 142, 83, 14);
		panel.add(lblContrasea);
		
		IP = new JTextField();
		IP.setText("localhost");
		IP.setBounds(103, 33, 91, 20);
		panel.add(IP);
		IP.setColumns(10);
		
		usuario = new JTextField();
		usuario.setText("root");
		usuario.setBounds(103, 86, 91, 20);
		panel.add(usuario);
		usuario.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(103, 139, 91, 20);
		panel.add(password);
		
		JButton btnConectar = new JButton("Conectar");
		getRootPane().setDefaultButton(btnConectar);
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						bd=new BaseDatos(IP.getText(),usuario.getText(),String.valueOf(password.getPassword()));
						csv.setVisible(true);
						foto.setIcon(new ImageIcon(getClass().getResource("bien.png")));
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, e1.getErrorCode() + "-"+ e1.getMessage(), 
							"Error al conectar con MySQL",JOptionPane.ERROR_MESSAGE);
						foto.setIcon(new ImageIcon(getClass().getResource("mal.png")));
						csv.setVisible(false);
					}
					
				
			}
		});
		btnConectar.setBackground(new Color(175, 238, 238));
		btnConectar.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnConectar.setBounds(323, 32, 111, 41);
		panel.add(btnConectar);
		
		foto = new JLabel("");
		foto.setBounds(323, 91, 126, 79);
		panel.add(foto);
		
		csv = new JPanel();
		csv.setBackground(new Color(0, 128, 128));
		csv.setBorder(new TitledBorder(new LineBorder(new Color(0, 100, 0), 3, true), "Elegir CSV", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 255, 0)));
		csv.setBounds(10, 216, 477, 192);
		contentPane.add(csv);
		csv.setLayout(null);
		csv.setVisible(false);
		
		fichero = new JTextField();
		fichero.setBounds(22, 65, 288, 31);
		csv.add(fichero);
		fichero.setColumns(10);
		
		JLabel lblSeleccionarFichero = new JLabel("Seleccionar Fichero");
		lblSeleccionarFichero.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblSeleccionarFichero.setBounds(161, 27, 154, 14);
		csv.add(lblSeleccionarFichero);
		
		JButton seleccion = new JButton("Seleccionar");
		seleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc=new JFileChooser();
				jfc.setCurrentDirectory(new File("c:/"));
				FileNameExtensionFilter filtroCSV=new FileNameExtensionFilter("Ficheros CSV", "csv");
				jfc.setFileFilter(filtroCSV);
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int seleccion=jfc.showDialog(contentPane, "Seleccionar");
				if(seleccion==JFileChooser.APPROVE_OPTION)
				{
					fichero.setText(jfc.getSelectedFile().getAbsolutePath());
				}
			}
		});
		seleccion.setBackground(new Color(154, 205, 50));
		seleccion.setBounds(320, 65, 106, 31);
		csv.add(seleccion);
		
		JButton importar = new JButton("Importar");
		importar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f=new File(fichero.getText());
				if(bd.ficheroCorrecto(f))
				{
					bd.importarTabla(f);
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, "El fichero es incorrecto", 
							"Error en fichero", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		importar.setBackground(new Color(154, 205, 50));
		importar.setBounds(166, 129, 115, 36);
		csv.add(importar);
	}
	public JPanel getCsv() {
		return csv;
	}
	public JLabel getFoto() {
		return foto;
	}
	public JTextField getFichero() {
		return fichero;
	}
}
