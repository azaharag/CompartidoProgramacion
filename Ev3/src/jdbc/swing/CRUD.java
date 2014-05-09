package jdbc.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CRUD extends JFrame {

	private JPanel contentPane;
	private JTextField campoDni;
	private JTextField campoNombre;
	private JTextField campoFecha;
	private JTextField campoTutor;
	private JTextField info;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUD frame = new CRUD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//Connection conexion
	}

	/**
	 * Create the frame.
	 */
	public CRUD() {
		setTitle("Mantenimiento Alumnos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDni.setBounds(27, 29, 78, 28);
		contentPane.add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(27, 90, 78, 28);
		contentPane.add(lblNombre);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaNacimiento.setBounds(27, 149, 113, 28);
		contentPane.add(lblFechaNacimiento);
		
		JLabel lblTutor = new JLabel("Tutor");
		lblTutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTutor.setBounds(27, 208, 78, 28);
		contentPane.add(lblTutor);
		
		campoDni = new JTextField();
		campoDni.setBounds(158, 31, 132, 28);
		contentPane.add(campoDni);
		campoDni.setColumns(10);
		
		campoNombre = new JTextField();
		campoNombre.setColumns(10);
		campoNombre.setBounds(158, 90, 132, 28);
		contentPane.add(campoNombre);
		
		campoFecha = new JTextField();
		campoFecha.setColumns(10);
		campoFecha.setBounds(158, 149, 132, 28);
		contentPane.add(campoFecha);
		
		campoTutor = new JTextField();
		campoTutor.setColumns(10);
		campoTutor.setBounds(158, 208, 132, 28);
		contentPane.add(campoTutor);
		
		JButton btnNewButton = new JButton("Alta/Consulta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(324, 39, 108, 36);
		contentPane.add(btnNewButton);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBaja.setBounds(324, 114, 108, 36);
		contentPane.add(btnBaja);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardar.setBounds(324, 189, 108, 36);
		contentPane.add(btnGuardar);
		
		info = new JTextField();
		info.setEditable(false);
		info.setBounds(125, 271, 196, 53);
		contentPane.add(info);
		info.setColumns(10);
	}
}
