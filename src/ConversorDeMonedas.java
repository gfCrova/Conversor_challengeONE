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

import Monedas.Dolar;
import Monedas.Euro;
import Monedas.Libras;
import Monedas.Pesos;
import Monedas.WonSurcoreano;
import Monedas.YenJapones;


public class ConversorDeMonedas extends JFrame implements ActionListener{

	private JLabel textCantidad, textSelect;
	private JTextField cantidad;
	private JButton botonConvertir, botonBack;
	private JComboBox<String> select;
	private double amount, result;
	private Dolar dolar;
	private Euro euro;
	private Libras libra;
	private YenJapones yen;
	private WonSurcoreano won;
	private Pesos peso;
	private SeleccionDeConversion anterior;
	
	public ConversorDeMonedas() {
		setTitle("Conversor De Monedas - ChallengeONE");
		getContentPane().setBackground(new java.awt.Color(0,50,255));
		getContentPane().setLayout(null);
		((JComponent) getContentPane()).setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,158,160)));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ingresarCantidad();
		comboBox();
		botonConvertir();
		botonBack();
		
		this.dolar = new Dolar();
		this.euro = new Euro();
		this.libra = new Libras();
		this.yen = new YenJapones();
		this.won = new WonSurcoreano();
		this.peso = new Pesos();
	}

	
	public void ingresarCantidad() {
		Font myFont1 = new Font("sans-Serif", Font.BOLD, 16);
		textCantidad = new JLabel("Ingrese el monto $");
		textCantidad.setBounds(50, -15, 200, 100);
		textCantidad.setForeground(Color.GREEN.brighter());
		textCantidad.setFont(myFont1);
		
		cantidad = new JTextField();
		cantidad.setBounds(50, 50, 350, 20);
		
		add(textCantidad);
		add(cantidad);
	}
	
	public void comboBox() {
		Font myFont1 = new Font("sans-Serif", Font.BOLD, 16);
		textSelect = new JLabel("Seleccione la moneda a convertir");
		textSelect.setBounds(50, 65, 350, 100);
		textSelect.setForeground(Color.GREEN.brighter());
		textSelect.setFont(myFont1);
		
		select = new JComboBox<String>();
		select.setBounds(50, 135, 350, 20);
		select.addItem("De Pesos A Dólares");
		select.addItem("De Pesos A Euros");
		select.addItem("De Pesos A Libras");
		select.addItem("De Pesos A Yen Japonés");
		select.addItem("De Pesos A Won Surcoreano");
		select.addItem("De Dólares A Pesos");
		select.addItem("De Euros A Pesos");
		select.addItem("De Libras A Pesos");
		select.addItem("De Yen Japonés A Pesos");
		select.addItem("De Won Surcoreano A Pesos");
		
		add(textSelect);
		add(select);
		
	}
	
	public void botonConvertir() {
		Font myFont1 = new Font("sans-Serif", Font.BOLD, 16);
		botonConvertir = new JButton("Convertir");
		botonConvertir.setBounds(230, 190, 150, 30);
		botonConvertir.setFont(myFont1);
		botonConvertir.setBackground(Color.GREEN.brighter());
		botonConvertir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		botonConvertir.addActionListener(this);
		
		add(botonConvertir);
	}
	
	public void botonBack() {
		Font myFont1 = new Font("sans-Serif", Font.BOLD, 16);
		botonBack = new JButton("Atras");
		botonBack.setBounds(70, 190, 150, 30);
		botonBack.setBackground(Color.GREEN.brighter());
		botonBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		botonBack.setFont(myFont1);
		botonBack.addActionListener(this);
		
		add(botonBack);
	}
	
	public void continuar() {
		int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas realizar otra conversión?");
        if (JOptionPane.NO_OPTION == respuesta) {
            JOptionPane.showMessageDialog(null, "Programa terminado");
            System.exit(0);
        }
    }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonConvertir) {
			try {
				switch (select.getSelectedItem().toString()) {
					case "De Pesos A Dólares":
						amount = Double.parseDouble(cantidad.getText());
						result = amount * dolar.getDolar();
						JOptionPane.showMessageDialog(null, "Usted tiene: $" + String.format("%.3f", result) + " Dolares.");
						continuar();
						break;
					case "De Pesos A Euros":
						amount = Double.parseDouble(cantidad.getText());
						result = amount * euro.getEuro();
						JOptionPane.showMessageDialog(null, "Usted tiene: $" + String.format("%.3f", result) + " Euros.");
						continuar();
					break;
					case "De Pesos A Libras":
						amount = Double.parseDouble(cantidad.getText());
						result = amount * libra.getLibra();
						JOptionPane.showMessageDialog(null, "Usted tiene: $" + String.format("%.3f", result) + " Libras Esterlinas.");
						continuar();
					break;
					case "De Pesos A Yen Japonés":
						amount = Double.parseDouble(cantidad.getText());
						result = amount * yen.getYen();
						JOptionPane.showMessageDialog(null, "Usted tiene: $" + String.format("%.2f", result) + " Yen Japonés.");
						continuar();
					break;
					case "De Pesos A Won Surcoreano":
						amount = Double.parseDouble(cantidad.getText());
						result = amount * won.getWon();
						JOptionPane.showMessageDialog(null, "Usted tiene: $" + String.format("%.2f", result) + " Won Surcoreano.");
						continuar();
					break;
					case "De Dólares A Pesos":
						amount = Double.parseDouble(cantidad.getText());
						result = amount * peso.getValorPesoEnDolar();
						JOptionPane.showMessageDialog(null, "Usted tiene: $" + String.format("%.2f", result) + " Pesos.");
						continuar();
					break;
					case "De Euros A Pesos":
						amount = Double.parseDouble(cantidad.getText());
						result = amount * peso.getValorPesoEnEuro();
						JOptionPane.showMessageDialog(null, "Usted tiene: $" + String.format("%.2f", result) + " Pesos.");
						continuar();
					break;
					case "De Libras A Pesos":
						amount = Double.parseDouble(cantidad.getText());
						result = amount * peso.getValorPesoEnLibra();
						JOptionPane.showMessageDialog(null, "Usted tiene: $" + String.format("%.2f", result) + " Pesos.");
						continuar();
					break;
					case "De Yen Japonés A Pesos":
						amount = Double.parseDouble(cantidad.getText());
						result = amount * peso.getValorPesoEnYen();
						JOptionPane.showMessageDialog(null, "Usted tiene: $" + String.format("%.2f", result) + " Pesos.");
						continuar();
					break;
					case "De Won Surcoreano A Pesos":
						amount = Double.parseDouble(cantidad.getText());
						result = amount * peso.getValorPesoEnWon();
						JOptionPane.showMessageDialog(null, "Usted tiene: $" + String.format("%.2f", result) + " Pesos.");
						continuar();
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
				this.dispose();  // Cierra la ventana actual
		}
	}
}
