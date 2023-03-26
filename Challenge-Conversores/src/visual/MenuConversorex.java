package visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuConversorex extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JButton btnDivisas, btnTemperatura, btnSalir;

	public MenuConversorex() {
		
		iniciarComponentes();
		
		setResizable(false);
		setLocationRelativeTo(null);
		
	}

	private void iniciarComponentes() {
		setAlwaysOnTop(true);
		setTitle("Conversorex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Conversorex");
		lblTitulo.setForeground(new Color(0, 128, 255));
		lblTitulo.setBackground(new Color(0, 128, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Georgia", Font.BOLD, 30));
		lblTitulo.setBounds(0, 0, 703, 88);
		contentPane.add(lblTitulo);
		
		btnDivisas = new JButton("Divisas");
		btnDivisas.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		btnDivisas.setBounds(201, 131, 274, 64);
		btnDivisas.addActionListener(this);
		contentPane.add(btnDivisas);
		
		btnTemperatura = new JButton("Temperatura");
		btnTemperatura.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		btnTemperatura.setBounds(201, 219, 274, 64);
		btnTemperatura.addActionListener(this);
		contentPane.add(btnTemperatura);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		btnSalir.setBounds(201, 307, 274, 64);
		btnSalir.addActionListener(this);
		contentPane.add(btnSalir);
	}
	
	private void presentarDivisas() {
		DivisasVisual Divisa = new DivisasVisual();
		Divisa.setVisible(true);
	}
	
	private void presentarTemperatura() {
		TemperaturaVisual Temp = new TemperaturaVisual();
		Temp.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnDivisas == e.getSource()) {
			presentarDivisas();
			dispose();
		}
		if (btnTemperatura == e.getSource()) {
			presentarTemperatura();
			dispose();
		}
		if (btnSalir == e.getSource()) {
			dispose();
		}
		
	}
	
	
	
}
