package uo.cpm.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uo.cpm.model.Product;
import uo.cpm.service.McDonalds;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class VPrincipal extends JFrame {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private McDonalds mcDonalds;
	private JPanel contentPane;
	private JLabel lblLogo;
	private JComboBox<Product> cbArticulos;
	private JLabel lblArticulos;
	private JSpinner spUnidades;
	private JTextField txPreciototal;
	private JLabel lblUnidades;
	private JButton btnAdd;
	private JLabel lblPrecioPedido;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private JLabel lblDescuento;
	private JLabel lblCuantasUnidadesHay;


	/**
	 * Create the frame.
	 * @param mc 
	 * @param mc 
	 */
	public VPrincipal(McDonalds mc) {
		this.mcDonalds = mc;
		setResizable(false);
		setTitle("McDonald's Espa\u00F1a");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VPrincipal.class.getResource("/img/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLogo());
		contentPane.add(getCbArticulos());
		contentPane.add(getLblArticulos());
		contentPane.add(getSpUnidades());
		contentPane.add(getTxPreciototal());
		contentPane.add(getLblUnidades());
		contentPane.add(getBtnAdd());
		contentPane.add(getLblPrecioPedido());
		contentPane.add(getBtnSiguiente());
		contentPane.add(getBtnCancelar());
		contentPane.add(getLblDescuento());
		contentPane.add(getLblCuantasUnidadesHay());
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("  McDonald's");
			lblLogo.setFont(new Font("Arial Black", Font.PLAIN, 44));
			lblLogo.setIcon(new ImageIcon(VPrincipal.class.getResource("/img/logo.png")));
			lblLogo.setBounds(32, 10, 460, 130);
		}
		return lblLogo;
	}
	private JComboBox<Product> getCbArticulos() {
		if (cbArticulos == null) {
			cbArticulos = new JComboBox<Product>();
			cbArticulos.setBounds(32, 205, 260, 22);
			cbArticulos.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					getSpUnidades().setValue(1);
					cuantasUnidades();
					
				}
			});
			cbArticulos.setModel(new DefaultComboBoxModel<Product>(mcDonalds.getMenuProducts()));
		}
		return cbArticulos;
	} 
	
	
	private JLabel getLblArticulos() {
		if (lblArticulos == null) {
			lblArticulos = new JLabel("Articulos:");
			lblArticulos.setBounds(32, 179, 260, 14);
		}
		return lblArticulos;
	}
	private JSpinner getSpUnidades() {
		if (spUnidades == null) {
			spUnidades = new JSpinner();
			spUnidades.setModel(new SpinnerNumberModel(1, 1, 50, 1));
			spUnidades.setBounds(338, 205, 52, 22);
		}
		return spUnidades;
	}
	private JTextField getTxPreciototal() {
		if (txPreciototal == null) {
			txPreciototal = new JTextField();
			txPreciototal.setHorizontalAlignment(SwingConstants.TRAILING);
			txPreciototal.setEditable(false);
			txPreciototal.setBounds(338, 261, 86, 20);
			txPreciototal.setColumns(10);
		}
		return txPreciototal;
	}
	private JLabel getLblUnidades() {
		if (lblUnidades == null) {
			lblUnidades = new JLabel("Unidades:");
			lblUnidades.setBounds(338, 179, 67, 14); 
		}
		return lblUnidades;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("A\u00F1adir");
			btnAdd.setForeground(new Color(255, 255, 255));
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					anadirAPedido();
					getBtnSiguiente().setEnabled(true);
					cuantasUnidades();
				}
			});
			btnAdd.setBackground(new Color(0, 128, 0));
			btnAdd.setBounds(403, 205, 89, 23);
		}
		
		return btnAdd;
	}
	private void anadirAPedido() {
		Product articuloSeleccionado = (Product) getCbArticulos().getSelectedItem();
		int unidadesSolicitadas = (int) getSpUnidades().getValue();
		mcDonalds.addToOrder(articuloSeleccionado,unidadesSolicitadas);
		float precioTotal = (float) mcDonalds.getOrderTotal();
		precioTotal = aplicarDescuento(precioTotal);
		String precio = String.format("%.2f", precioTotal);
		
		getTxPreciototal().setText(precio + " €");
	}
	
	private float aplicarDescuento(float precioTotal) {
		if(precioTotal < 60) {
			return precioTotal;
			
		}
		float descuento = (float) 0.90;
		precioTotal = precioTotal*descuento;
		 JOptionPane.showMessageDialog(null, "Se ha aplicado tu descuento correctamente");
		 return precioTotal;
	}
	private JLabel getLblPrecioPedido() {
		if (lblPrecioPedido == null) {
			lblPrecioPedido = new JLabel("Precio Pedido:");
			lblPrecioPedido.setBounds(338, 237, 86, 14);
		}
		return lblPrecioPedido;
	}
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setEnabled(false);
			btnSiguiente.setBackground(new Color(0, 128, 0));
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVRegistro();
				}
			});
			btnSiguiente.setForeground(new Color(255, 255, 255));
			btnSiguiente.setBounds(338, 327, 89, 23);
		}
		return btnSiguiente;
	}

	private void mostrarVRegistro() {
		VRegistro frame = new VRegistro(this);
		frame.setVisible(true);
	}
	public McDonalds getMcDonalds() {
		return mcDonalds;
	}
	
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
			btnCancelar.setForeground(new Color(255, 255, 255));
			btnCancelar.setBackground(new Color(255, 0, 0));
			btnCancelar.setBounds(437, 327, 89, 23);
		}
		return btnCancelar;
	}
	
	protected void inicializar() {
		//Capa de negocio
		mcDonalds.initOrder();
		//Capa de interfaz
		getCbArticulos().setSelectedIndex(0); //Se pone en primera posicion
		getSpUnidades().setValue(1);
		getTxPreciototal().setText("");
		getBtnSiguiente().setEnabled(false);
	}
	private JLabel getLblDescuento() {
		if (lblDescuento == null) {
			lblDescuento = new JLabel("New label");
			lblDescuento.setIcon(new ImageIcon(VPrincipal.class.getResource("/img/ofertaHappy22_23.png")));
			lblDescuento.setBounds(406, 86, 302, 130);
		}
		return lblDescuento;
	}
	private JLabel getLblCuantasUnidadesHay() {
		if (lblCuantasUnidadesHay == null) {
			
			lblCuantasUnidadesHay = new JLabel("Hay 0 unidades de este producto");
			lblCuantasUnidadesHay.setFont(new Font("Arial Black", Font.PLAIN, 10));
			lblCuantasUnidadesHay.setBounds(32, 264, 260, 13);
			
		}
		return lblCuantasUnidadesHay;
	}
	private void cuantasUnidades() {
		Product articuloSeleccionado = (Product) getCbArticulos().getSelectedItem();
		int n = mcDonalds.getUnidades(articuloSeleccionado);
		getLblCuantasUnidadesHay().setText("Hay "+ n +" unidades de este producto");
	}
}
