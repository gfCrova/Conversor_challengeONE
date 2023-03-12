import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Formatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;


public class ConversorDeMonedas extends JFrame implements ActionListener{

	private JLabel textCantidad, textSelect;
	private JFormattedTextField cantidad;
	private JComboBox<String> select;
	private JButton boton;
	private double amount, result;
	
	public ConversorDeMonedas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Conversor De Monedas - ChallengeONE");
		iniciarComponentes();
	};

	
	public void iniciarComponentes() {
		
		/*NumberFormatter numberFormatter = new NumberFormatter(NumberFormat.getIntegerInstance());
		numberFormatter.setValueClass(Integer.class);
		numberFormatter.setAllowsInvalid(false);
		numberFormatter.setMinimum(0);
		numberFormatter.setMaximum(Integer.MAX_VALUE);*/
		
		textCantidad = new JLabel("Ingrese el monto $");
		textCantidad.setBounds(50, -15, 200, 100);
		
		cantidad = new JFormattedTextField();
		cantidad.setBounds(50, 50, 350, 20);
		
		textSelect = new JLabel("Seleccione la moneda a convertir");
		textSelect.setBounds(50, 50, 200, 100);
		
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
		boton.setBounds(150, 190, 180, 30);
		boton.addActionListener(this);
		
		add(textCantidad);
		add(textSelect);
		add(cantidad);
		add(select);
		add(boton);
	}
	
	public static void main(String[] args) {
		
		ConversorDeMonedas conversor = new ConversorDeMonedas();
		conversor.setBounds(0, 0, 480, 300);
        conversor.setLocationRelativeTo(null);
        conversor.setResizable(false);
        conversor.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton) {
			String getInput = cantidad.getText();
			double dInput = Double.parseDouble(getInput);
			double texto = 0;
			if(dInput != texto) {
				switch (select.getSelectedItem().toString()) {
				case "De Pesos A Dólares":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 0.005;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Pesos equivalen a " + String.format("%.3f", result) + " Dolares.");
					break;
				case "De Pesos A Euros":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 0.004;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Pesos equivalen a " + String.format("%.3f", result) + " Euros.");
				break;
				case "De Pesos A Libras":
					result = amount * 0.004;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Pesos equivalen a " + String.format("%.3f", result) + " Libras Esterlinas.");
				break;
				case "De Pesos A Yen Japonés":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 0.67;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Pesos equivalen a " + String.format("%.2f", result) + " Yen Japonés.");
				break;
				case "De Pesos A Won Surcoreano":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 6.59;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Pesos equivalen a " + String.format("%.2f", result) + " Won Surcoreano.");
				break;
				case "De Dólares A Pesos":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 200.74;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Dólares equivalen a " + String.format("%.2f", result) + " Pesos.");
				break;
				case "De Euros A Pesos":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 213.79;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Euros equivalen a " + String.format("%.2f", result) + " Pesos.");
				break;
				case "De Libras A Pesos":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 241.54;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Libras Esterlinas equivalen a " + String.format("%.2f", result) + " Pesos.");
				break;
				case "De Yen Japonés A Pesos":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 1.48;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Yen Japonés equivalen a " + String.format("%.2f", result) + " Pesos.");
				break;
				case "De Won Surcoreano A Pesos":
					amount = Double.parseDouble(cantidad.getText());
					result = amount * 0.15;
					JOptionPane.showMessageDialog(null, String.format("%.2f", amount) + " Won Surcoreanos equivalen a " + String.format("%.2f", result) + " Pesos.");
				break;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Caracteres no válidos! ");
			}
		}
		
	}

	

}
