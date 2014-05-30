package jTable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class EjemploJTable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField fila;
	private JTextField col;
	private JTextField valor;
	private JButton btnBorrarFila;
	DefaultTableModel dtm;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploJTable frame = new EjemploJTable();
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
	public EjemploJTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 489, 204);
		contentPane.add(scrollPane);

		table = new JTable();
		
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);

		JButton btnCargaTabla = new JButton("CARGA TABLA");
		btnCargaTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargaTabla();
			}
		});
		btnCargaTabla.setBounds(10, 215, 141, 23);
		contentPane.add(btnCargaTabla);
		
		fila = new JTextField();
		fila.setBounds(217, 219, 22, 20);
		contentPane.add(fila);
		fila.setColumns(10);
		
		JLabel lblFila = new JLabel("Fila");
		lblFila.setBounds(217, 204, 32, 14);
		contentPane.add(lblFila);
		
		JLabel lblCol = new JLabel("Col");
		lblCol.setBounds(249, 204, 32, 14);
		contentPane.add(lblCol);
		
		col = new JTextField();
		col.setColumns(10);
		col.setBounds(249, 219, 22, 20);
		contentPane.add(col);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(301, 204, 32, 14);
		contentPane.add(lblValor);
		
		valor = new JTextField();
		valor.setColumns(10);
		valor.setBounds(280, 219, 73, 20);
		contentPane.add(valor);
		
		JButton btnLeercelda = new JButton("Leer Celda");
		btnLeercelda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int f=Integer.valueOf(fila.getText());
				int c=Integer.valueOf(col.getText());
				String v=(String) dtm.getValueAt(f, c);
				valor.setText(v);
			}
		});
		btnLeercelda.setBounds(363, 218, 116, 23);
		contentPane.add(btnLeercelda);
		
		JButton btnEscribircelda = new JButton("Escribir Celda");
		btnEscribircelda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int f=Integer.valueOf(fila.getText());
				int c=Integer.valueOf(col.getText());
				String v=valor.getText();
				dtm.setValueAt(v,f, c);
			}
		});
		btnEscribircelda.setBounds(363, 253, 116, 23);
		contentPane.add(btnEscribircelda);
		
		btnBorrarFila = new JButton("Borrar Fila");
		btnBorrarFila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int f=Integer.valueOf(fila.getText());
				dtm.removeRow(f);
			}
		});
		btnBorrarFila.setBounds(217, 253, 119, 23);
		contentPane.add(btnBorrarFila);
		
		btnNewButton = new JButton("Ver Dimensiones");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Filas: "+table.getRowCount()+" Columnas: "+table.getColumnCount());
			}
		});
		btnNewButton.setBounds(10, 277, 141, 23);
		contentPane.add(btnNewButton);
	}

	protected void cargaTabla() {
		Object[][] datos = {
				{ "Mary", "Campione", "Esquiar", new Integer(5), new Boolean(false) },
				{ "Lhucas", "Huml", "Patinar", new Integer(3),	new Boolean(true) },
				{ "Kathya", "Walrath", "Escalar", new Integer(2),
						new Boolean(false) },
				{ "Marcus", "Andrews", "Correr", new Integer(7),
						new Boolean(true) },
				{ "Angela", "Lalth", "Nadar", new Integer(4),
						new Boolean(false) } };
		String[] nombresColumna = { "Nombre", "Apellido", "Pasatiempo", "Años de Practica", "Soltero(a)" };

		dtm = new DefaultTableModel(datos, nombresColumna);

		table.setModel(dtm);

	}
}
