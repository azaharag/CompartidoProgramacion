package temporales;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SustituirCadena extends JFrame {

	private JPanel contentPane;
	private JTextField path;
	private JTextField buscar;
	private JTextField cambiar;
	private File f;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SustituirCadena frame = new SustituirCadena();
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
	public SustituirCadena() {
		setTitle("Sustituir Cadena");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPath = new JLabel("Path:");
		lblPath.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPath.setBounds(10, 56, 46, 14);
		contentPane.add(lblPath);
		
		JLabel lblCadenaACambiar = new JLabel("Cadena a cambiar:");
		lblCadenaACambiar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCadenaACambiar.setBounds(10, 126, 125, 14);
		contentPane.add(lblCadenaACambiar);
		
		JLabel lblSustituirPor = new JLabel("Sustituir por:");
		lblSustituirPor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSustituirPor.setBounds(10, 196, 109, 14);
		contentPane.add(lblSustituirPor);
		
		path = new JTextField();
		path.setBounds(165, 51, 139, 20);
		contentPane.add(path);
		path.setColumns(10);
		
		buscar = new JTextField();
		buscar.setBounds(165, 122, 139, 20);
		contentPane.add(buscar);
		buscar.setColumns(10);
		
		cambiar = new JTextField();
		cambiar.setBounds(165, 193, 139, 20);
		contentPane.add(cambiar);
		cambiar.setColumns(10);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc=new JFileChooser();
				jfc.setCurrentDirectory(new File("c:/"));
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int seleccion=jfc.showDialog(contentPane, "Seleccionar");
				if(seleccion==JFileChooser.APPROVE_OPTION)
				{
					f= jfc.getSelectedFile();
					path.setText(f.getName());
				}
				
			}
		});
		btnSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSeleccionar.setBounds(314, 47, 109, 23);
		contentPane.add(btnSeleccionar);
		
		JButton btnNewButton = new JButton("Sustituir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sustituir(cambiar.getText(),buscar.getText(),f);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(163, 233, 116, 23);
		contentPane.add(btnNewButton);
	}

	public void sustituir(String cambio, String origen,File fOrigen) {
		BufferedReader br;
		PrintWriter p;
		String t;
		File fDestino;
		int cont=0;
		try {
			 br=new BufferedReader(new FileReader(fOrigen.getAbsolutePath()));
			 fDestino=File.createTempFile("tmp", ".txt", new File(fOrigen.getParent()));
			 p=new PrintWriter(fDestino);
			 while((t=br.readLine())!=null)
			 {
				 StringTokenizer st=new StringTokenizer(t," ./-,:;¿?¡!");
				 while(st.hasMoreTokens())
				 {
					if(st.nextToken().equalsIgnoreCase(origen))
						cont++;
				 }
				if(t.indexOf(origen)!=-1)
				{
					t=t.replaceAll(origen, cambio);
					p.println(t);
				}
				else
				{
					p.println(t);
				}
			 }
			 br.close();
			 p.close();
			 String nombre=fOrigen.getAbsolutePath();
			 fOrigen.delete();
			 fDestino.renameTo(new File(nombre));
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(contentPane, "Se han modificado "+cont+" palabras");
	}
}
