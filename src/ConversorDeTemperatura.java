
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ConversorDeTemperatura extends JFrame implements ActionListener {
	
	private JLabel textCantidad, textSelect;
	private JTextField cantidad;
	private JComboBox<String> select;
	private JButton botonConvertir, botonBack;
	private double amount, result;
	private ConversorDeMonedas cdm;
	private SeleccionDeConversion anterior;
	
	public ConversorDeTemperatura() {
		setTitle("Conversor De Grados C° a F°");
		getContentPane().setBackground(new java.awt.Color(255,203,164));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		botonConvertir();
		botonBack();
		this.cdm = new ConversorDeMonedas();
	};

	
	public void iniciarComponentes() {

		textCantidad = new JLabel("Grados °");
		textCantidad.setForeground(Color.RED.darker());
		textCantidad.setFont(new Font("Montserrat", Font.BOLD, 18));
		textCantidad.setBounds(50, -15, 200, 100);
		
		cantidad = new JTextField();
		cantidad.setBounds(50, 50, 75, 50);
		cantidad.setFont(new Font("Montserrat", Font.BOLD, 18));
		cantidad.setSelectedTextColor(new java.awt.Color(125, 233, 197));
		
		textSelect = new JLabel("Tipo de temperatura a convertir");
		textSelect.setForeground(Color.RED.darker());
		textSelect.setFont(new Font("Montserrat", Font.BOLD, 18));
		textSelect.setBounds(130, 50, 400, 130);
		
		select = new JComboBox<String>();
		select.setBounds(50, 135, 360, 40);
		select.setFont(new Font("Montserrat", Font.BOLD, 16));
		select.addItem("De Farenheit A Celcius");
		select.addItem("De Farenheit A Kelvin");
		select.addItem("De Celcius A Farenheit");
		select.addItem("De Celcius A Kelvin");
		select.addItem("De Kelvin A Farenheit");
		select.addItem("De Kelvin A Celcius");
		
		add(textCantidad);
		add(textSelect);
		add(cantidad);
		add(select);
	}
	
	public void botonConvertir() {
		botonConvertir = new JButton("Convertir");
		botonConvertir.setBounds(230, 200, 150, 40);
		botonConvertir.setFont(new Font("Montserrat", Font.BOLD, 16));
		botonConvertir.setForeground(Color.WHITE);
		botonConvertir.setBackground(Color.RED.darker());
		botonConvertir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		botonConvertir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(122,0,22)));
		botonConvertir.addActionListener(this);
		
		add(botonConvertir);
	}
	
	public void botonBack() {
		botonBack = new JButton("Atras");
		botonBack.setBounds(70, 200, 150, 40);
		botonBack.setForeground(Color.WHITE);
		botonBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		botonBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(122,0,22)));
		botonBack.setFont(new Font("Montserrat", Font.BOLD, 16));
		botonBack.setBackground(Color.RED.darker());
		botonBack.addActionListener(this);
		
		add(botonBack);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonConvertir) {
			try {
				switch (select.getSelectedItem().toString()) {
				case "De Farenheit A Celcius":
					amount = Double.parseDouble(cantidad.getText());
					result = (amount - 32) * 5/9;
					JOptionPane.showMessageDialog(null, amount + " Grados Farenheit son:  \n" + String.format("%.3f", result) + " Grados Celcius", "Resultado", 3);
					cdm.continuar();
					break;
				case "De Farenheit A Kelvin":
					amount = Double.parseDouble(cantidad.getText());
					result = (amount - 32) * 5/9 + 273.15;
					JOptionPane.showMessageDialog(null, amount + " Grados Farenheit son:  \n" + String.format("%.3f", result) + " Grados Kelvin");
					cdm.continuar();
					break;
				case "De Celcius A Farenheit":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * (9 / 5) + 32;
					JOptionPane.showMessageDialog(null, amount + " Grados Celcius son:  \n" + String.format("%.2f", result) + " Grados Farenheit");
					cdm.continuar();
					break;
				case "De Celcius A Kelvin":
					amount = Double.parseDouble(cantidad.getText());
					result = amount + 273.15;
					JOptionPane.showMessageDialog(null, amount + " Grados Celcius son:  \n" + String.format("%.2f", result) + " Grados Kelvin");
					cdm.continuar();
					break;
				case "De Kelvin A Farenheit":
					amount = Double.parseDouble(cantidad.getText());
					result = (amount - 273.15) * 5/9 + 32;
					JOptionPane.showMessageDialog(null, amount + " Grados Kelvin son:  \n" + String.format("%.2f", result) + " Grados Farenheit");
					cdm.continuar();
					break;
				case "De Kelvin A Celcius":
					amount = Double.parseDouble(cantidad.getText());
					result = amount - 273.15;
					JOptionPane.showMessageDialog(null, amount + " Grados Kelvin son:  \n" + String.format("%.2f", result) + " Grados Celcius");
					cdm.continuar();
					break;
				}
			} catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Ingresar un monto válido", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == botonBack) {
			this.anterior = new SeleccionDeConversion();
			anterior.setBounds(0, 0, 350, 250);
			anterior.setLayout(null);
			anterior.setLocationRelativeTo(null);
			anterior.setVisible(true);
			this.dispose(); 
		}
	}
}
