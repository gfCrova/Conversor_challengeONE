import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SeleccionDeConversion extends JFrame implements ActionListener {

	private JLabel textTipo;
	private JButton botonContinuar, botonSalir;
	private JComboBox<String> select;
	
	public SeleccionDeConversion() {
		setTitle("Conversor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
		setupComp();
	}
	
	public void setupComp() {
		Font myFont1 = new Font("sans-Serif", Font.BOLD, 16);
		
		select = new JComboBox<String>();
		select.addItem("Conversor de Monedas");
		select.addItem("Conversor de Temperatura");
		select.setBounds(35, 75, 260, 30);
        select.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        add(select);
        
        botonContinuar = new JButton();
        botonContinuar.setText("Continuar");
        botonContinuar.setBounds(40, 155, 120, 30);
        botonContinuar.setFont(myFont1);
		botonContinuar.addActionListener(this);
		add(botonContinuar);
		
		botonSalir = new JButton();
		botonSalir.setText("Salir");
        botonSalir.setBounds(170, 155, 120, 30);
        botonSalir.setFont(myFont1);
		botonSalir.addActionListener(this);
		add(botonSalir);
		
		textTipo = new JLabel();
		textTipo.setText("Seleccione el tipo de conversión: ");
		textTipo.setBounds(60, 25, 200, 50);
		add(textTipo);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
	       if(e.getSource() == botonContinuar) {
	       		switch (select.getSelectedItem().toString()) {
		       		case "Conversor de Monedas":
		       			ConversorDeMonedas cdm = new ConversorDeMonedas();
		       			cdm.setBounds(0, 0, 480, 300);
		       			cdm.setLayout(null);
		       			cdm.setLocationRelativeTo(null);
		       			cdm.setResizable(false);
		       			cdm.setVisible(true);
		                break;
		            case "Conversor de Temperatura":
		            	ConversorDeTemperatura cdt = new ConversorDeTemperatura();
		            	cdt.setBounds(0, 0, 480, 300);
		       			cdt.setLayout(null);
		       			cdt.setLocationRelativeTo(null);
		       			cdt.setResizable(false);
		       			cdt.setVisible(true);
		                break;
	       		}
	       }
	       if(e.getSource() == botonSalir) {
	            System.exit(0);
	       }
	}
	
	public static void main(String[] args) {
			
		SeleccionDeConversion conversor = new SeleccionDeConversion();
		 conversor.setBounds(0, 0, 350, 250);
		 conversor.setLayout(null);
		 conversor.setLocationRelativeTo(null);
		 conversor.setResizable(false);
		 
		}

}
