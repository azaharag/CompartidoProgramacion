package juego;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AtrapaACris extends JFrame {

	private static JPanel contentPane;
	private static JLabel fotaza;
	static Timer t;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtrapaACris frame = new AtrapaACris();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		mover();
	}

	/**
	 * Create the frame.
	 */
	public AtrapaACris() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fotaza = new JLabel("New label");
		fotaza.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				t.stop();
				JOptionPane.showMessageDialog(contentPane, "¡GOOOOL!");
				t.start();
				
			}
		});
		fotaza.setIcon(new ImageIcon(AtrapaACris.class.getResource("/juego/CrisMinion_opt.png")));
		fotaza.setBounds(34, 25, 50, 75);
		contentPane.add(fotaza);
	}
public static void mover(){
	t=new Timer(300, new ActionListener(){
		public void actionPerformed(ActionEvent e){
			Random rx=new Random();
				int x=rx.nextInt(contentPane.getWidth()-fotaza.getWidth())+1 ;
			Random ry=new Random();
				int y=ry.nextInt(contentPane.getHeight()-fotaza.getHeight())+1;
		fotaza.setLocation(x, y);
		}
	});
	t.setRepeats(true);
	t.start();
	
}
	public JLabel getFotaza() {
		return fotaza;
	}
}
