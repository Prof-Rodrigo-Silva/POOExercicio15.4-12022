package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaSistema {

	private JFrame frame;
	private JTextField textNumeros;
	private JTextField textMaior;
	private JTextField textMenor;
	private JTextField textMedia;
	
	String valoresDigitados;
	String[] valores;
	int[] valoresConvertidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSistema window = new TelaSistema();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaSistema() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 620, 350);
		frame.setTitle("Verificador");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite o número:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(30, 30, 180, 30);
		frame.getContentPane().add(lblNewLabel);
		
		textNumeros = new JTextField();
		textNumeros.setFont(new Font("Dialog", Font.PLAIN, 16));
		textNumeros.setBounds(30, 70, 180, 30);
		frame.getContentPane().add(textNumeros);
		textNumeros.setColumns(10);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valoresDigitados = textNumeros.getText();
				if(!valoresDigitados.isEmpty()) {
					String[] valores = valoresDigitados.split(",");
					valoresConvertidos = new int[valores.length];
					for(int i = 0; i < valores.length; i++) {
						valoresConvertidos[i] = Integer.parseInt(valores[i]);	
					}
					JOptionPane.showMessageDialog(null, "Valores Cadastrados!","Aviso",JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Cadastre pelo menos UM valor!","Aviso",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnOK.setBounds(228, 70, 180, 30);
		frame.getContentPane().add(btnOK);
		
		JLabel lblNewLabel_1 = new JLabel("Maior >>>");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1.setBounds(60, 140, 180, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Menor >>>");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_2.setBounds(60, 180, 180, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Média >>>");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_3.setBounds(60, 220, 180, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		textMaior = new JTextField();
		textMaior.setFont(new Font("Dialog", Font.PLAIN, 16));
		textMaior.setBounds(228, 140, 180, 30);
		frame.getContentPane().add(textMaior);
		textMaior.setColumns(10);
		
		textMenor = new JTextField();
		textMenor.setFont(new Font("Dialog", Font.PLAIN, 16));
		textMenor.setColumns(10);
		textMenor.setBounds(228, 180, 180, 30);
		frame.getContentPane().add(textMenor);
		
		textMedia = new JTextField();
		textMedia.setFont(new Font("Dialog", Font.PLAIN, 16));
		textMedia.setColumns(10);
		textMedia.setBounds(228, 220, 180, 30);
		frame.getContentPane().add(textMedia);
		
		JButton btnExibir = new JButton("Exibir");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maior = valoresConvertidos[0];
				int menor = valoresConvertidos[0];
				double media;
				int soma=0;
				
				for(int i : valoresConvertidos) {
					if(maior < i) {
						maior = i;
					}
					if(menor > i) {
						menor = i;						
					}
					soma += i;
				}
				media = soma / valoresConvertidos.length;
				
				textMaior.setText(Integer.toString(maior));
				textMenor.setText(Integer.toString(menor));
				textMedia.setText(Double.toString(media));
			}
		});
		btnExibir.setBounds(420, 180, 180, 30);
		frame.getContentPane().add(btnExibir);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNumeros.setText(null);
				textMaior.setText(null);
				textMenor.setText(null);
				textMaior.setText(null);
				textMedia.setText(null);
			}
		});
		btnLimpar.setBounds(420, 220, 180, 30);
		frame.getContentPane().add(btnLimpar);
	}
}
