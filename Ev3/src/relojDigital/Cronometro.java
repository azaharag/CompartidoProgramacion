package relojDigital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cronometro extends JFrame {

	private JPanel contentPane;
	private JTextField reloj;
	Timer timer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cronometro frame = new Cronometro();
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
	public Cronometro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		reloj = new JTextField();
		reloj.setFont(new Font("Tahoma", Font.BOLD, 50));
		reloj.setText("0:0:0.000");
		reloj.setEditable(false);
		reloj.setBounds(52, 29, 337, 70);
		contentPane.add(reloj);
		reloj.setColumns(10);
		
		JButton inicio = new JButton("START");
		inicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer=new Timer(1, new ActionListener ()
				{
					public void actionPerformed(ActionEvent e)
					{
						Date diferencia=new Date(0);
						Date actual=new Date();
						SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss.SSS");
						long dif=0;
						dif=actual.getTime()-dif;
						diferencia.setTime(dif);
						reloj.setText(sdf.format(diferencia));
					}
				}); 
				timer.start();
		}});
		inicio.setForeground(Color.GREEN);
		inicio.setFont(new Font("Tahoma", Font.BOLD, 14));
		inicio.setBounds(43, 191, 89, 23);
		contentPane.add(inicio);
		
		JButton parar = new JButton("STOP");
		parar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
			}
		});
		parar.setForeground(Color.BLUE);
		parar.setFont(new Font("Tahoma", Font.BOLD, 14));
		parar.setBounds(175, 191, 89, 23);
		contentPane.add(parar);
		
		JButton borrar = new JButton("RESET");
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reloj.setText("0:0:0.000");
			}
		});
		borrar.setForeground(Color.RED);
		borrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		borrar.setBounds(307, 191, 89, 23);
		contentPane.add(borrar);
	}
}
