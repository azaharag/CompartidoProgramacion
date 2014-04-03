package swing;

import javax.swing.*;

public class PintaVentana {

	public static void main(String[] args) {
		//JFrame
		JFrame f=new JFrame();
        f.setBounds(100,100,600,400);
     
        //JLabel
        f.setLayout(null);
        JLabel label1,label2;
        label1=new JLabel("Sistema de Facturación.");
        label1.setBounds(100,20,300,30);
        f.add(label1);
        label2=new JLabel("Version 1.0");
        label2.setBounds(100,100,100,30);
        f.add(label2);
        f.setVisible(true);
	}

}
