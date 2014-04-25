package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.Font;
import java.awt.Color;

public class CopiarFichero extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	File o,d;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopiarFichero frame = new CopiarFichero();
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
	public CopiarFichero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFicheroOrigen = new JLabel("Fichero Origen:");
		lblFicheroOrigen.setFont(new Font("Calibri", Font.BOLD, 12));
		lblFicheroOrigen.setBounds(25, 59, 87, 27);
		contentPane.add(lblFicheroOrigen);
		
		JLabel lblFicheroDestino = new JLabel("Fichero Destino:");
		lblFicheroDestino.setFont(new Font("Calibri", Font.BOLD, 12));
		lblFicheroDestino.setBounds(25, 125, 87, 27);
		contentPane.add(lblFicheroDestino);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(139, 62, 156, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(139, 128, 156, 20);
		contentPane.add(textField_1);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBackground(Color.PINK);
		btnSeleccionar.setFont(new Font("Calibri", Font.BOLD, 12));
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc=new JFileChooser();
				jfc.setCurrentDirectory(new File("c:/"));
				jfc.showDialog(contentPane, "Seleccionar");
				o=jfc.getSelectedFile();
				textField.setText(o.getPath());
			}
		});
		btnSeleccionar.setBounds(305, 61, 127, 23);
		contentPane.add(btnSeleccionar);
		
		JButton button = new JButton("Seleccionar");
		button.setBackground(Color.PINK);
		button.setFont(new Font("Calibri", Font.BOLD, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc=new JFileChooser();
				jfc.setCurrentDirectory(new File("c:/"));
				jfc.showDialog(contentPane, "Seleccionar");
				d=jfc.getSelectedFile();
				int confirmado = 0;
				if(d.exists())
				{
					confirmado=JOptionPane.showConfirmDialog(contentPane, "¿Desea Sobreescribir?", "¿Desea Sobreescribir?", 
					JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				}
				if(confirmado==JOptionPane.YES_OPTION)
				{
					textField_1.setText(d.getPath());
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, "No se ha seleccionado fichero");
				}
			}
		});
		button.setBounds(305, 127, 127, 23);
		contentPane.add(button);
		
		JButton btnCopiar = new JButton("Copiar");
		btnCopiar.setBackground(Color.GREEN);
		btnCopiar.setForeground(Color.BLACK);
		btnCopiar.setFont(new Font("Calibri", Font.BOLD, 12));
		btnCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copiarFichero(o,d);
				JOptionPane.showMessageDialog(contentPane, "Fichero Copiado");
			}
		});
		btnCopiar.setBounds(158, 191, 127, 43);
		contentPane.add(btnCopiar);
	}

	protected void copiarFichero(File o2, File d2) {
		DataInputStream in=null;
		DataOutputStream out=null;
		try{
			in=new DataInputStream(new FileInputStream(o));
			out=new DataOutputStream(new FileOutputStream(d));
			while(true)
			{
				out.writeByte(in.readByte());
			}
		}
		catch(EOFException e)
		{
			//Fin fichero
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(in!=null && out!=null)
			{
				try{
					in.close();
					out.close();
				}catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
