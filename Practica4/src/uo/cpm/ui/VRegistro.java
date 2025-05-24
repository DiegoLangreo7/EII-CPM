package uo.cpm.ui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VRegistro extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btSiguiente;
	private JButton btCancelar;
	private VPrincipal vPrincipal;
	private JPanel pnCliente;
	private JTextField txNombre;
	private JLabel lbNombre;
	private JLabel lbNacimiento;
	private JLabel lbContrasena;
	private JLabel lbReintroduzcaContrasena;
	private JPasswordField txContrasena;
	private JPasswordField txContrasenaRepetir;
	private JPanel pnPedido;
	private JRadioButton btLocal;
	private JRadioButton btLlevar;
	private JComboBox<String> comboBox;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	public VRegistro(VPrincipal vPrincipal) {
		setModal(true);
		this.vPrincipal = vPrincipal;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VRegistro.class.getResource("/img/logo.png")));
		setTitle("McDonald's Espa\u00F1a : Datos de registro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 310);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		contentPane.add(getBtSiguiente());
		contentPane.add(getBtCancelar());
		contentPane.add(getPnCliente());
		contentPane.add(getPnPedido());
	}
	
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("ACEPTAR"); 
			btSiguiente.setForeground(Color.WHITE);
			btSiguiente.setBackground(new Color(0, 128, 0));
			btSiguiente.setBounds(227, 238, 104, 21);
			
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) { 
					boolean nombreCond = revisarNombreYApellidos();
					if(nombreCond == true) {
						boolean contrasenaCond = revisarContrasenas();
						if(contrasenaCond == true) {
							mostrarVConfirmacion();
						}
					}
					
				}

				private boolean revisarContrasenas() {
					if(String.valueOf(txContrasena.getPassword()).isEmpty()){
					  JOptionPane.showMessageDialog(null, "No ha rellenado el campo de Contraseï¿½a");
					  return false;
					}
					else if(String.valueOf(txContrasenaRepetir.getPassword()).isEmpty()){
						  JOptionPane.showMessageDialog(null, "No ha rellenado el campo de Repetir Contraseï¿½a");
						  return false;
						}
					else if(!String.valueOf(txContrasena.getPassword()).equals(String.valueOf(txContrasenaRepetir.getPassword()))){
						  JOptionPane.showMessageDialog(null, "Los campos de contraseï¿½as no coinciden");
						  return false;
						}
					return true;
				}

				private boolean revisarNombreYApellidos() {
					if(txNombre.getText().isEmpty()) {
					  JOptionPane.showMessageDialog(null, "No ha rellenado el campo de Nombre y Apellidos");
					  return false;
					}
					return true;
				}
			});
		}
		return btSiguiente;
	}
	
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btCancelar.setForeground(Color.WHITE);
			btCancelar.setBackground(Color.RED);
			btCancelar.setBounds(341, 237, 104, 23);
		}
		return btCancelar;
	}
	private JPanel getPnCliente() {
		if (pnCliente == null) {
			pnCliente = new JPanel();
			pnCliente.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnCliente.setBackground(SystemColor.window);
			pnCliente.setBounds(10, 11, 463, 151);
			pnCliente.setLayout(null);
			pnCliente.add(getLbNombre());
			pnCliente.add(getTxNombre());
			pnCliente.add(getLbNacimiento());
			pnCliente.add(getLbContrasena());
			pnCliente.add(getLbReintroduzcaContrasena());
			pnCliente.add(getTxContrasena());
			pnCliente.add(getTxContrasenaRepetir());
			pnCliente.add(getComboBox());
		}
		return pnCliente;
	}
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setBounds(168, 21, 260, 22);
			txNombre.setColumns(10);
		}
		return txNombre;
	}
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre y Apellidos");
			lbNombre.setBounds(21, 24, 138, 14);
		}
		return lbNombre;
	}
	private JLabel getLbNacimiento() {
		if (lbNacimiento == null) {
			lbNacimiento = new JLabel("Año de nacimiento");
			lbNacimiento.setBounds(21, 52, 138, 14);
		}
		return lbNacimiento;
	}
	private JLabel getLbContrasena() {
		if (lbContrasena == null) {
			lbContrasena = new JLabel("Contraseña");
			lbContrasena.setBounds(21, 83, 88, 14);
		}
		return lbContrasena;
	}
	private JLabel getLbReintroduzcaContrasena() {
		if (lbReintroduzcaContrasena == null) {
			lbReintroduzcaContrasena = new JLabel("Reintroduzca contraseña");
			lbReintroduzcaContrasena.setBounds(21, 114, 160, 14);
		}
		return lbReintroduzcaContrasena;
	}
	private JPasswordField getTxContrasena() {
		if (txContrasena == null) {
			txContrasena = new JPasswordField();
			txContrasena.setBounds(168, 80, 260, 23);
		}
		return txContrasena;
	}
	private JPasswordField getTxContrasenaRepetir() {
		if (txContrasenaRepetir == null) {
			txContrasenaRepetir = new JPasswordField();
			txContrasenaRepetir.setBounds(168, 111, 260, 23);
		}
		return txContrasenaRepetir;
	}
	private JPanel getPnPedido() {
		if (pnPedido == null) {
			pnPedido = new JPanel();
			pnPedido.setBorder(new TitledBorder(null, "Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnPedido.setBackground(SystemColor.window);
			pnPedido.setBounds(10, 167, 463, 59);
			pnPedido.setLayout(null);
			pnPedido.add(getBtLocal());
			pnPedido.add(getBtLlevar());
		}
		return pnPedido;
	}
	private JRadioButton getBtLocal() {
		if (btLocal == null) {
			btLocal = new JRadioButton("Local");
			buttonGroup.add(btLocal);
			btLocal.setBackground(SystemColor.window);
			btLocal.setSelected(true);
			btLocal.setBounds(22, 23, 59, 23);
		}
		return btLocal;
	}
	private JRadioButton getBtLlevar() {
		if (btLlevar == null) {
			btLlevar = new JRadioButton("Llevar");
			buttonGroup.add(btLlevar);
			btLlevar.setBackground(SystemColor.window);
			btLlevar.setBounds(96, 23, 84, 23);
		}
		return btLlevar;
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			String[] listaAnosNacimiento = new String[120];
			for(int i=2004;i>1900;i--) {
				listaAnosNacimiento[2004-i] = ""+i;
			}
			comboBox.setModel(new DefaultComboBoxModel<String>(listaAnosNacimiento));
			comboBox.setBackground(SystemColor.window);
			comboBox.setBounds(168, 52, 123, 22);
		}
		return comboBox;
	}

	private void mostrarVConfirmacion() {
		VConfirmacion dialog = new VConfirmacion(this);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

	public VPrincipal getvPrincipal() {
		return vPrincipal;
	}
}
