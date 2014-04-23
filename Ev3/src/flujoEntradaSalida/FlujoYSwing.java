package flujoEntradaSalida;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Color;

public class FlujoYSwing extends JFrame {

	private JPanel contentPane;
	private JButton btnGuardar;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlujoYSwing frame = new FlujoYSwing();
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
	public FlujoYSwing() {
		setTitle("Mi Peque\u00F1o Poema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 71, 182, 126);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(238, 130, 238));
		scrollPane.setViewportView(textArea);
		
		JLabel lblPoema = new JLabel("Poema");
		lblPoema.setBackground(new Color(255, 255, 255));
		lblPoema.setForeground(new Color(0, 0, 128));
		lblPoema.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblPoema.setBounds(27, 37, 151, 23);
		contentPane.add(lblPoema);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(75, 0, 130));
		btnGuardar.setForeground(new Color(255, 160, 122));
		btnGuardar.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmado = 0;
				JFileChooser jfc=new JFileChooser();
				jfc.setCurrentDirectory(new File("c:/"));
				PrintWriter p = null;
				jfc.showDialog(contentPane, "Seleccionar");
				if((new File(jfc.getSelectedFile().getPath()).exists()))
				{
				 confirmado=JOptionPane.showConfirmDialog(contentPane, "¿Desea Sobreescribir?", "¿Desea Sobreescribir?", 
					JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				}
				if(confirmado==JOptionPane.YES_OPTION)
				{
				try {
					 p= new PrintWriter(jfc.getSelectedFile());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
					p.println(textArea.getText());
					p.close();
				}
				else
				{
						return;
				}
			}
		});
		btnGuardar.setBounds(256, 71, 103, 42);
		contentPane.add(btnGuardar);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				JFileChooser jfc=new JFileChooser();
				jfc.setCurrentDirectory(new File("c:/"));
				FileReader fr = null;
				String t ="";
				jfc.showDialog(contentPane, "Seleccionar");
				try {
					fr=new FileReader(jfc.getSelectedFile());
					int c=fr.read();
					while(c!=-1)
					{ 
						t=t+((char)c);
						c=fr.read();
					}
					fr.close();
					textArea.setText(t);
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(contentPane, "No se ha podido abrir: "+jfc.getSelectedFile().getPath());
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(contentPane, "No se ha podido leer: "+jfc.getSelectedFile().getPath());
						try {
							fr.close();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
				}
				
			}
		});
		btnCargar.setForeground(new Color(255, 160, 122));
		btnCargar.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		btnCargar.setBackground(new Color(75, 0, 130));
		btnCargar.setBounds(256, 143, 103, 42);
		contentPane.add(btnCargar);
	}
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
}
