package mapas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class PalabrasConMapas extends JFrame {

	private JPanel contentPane;
	private JTextField ruta;
	private JTable table;
	private Map<String,Integer> m;
	private DefaultTableModel dtm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PalabrasConMapas frame = new PalabrasConMapas();
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
	public PalabrasConMapas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRuta = new JLabel("Ruta:");
		lblRuta.setBounds(10, 11, 100, 19);
		contentPane.add(lblRuta);
		
		ruta = new JTextField();
		ruta.setBounds(120, 10, 312, 20);
		contentPane.add(ruta);
		ruta.setColumns(10);
		
		JButton btnBuscarPalabras = new JButton("Seleccionar Fichero");
		btnBuscarPalabras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc=new JFileChooser();
				jfc.setCurrentDirectory(new File("c:/"));
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int seleccion=jfc.showDialog(contentPane, "Seleccionar");
				if(seleccion==JFileChooser.APPROVE_OPTION)
				{
					ruta.setText(jfc.getSelectedFile().getAbsolutePath());
				}
				
			}
		});
		btnBuscarPalabras.setBounds(20, 47, 157, 23);
		contentPane.add(btnBuscarPalabras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 422, 175);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("Buscar Palabras");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f=new File(ruta.getText());
				try {
					BufferedReader br=new BufferedReader(new FileReader(f));
					String linea=br.readLine();
					while(linea!=null)
					{
						separaPalabras(linea);
						linea=br.readLine();
					}
					br.close();
					String [] cabecera={"Palabra","Cantidad"};
					
					Object [][] datos=new Object[m.size()][2];
					Set<Map.Entry<String,Integer>> conjunto=m.entrySet();
					for(Map.Entry<String,Integer> ef:conjunto)
					{
						for(int i=0;i<datos.length;i++)
						{
							datos[i][0]=ef.getKey();
							datos[i][1]=ef.getValue();
						}
					}
					dtm=new DefaultTableModel(datos,cabecera);
					table.setModel(dtm);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(247, 47, 157, 23);
		contentPane.add(button);
	}

	protected void separaPalabras(String linea) {
		StringTokenizer st=new StringTokenizer(linea," ./-,:;¿?¡!");
		m=new TreeMap<String,Integer>();
		while(st.hasMoreTokens())
		{
			String palabra=st.nextToken();
			Integer v=m.get(palabra);
			if(v==null)
			{
				m.put(palabra, 1);
			}
			else
			{
				m.put(palabra, v+1);
			}
		}
	}
}
