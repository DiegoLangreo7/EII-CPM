package uo294255.cpm.modulo.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uo294255.cpm.modulo.service.CANOSA;

import java.awt.Toolkit;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class VentanaDescuento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean modo; //true registrar // false buscar
	private CANOSA canosa;
	private int descuento;
	private VentanaPrincipal vp;
	private JPanel panelPedirDNI;
	private JPanel panelDescuentoGuardado;
	private JPanel panelDescuentoBuscado;
	private JButton btnBACKDNI;
	private JLabel lblIntroduceDNI;
	private JCheckBox chckbxEDAD;
	private JLabel lblNewLabel;
	private JTextArea textAreaDNI;
	private JLabel lbl18;
	private JButton btnSiguiente;
	private JLabel lblLogo1;
	private JLabel lblLogo2;
	private JLabel lblLogo3;
	private JLabel lblFelicitaciones;
	private JLabel lblFelicitaciones2;
	private JButton btnIrAReserva;
	private JButton btnSalir;
	private JButton btnJugar;
	private JButton btnProbarOtroDni;
	private JLabel lblNoTieneNingun;
	private JLabel lblPruebeConOtro;
	ResourceBundle textos;


	public VentanaDescuento(CANOSA canosa, VentanaPrincipal ventanaPrincipal,boolean modo, int descuento, Locale localizacion) {
		textos = ResourceBundle.getBundle("rcs/Textos",localizacion);
		this.descuento  = descuento;
		this.modo = modo;
		this.canosa = canosa;
		vp  = ventanaPrincipal;
		vp.setEnabled(false);
		this.setTitle(textos.getString("txt73") + " : " + textos.getString("txt77"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaDescuento.class.getResource("/img/logo.png")));
		setResizable(false);
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPanelPedirDNI(), "panelDNI");
		contentPane.add(getPanelDescuentoGuardado(), "panelDescuentoGuardado");
		contentPane.add(getPanelDescuentoBuscado(), "panelDescuentoBuscado");
		
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                preguntarSalir(); 
            }
        });
	}

	private void setImagenAdaptada(JButton boton, String rutaImagen) {
		Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage();
		Image imgEscalada = imgOriginal.getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(imgEscalada);
		boton.setDisabledIcon(icon);
		boton.setIcon(icon);
	}
	
	private JPanel getPanelPedirDNI() {
		if (panelPedirDNI == null) {
			panelPedirDNI = new JPanel();
			panelPedirDNI.setBackground(SystemColor.window);
			panelPedirDNI.setLayout(null);
			panelPedirDNI.add(getBtnBACKDNI());
			panelPedirDNI.add(getLblIntroduceDNI());
			panelPedirDNI.add(getChckbxEDAD());
			panelPedirDNI.add(getLblNewLabel());
			panelPedirDNI.add(getTextAreaDNI());
			panelPedirDNI.add(getLbl18());
			panelPedirDNI.add(getBtnSiguiente());
			panelPedirDNI.add(getLblLogo1());
		}
		return panelPedirDNI;
	}
	private JPanel getPanelDescuentoGuardado() {
		if (panelDescuentoGuardado == null) {
			panelDescuentoGuardado = new JPanel();
			panelDescuentoGuardado.setBackground(SystemColor.window);
			panelDescuentoGuardado.setLayout(null);
			panelDescuentoGuardado.add(getLblLogo2());
			panelDescuentoGuardado.add(getLblFelicitaciones());
			panelDescuentoGuardado.add(getLblFelicitaciones2());
			panelDescuentoGuardado.add(getBtnIrAReserva());
			panelDescuentoGuardado.add(getBtnSalir());
		}
		return panelDescuentoGuardado;
	}
	private JPanel getPanelDescuentoBuscado() {
		if (panelDescuentoBuscado == null) {
			panelDescuentoBuscado = new JPanel();
			panelDescuentoBuscado.setBackground(SystemColor.window);
			panelDescuentoBuscado.setLayout(null);
			panelDescuentoBuscado.add(getLblLogo3());
			panelDescuentoBuscado.add(getBtnJugar());
			panelDescuentoBuscado.add(getBtnProbarOtroDni());
			panelDescuentoBuscado.add(getLblNoTieneNingun());
			panelDescuentoBuscado.add(getLblPruebeConOtro());
		}
		return panelDescuentoBuscado;
	}
	private JButton getBtnBACKDNI() {
		if (btnBACKDNI == null) {
			btnBACKDNI = new JButton("");
			btnBACKDNI.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					preguntarSalir();
				}
			});
			btnBACKDNI.setBorder(new LineBorder(new Color(0, 0, 0)));
			btnBACKDNI.setBackground(Color.WHITE);
			btnBACKDNI.setBounds(10, 10, 100, 60);
			setImagenAdaptada(btnBACKDNI,"/img/FlechaBack.png");
		}
		return btnBACKDNI;
	}

	protected void preguntarSalir() {
		 int respuesta = JOptionPane.showConfirmDialog(null, textos.getString("txt90"), textos.getString("txt73") + " : " + textos.getString("txt77"), JOptionPane.YES_NO_OPTION);
      	  if (respuesta == JOptionPane.YES_OPTION) {
      		  canosa.iniciarJuego();
      		  vp.setEnabled(true);
      		  this.dispose();
      	  }
	}
	private JLabel getLblIntroduceDNI() {
		if (lblIntroduceDNI == null) {
			lblIntroduceDNI = new JLabel(textos.getString("txt89"));
			lblIntroduceDNI.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblIntroduceDNI.setBounds(134, 10, 201, 84);
		}
		return lblIntroduceDNI;
	}
	private JCheckBox getChckbxEDAD() {
		if (chckbxEDAD == null) {
			chckbxEDAD = new JCheckBox( textos.getString("txt35"));
			chckbxEDAD.setBackground(SystemColor.window);
			chckbxEDAD.setMnemonic('A');
			chckbxEDAD.setBounds(146, 110, 213, 34);
		}
		return chckbxEDAD;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("DNI : ");
			lblNewLabel.setLabelFor(getTextAreaDNI());
			lblNewLabel.setDisplayedMnemonic('D');
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(37, 169, 60, 34);
		}
		return lblNewLabel;
	}
	private JTextArea getTextAreaDNI() {
		if (textAreaDNI == null) {
			textAreaDNI = new JTextArea();
			textAreaDNI.setFont(new Font("Monospaced", Font.BOLD, 17));
			textAreaDNI.setBounds(88, 169, 247, 34);
		}
		return textAreaDNI;
	}
	private JLabel getLbl18() {
		if (lbl18 == null) {
			lbl18 = new JLabel("");
			lbl18.setIcon(new ImageIcon(VentanaDescuento.class.getResource("/img/Menores.png")));
			lbl18.setBounds(101, 110, 45, 34);
		}
		return lbl18;
	}
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("");
			btnSiguiente.setBorder(new LineBorder(new Color(0, 0, 0)));
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comprobarDNI();
				}
			});
			btnSiguiente.setBounds(356, 168, 60, 35);
			setImagenAdaptada(btnSiguiente,"/img/Siguiente.png");
		}
		return btnSiguiente;
	}

	protected void comprobarDNI() {
		if(!getTextAreaDNI().getText().isEmpty() && getChckbxEDAD().isSelected()) {
			siguientePestaña();
		}
		else {
			 JOptionPane.showMessageDialog(null, textos.getString("txt83"), textos.getString("txt73") + " : " + textos.getString("txt80"), JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private void siguientePestaña() {
		if(modo) {
			registro();
		}
		else {
			busqueda();
		}
	}

	private void busqueda() {
		if(canosa.buscarDescuento(getTextAreaDNI().getText())!=0) {
	        JOptionPane.showMessageDialog(null, textos.getString("txt86") + " " + canosa.buscarDescuento(getTextAreaDNI().getText())+ "%",  textos.getString("txt73") + " : " + textos.getString("txt77"), JOptionPane.INFORMATION_MESSAGE);
	        vp.aplicarDescuento(canosa.buscarDescuento(getTextAreaDNI().getText()));
	        canosa.borrarDescuento(getTextAreaDNI().getText());
	        vp.setEnabled(true);
			this.dispose();
		}
		else {
			((CardLayout)getContentPane().getLayout()).show(getContentPane(),"panelDescuentoBuscado");
		}
		
	}

	private void registro() {
		if(canosa.buscarDescuento(getTextAreaDNI().getText())!=0) {
			 JOptionPane.showMessageDialog(null, textos.getString("txt84"), textos.getString("txt73") + " : " + textos.getString("txt80"), JOptionPane.WARNING_MESSAGE);
		}
		else {
			canosa.registrarDescuento(getTextAreaDNI().getText(),this.descuento);
			((CardLayout)getContentPane().getLayout()).show(getContentPane(),"panelDescuentoGuardado");
		}
	}
	private JLabel getLblLogo1() {
		if (lblLogo1 == null) {
			lblLogo1 = new JLabel("CANOSA");
			lblLogo1.setIcon(new ImageIcon(VentanaDescuento.class.getResource("/img/logoCC.png")));
			lblLogo1.setBounds(350, 217, 76, 36);
		}
		return lblLogo1;
	}
	private JLabel getLblLogo2() {
		if (lblLogo2 == null) {
			lblLogo2 = new JLabel("CANOSA");
			lblLogo2.setIcon(new ImageIcon(VentanaDescuento.class.getResource("/img/logoCC.png")));
			lblLogo2.setBounds(350, 217, 76, 36);
		}
		return lblLogo2;
	}
	private JLabel getLblLogo3() {
		if (lblLogo3 == null) {
			lblLogo3 = new JLabel("CANOSA");
			lblLogo3.setIcon(new ImageIcon(VentanaDescuento.class.getResource("/img/logoCC.png")));
			lblLogo3.setBounds(350, 217, 76, 36);
		}
		return lblLogo3;
	}
	private JLabel getLblFelicitaciones() {
		if (lblFelicitaciones == null) {
			lblFelicitaciones = new JLabel(textos.getString("txt85"));
			lblFelicitaciones.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblFelicitaciones.setBounds(27, 31, 389, 105);
		}
		return lblFelicitaciones;
	}
	private JLabel getLblFelicitaciones2() {
		if (lblFelicitaciones2 == null) {
			lblFelicitaciones2 = new JLabel(textos.getString("txt86"));
			lblFelicitaciones2.setBounds(82, 127, 334, 29);
		}
		return lblFelicitaciones2;
	}
	private JButton getBtnIrAReserva() {
		if (btnIrAReserva == null) {
			btnIrAReserva = new JButton(textos.getString("txt87"));
			btnIrAReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cerraryreservar();
				}
			});
			btnIrAReserva.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnIrAReserva.setBounds(59, 166, 142, 55);
		}
		return btnIrAReserva;
	}
	
	protected void cerraryreservar() {
		vp.setEnabled(true);
		vp.mostrarCatalogo();
		this.dispose();
	}
	
	protected void cerrarysalir() {
		vp.setEnabled(true);
		vp.mostrarPortada();
		this.dispose();
	}

	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("SALIR");
			btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cerrarysalir();
				}
			});
			btnSalir.setBounds(242, 166, 142, 55);
		}
		return btnSalir;
	}
	private JButton getBtnJugar() {
		if (btnJugar == null) {
			btnJugar = new JButton(textos.getString("txt94"));
			btnJugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugarParaConseguirDescuento();
				}
			});
			btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnJugar.setBounds(42, 163, 142, 55);
		}
		return btnJugar;
	}
	protected void jugarParaConseguirDescuento() {
		vp.mostrarCaratula();
		vp.setEnabled(true);
		this.dispose();
	}
	
	private JButton getBtnProbarOtroDni() {
		if (btnProbarOtroDni == null) {
			btnProbarOtroDni = new JButton(textos.getString("txt93"));
			btnProbarOtroDni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPedirDNI();
				}
			});
			btnProbarOtroDni.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnProbarOtroDni.setBounds(225, 163, 142, 55);
		}
		return btnProbarOtroDni;
	}
	protected void mostrarPedirDNI() {
		((CardLayout)getContentPane().getLayout()).show(getContentPane(),"panelDNI");
	}

	private JLabel getLblNoTieneNingun() {
		if (lblNoTieneNingun == null) {
			lblNoTieneNingun = new JLabel(textos.getString("txt91"));
			lblNoTieneNingun.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNoTieneNingun.setBounds(10, 28, 406, 105);
		}
		return lblNoTieneNingun;
	}
	private JLabel getLblPruebeConOtro() {
		if (lblPruebeConOtro == null) {
			lblPruebeConOtro = new JLabel(textos.getString("txt92"));
			lblPruebeConOtro.setBounds(53, 124, 363, 29);
		}
		return lblPruebeConOtro;
	}
}
