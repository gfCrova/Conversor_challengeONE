import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ConversorDeMonedas extends JFrame implements ActionListener{

	private JLabel textCantidad, textSelect;
	private JTextField cantidad;
	private JComboBox<String> select;
	private JButton boton, botonBack;
	private double amount, result;
	private SeleccionDeConversion nueva;
	
	public ConversorDeMonedas() {
		setTitle("Conversor De Monedas - ChallengeONE");
		getContentPane().setBackground(new java.awt.Color(0,112,255));
		getContentPane().setLayout(null);
		((JComponent) getContentPane()).setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95,158,160)));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
	};
	
	public void iniciarComponentes() {
		Font myFont1 = new Font("sans-Serif", Font.BOLD, 16);

		textCantidad = new JLabel("Ingrese el monto $");
		textCantidad.setBounds(50, -15, 200, 100);
		textCantidad.setForeground(Color.WHITE);
		textCantidad.setFont(myFont1);
		
		cantidad = new JTextField();
		cantidad.setBounds(50, 50, 350, 20);
		
		textSelect = new JLabel("Seleccione la moneda a convertir");
		textSelect.setBounds(50, 65, 350, 100);
		textSelect.setForeground(Color.WHITE);
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
		
		boton = new JButton("Convertir");
		boton.setBounds(230, 190, 150, 30);
		boton.setFont(myFont1);
		boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		boton.addActionListener(this);
		
		botonBack = new JButton("Atras");
		botonBack.setBounds(70, 190, 150, 30);
		botonBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		botonBack.setFont(myFont1);
		
		getContentPane().add(textCantidad);
		getContentPane().add(textSelect);
		getContentPane().add(cantidad);
		getContentPane().add(select);
		getContentPane().add(boton);
		getContentPane().add(botonBack);
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
		if(e.getSource() == boton) {
			try {
				switch (select.getSelectedItem().toString()) {
				case "De Pesos A Dólares":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 0.005;
					JOptionPane.showMessageDialog(null, "Usted tiene: $" + String.format("%.3f", result) + " Dolares.");
					continuar();
					break;
				case "De Pesos A Euros":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 0.004;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Pesos equivalen a " + String.format("%.3f", result) + " Euros.");
					continuar();
				break;
				case "De Pesos A Libras":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 0.004;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Pesos equivalen a " + String.format("%.3f", result) + " Libras Esterlinas.");
					continuar();
				break;
				case "De Pesos A Yen Japonés":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 0.67;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Pesos equivalen a " + String.format("%.2f", result) + " Yen Japonés.");
					continuar();
				break;
				case "De Pesos A Won Surcoreano":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 6.59;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Pesos equivalen a " + String.format("%.2f", result) + " Won Surcoreano.");
					continuar();
				break;
				case "De Dólares A Pesos":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 200.74;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Dólares equivalen a " + String.format("%.2f", result) + " Pesos.");
					continuar();
				break;
				case "De Euros A Pesos":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 213.79;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Euros equivalen a " + String.format("%.2f", result) + " Pesos.");
					continuar();
				break;
				case "De Libras A Pesos":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 241.54;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Libras Esterlinas equivalen a " + String.format("%.2f", result) + " Pesos.");
					continuar();
				break;
				case "De Yen Japonés A Pesos":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 1.48;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Yen Japonés equivalen a " + String.format("%.2f", result) + " Pesos.");
					continuar();
				break;
				case "De Won Surcoreano A Pesos":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 0.15;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Won Surcoreanos equivalen a " + String.format("%.2f", result) + " Pesos.");
					continuar();
				break;
				}
				
			} catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Ingresar un monto válido", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	

}
