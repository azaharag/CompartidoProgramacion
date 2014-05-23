package socket;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient extends JFrame {

	private JPanel contentPane;
	private JTextField dirIp;
	private JTextField puerto;
	private JTextArea textEnvio;
	private JTextArea textRecibido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UDPClient frame = new UDPClient();
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
	public UDPClient() {
		setTitle("UDP Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIpONombre = new JLabel("IP o Nombre:");
		lblIpONombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIpONombre.setBounds(10, 11, 97, 14);
		contentPane.add(lblIpONombre);
		
		JLabel lblPuerto = new JLabel("Puerto:");
		lblPuerto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPuerto.setBounds(10, 50, 97, 14);
		contentPane.add(lblPuerto);
		
		JLabel lblMensajeAEnviar = new JLabel("Mensaje a enviar:");
		lblMensajeAEnviar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMensajeAEnviar.setBounds(10, 90, 117, 14);
		contentPane.add(lblMensajeAEnviar);
		
		JLabel lblRecibido = new JLabel("Recibido:");
		lblRecibido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRecibido.setBounds(10, 180, 82, 14);
		contentPane.add(lblRecibido);
		
		dirIp = new JTextField();
		dirIp.setBounds(94, 9, 86, 20);
		contentPane.add(dirIp);
		dirIp.setColumns(10);
		
		puerto = new JTextField();
		puerto.setEditable(false);
		puerto.setText("8888");
		puerto.setBounds(94, 59, 86, 20);
		contentPane.add(puerto);
		puerto.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 108, 383, 62);
		contentPane.add(scrollPane);
		
		textEnvio = new JTextArea();
		scrollPane.setViewportView(textEnvio);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(34, 196, 362, 41);
		contentPane.add(scrollPane_1);
		
		textRecibido = new JTextArea();
		scrollPane_1.setViewportView(textRecibido);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				      DatagramSocket clientSocket = new DatagramSocket();
				      InetAddress IPAddress = InetAddress.getByName(dirIp.getText());
				      byte[] sendData = new byte[1024];
				      byte[] receiveData = new byte[1024];
				      String sentence = textEnvio.getText();
				      sendData = sentence.getBytes();
				      Integer puertoEnvio=Integer.parseInt(puerto.getText());
				      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, puertoEnvio);
				      clientSocket.send(sendPacket);
				      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				      clientSocket.receive(receivePacket);
				      String modifiedSentence = new String(receivePacket.getData());
				      textRecibido.setText("Se ha recibido: "+modifiedSentence);
				      clientSocket.close();
				      }catch(Exception exc){
				    	  exc.printStackTrace();
				      }
			}
		});
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnviar.setBounds(272, 27, 109, 39);
		contentPane.add(btnEnviar);
	}
	public JTextArea getTextEnvio() {
		return textEnvio;
	}
	public JTextArea getTextRecibido() {
		return textRecibido;
	}
}
