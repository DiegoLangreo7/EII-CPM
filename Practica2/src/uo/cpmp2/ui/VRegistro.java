package uo.cpmp2.ui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btSiguiente;
	private JButton btCancelar;
	private JPanel pnCliente;
	private JTextField txNombre;
	private JLabel lbNombre;
	private JLabel lbNacimiento;
	private JLabel lbContrase�a;
	private JLabel lbReintroduzcaContrase�a;
	private JPasswordField txContrase�a;
	private JPasswordField txContrase�aRepetir;
	private JPanel pnPedido;
	private JRadioButton btLocal;
	private JRadioButton btLlevar;
	private JComboBox<String> comboBox;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VRegistro frame = new VRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public VRegistro() {
		setTitle("Datos de registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 310);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtSiguiente());
		contentPane.add(getBtCancelar());
		contentPane.add(getPnCliente());
		contentPane.add(getPnPedido());
	}
	
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("ACEPTAR"); 
			btSiguiente.setBackground(new Color(51, 204, 51));
			btSiguiente.setBounds(227, 238, 104, 21);
			
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) { 
					boolean nombreCond = revisarNombreYApellidos();
					boolean contrase�aCond = revisarContrase�as();
					if(nombreCond == true && contrase�aCond == true) {
						JOptionPane.showMessageDialog(null, "Ha hecho el pedido con exito");
						System.exit(0);
					}
				}

				private boolean revisarContrase�as() {
					if(String.valueOf(txContrase�a.getPassword()).isEmpty()){
					  JOptionPane.showMessageDialog(null, "No ha rellenado el campo de Contrase�a");
					  return false;
					}
					if(String.valueOf(txContrase�aRepetir.getPassword()).isEmpty()){
						  JOptionPane.showMessageDialog(null, "No ha rellenado el campo de Repetir Contrase�a");
						  return false;
						}
					if(!String.valueOf(txContrase�a.getPassword()).equals(String.valueOf(txContrase�aRepetir.getPassword()))){
						  JOptionPane.showMessageDialog(null, "Los campos de contrase�as no coinciden");
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
					System.exit(0);
				}
			});
			btCancelar.setForeground(Color.WHITE);
			btCancelar.setBackground(Color.RED);
			btCancelar.setBounds(341, 237, 89, 23);
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
			pnCliente.add(getLbContrase�a());
			pnCliente.add(getLbReintroduzcaContrase�a());
			pnCliente.add(getTxContrase�a());
			pnCliente.add(getTxContrase�aRepetir());
			pnCliente.add(getComboBox());
		}
		return pnCliente;
	}
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setBounds(168, 21, 260, 20);
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
			lbNacimiento = new JLabel("A\u00F1o de nacimiento");
			lbNacimiento.setBounds(21, 52, 138, 14);
		}
		return lbNacimiento;
	}
	private JLabel getLbContrase�a() {
		if (lbContrase�a == null) {
			lbContrase�a = new JLabel("Contrase\u00F1a");
			lbContrase�a.setBounds(21, 83, 88, 14);
		}
		return lbContrase�a;
	}
	private JLabel getLbReintroduzcaContrase�a() {
		if (lbReintroduzcaContrase�a == null) {
			lbReintroduzcaContrase�a = new JLabel("Reintroduzca contrase\u00F1a");
			lbReintroduzcaContrase�a.setBounds(21, 114, 160, 14);
		}
		return lbReintroduzcaContrase�a;
	}
	private JPasswordField getTxContrase�a() {
		if (txContrase�a == null) {
			txContrase�a = new JPasswordField();
			txContrase�a.setBounds(168, 80, 260, 20);
		}
		return txContrase�a;
	}
	private JPasswordField getTxContrase�aRepetir() {
		if (txContrase�aRepetir == null) {
			txContrase�aRepetir = new JPasswordField();
			txContrase�aRepetir.setBounds(168, 111, 260, 20);
		}
		return txContrase�aRepetir;
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
			String[] listaA�osNacimiento = new String[120];
			for(int i=2004;i>1900;i--) {
				listaA�osNacimiento[2004-i] = ""+i;
			}
			comboBox.setModel(new DefaultComboBoxModel<String>(listaA�osNacimiento));
			comboBox.setBackground(SystemColor.window);
			comboBox.setBounds(168, 52, 123, 22);
		}
		return comboBox;
	}
}
