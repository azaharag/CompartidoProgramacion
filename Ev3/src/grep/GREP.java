package grep;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JTextArea;

public class GREP extends JFrame {

	private JPanel contentPane;
	private JTextField ruta;
	private JTextField cadena;
	private JCheckBox igMayus;
	private JCheckBox recursividad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GREP frame = new GREP();
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
	public GREP() {
		setTitle("GREP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRutaDondeBuscar = new JLabel("Ruta donde buscar:");
		lblRutaDondeBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRutaDondeBuscar.setBounds(10, 34, 131, 14);
		contentPane.add(lblRutaDondeBuscar);
		
		ruta = new JTextField();
		ruta.setEditable(false);
		ruta.setBounds(150, 33, 143, 20);
		contentPane.add(ruta);
		ruta.setColumns(10);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc=new JFileChooser();
				jfc.setCurrentDirectory(new File("c:/"));
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int seleccion=jfc.showDialog(contentPane, "Seleccionar");
				if(seleccion==JFileChooser.APPROVE_OPTION)
				{
					ruta.setText(jfc.getSelectedFile().getAbsolutePath());
				}
			}
		});
		btnSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSeleccionar.setBounds(321, 32, 111, 23);
		contentPane.add(btnSeleccionar);
		
		JLabel lblCadenaABuscar = new JLabel("Cadena a buscar:");
		lblCadenaABuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadenaABuscar.setBounds(10, 82, 131, 14);
		contentPane.add(lblCadenaABuscar);
		
		cadena = new JTextField();
		cadena.setColumns(10);
		cadena.setBounds(150, 81, 143, 20);
		contentPane.add(cadena);
		
		igMayus = new JCheckBox("Ignorar May\u00FAsculas");
		igMayus.setSelected(true);
		igMayus.setBounds(44, 141, 131, 23);
		contentPane.add(igMayus);
		
		recursividad = new JCheckBox("Buscar en subcarpetas");
		recursividad.setSelected(true);
		recursividad.setBounds(225, 141, 143, 23);
		contentPane.add(recursividad);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(puedoBuscar())
				{
					buscarCadena(ruta.getText(),cadena.getText(),igMayus.isSelected(),recursividad.isSelected());
				}
				else
				{	if(ruta.getText().isEmpty())
					{
						JOptionPane.showInternalMessageDialog(contentPane, "Debe rellenar la ruta","Falta la ruta"
							,JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						JOptionPane.showInternalMessageDialog(contentPane, "Debe rellenar la cadena","Falta la cadena"
								,JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(126, 205, 143, 40);
		contentPane.add(btnBuscar);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(44, 280, 361, 151);
		contentPane.add(textArea);
	}

	protected boolean puedoBuscar() {
		return !ruta.getText().isEmpty()&& !cadena.getText().isEmpty();
		
	}

	protected ArrayList<ItemBusqueda> buscarCadena(String ruta, String cadena,boolean igMayus, boolean recur) {
		ArrayList <ItemBusqueda> listado=new ArrayList<ItemBusqueda>();
		int seleccion=JOptionPane.showConfirmDialog(contentPane,"¿Está bien la ruta? "+ruta, "Confirmación",  JOptionPane.YES_NO_OPTION);
		if(seleccion==JOptionPane.YES_OPTION)
		{
			seleccion=JOptionPane.showConfirmDialog(contentPane,"¿Está bien la cadena de busqueda? "+cadena, 
					"Confirmación", JOptionPane.YES_NO_OPTION);
			if(seleccion==JOptionPane.YES_OPTION)
			{
				//buscar
			}
			else
			{
				String t=JOptionPane.showInputDialog(contentPane, "Introduzca nuevo termino de búsqueda");
				cadena=t;
				//buscar
			}
		}
		else
		{
			JOptionPane.showMessageDialog(contentPane, "Seleccione nueva ruta");
			JFileChooser jfc=new JFileChooser();
			jfc.setCurrentDirectory(new File("c:/"));
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			seleccion=jfc.showDialog(contentPane, "Seleccionar");
			if(seleccion==JFileChooser.APPROVE_OPTION)
			{
				ruta=jfc.getSelectedFile().getAbsolutePath();
			}
			seleccion=JOptionPane.showConfirmDialog(contentPane,"¿Está bien la cadena de busqueda? "+cadena, 
					"Confirmación", JOptionPane.YES_NO_OPTION);
			if(seleccion==JOptionPane.YES_OPTION)
			{
				//buscar
			}
			else
			{
				String t=JOptionPane.showInputDialog(contentPane, "Introduzca nuevo termino de búsqueda");
				cadena=t;
				//buscar
			}
		}
		return null;
	}

	public JCheckBox getChckbxIgnorarMaysculas() {
		return igMayus;
	}
	public JCheckBox getChckbxBuscarEnSubcarpetas() {
		return recursividad;
	}
	public JTextField getTextField() {
		return ruta;
	}
}
