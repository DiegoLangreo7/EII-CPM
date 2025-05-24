package uo.cpm.p2.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class VentanaRegistro extends JFrame {

	private JPanel pnPrincipal;
	private JPanel pnDatosUsuario;
	private JLabel lbNombreYApellidos;
	private JTextField tfNombreYApellidos;
	private JLabel lbAño;
	private JComboBox<?> cbAño;
	private JLabel lbContraseña;
	private JLabel lbContraseñaRepetir;
	private JPanel pnPedido;
	private JRadioButton btLocal;
	private JRadioButton btLlevar;
	private JButton btAceptar;
	private JButton btCancelar;
	private JPasswordField pfContraseña;
	private JPasswordField pfReintroducirContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
		setBackground(SystemColor.window);
		setTitle("Datos de Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(SystemColor.window);
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(null);
		pnPrincipal.add(getPnDatosUsuario());
		pnPrincipal.add(getPnPedido());
		pnPrincipal.add(getBtAceptar());
		pnPrincipal.add(getBtCancelar());
	}
	private JPanel getPnDatosUsuario() {
		if (pnDatosUsuario == null) {
			pnDatosUsuario = new JPanel();
			pnDatosUsuario.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnDatosUsuario.setBackground(SystemColor.window);
			pnDatosUsuario.setBounds(10, 10, 566, 174);
			pnDatosUsuario.setLayout(null);
			pnDatosUsuario.add(getLbNombreYApellidos());
			pnDatosUsuario.add(getTfNombreYApellidos());
			pnDatosUsuario.add(getCbAño());
			pnDatosUsuario.add(getLbContraseña());
			pnDatosUsuario.add(getLbContraseñaRepetir());
			pnDatosUsuario.add(getLbAño());
			pnDatosUsuario.add(getPfContraseña());
			pnDatosUsuario.add(getPfReintroducirContraseña());
		}
		return pnDatosUsuario;
	}
	private JLabel getLbNombreYApellidos() {
		if (lbNombreYApellidos == null) {
			lbNombreYApellidos = new JLabel("Nombre y Apellidos:");
			lbNombreYApellidos.setBounds(22, 33, 138, 13);
		}
		return lbNombreYApellidos;
	}
	private JTextField getTfNombreYApellidos() {
		if (tfNombreYApellidos == null) {
			tfNombreYApellidos = new JTextField();
			tfNombreYApellidos.setBounds(178, 30, 324, 19);
			tfNombreYApellidos.setColumns(10);
		}
		return tfNombreYApellidos;
	}
	private JLabel getLbAño() {
		if (lbAño == null) {
			lbAño = new JLabel("Año de nacimiento: ");
			lbAño.setBounds(22, 69, 138, 13);
		}
		return lbAño;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JComboBox<?> getCbAño() {
		if (cbAño == null) {
			cbAño = new JComboBox();
			String[] listaAñosNacimiento = new String[120];
			for(int i=2004;i>1900;i--) {
				listaAñosNacimiento[2004-i] = ""+i;
			}
			cbAño.setModel(new DefaultComboBoxModel(listaAñosNacimiento));
			cbAño.setBounds(178, 65, 118, 21);
			
		}
		return cbAño;
	}
	private JLabel getLbContraseña() {
		if (lbContraseña == null) {
			lbContraseña = new JLabel("Contraseña: ");
			lbContraseña.setBounds(22, 109, 138, 13);
		}
		return lbContraseña;
	}
	private JLabel getLbContraseñaRepetir() {
		if (lbContraseñaRepetir == null) {
			lbContraseñaRepetir = new JLabel("Reintroduzca contraseña:");
			lbContraseñaRepetir.setBounds(22, 141, 163, 13);
		}
		return lbContraseñaRepetir;
	}
	private JPanel getPnPedido() {
		if (pnPedido == null) {
			pnPedido = new JPanel();
			pnPedido.setBorder(new TitledBorder(null, "Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnPedido.setBackground(SystemColor.window);
			pnPedido.setBounds(10, 194, 258, 59);
			pnPedido.setLayout(null);
			pnPedido.add(getBtLocal());
			pnPedido.add(getBtLlevar());
		}
		return pnPedido;
	}
	private JRadioButton getBtLocal() {
		if (btLocal == null) {
			btLocal = new JRadioButton("Local");
			btLocal.setBackground(SystemColor.window);
			btLocal.setSelected(true);
			btLocal.setBounds(18, 20, 103, 21);
			
			btLocal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btLlevar.setSelected(false);
				}
			});
		}
		return btLocal;
	}
	private JRadioButton getBtLlevar() {
		if (btLlevar == null) {
			btLlevar = new JRadioButton("Llevar");
			btLlevar.setBackground(Color.WHITE);
			btLlevar.setBounds(120, 20, 103, 21);
		}
		btLlevar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btLocal.setSelected(false);
			}
		});
		return btLlevar;
	}
	private JButton getBtAceptar() {
		if (btAceptar == null) {
			btAceptar = new JButton("ACEPTAR"); 
			btAceptar.setBackground(new Color(51, 204, 51));
			btAceptar.setBounds(339, 216, 104, 21);
			
			btAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) { 
					boolean nombreCond = revisarNombreYApellidos();
					boolean contraseñaCond = revisarContraseñas();
					if(nombreCond == true && contraseñaCond == true) {
						JOptionPane.showMessageDialog(null, "Ha hecho el pedido con éxito");
						System.exit(0);
					}
				}

				private boolean revisarContraseñas() {
					if(String.valueOf(pfContraseña.getPassword()).isEmpty()){
					  JOptionPane.showMessageDialog(null, "No ha rellenado el campo de Contraseña");
					  return false;
					}
					if(String.valueOf(pfReintroducirContraseña.getPassword()).isEmpty()){
						  JOptionPane.showMessageDialog(null, "No ha rellenado el campo de Repetir Contraseña");
						  return false;
						}
					if(!String.valueOf(pfContraseña.getPassword()).equals(String.valueOf(pfReintroducirContraseña.getPassword()))){
						  JOptionPane.showMessageDialog(null, "Los campos de contraseñas no coinciden");
						  return false;
						}
					return true;
				}

				private boolean revisarNombreYApellidos() {
					if(tfNombreYApellidos.getText().isEmpty()) {
					  JOptionPane.showMessageDialog(null, "No ha rellenado el campo de Nombre y Apellidos");
					  return false;
					}
					return true;
				}
			});
		}
		return btAceptar;
	}
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("CANCELAR");
			btCancelar.setBackground(new Color(255, 0, 51));
			btCancelar.setBounds(453, 216, 106, 21);
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return btCancelar;
	}
	private JPasswordField getPfContraseña() {
		if (pfContraseña == null) {
			pfContraseña = new JPasswordField();
			pfContraseña.setBounds(178, 106, 324, 19);
		}
		return pfContraseña;
	}
	private JPasswordField getPfReintroducirContraseña() {
		if (pfReintroducirContraseña == null) {
			pfReintroducirContraseña = new JPasswordField();
			pfReintroducirContraseña.setBounds(178, 138, 324, 19);
		}
		return pfReintroducirContraseña;
	}
}
