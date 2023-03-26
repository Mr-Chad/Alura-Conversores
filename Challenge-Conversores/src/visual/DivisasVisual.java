package visual;

import clases.Divisas;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class DivisasVisual extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDivisa1;
	private JTextField txtDivisa2;
	private JButton btnConvertir;
	private JButton btnVolver;
	JComboBox <Divisas> comboBoxDivisa1;
	JComboBox <Divisas> comboBoxDivisa2;
	
	
	
	ArrayList<Divisas> Monedas = new ArrayList<Divisas>();
	
	double convertir(Divisas Divisa1Select, Divisas Divisa2Select, double cantidadSelect) {
		double parte1 = cantidadSelect / Divisa1Select.getValorUsd();
		double resultado = parte1 * Divisa2Select.getValorUsd();
		return resultado;
	}
	
	public DivisasVisual() {
		setTitle("Conversorex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		Divisas dolarUSD = new Divisas("Dolar Estados Unidos", "USD", 1);
		Divisas pesoArg = new Divisas("Peso Argentino", "ARS", 380);
		Divisas euro = new Divisas("Euro", "EUR", 0.93);
		Divisas libraEsterlina = new Divisas("Libra Esterlina", "GBP", 0.82);
		Divisas yenJapones = new Divisas("Yen japones", "JPY", 130.75);
		Divisas wonSur = new Divisas("Won Sul-Coreano", "KRW", 1295.83);
		
		Monedas.add(dolarUSD);
		Monedas.add(pesoArg);
		Monedas.add(euro);
		Monedas.add(libraEsterlina);
		Monedas.add(yenJapones);
		Monedas.add(wonSur);
		iniciarContenido();
		
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void iniciarContenido() {
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTituloDivisa = new JLabel("Divisas");
		lblTituloDivisa.setForeground(new Color(0, 128, 255));
		lblTituloDivisa.setBackground(new Color(0, 128, 255));
		lblTituloDivisa.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloDivisa.setFont(new Font("Georgia", Font.BOLD, 30));
		lblTituloDivisa.setBounds(0, 0, 703, 88);
		contentPane.add(lblTituloDivisa);
		
		txtDivisa1 = new JTextField();
		txtDivisa1.setBounds(103, 229, 163, 40);
		contentPane.add(txtDivisa1);
		txtDivisa1.addActionListener(this);
		txtDivisa1.setColumns(10);
		
		txtDivisa2 = new JTextField();
		txtDivisa2.setColumns(10);
		txtDivisa2.setBounds(419, 229, 163, 40);
		contentPane.add(txtDivisa2);
		
		JLabel lblFlecha = new JLabel("--->");
		lblFlecha.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblFlecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlecha.setBounds(276, 229, 133, 31);
		contentPane.add(lblFlecha);
		
		comboBoxDivisa1 = new JComboBox<Divisas>();
		comboBoxDivisa1.setBounds(103, 164, 163, 31);
		comboBoxDivisa1.addItem(Monedas.get(0));
		comboBoxDivisa1.addItem(Monedas.get(1));
		comboBoxDivisa1.addItem(Monedas.get(2));
		comboBoxDivisa1.addItem(Monedas.get(3));
		comboBoxDivisa1.addItem(Monedas.get(4));
		comboBoxDivisa1.addItem(Monedas.get(5));
		comboBoxDivisa1.addActionListener(this);
		contentPane.add(comboBoxDivisa1);
		
		comboBoxDivisa2 = new JComboBox<Divisas>();
		comboBoxDivisa2.setBounds(419, 164, 163, 31);
		comboBoxDivisa2.addItem(Monedas.get(0));
		comboBoxDivisa2.addItem(Monedas.get(1));
		comboBoxDivisa2.addItem(Monedas.get(2));
		comboBoxDivisa2.addItem(Monedas.get(3));
		comboBoxDivisa2.addItem(Monedas.get(4));
		comboBoxDivisa2.addItem(Monedas.get(5));
		comboBoxDivisa2.addActionListener(this);
		contentPane.add(comboBoxDivisa2);
		
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
		if (e.getSource() == btnConvertir) {
			Divisas Divisa1Select = (Divisas)comboBoxDivisa1.getSelectedItem();
			Divisas Divisa2Select = (Divisas)comboBoxDivisa2.getSelectedItem();
			try {
	            double cantidadSelect = Double.parseDouble(txtDivisa1.getText());
	            txtDivisa2.setText(Double.toString(convertir(Divisa1Select, Divisa2Select, cantidadSelect)));
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
