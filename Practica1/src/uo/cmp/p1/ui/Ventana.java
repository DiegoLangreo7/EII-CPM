package uo.cmp.p1.ui;

import java.awt.Color;

import javax.swing.*;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal;
	private JButton btAceptar;
	private JButton btCancelar;
	private JTextField txNombre;

	public Ventana() {
		this.setBounds(100, 100, 450, 300);
		this.setTitle("Mi primera ventana");

		pnPrincipal = new JPanel();
		this.setContentPane(pnPrincipal);
		pnPrincipal.setLayout(null);
		pnPrincipal.setBackground(Color.PINK);

		btAceptar = new JButton();
		btAceptar.setBounds(250, 220, 100, 30);
		btAceptar.setText("Aceptar");
		btAceptar.setForeground(Color.GREEN);
		
		btCancelar = new JButton();
		btCancelar.setBounds(110, 220, 100, 30);
		btCancelar.setText("Cancelar");
		btCancelar.setForeground(Color.RED);
		
		txNombre = new JTextField();
		txNombre.setBounds(145, 70, 175, 30);
		
		pnPrincipal.add(btAceptar);
		pnPrincipal.add(btCancelar);
		pnPrincipal.add(txNombre);
	}

	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		ventana.setVisible(true);
	}

}





