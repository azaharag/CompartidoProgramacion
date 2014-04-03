package swing;
import javax.swing.*;

public class PintarVentanaBis extends JFrame{
	    private JLabel label1,label2;
	    private JTextField caja;
	    private JButton boton;
	    public PintarVentanaBis() {
	        setLayout(null);
	        label1=new JLabel("Sistema de Facturación.");
	        label1.setBounds(10,20,300,30);
	        add(label1);
	        label2=new JLabel("Vesion 1.0");
	        label2.setBounds(10,100,100,30);
	        add(label2);
	        caja=new JTextField("Valor inicial");
	        caja.setBounds(20,200,100,40);
	        add(caja);
	        boton=new JButton("OK");
	        boton.setBounds(100,200,100,40);
	        add(boton);
	        
	    }
	    
	    public static void main(String[] ar) {
	        PintarVentanaBis formulario1=new PintarVentanaBis();
	        formulario1.setBounds(0,0,900,600);
	       // formulario1.setResizable(false);
	        formulario1.setVisible(true);
	    }
	}

