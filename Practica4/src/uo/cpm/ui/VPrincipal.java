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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

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
	private JButton btnEliminar;
	private JButton btnPedido;
	private JTextArea txtAreaPedidoVer;
	private JScrollPane panelPedido;


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
		setBounds(100, 100, 701, 400);
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
		contentPane.add(getBtnEliminar());
		contentPane.add(getBtnPedido());
		contentPane.add(getPanelPedido());
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
					revisarBotonEliminar();
					
				}
			});
			cbArticulos.setModel(new DefaultComboBoxModel<Product>(mcDonalds.getMenuProducts()));
		}
		return cbArticulos;
	} 
	
	private void revisarBotonEliminar() {
		if(this.mcDonalds.getUnidades((Product) getCbArticulos().getSelectedItem())==0) {
			getBtnEliminar().setEnabled(false);
		}
		else {
			getBtnEliminar().setEnabled(true);
		}
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
			spUnidades.setBounds(357, 205, 52, 22);
		}
		return spUnidades;
	}
	private JTextField getTxPreciototal() {
		if (txPreciototal == null) {
			txPreciototal = new JTextField();
			txPreciototal.setFont(new Font("Tahoma", Font.BOLD, 11));
			txPreciototal.setText("0.0 €");
			txPreciototal.setHorizontalAlignment(SwingConstants.TRAILING);
			txPreciototal.setEditable(false);
			txPreciototal.setBounds(357, 263, 86, 23);
			txPreciototal.setColumns(10);
		}
		return txPreciototal;
	}
	private JLabel getLblUnidades() {
		if (lblUnidades == null) {
			lblUnidades = new JLabel("Unidades:");
			lblUnidades.setBounds(357, 179, 67, 14); 
			
		}
		return lblUnidades;
	} 
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("A\u00F1adir");
			btnAdd.setForeground(Color.DARK_GRAY);
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					anadirAPedido();	
				}
			});
			btnAdd.setBackground(SystemColor.activeCaption);
			btnAdd.setBounds(437, 205, 89, 23);
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
		/////////////////////////////////////////////////
		getTxPreciototal().setText(precio + " €");
		getBtnSiguiente().setEnabled(true);
		cuantasUnidades();
		revisarBotonEliminar();
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
			lblPrecioPedido.setBounds(357, 238, 86, 14);
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
			btnSiguiente.setBounds(401, 327, 89, 23);
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
			btnCancelar.setBounds(524, 327, 89, 23);
		}
		return btnCancelar;
	}
	
	protected void inicializar() {
		//Capa de negocio
		mcDonalds.initOrder();
		//Capa de interfaz
		getCbArticulos().setSelectedIndex(0); //Se pone en primera posicion
		getSpUnidades().setValue(1);
		getTxPreciototal().setText("0.0 €");
		getBtnSiguiente().setEnabled(false);
	}
	private JLabel getLblDescuento() {
		if (lblDescuento == null) {
			lblDescuento = new JLabel("New label");
			lblDescuento.setIcon(new ImageIcon(VPrincipal.class.getResource("/img/ofertaHappy22_23.png")));
			lblDescuento.setBounds(42, 238, 249, 112);
		}
		return lblDescuento;
	}
	private JLabel getLblCuantasUnidadesHay() {
		if (lblCuantasUnidadesHay == null) {
			
			lblCuantasUnidadesHay = new JLabel("Hay 0 unidades de este producto");
			lblCuantasUnidadesHay.setFont(new Font("Arial Black", Font.PLAIN, 10));
			lblCuantasUnidadesHay.setBounds(32, 161, 260, 13);
			
		}
		return lblCuantasUnidadesHay;
	}
	private void cuantasUnidades() {
		Product articuloSeleccionado = (Product) getCbArticulos().getSelectedItem();
		int n = mcDonalds.getUnidades(articuloSeleccionado);
		getLblCuantasUnidadesHay().setText("Hay "+ n +" unidades de este producto");
	}
	
	/**
	 * Pasos a seguir:
	 * 		mc.eliminarDePedido(articulo,cantidad)
	 * 		actualizar msg y uds.
	 * 		actualizar pedido
	 * 		actualizar descuento
	 * 		si pedido es 0 -> desactivar boton siguiente.
	 * @return
	 */
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarArticulo();
				}
			});
			btnEliminar.setForeground(Color.DARK_GRAY);
			btnEliminar.setBackground(SystemColor.activeCaption);
			btnEliminar.setBounds(550, 205, 89, 23);
			getBtnEliminar().setEnabled(false);
		}
		return btnEliminar;
	}
	private void eliminarArticulo() {
		mcDonalds.eliminarDePedido((Product) getCbArticulos().getSelectedItem(), (int) getSpUnidades().getValue());
		
		cuantasUnidades();
		float precioFinal = (float) mcDonalds.getOrderTotal();
		getTxPreciototal().setText(precioFinal + " €");
		if(precioFinal == 0) {
			getBtnSiguiente().setEnabled(false);
		}
		revisarBotonEliminar();
	}
	private JButton getBtnPedido() {
		if (btnPedido == null) {
			btnPedido = new JButton("");
			btnPedido.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					panelPedido.setVisible(true);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					panelPedido.setVisible(false);
				}
			});
			btnPedido.setBackground(SystemColor.window);
			btnPedido.setIcon(new ImageIcon(VPrincipal.class.getResource("/img/pedido.png")));
			btnPedido.setBounds(526, 22, 127, 30);
		}
		return btnPedido;
	}
	private JTextArea getTxtAreaPedidoVer() {
		if (txtAreaPedidoVer == null) {
			txtAreaPedidoVer = new JTextArea();
			txtAreaPedidoVer.setEditable(false);
			txtAreaPedidoVer.setText("asdfasdfa");
		}
		return txtAreaPedidoVer;
	}
	private JScrollPane getPanelPedido() {
		if (panelPedido == null) {
			panelPedido = new JScrollPane();
			panelPedido.setViewportBorder(null);
			panelPedido.setVisible(false);
			panelPedido.setBounds(524, 63, 129, 102);
			panelPedido.setViewportView(getTxtAreaPedidoVer());
		}
		return panelPedido;
	}
}
