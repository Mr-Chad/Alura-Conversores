package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleUnaryOperator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import clases.Temp;
import clases.conversorDeTemp;

public class TemperaturaVisual extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTemp1;
	private JTextField txtTemp2;
	private JButton btnConvertir;
	private JButton btnVolver;
	JComboBox <Temp> comboBoxTemp1;
	JComboBox <Temp> comboBoxTemp2;
		
	
	ArrayList <Temp> TiposTemp = new ArrayList<Temp>();
	
	public TemperaturaVisual() {
		setTitle("Conversorex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Temp celcius = new Temp("Celcius");
		Temp fahrenheit = new Temp("Fahrenheit");
		Temp kelvin = new Temp("Kelvin");
		
		TiposTemp.add(celcius);
		TiposTemp.add(fahrenheit);
		TiposTemp.add(kelvin);
		
		iniciarContenido();
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	private void iniciarContenido() {
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTituloDivisa = new JLabel("Temperatura");
		lblTituloDivisa.setForeground(new Color(0, 128, 255));
		lblTituloDivisa.setBackground(new Color(0, 128, 255));
		lblTituloDivisa.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloDivisa.setFont(new Font("Georgia", Font.BOLD, 30));
		lblTituloDivisa.setBounds(0, 0, 703, 88);
		contentPane.add(lblTituloDivisa);
		
		txtTemp1 = new JTextField();
		txtTemp1.setBounds(103, 229, 163, 40);
		contentPane.add(txtTemp1);
		txtTemp1.addActionListener(this);
		txtTemp1.setColumns(10);
		
		txtTemp2 = new JTextField();
		txtTemp2.setColumns(10);
		txtTemp2.setBounds(419, 229, 163, 40);
		contentPane.add(txtTemp2);
		
		JLabel lblFlecha = new JLabel("--->");
		lblFlecha.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblFlecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlecha.setBounds(276, 229, 133, 31);
		contentPane.add(lblFlecha);
		
		comboBoxTemp1 = new JComboBox<Temp>();
		comboBoxTemp1.setBounds(103, 164, 163, 31);
		comboBoxTemp1.addItem(TiposTemp.get(0));
		comboBoxTemp1.addItem(TiposTemp.get(1));
		comboBoxTemp1.addItem(TiposTemp.get(2));
		comboBoxTemp1.addActionListener(this);
		contentPane.add(comboBoxTemp1);
		
		comboBoxTemp2 = new JComboBox<Temp>();
		comboBoxTemp2.setBounds(419, 164, 163, 31);
		comboBoxTemp2.addItem(TiposTemp.get(0));
		comboBoxTemp2.addItem(TiposTemp.get(1));
		comboBoxTemp2.addItem(TiposTemp.get(2));
		comboBoxTemp2.addActionListener(this);
		contentPane.add(comboBoxTemp2);
		
		btnConvertir = new JButton("Convertir");
		btnConvertir.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConvertir.setBounds(276, 329, 133, 31);
		btnConvertir.addActionListener(this);
		contentPane.add(btnConvertir);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVolver.setBounds(0, 11, 102, 31);
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	    if(e.getSource() == btnConvertir) {
	        Temp temp1 = (Temp) comboBoxTemp1.getSelectedItem();
	        Temp temp2 = (Temp) comboBoxTemp2.getSelectedItem();
	        try {
	            double cantidadSelect = Double.parseDouble(txtTemp1.getText());
	            
	            if(temp1.equals(temp2)) {
	            	txtTemp2.setText(txtTemp1.getText());
	            }
	            
	            Map<String, DoubleUnaryOperator> conversiones = new HashMap<>();
	            conversiones.put("Celcius->Fahrenheit", conversorDeTemp::celsiusToFahrenheit);
	            conversiones.put("Celcius->Kelvin", conversorDeTemp::celsiusToKelvin);
	            conversiones.put("Fahrenheit->Celcius", conversorDeTemp::fahrenheitToCelsius);
	            conversiones.put("Fahrenheit->Kelvin", conversorDeTemp::fahrenheitToKelvin);
	            conversiones.put("Kelvin->Celcius", conversorDeTemp::kelvinToCelsius);
	            conversiones.put("Kelvin->Fahrenheit", conversorDeTemp::fahrenheitToCelsius);
	            
	            String conversionKey = temp1.getNombre() + "->" + temp2.getNombre();
	            
	            DoubleUnaryOperator conversion = conversiones.get(conversionKey);
	            
	            double resultado = conversion.applyAsDouble(cantidadSelect);
	            
	            txtTemp2.setText(Double.toString(resultado));
	            
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(null, "Error: Solo se permiten números", "Error de entrada", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	    
	    if (btnVolver == e.getSource()) {
	    	dispose();
	    	MenuConversorex menu = new MenuConversorex();
	    	menu.setVisible(true);
	    }
	}
}
