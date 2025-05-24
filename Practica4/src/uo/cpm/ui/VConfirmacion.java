package uo.cpm.ui;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VConfirmacion extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblPulseParaFinalizar;
	private JLabel lblCodigoRecogida;
	private JTextField txtCodigo;
	private JButton btnFinalizar;
	private JLabel lblPrecioFinal;
	private VRegistro vRegistro;


	/**
	 * Create the dialog.
	 * @param vRegistro 
	 */
	public VConfirmacion(VRegistro vRegistro) {
		setModal(true);
		this.vRegistro = vRegistro; 
		setResizable(false);
		getContentPane().setBackground(SystemColor.window);
		getContentPane().setLayout(null);
		getContentPane().add(getLblPulseParaFinalizar());
		getContentPane().add(getLblCodigoRecogida());
		getContentPane().add(getTxtCodigo());
		getContentPane().add(getBtnFinalizar());
		getContentPane().add(getLblPrecioFinal());
		setTitle("McDonald's Espa\u00F1a : Confirmacion de pedido");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VConfirmacion.class.getResource("/img/logo.png")));
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);

	}

	private JLabel getLblPulseParaFinalizar() {
		if (lblPulseParaFinalizar == null) {
			lblPulseParaFinalizar = new JLabel("Pulse Finalizar para confirmar el pedido");
			lblPulseParaFinalizar.setFont(new Font("Arial Black", Font.PLAIN, 16));
			lblPulseParaFinalizar.setIcon(new ImageIcon(VConfirmacion.class.getResource("/img/ok.png")));
			lblPulseParaFinalizar.setBackground(SystemColor.window);
			lblPulseParaFinalizar.setBounds(10, 33, 414, 104);
		}
		return lblPulseParaFinalizar;
	}
	private JLabel getLblCodigoRecogida() {
		if (lblCodigoRecogida == null) {
			lblCodigoRecogida = new JLabel("El codigo de recogida es:");
			lblCodigoRecogida.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblCodigoRecogida.setBounds(63, 129, 218, 22);
		}
		return lblCodigoRecogida;
	}
	private JTextField getTxtCodigo() {
		if (txtCodigo == null) {
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
			txtCodigo.setText(this.vRegistro.getvPrincipal().getMcDonalds().getOrderCode());
			txtCodigo.setBounds(247, 131, 96, 22);
			txtCodigo.setColumns(10);
		}
		return txtCodigo;
		
		
	}
	private JButton getBtnFinalizar() {
		if (btnFinalizar == null) {
			btnFinalizar = new JButton("Finalizar");
			btnFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					finalizar();
				}
			});
			btnFinalizar.setBackground(new Color(0, 128, 0));
			btnFinalizar.setForeground(Color.WHITE);
			btnFinalizar.setBounds(301, 203, 85, 21);
		}
		return btnFinalizar;
	}
	
	
	private void finalizar() {
			this.vRegistro.getvPrincipal().getMcDonalds().saveOrder();
			JOptionPane.showMessageDialog(null, "Se ha realizado el pedido con exito.");
			this.dispose();
			vRegistro.dispose();
			vRegistro.getvPrincipal().inicializar();
	}
	
	
	private JLabel getLblPrecioFinal() {
		if (lblPrecioFinal == null) {
			float precioFinal = (float) this.vRegistro.getvPrincipal().getMcDonalds().getOrderTotal();
			if(precioFinal>=60) {
				precioFinal = (float) (precioFinal*0.90);
			}
			String precio = String.format("%.2f",precioFinal );
			lblPrecioFinal = new JLabel("El precio total es de: " + precio + "€");
			lblPrecioFinal.setFont(new Font("Arial Black", Font.PLAIN, 10));
			lblPrecioFinal.setBounds(63, 164, 218, 13);
		}
		return lblPrecioFinal;
	}
}
