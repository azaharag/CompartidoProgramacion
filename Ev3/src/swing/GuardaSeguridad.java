package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GuardaSeguridad extends JFrame {

	private JPanel contentPane;
	private JTextArea mensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuardaSeguridad frame = new GuardaSeguridad();
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
	public GuardaSeguridad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMensaje = new JLabel("Mensaje");
		lblMensaje.setFont(new Font("Calibri", Font.BOLD, 16));
		lblMensaje.setBounds(10, 46, 77, 14);
		contentPane.add(lblMensaje);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(132, 46, 280, 133);
		contentPane.add(scrollPane);
		
		mensaje = new JTextArea();
		scrollPane.setViewportView(mensaje);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					escribirArchivo();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGrabar.setForeground(Color.BLUE);
		btnGrabar.setFont(new Font("Calibri", Font.BOLD, 14));
		btnGrabar.setBounds(10, 203, 89, 23);
		contentPane.add(btnGrabar);
	}

	protected void escribirArchivo() throws FileNotFoundException {
		PrintWriter p=null;
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ");
		try{
			p=new PrintWriter(new FileOutputStream("c:/Actividad.log",true));
			d.getTime();
			p.println(sdf.format(d)+ mensaje.getText());
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		finally{
			if(p!=null)
			{
				p.close();
				mensaje.setText(null);
				JOptionPane.showMessageDialog(contentPane, "Grabado");
			}	
		}
	}
	
	public JTextArea getTextArea() {
		return mensaje;
	}
}
