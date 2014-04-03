package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.StringTokenizer;

public class SumaMatrices extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatriz;
	private JTextField txtMatriz_1;
	private JTextField txtMatrizSuma;
	private JTextArea matriz1;
	private JTextArea matriz2;
	private JTextArea matrizSuma;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SumaMatrices frame = new SumaMatrices();
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
	public SumaMatrices() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		matriz1 = new JTextArea();
		matriz1.setBounds(10, 56, 116, 131);
		contentPane.add(matriz1);
		
		matriz2 = new JTextArea();
		matriz2.setBounds(10, 275, 116, 131);
		contentPane.add(matriz2);
		
		matrizSuma = new JTextArea();
		matrizSuma.setEditable(false);
		matrizSuma.setBounds(359, 157, 116, 131);
		contentPane.add(matrizSuma);
		
		JButton btnSumar = new JButton("Sumar");
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				Matriz m1=new Matriz(matriz1.getText());
				Matriz m2=new Matriz(matriz2.getText());
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(contentPane, "La dimensión de la matriz no es correcta");
				}
//				if(m1.compatible(m2))
//				{
//					matrizSuma.setText(m1.suma(m2));
//				}
			}
		
			
		});
		btnSumar.setBounds(194, 195, 89, 23);
		contentPane.add(btnSumar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(194, 245, 89, 23);
		contentPane.add(btnLimpiar);
		
		txtMatriz = new JTextField();
		txtMatriz.setEditable(false);
		txtMatriz.setText("Matriz 1");
		txtMatriz.setBounds(10, 25, 86, 20);
		contentPane.add(txtMatriz);
		txtMatriz.setColumns(10);
		
		txtMatriz_1 = new JTextField();
		txtMatriz_1.setEditable(false);
		txtMatriz_1.setText("Matriz 2");
		txtMatriz_1.setColumns(10);
		txtMatriz_1.setBounds(10, 246, 86, 20);
		contentPane.add(txtMatriz_1);
		
		txtMatrizSuma = new JTextField();
		txtMatrizSuma.setEditable(false);
		txtMatrizSuma.setText("Matriz Suma");
		txtMatrizSuma.setColumns(10);
		txtMatrizSuma.setBounds(389, 122, 86, 20);
		contentPane.add(txtMatrizSuma);
	
		
	}
	public JTextArea getMatriz1() {
		return matriz1;
	}
	public JTextArea getMatriz2() {
		return matriz2;
	}
	public JTextArea getMatrizSuma() {
		return matrizSuma;
	}
}
