package relojDigital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class RelojDigital extends JFrame {

	private JPanel contentPane;
	private static JTextField reloj;
	 static GregorianCalendar gc;
	 static SimpleDateFormat sdt;
	 static Timer timer = new Timer (1000, new ActionListener ()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        gc=new GregorianCalendar();
		        sdt=new SimpleDateFormat("HH:mm:ss");
		        reloj.setText(sdt.format(gc.getTime()));
		     }
		}); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelojDigital frame = new RelojDigital();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		timer.start();
	}

	/**
	 * Create the frame.
	 */
	public RelojDigital() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		reloj = new JTextField();
		reloj.setForeground(Color.BLUE);
		reloj.setFont(new Font("Tahoma", Font.BOLD, 50));
		reloj.setEditable(false);
		reloj.setBounds(26, 42, 390, 70);
		contentPane.add(reloj);
		reloj.setColumns(10);
	}

}
