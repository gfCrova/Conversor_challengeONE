
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConversorDeTemperatura extends JFrame implements ActionListener {
	
	private JLabel textCantidad, textSelect;
	private JTextField cantidad;
	private JComboBox<String> select;
	private JButton boton;
	private double amount, result;
	
	public ConversorDeTemperatura() {
		setTitle("Conversor De Grados C° a F°");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
	};

	
	public void iniciarComponentes() {

		textCantidad = new JLabel("Ingrese el monto $");
		textCantidad.setBounds(50, -15, 200, 100);
		
		cantidad = new JTextField();
		cantidad.setBounds(50, 50, 350, 20);
		
		textSelect = new JLabel("Seleccione la moneda a convertir");
		textSelect.setBounds(50, 50, 200, 100);
		
		select = new JComboBox<String>();
		select.setBounds(50, 135, 350, 20);
		select.addItem("De Farenheit A Celcius");
		select.addItem("De Farenheit A Euros");
		select.addItem("De Farenheit A Libras");
		select.addItem("De Farenheit Yen Japonés");
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
