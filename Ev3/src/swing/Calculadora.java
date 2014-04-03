package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField pantalla;
	JButton b9 = new JButton("9");
	JButton b8 = new JButton("8");
	JButton b7 = new JButton("7");
	JButton b6 = new JButton("6");
	JButton b5 = new JButton("5");
	JButton b4 = new JButton("4");
	JButton b3 = new JButton("3");
	JButton b2 = new JButton("2");
	JButton b1 = new JButton("1");
	JButton b0 = new JButton("0");
	Character op;
	Integer n1,n2;
	static int cnt=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
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
	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pantalla = new JTextField();
		pantalla.setEditable(false);
		pantalla.setBounds(32, 38, 283, 42);
		contentPane.add(pantalla);
		pantalla.setColumns(10);
		
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirDigito(b9.getText());
			}
		});
		b9.setBounds(32, 143, 51, 42);
		contentPane.add(b9);
		
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirDigito(b8.getText());
			}
		});
		b8.setBounds(110, 143, 51, 42);
		contentPane.add(b8);
		
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirDigito(b7.getText());
			}
		});
		b7.setBounds(187, 143, 51, 42);
		contentPane.add(b7);
		
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirDigito(b6.getText());
			}
		});
		b6.setBounds(32, 207, 51, 42);
		contentPane.add(b6);
		
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirDigito(b5.getText());
			}
		});
		b5.setBounds(110, 207, 51, 42);
		contentPane.add(b5);
		
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirDigito(b4.getText());
			}
		});
		b4.setBounds(187, 207, 51, 42);
		contentPane.add(b4);
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirDigito(b3.getText());
			}
		});
		b3.setBounds(32, 269, 51, 42);
		contentPane.add(b3);
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirDigito(b2.getText());
			}
		});
		b2.setBounds(110, 269, 51, 42);
		contentPane.add(b2);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirDigito(b1.getText());
			}
		});
		b1.setBounds(187, 269, 51, 42);
		contentPane.add(b1);
		
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirDigito(b0.getText());
			}
		});
		b0.setBounds(32, 337, 51, 42);
		contentPane.add(b0);
		
		JButton bIgual = new JButton("=");
		bIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n2=Integer.valueOf(pantalla.getText());
				pantalla.setText(String.valueOf(operacion()));
				cnt=0;
			}
		});
		bIgual.setBounds(110, 337, 51, 42);
		contentPane.add(bIgual);
		
		JButton bSuma = new JButton("+");
		bSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(n1==null)
				n1=Integer.valueOf(pantalla.getText());
				op='+';
			}
		});
		bSuma.setBounds(264, 143, 51, 42);
		contentPane.add(bSuma);
		
		JButton bResta = new JButton("-");
		bResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(n1==null)
				n1=Integer.valueOf(pantalla.getText());
				op='-';
			}
		});
		bResta.setBounds(264, 207, 51, 42);
		contentPane.add(bResta);
		
		JButton btnX = new JButton("x");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(n1==null)
				n1=Integer.valueOf(pantalla.getText());
				op='x';
			}
		});
		btnX.setBounds(264, 269, 51, 42);
		contentPane.add(btnX);
		
		JButton bDiv = new JButton("/");
		bDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(n1==null)
				n1=Integer.valueOf(pantalla.getText());
				op='/';
			}
		});
		bDiv.setBounds(264, 337, 51, 42);
		contentPane.add(bDiv);
		
		JButton btnC = new JButton("C");
		btnC.setForeground(Color.RED);
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText("");
				cnt=0;
				n1=null;
				n2=null;
				op=null;
			}
		});
		btnC.setBounds(187, 337, 51, 42);
		contentPane.add(btnC);
	}
	public void añadirDigito(String d)
	{	
		if(n1!=null && cnt==0)
		{
			pantalla.setText("");
			cnt++;
		}
		String t=pantalla.getText();
		t=t+d;
		pantalla.setText(t);
		
	}
	
	public int operacion()
	{
		switch(op){
			case '+': return n1=n1+n2;
			case '-': return n1=n1-n2;
			case 'x': return n1=n1*n2;
			case '/': 
				if(n2==0)
				{
					JOptionPane.showMessageDialog(contentPane, "No se puede dividir entre 0");
					return n1=0;
				}
				else
					return n1=n1/n2;
		}
		return 0;
	}

}
