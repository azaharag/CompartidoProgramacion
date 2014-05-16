package socketudp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class UDPServer extends JFrame {

	private JPanel contentPane;
	private static JTextArea textoR;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UDPServer frame = new UDPServer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		escucharSocket();
	}


	/**
	 * Create the frame.
	 */
	public UDPServer() {
		setTitle("UDP Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMensajesRecibidos = new JLabel("Mensajes recibidos:");
		lblMensajesRecibidos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMensajesRecibidos.setBounds(132, 21, 177, 31);
		contentPane.add(lblMensajesRecibidos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 73, 372, 172);
		contentPane.add(scrollPane);
		
		textoR = new JTextArea();
		textoR.setEditable(false);
		scrollPane.setViewportView(textoR);
	}
	public JTextArea getTextoR() {
		return textoR;
	}
	protected static  void escucharSocket() throws IOException {
		 DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true)
           {
              DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
              serverSocket.receive(receivePacket);
              String sentence = new String( receivePacket.getData());
              InetAddress IPAddress = receivePacket.getAddress();
              int port = receivePacket.getPort();
              textoR.setText(textoR.getText()+"\n"+"<"+IPAddress+"> ("+port+"): "+sentence);
              String capitalizedSentence = sentence.toUpperCase();
              sendData = capitalizedSentence.getBytes();
              DatagramPacket sendPacket =
              new DatagramPacket(sendData, sendData.length, IPAddress, port);
              serverSocket.send(sendPacket);
           }
	}
}
