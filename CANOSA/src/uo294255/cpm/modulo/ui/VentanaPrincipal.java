package uo294255.cpm.modulo.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultStyledDocument;

import uo294255.cpm.modulo.game.Dado;
import uo294255.cpm.modulo.model.Castillo;
import uo294255.cpm.modulo.service.CANOSA;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;

import javax.help.*;
import java.net.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.io.*;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private CANOSA canosa;
	
	private JPanel contentPane;
	private JPanel panelPortada;
	private JPanel panelTitulo;
	private JPanel panelContenidos;
	private JLabel lblSelectLanguage;
	private JButton btnEspañol;
	private JButton btnIngles;
	private JButton btnNEXTpanelIdioma;
	private JLabel lblTitulo;
	private JButton btnReservaYA;
	private JButton btnJuegaYGana;
	private JButton btnBACKtitulo;
	private JPanel panelCaratula;
	private JPanel panelOfertaJuego;
	private JPanel panelStart;
	private JButton btnStart;
	private JPanel panelJuego;
	private JLabel lblTV;
	private JTextArea txtrJuegaAlJuego;
	private JPanel panelEscenarioJuego;
	private JPanel panelCatalogo;
	private JButton btnBACKcatalogo;
	private JButton btnImgTitulo;
	private JLabel lblPropaganda1;
	private JLabel lblPropaganda2;
	private JScrollPane scrollPaneCatalogo;
	private JPanel panelScrollCatalogo;
	private JPanel panelAjustesCatalogo;
	private JPanel panelAjustesParteFiltrosCatalogo;
	private JPanel panelFiltros;
	private JCheckBox chckbxFiltroAP;
	private JCheckBox chckbxFiltroDE;
	private JCheckBox chckbxFiltroEN;
	private JCheckBox chckbxFiltroOB;
	private JCheckBox chckbxFiltroOL;
	private JCheckBox chckbxFiltroRU;
	private JPanel panelAjustesParteprecioCatalogo;
	private JTextField textField;
	private JLabel lblPrecio;
	private JSlider sliderPrecio;
	private JButton btnEliminarFiltros;
	private JPanel panelInfoCastillo;
	private Castillo castillo;
	private JButton btnBACKinfoCastillo;
	private JButton btnFotoInfo;
	private JPanel panelCabeceraInfo;
	private JPanel panelInfo;
	private JLabel lblNombreCastillo;
	private JLabel lblPaisCastillo;
	private JLabel lblDescripcionCastillo;
	private JScrollPane scrollPaneDescripcion;
	private JTextArea textAreaDescripcion;
	private JLabel lblLogo;
	private JLabel lblLogo2;
	private JLabel lblLogo3;
	private JLabel lblLogo4;
	private JButton btnLogo5;
	private JLabel lblPrecioHabitacionCastillo;
	private JButton btnCalendario;
	private JLabel lblNPersonas;
	private JLabel lblNHabitaciones;
	private JSpinner spinnerNPersonas;
	private JSpinner spinnerNHabitaciones;
	private JButton btnReservar;
	private JLabel lblPrecioTotal;
	private JTextField textFieldPrecioTotal;
	private JPanel panelRegistro;
	private JPanel panelDatosRegistro;
	private JCheckBox chckbxMayorDeEdad;
	private JLabel lblLogo5;
	private JButton btnBACKcaratula;
	private JButton btnBACKRegistro;
	private JLabel lblNombreUsuario;
	private JTextField textFieldNombreYApellidos;
	private JLabel lblCorreo;
	private JLabel lblDni;
	private JTextField textFieldCorreo;
	private JTextField textFieldDNI;
	private JLabel lblComentarios;
	private JScrollPane scrollPaneComentarios;
	private JTextArea textAreaComentarios;
	private JPanel panelDatosEditables;
	private JLabel lblPrecioFinalReserva;
	private JTextField textFieldPrecioFinal;
	private JLabel lblRecuentoPersonas;
	private JTextField textRecuentoPersonas;
	private JLabel lblRecuentoHabitaciones;
	private JTextField textRecuentoHabitaciones;
	private JLabel lblRecuentoDias;
	private JTextField textDias;
	private JLabel lblRecuentoFecha;
	private JTextField textFecha;
	private JButton btnConfirmarReserva;
	private JButton btnApagar;
	private JButton btnDado;
	private JTextField textDado;
	private JLabel lbl18;
	private JLabel lblDescuentoAnuncio;
	private JMenuBar menuBar;
	private JMenu mnApp;
	private JMenuItem mntmSalir;
	private JSeparator separator;
	private JMenuItem mntmReservarCastilloDirecto;
	private JMenuItem mntmJuegaDirecto;
	private JMenuItem mntmReiniciar;
	private JButton btnNormas;
	private JMenu mnHelp;
	private JMenuItem mntmContenidos;
	private JSeparator separator_1;
	private JMenuItem mntmAcercaDe;
	@SuppressWarnings("deprecation")
	Locale localizacion = new Locale("es_ES");
	ResourceBundle textos;
	private String idioma  ="ES";
	private JMenu mnIdioma;
	private JMenuItem mntmEspanol;
	private JMenuItem mntmNewMenuItem_1;

	public VentanaPrincipal(CANOSA sA) {
		setResizable(false);
		this.canosa = sA;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.png")));
		setTitle("CANOSA España");
		setBounds(100, 100, 823, 578);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelContenidos(), BorderLayout.CENTER);
		contentPane.add(getMenuBar_1(), BorderLayout.NORTH);
		eliminarFiltros();
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarVentana(); 
            }
        });
		this.setSize(new Dimension(823, 578));
		this.setMinimumSize(new Dimension(823, 578));
		cargarAyuda();
		localizar(this.localizacion,"ES");
	}	
	
	private void localizar(Locale localizacion, String idioma) {
		canosa.setIdioma(idioma);
		this.idioma = idioma;
		this.generaCatalogo();
		this.localizacion = localizacion;
		textos = ResourceBundle.getBundle("rcs/Textos",localizacion);
		//
		getMnApp().setText(textos.getString("txt102"));
		getMnIdioma().setText(textos.getString("txt101"));
		getMnHelp().setText(textos.getString("txt103"));
		if(idioma.equals("ES")) {
			getMnIdioma().setMnemonic('I');
			getMnHelp().setMnemonic('y');
		}
		else {
			getMnIdioma().setMnemonic('L');
			getMnHelp().setMnemonic('H');
		}
		//
		getLblSelectLanguage().setText(textos.getString("txt1"));
		getBtnNEXTpanelIdioma().setToolTipText(textos.getString("txt2"));
		//
		getLblTitulo().setText(textos.getString("txt3"));
		getBtnBACKtitulo().setToolTipText(textos.getString("txt4"));
		getBtnReservaYA().setText(textos.getString("txt5"));
		getBtnReservaYA().setToolTipText(textos.getString("txt6"));
		getBtnJuegaYGana().setText(textos.getString("txt7"));
		getBtnJuegaYGana().setToolTipText(textos.getString("txt8"));
		//
		getBtnBACKcatalogo().setToolTipText(textos.getString("txt9"));
		getBtnEliminarFiltros().setToolTipText(textos.getString("txt10"));
		getLblPrecio().setText(textos.getString("txt11"));
		getSliderPrecio().setToolTipText(textos.getString("txt12"));
		getPanelFiltros().setBorder(new TitledBorder(null,textos.getString("txt13"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//
		getBotonInfoCastillo().setToolTipText(textos.getString("txt14"));
		getLblNombreCastillo().setText(textos.getString("txt15"));
		getLblPaisCastillo().setText(textos.getString("txt16"));
		getLblDescripcionCastillo().setText(textos.getString("txt17"));
		getLblPrecioHabitacionCastillo().setText(textos.getString("txt18"));
		getLblNPersonas().setText(textos.getString("txt19"));
		getLblNHabitaciones().setText(textos.getString("txt20"));
		getLblPrecioTotal().setText(textos.getString("txt21"));
		getBtnReservar().setText(textos.getString("txt22"));
		getBtnReservar().setToolTipText(textos.getString("txt23"));
		getBtnCalendario().setToolTipText(textos.getString("txt24"));
		//
		getBtnBACKRegistro().setToolTipText(textos.getString("txt25"));
		getLblNombreUsuario().setText(textos.getString("txt26"));
		getLblCorreo().setText(textos.getString("txt27"));
		getLblDni().setText(textos.getString("txt28"));
		getLblComentarios().setText(textos.getString("txt29"));
		getLblRecuentoPersonas().setText(textos.getString("txt30"));
		getLblRecuentoHabitaciones().setText(textos.getString("txt31"));
		getLblRecuentoDias().setText(textos.getString("txt32"));
		getLblRecuentoFecha().setText(textos.getString("txt33"));
		getLblPrecioFinalReserva().setText(textos.getString("txt34"));
		getChckbxMayorDeEdad().setText(textos.getString("txt35"));
		getBtnConfirmarReserva().setText(textos.getString("txt36"));
		getBtnConfirmarReserva().setToolTipText(textos.getString("txt37"));
		//
		getBtnBACKcaratula().setText(textos.getString("txt38"));
		getLblPropaganda1().setText(textos.getString("txt39"));
		getLblPropaganda2().setText(textos.getString("txt40"));
		getTxtrJuegaAlJuego().setText(textos.getString("txt42"));
		getBtnStart().setText(textos.getString("txt43"));
		getBtnStart().setToolTipText(textos.getString("txt44"));
		getBtnNormas().setText(textos.getString("txt45"));
		getBtnNormas().setToolTipText(textos.getString("txt46"));
		//
		getBtnApagar().setToolTipText(textos.getString("txt47"));
		getBtnDado().setToolTipText(textos.getString("txt48"));
		//
		getMntmReservarCastilloDirecto().setText(textos.getString("txt49"));
		getMntmJuegaDirecto().setText(textos.getString("txt50"));
		getMntmReiniciar().setText(textos.getString("txt51"));
		getMntmSalir().setText(textos.getString("txt52"));
		getMntmContenidos().setText(textos.getString("txt53"));
		getMntmAcercaDe().setText(textos.getString("txt54"));
		//
		generaCatalogo();
		//
		getChckbxFiltroAP().setText(textos.getString("txt104"));
		getChckbxFiltroDE().setText(textos.getString("txt105"));
		getChckbxFiltroEN().setText(textos.getString("txt106"));
		getChckbxFiltroOB().setText(textos.getString("txt107"));
		getChckbxFiltroOL().setText(textos.getString("txt108"));
		getChckbxFiltroRU().setText(textos.getString("txt109"));
		//
		this.setTitle(textos.getString("txt73"));
	}

	protected void cerrarVentana() {
		int respuesta = JOptionPane.showConfirmDialog(null, textos.getString("txt59"), "CANOSA", JOptionPane.YES_NO_OPTION);
      	  if (respuesta == JOptionPane.YES_OPTION) {
    		this.dispose();
      	  }
	}
	
	private void cargarAyuda(){

		   URL hsURL;
		   HelpSet hs;

		    try {
			    	File fichero = new File("help/Ayuda.hs");
			    	hsURL = fichero.toURI().toURL();
			        hs = new HelpSet(null, hsURL);
			      }

		    catch (Exception e){
		      System.out.println("Ayuda no encontrada");
		      return;
		   }

		   HelpBroker hb = hs.createHelpBroker();
		   hb.initPresentation();
		   hb.enableHelpKey(getRootPane(),"introduccion", hs);
		   hb.enableHelpOnButton(getMntmContenidos(), "introduccion", hs);
		   hb.enableHelp(getBtnReservaYA(), "reservar", hs);
		   hb.enableHelp(getBtnJuegaYGana(), "descuentos", hs);
		   hb.enableHelp(getBtnNormas(), "jugar", hs);
		 }
	
	private JPanel getPanelContenidos() {
		if (panelContenidos == null) {
			panelContenidos = new JPanel();
			panelContenidos.setBackground(SystemColor.textHighlight);
			panelContenidos.setLayout(new CardLayout(0, 0));
			panelContenidos.add(getPanelPortada(), "panelPortada");
			panelContenidos.add(getPanelTitulo(), "panelTitulo");
			panelContenidos.add(getPanelCaratula(), "panelCaratula");
			panelContenidos.add(getPanelJuego(), "panelJuego");
			panelContenidos.add(getPanelCatalogo(), "panelCatalogo");
			panelContenidos.add(getPanelInfoCastillo(), "panelInfoCastillo");
			panelContenidos.add(getPanelRegistro(), "panelRegistro");
		}
		return panelContenidos;
	}
	
	private JPanel getPanelPortada() {
		if (panelPortada == null) {
			panelPortada = new JPanel();
			panelPortada.setBackground(SystemColor.window);
			panelPortada.setLayout(null);
			panelPortada.add(getLblSelectLanguage());
			panelPortada.add(getBtnEspañol());
			panelPortada.add(getBtnIngles());
			panelPortada.add(getBtnNEXTpanelIdioma());
			panelPortada.add(getLblLogo());
		}
		return panelPortada;
	}
	
	private JPanel getPanelTitulo() {
		if (panelTitulo == null) {
			panelTitulo = new JPanel();
			panelTitulo.setBackground(SystemColor.window);
			panelTitulo.setLayout(null);
			panelTitulo.add(getLblTitulo());
			panelTitulo.add(getBtnReservaYA());
			panelTitulo.add(getBtnJuegaYGana());
			panelTitulo.add(getBtnBACKtitulo());
			panelTitulo.add(getBtnImgTitulo());
			panelTitulo.add(getLblLogo2());
			panelTitulo.add(getLblLogo3());
		}
		return panelTitulo;
	}
	
	private JLabel getLblSelectLanguage() {
		if (lblSelectLanguage == null) {
			lblSelectLanguage = new JLabel("Selecciona Tu Idioma");
			lblSelectLanguage.setFont(new Font("Tahoma", Font.PLAIN, 46));
			lblSelectLanguage.setBounds(187, 95, 454, 103);
		}
		return lblSelectLanguage;
	}
	private JButton getBtnEspañol() {
		if (btnEspañol == null) {
			btnEspañol = new JButton("");
			btnEspañol.setToolTipText("Selecciona como idioma en la aplicacion el Español");
			btnEspañol.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					toEspañol();
				}
			});
			btnEspañol.setBackground(SystemColor.window);
			btnEspañol.setBounds(166, 208, 228, 156);
			setImagenAdaptada(btnEspañol,"/img/espanol.png");
		}
		return btnEspañol;
	}
	private JButton getBtnIngles() {
		if (btnIngles == null) {
			btnIngles = new JButton("");
			btnIngles.setToolTipText("Selecciona como idioma en la aplicacion el Inglés");
			btnIngles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					toIngles();
				}
			});
			btnIngles.setBackground(SystemColor.window);
			btnIngles.setBounds(426, 208, 228, 156);
			setImagenAdaptada(btnIngles,"/img/inglesNO.png");
		}
		return btnIngles;
	}
	private JButton getBtnNEXTpanelIdioma() {
		if (btnNEXTpanelIdioma == null) {
			btnNEXTpanelIdioma = new JButton("");
			btnNEXTpanelIdioma.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnNEXTpanelIdioma.setToolTipText("Siguiente pagina");
			btnNEXTpanelIdioma.setFont(new Font("Tahoma", Font.BOLD, 33));
			btnNEXTpanelIdioma.setBackground(SystemColor.window);
			btnNEXTpanelIdioma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarTitulo();
				}
			});
			btnNEXTpanelIdioma.setBounds(649, 401, 133, 63);
			setImagenAdaptada(btnNEXTpanelIdioma, "/img/Siguiente.png");
		}
		return btnNEXTpanelIdioma;
	}
	
	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel(" Castillos Encantados");
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setForeground(SystemColor.textHighlightText);
			lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 45));
			lblTitulo.setBounds(170, 118, 490, 136);
		}
		return lblTitulo;
	}
	private JButton getBtnReservaYA() {
		if (btnReservaYA == null) {
			btnReservaYA = new JButton("Reserva Tu castillo");
			btnReservaYA.setToolTipText("Inicia directamente el proceso de reserva");
			btnReservaYA.setBorder(UIManager.getBorder("DesktopIcon.border"));
			btnReservaYA.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnReservaYA.setBackground(SystemColor.window);
			btnReservaYA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarCatalogo();
				}
			});
			btnReservaYA.setBounds(91, 278, 257, 108);
		}
		return btnReservaYA;
	}
	private JButton getBtnJuegaYGana() {
		if (btnJuegaYGana == null) {
			btnJuegaYGana = new JButton("Juega y gana DESCUENTOS");
			btnJuegaYGana.setToolTipText("Juega para optar a decuentos ");
			btnJuegaYGana.setBorder(UIManager.getBorder("DesktopIcon.border"));
			btnJuegaYGana.setBackground(SystemColor.window);
			btnJuegaYGana.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnJuegaYGana.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarCaratula();
				}
			});
			btnJuegaYGana.setBounds(462, 278, 257, 108);
		}
		return btnJuegaYGana;
	}
	private JButton getBtnBACKtitulo() {
		if (btnBACKtitulo == null) {
			btnBACKtitulo = new JButton("");
			btnBACKtitulo.setToolTipText("Vuelve a la seleccion de idioma");
			btnBACKtitulo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnBACKtitulo.setBackground(SystemColor.window);
			btnBACKtitulo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPortada();
				}
			});
			btnBACKtitulo.setBounds(26, 20, 139, 90);
			setImagenAdaptada(btnBACKtitulo, "/img/FlechaBack.png");
		}
		return btnBACKtitulo;
	}
	
	private void setImagenAdaptada(JButton boton, String rutaImagen) {
		Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage();
		Image imgEscalada = imgOriginal.getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(imgEscalada);
		boton.setDisabledIcon(icon);
		boton.setIcon(icon);
	}
	
	protected void mostrarPortada() {
		((CardLayout)getPanelContenidos().getLayout()).show(getPanelContenidos(),"panelPortada");
		this.setTitle(textos.getString("txt73"));
	}
	
	protected void mostrarTitulo() {
		((CardLayout)getPanelContenidos().getLayout()).show(getPanelContenidos(),"panelTitulo");
		this.setTitle(textos.getString("txt73") + " : "+ textos.getString("txt74"));
		this.setBounds(100, 100, 823, 539);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		getLblDescuentoAnuncio().setVisible(false);
	}
	
	protected void mostrarCaratula() {
		((CardLayout)getPanelContenidos().getLayout()).show(getPanelContenidos(),"panelCaratula");
		this.setTitle(textos.getString("txt73")+ " : "+textos.getString("txt75"));
	}
	
	protected void mostrarJuego() {
		((CardLayout)getPanelContenidos().getLayout()).show(getPanelContenidos(),"panelJuego");
		this.setTitle(textos.getString("txt73")+ " : "+textos.getString("txt75"));
		getBtnDado().setEnabled(true);
		getTextDado().setText("");
	}
	
	protected void mostrarCatalogo() {
		((CardLayout)getPanelContenidos().getLayout()).show(getPanelContenidos(),"panelCatalogo");
		this.setTitle(textos.getString("txt73")+ " : "+textos.getString("txt76"));
		this.setResizable(true);
		this.setMinimumSize(new Dimension(823, 578));
	}
	
	protected void mostrarInfoCastillo(Castillo castillo) {
		this.setBounds(100, 100, 823, 539);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.castillo = castillo;
		canosa.registrarCastillo(castillo);
		((CardLayout)getPanelContenidos().getLayout()).show(getPanelContenidos(),"panelInfoCastillo");
		this.setTitle(textos.getString("txt73")+ " : "+textos.getString("txt76") + " : " + castillo.getDenominacion());
		setImagenAdaptada(getBtnFotoInfo(),"/img/"+castillo.getCodigo()+".png");
		getPanelCabeceraInfo().revalidate();
		getPanelCabeceraInfo().repaint();
		getLblNombreCastillo().setText(textos.getString("txt15") + castillo.getDenominacion());
		getLblPaisCastillo().setText(textos.getString("txt16") + castillo.getPais());
		String descripcion = recortarString(castillo.getDescripcion(),300);
		getTextAreaDescripcion().setText(descripcion);
		getTextAreaDescripcion().append("\n\n" + textos.getString("txt41")  + "\n");
		if(this.idioma.equals("ES")) {getTextAreaDescripcion().append(castillo.toStringEncantamientosES());}
		if(this.idioma.equals("EN")) {getTextAreaDescripcion().append(castillo.toStringEncantamientosEN());}
		getLblPrecioHabitacionCastillo().setText(textos.getString("txt18") + castillo.getPrecio() + "€");
		getTextFieldPrecioTotal().setText(canosa.calcularPrecioFinal()+"€");
		}
	
	protected void mostrarRegistro() {
		int respuesta = JOptionPane.showConfirmDialog(null, textos.getString("txt60"),
				textos.getString("txt73")+ " : "+textos.getString("txt76") + " : " + castillo.getDenominacion() + " : " + textos.getString("txt77"),JOptionPane.YES_NO_OPTION);
		if (respuesta == JOptionPane.YES_OPTION) {
			try {
    			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    			VentanaDescuento frame = new VentanaDescuento(canosa,this,false,0,this.localizacion);
    			frame.setVisible(true);
    		} catch(Exception e) {}
		}
		canosa.registrarHabitaciones((int)getSpinnerNPersonas().getValue() ,(int)getSpinnerNHabitaciones().getValue());
		((CardLayout)getPanelContenidos().getLayout()).show(getPanelContenidos(),"panelRegistro");
		this.setTitle(textos.getString("txt73")+ " : "+textos.getString("txt76") + " : " + castillo.getDenominacion() + " : " + textos.getString("txt78"));
		getTextFieldPrecioFinal().setText(canosa.calcularPrecioFinal()+"€");
		getTextRecuentoHabitaciones().setText((int)getSpinnerNHabitaciones().getValue()+"");
		getTextRecuentoPersonas().setText((int)getSpinnerNPersonas().getValue()+"");
		getTextDias().setText(canosa.getDias()+"");
		getTextFecha().setText(canosa.getFecha());
	}
	
	private void resetearInfo() {
		canosa.resetReserva();
		getSpinnerNHabitaciones().setValue(1);
		getSpinnerNPersonas().setValue(1);
		getTextFieldNombreYApellidos().setText("");
		getTextFieldCorreo().setText("");
		getTextFieldDNI().setText("");
	}
	
	private void preguntarFecha() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			VentanaFechaReserva frame = new VentanaFechaReserva(canosa,this,this.localizacion);
			frame.setVisible(true);
		} catch(Exception e) {}
	}
	
	void revisarValido() {
		if(canosa.calcularPrecioFinal()>0) {
			getBtnReservar().setEnabled(true);
		}
		else {
			getBtnReservar().setEnabled(false);
		}
	}
	
	private void procesarReserva() {
		boolean NyA = revisarNombreYApellidos();
		boolean Email = revisarEmail();
		boolean ID = revisarID();
		if(NyA && Email && ID){
			int respuesta = JOptionPane.showConfirmDialog(null, textos.getString("txt61")
					+ textos.getString("txt62")
					+ textos.getString("txt63") + getTextFieldNombreYApellidos().getText()+ "\n"
					+ textos.getString("txt64") + getTextFieldCorreo().getText() + "\n"
					+ textos.getString("txt65")+ getTextFieldDNI().getText() + "\n"
					+ textos.getString("txt30") + getTextRecuentoPersonas().getText() + " - " + textos.getString("txt31") + getTextRecuentoHabitaciones().getText() + "\n"
					+ textos.getString("txt32") + getTextFecha().getText() + " - " +  textos.getString("txt33") + getTextDias().getText() ,
					textos.getString("txt73")+ " : "+textos.getString("txt76") + " : " + castillo.getDenominacion() + " : " + textos.getString("txt79"),JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_OPTION) {
				canosa.registrarDatosUsuario(getTextFieldNombreYApellidos().getText(),getTextFieldCorreo().getText(),
						getTextFieldDNI().getText(),getTextAreaComentarios().getText());
				canosa.confirmarReserva();
				eliminarFiltros();
				limpiarRegistro();
				getLblDescuentoAnuncio().setVisible(false);
				JOptionPane.showMessageDialog(null, textos.getString("txt66"));
				mostrarPortada();
			}
		}
		else {
			 JOptionPane.showMessageDialog(null, textos.getString("txt67") , textos.getString("txt73") + " : " + textos.getString("txt80"), JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	private void limpiarRegistro() {
		getTextAreaComentarios().setText("");
		getTextFieldCorreo().setText("");
		getTextFieldDNI().setText("");
		getTextFieldNombreYApellidos().setText("");

	}

	private boolean revisarNombreYApellidos() {
		return !getTextFieldNombreYApellidos().getText().isEmpty();
	}
	
	private boolean revisarEmail() {
		return (getTextFieldCorreo().getText().contains("@") && !getTextFieldCorreo().getText().isEmpty());
	}
	
	private boolean revisarID() {
		return !getTextFieldDNI().getText().isEmpty();
	}
	
	private String recortarString(String descripcion, int anchoMax) {
		 FontMetrics fontMetrics = new JLabel().getFontMetrics(UIManager.getFont("Label.font"));

	        int ancho = 0;
	        StringBuilder result = new StringBuilder();

	        for (char c : descripcion.toCharArray()) {
	            ancho += fontMetrics.charWidth(c);

	            if (ancho > anchoMax) {
	                result.append("\n");
	                ancho = 0;
	            }

	            result.append(c);
	        }

	        return result.toString();
	}

	@SuppressWarnings("deprecation") //Locale y sus cosas.
	protected void toEspañol() {
		setImagenAdaptada(btnIngles, "/img/inglesNO.png");
		setImagenAdaptada(btnEspañol, "/img/espanol.png");
		localizar(new Locale("es"),"ES");
	}
	
	@SuppressWarnings("deprecation")
	protected void toIngles() {
		setImagenAdaptada(btnIngles, "/img/ingles.png");
		setImagenAdaptada(btnEspañol, "/img/espanolNO.png");
		localizar(new Locale("en"),"EN");

	}
	
	protected void iniciarJuego() {
		canosa.iniciarJuego();
		generaTablero();
	}

	private void generaTablero() {
		getPanelEscenarioJuego().removeAll();
		getPanelEscenarioJuego().repaint();
		for (int y = 0; y < canosa.getGameY(); y++) {
			for (int x = 0; x < canosa.getGameX(); x++) {
				JButton casilla = creaBotonTablero(x,y);
				getPanelEscenarioJuego().add(casilla);
				if(!(canosa.getImagenCasilla(x,y)=="")) {
					setImagenAdaptada(casilla, canosa.getImagenCasilla(x,y));
				}
			}
		}
	}
	
	private JButton creaBotonTablero(int x, int y) {
		JButton button = new JButton();
		button.setBounds(EXIT_ON_CLOSE, ABORT, 70, 70);
		button.setBackground(Color.WHITE);
		button.setEnabled(false);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ejecutarCasilla(x,y);
			}
		});
		return button;
	}

	protected void ejecutarCasilla(int x, int y) {
		if(canosa.mover(x,y)) {
			generaTablero();
			for (int i = 0; i < getPanelEscenarioJuego().getComponents().length; i++) {
				JButton boton = (JButton) (getPanelEscenarioJuego().getComponents()[i]);
				boton.setEnabled(false);
			}
			getBtnDado().setEnabled(true);
			getTextDado().setText("");
			if(canosa.revisarFinalizar()) {
				finalizarJuego();
			}
		}
		else {
	        JOptionPane.showMessageDialog(null, textos.getString("txt68"), textos.getString("txt73") + " : " + textos.getString("txt75")+ " : " + textos.getString("txt80"), JOptionPane.WARNING_MESSAGE);
		}
	}

	private void finalizarJuego() {
		int descuento = canosa.revisarDescuento();
		if(descuento==0) {
			 int respuesta = JOptionPane.showConfirmDialog(null, textos.getString("txt69"), 
					 textos.getString("txt73") + " : "+ textos.getString("txt75")+ " : "+ textos.getString("txt81"), JOptionPane.YES_NO_OPTION);
       	  if (respuesta == JOptionPane.YES_OPTION) {
       		  canosa.iniciarJuego();
       		  generaTablero();
       	  }
       	  else {
       		  mostrarTitulo();
       	  }
		}
		else {
        int respuesta = JOptionPane.showConfirmDialog(null,textos.getString("txt70")  + " "+ descuento
        		+textos.getString("txt71"), textos.getString("txt73") + " : "+ textos.getString("txt75")+ " : "+ textos.getString("txt81"), JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
        	try {
    			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    			VentanaDescuento frame = new VentanaDescuento(canosa,this,true,descuento,this.localizacion);
    			frame.setVisible(true);
    			mostrarCaratula();
    		} catch(Exception e) {}
        }
        else {
        	 respuesta = JOptionPane.showConfirmDialog(null, textos.getString("txt72") , textos.getString("txt73") + " : "+ textos.getString("txt75")+ " : "+ textos.getString("txt81"), JOptionPane.YES_NO_OPTION);
        	  if (respuesta == JOptionPane.YES_OPTION) {
        		  canosa.iniciarJuego();
        		  generaTablero();
        	  }
        	  else {
        		  mostrarTitulo();
        	  }
        }
		}
	}

	protected void setFiltro(JCheckBox cB,String filtro) {
		if(cB.isSelected()) {
			aplicarFiltro(filtro);
			
		}
		else {
			quitarFiltro(filtro);
		}
		((CardLayout)getPanelContenidos().getLayout()).show(getPanelContenidos(),"panelCatalogo");
	}
	
	protected void aplicarFiltro(String filtro){
		canosa.aplicarFiltro(filtro);
		generaCatalogo();
	}
	
	protected void quitarFiltro(String string){
		canosa.quitarFiltro(string,getSliderPrecio().getValue());
		generaCatalogo();
	}
	
	private JPanel getPanelCaratula() {
		if (panelCaratula == null) {
			panelCaratula = new JPanel();
			panelCaratula.setBackground(SystemColor.window);
			panelCaratula.setLayout(null);
			panelCaratula.add(getPanelOfertaJuego());
			panelCaratula.add(getPanelStart());
		}
		return panelCaratula;
	}
	private JPanel getPanelOfertaJuego() {
		if (panelOfertaJuego == null) {
			panelOfertaJuego = new JPanel();
			panelOfertaJuego.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelOfertaJuego.setBounds(0, 0, 809, 148);
			panelOfertaJuego.setBackground(SystemColor.activeCaption);
			panelOfertaJuego.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			panelOfertaJuego.setLayout(null);
			panelOfertaJuego.add(getLblPropaganda1());
			panelOfertaJuego.add(getLblPropaganda2());
			panelOfertaJuego.add(getBtnBACKcaratula());
		}
		return panelOfertaJuego;
	}
	private JPanel getPanelStart() {
		if (panelStart == null) {
			panelStart = new JPanel();
			panelStart.setBounds(0, 147, 809, 372);
			panelStart.setBackground(SystemColor.window);
			panelStart.setLayout(null);
			panelStart.add(getBtnNormas());
			panelStart.add(getBtnStart());
			panelStart.add(getTxtrJuegaAlJuego());
			panelStart.add(getLblLogo4());
		}
		return panelStart;
	}
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("JUEGA");
			btnStart.setToolTipText("Juega ya");
			btnStart.setMnemonic('J');
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarJuego();
					iniciarJuego();
				}
			});
			btnStart.setBackground(SystemColor.window);
			btnStart.setFont(new Font("Tahoma", Font.PLAIN, 28));
			btnStart.setBounds(168, 286, 233, 58);
		}
		return btnStart;
	}
	private JPanel getPanelJuego() {
		if (panelJuego == null) {
			panelJuego = new JPanel();
			panelJuego.setBackground(new Color(0, 0, 0));
			panelJuego.setLayout(null);
			panelJuego.add(getTextDado());
			panelJuego.add(getBtnDado());
			panelJuego.add(getBtnApagar());
			panelJuego.add(getPanelEscenarioJuego());
			panelJuego.add(getLblTV());
		}
		return panelJuego;
	}
	private JLabel getLblTV() {
		if (lblTV == null) {
			lblTV = new JLabel("");
			lblTV.setBounds(0, 0, 809, 502);
			lblTV.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Televisor.png")));
		}
		return lblTV;
	}
	private JTextArea getTxtrJuegaAlJuego() {
		if (txtrJuegaAlJuego == null) {
			txtrJuegaAlJuego = new JTextArea();
			txtrJuegaAlJuego.setFont(new Font("Arial", Font.PLAIN, 19));
			txtrJuegaAlJuego.setForeground(SystemColor.activeCaptionText);
			txtrJuegaAlJuego.setEditable(false);
			txtrJuegaAlJuego.setText("Juega al juego que os presentamos para ganar descuentos exclusivos.\r\nEs necesario proporcionar un DNI para guardarlo y ser mayor de edad.\r\nFinaliza la partida cuando se agotan los 7 movimientos posibles.\r\nAl final de la partida:\r\n− Si se ha eliminado el líder y al menos un fantasma de cada cuadrilla, \r\n  el descuento obtenido será del 25%.\r\n− Si sobrevive el líder de los fantasmas pero se ha eliminado al menos \r\n  un fantasma de cada cuadrilla, el descuento será del 10%.\r\n− En otros casos, el usuario no conseguirá descuento. \r\r\nEn caso de querer salir del juego o de errores, pulse el boton OFF.");
			txtrJuegaAlJuego.setBounds(99, 23, 628, 268);
		}
		return txtrJuegaAlJuego;
	}
	private JPanel getPanelEscenarioJuego() {
		if (panelEscenarioJuego == null) {
			panelEscenarioJuego = new JPanel();
			panelEscenarioJuego.setBackground(SystemColor.window);
			panelEscenarioJuego.setBounds(84, 93, 524, 321);
			panelEscenarioJuego.setLayout(new GridLayout(5, 7, 0, 0));
		}
		return panelEscenarioJuego;
	}
	private JPanel getPanelCatalogo() {
		if (panelCatalogo == null) {
			panelCatalogo = new JPanel();
			panelCatalogo.setBackground(Color.WHITE);
			panelCatalogo.setLayout(new BorderLayout(0, 0));
			panelCatalogo.add(getScrollPaneCatalogo(), BorderLayout.CENTER);
			panelCatalogo.add(getPanelAjustesCatalogo(), BorderLayout.NORTH);
		}
		return panelCatalogo;
	}
	private JButton getBtnBACKcatalogo() {
		if (btnBACKcatalogo == null) {
			btnBACKcatalogo = new JButton("");
			btnBACKcatalogo.setToolTipText("Vuelve al titulo de la aplicacion");
			btnBACKcatalogo.setBounds(EXIT_ON_CLOSE, ABORT, 90, 70);
			btnBACKcatalogo.setBackground(SystemColor.window);
			btnBACKcatalogo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarTitulo();
					eliminarFiltros();
				}
			});
			setImagenAdaptada(btnBACKcatalogo, "/img/FlechaBack.png");
		}
		return btnBACKcatalogo;
	}
	private JButton getBtnImgTitulo() {
		if (btnImgTitulo == null) {
			btnImgTitulo = new JButton("");
			btnImgTitulo.setEnabled(false);
			btnImgTitulo.setBackground(SystemColor.window);
			btnImgTitulo.setBounds(170, 118, 490, 136);
			this.setImagenAdaptada(btnImgTitulo, "/img/titulo.png");
		}
		return btnImgTitulo;
	}
	private JLabel getLblPropaganda1() {
		if (lblPropaganda1 == null) {
			lblPropaganda1 = new JLabel("JUEGA Y GANA");
			lblPropaganda1.setHorizontalAlignment(SwingConstants.CENTER);
			lblPropaganda1.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblPropaganda1.setBounds(217, 28, 506, 55);
		}
		return lblPropaganda1;
	}
	private JLabel getLblPropaganda2() {
		if (lblPropaganda2 == null) {
			lblPropaganda2 = new JLabel("DESCUENTOS DE HASTA UN 25%");
			lblPropaganda2.setHorizontalAlignment(SwingConstants.CENTER);
			lblPropaganda2.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblPropaganda2.setBounds(217, 83, 506, 55);
		}
		return lblPropaganda2;
	}
	private JScrollPane getScrollPaneCatalogo() {
		if (scrollPaneCatalogo == null) {
			scrollPaneCatalogo = new JScrollPane();
			scrollPaneCatalogo.setViewportView(getPanelScrollCatalogo());
		}
		return scrollPaneCatalogo;
	}

	
	private JPanel getPanelScrollCatalogo() {
		if (panelScrollCatalogo == null) {
			panelScrollCatalogo = new JPanel();
			panelScrollCatalogo.setBackground(SystemColor.window);
			panelScrollCatalogo.setLayout(new GridLayout(0,1,3,3));
			generaCatalogo();
		}
		return panelScrollCatalogo;
	}

	private void generaCatalogo() {
		getPanelScrollCatalogo().removeAll();
		RecorteInfoCastillo panelInfoCastillo;
		for (int i = 0; i < canosa.getNumeroItemsCatalogo(); i++) {
			 panelInfoCastillo = new RecorteInfoCastillo(this,canosa.getCastilloPos(i),this.localizacion);
			 getPanelScrollCatalogo().add(panelInfoCastillo);
		}
		getPanelScrollCatalogo().revalidate();
		getPanelScrollCatalogo().repaint();
	}

	private JPanel getPanelAjustesCatalogo() {
		if (panelAjustesCatalogo == null) {
			panelAjustesCatalogo = new JPanel();
			panelAjustesCatalogo.setLayout(new BorderLayout(0, 0));
			panelAjustesCatalogo.add(getPanelAjustesParteFiltrosCatalogo(), BorderLayout.CENTER);
			panelAjustesCatalogo.add(getPanelAjustesParteprecioCatalogo(), BorderLayout.SOUTH);
		}
		return panelAjustesCatalogo;
	}
	private JPanel getPanelAjustesParteFiltrosCatalogo() {
		if (panelAjustesParteFiltrosCatalogo == null) {
			panelAjustesParteFiltrosCatalogo = new JPanel();
			panelAjustesParteFiltrosCatalogo.setBackground(SystemColor.window);
			panelAjustesParteFiltrosCatalogo.setLayout(new BoxLayout(panelAjustesParteFiltrosCatalogo, BoxLayout.X_AXIS));
			panelAjustesParteFiltrosCatalogo.add(getBtnBACKcatalogo());
			panelAjustesParteFiltrosCatalogo.add(getPanelFiltros());
			panelAjustesParteFiltrosCatalogo.add(getBtnEliminarFiltros());
		}
		return panelAjustesParteFiltrosCatalogo;
	}
	private JPanel getPanelFiltros() {
		if (panelFiltros == null) {
			panelFiltros = new JPanel();
			panelFiltros.setLayout(null);
			panelFiltros.setBounds(EXIT_ON_CLOSE, ABORT, 400, 70);
			panelFiltros.setBorder(new TitledBorder(null, "Filtros de Busqueda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelFiltros.setBackground(Color.WHITE);
			panelFiltros.add(getChckbxFiltroAP());
			panelFiltros.add(getChckbxFiltroDE());
			panelFiltros.add(getChckbxFiltroEN());
			panelFiltros.add(getChckbxFiltroOB());
			panelFiltros.add(getChckbxFiltroOL());
			panelFiltros.add(getChckbxFiltroRU());
		}
		return panelFiltros;
	}
	private JCheckBox getChckbxFiltroAP() {
		if (chckbxFiltroAP == null) {
			chckbxFiltroAP = new JCheckBox("");
			chckbxFiltroAP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setFiltro(chckbxFiltroAP,"Ap");

				}
			});
			chckbxFiltroAP.setBackground(SystemColor.window);
			chckbxFiltroAP.setBounds(17, 20, 195, 21);
		}
		return chckbxFiltroAP;
	}
	private JCheckBox getChckbxFiltroDE() {
		if (chckbxFiltroDE == null) {
			chckbxFiltroDE = new JCheckBox("");
			chckbxFiltroDE.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setFiltro(chckbxFiltroDE,"De");

				}
			});
			chckbxFiltroDE.setBounds(222, 20, 170, 21);
			chckbxFiltroDE.setBackground(SystemColor.window);
		}
		return chckbxFiltroDE;
	}
	private JCheckBox getChckbxFiltroEN() {
		if (chckbxFiltroEN == null) {
			chckbxFiltroEN = new JCheckBox("");
			chckbxFiltroEN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setFiltro(chckbxFiltroEN,"En");

				}
			});
			chckbxFiltroEN.setBounds(404, 20, 155, 21);
			chckbxFiltroEN.setBackground(SystemColor.window);
		}
		return chckbxFiltroEN;
	}

	private JCheckBox getChckbxFiltroOB() {
		if (chckbxFiltroOB == null) {
			chckbxFiltroOB = new JCheckBox("");
			chckbxFiltroOB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setFiltro(chckbxFiltroOB,"Ob");

				}
			});
			chckbxFiltroOB.setBounds(17, 46, 195, 21);
			chckbxFiltroOB.setBackground(SystemColor.window);
		}
		return chckbxFiltroOB;
	}

	private JCheckBox getChckbxFiltroOL() {
		if (chckbxFiltroOL == null) {
			chckbxFiltroOL = new JCheckBox("");
			chckbxFiltroOL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setFiltro(chckbxFiltroOL,"Ol");
				}
			});
			chckbxFiltroOL.setBounds(222, 46, 170, 21);
			chckbxFiltroOL.setBackground(SystemColor.window);
		}
		return chckbxFiltroOL;
	}

	private JCheckBox getChckbxFiltroRU() {
		if (chckbxFiltroRU == null) {
			chckbxFiltroRU = new JCheckBox("");
			chckbxFiltroRU.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setFiltro(chckbxFiltroRU,"Ru");
				}
			});
			chckbxFiltroRU.setBounds(404, 46, 155, 21);
			chckbxFiltroRU.setBackground(SystemColor.window);
		}
		return chckbxFiltroRU;
	}

	private JPanel getPanelAjustesParteprecioCatalogo() {
		if (panelAjustesParteprecioCatalogo == null) {
			panelAjustesParteprecioCatalogo = new JPanel();
			panelAjustesParteprecioCatalogo.setBackground(SystemColor.window);
			panelAjustesParteprecioCatalogo.setLayout(new GridLayout(0, 3, 0, 0));
			panelAjustesParteprecioCatalogo.add(getLblPrecio());
			panelAjustesParteprecioCatalogo.add(getSliderPrecio());
			panelAjustesParteprecioCatalogo.add(getTxtPrecio());
		}
		return panelAjustesParteprecioCatalogo;
	}
	private JTextField getTxtPrecio() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBorder(null);
			textField.setBackground(SystemColor.window);
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setEditable(false);
			textField.setBounds(new Rectangle(0, 0, 40, 70));
			textField.setText("400€");
			textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblPrecio() {
		if (lblPrecio == null) {
			lblPrecio = new JLabel(" Precio Máximo : ");
			lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
			lblPrecio.setBounds(new Rectangle(0, 0, 100, 60));
			lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblPrecio.setDisplayedMnemonic('P');
		}
		return lblPrecio;
	}
	private JSlider getSliderPrecio() {
		if (sliderPrecio == null) {
			sliderPrecio = new JSlider();
			sliderPrecio.setToolTipText("Indique aqui el precio maximo al que este dispuesto a pagar");
			sliderPrecio.setBounds(new Rectangle(0, 0, 300, 70));
			sliderPrecio.setBounds(EXIT_ON_CLOSE, ABORT, 400, 50);
			sliderPrecio.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					if (!sliderPrecio.getValueIsAdjusting()) {
						ejecutaSlider();
					}
				}
			});
			sliderPrecio.setValue(400);
			sliderPrecio.setPaintTicks(true);
			sliderPrecio.setPaintLabels(true);
			sliderPrecio.setMinorTickSpacing(10);
			sliderPrecio.setMinimum(100);
			sliderPrecio.setMaximum(400);
			sliderPrecio.setMajorTickSpacing(50);
			sliderPrecio.setBackground(Color.WHITE);
		}
		return sliderPrecio;
	}
	
	protected void ejecutaSlider() {
		actualizaPrecio();
		aplicarFiltro(String.valueOf(getSliderPrecio().getValue()));
		for (int i = 0; i < getPanelFiltros().getComponents().length; i++) {
			JCheckBox cB = (JCheckBox) (getPanelFiltros().getComponents()[i]);
			if(cB.isSelected()) {
				setFiltro(cB,canosa.getEncantamiento(i));
			}
		}
	}
	protected void actualizaPrecio() {
		String precio = NumberFormat.getNumberInstance().format(getSliderPrecio().getValue());
		getTxtPrecio().setText(precio+"€");
	}
	private JButton getBtnEliminarFiltros() {
		if (btnEliminarFiltros == null) {
			btnEliminarFiltros = new JButton("");
			btnEliminarFiltros.setToolTipText("Borra todos los filtros aplicados");
			btnEliminarFiltros.setBounds(EXIT_ON_CLOSE, ABORT, 90, 70);
			btnEliminarFiltros.setBackground(SystemColor.window);
			btnEliminarFiltros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarFiltros();
				}
			});
			setImagenAdaptada(btnEliminarFiltros,"/img/papelera.png");
		}
		return btnEliminarFiltros;
	}

	protected void eliminarFiltros() {
		for (int i = 0; i < getPanelFiltros().getComponents().length; i++) {
			JCheckBox cB = (JCheckBox) (getPanelFiltros().getComponents()[i]);
			getSliderPrecio().setValue(400);
			cB.setSelected(false);
		}
		canosa.resetCatalogo();
		generaCatalogo();
	}
	private JPanel getPanelInfoCastillo() {
		if (panelInfoCastillo == null) {
			panelInfoCastillo = new JPanel();
			panelInfoCastillo.setBackground(SystemColor.window);
			panelInfoCastillo.setLayout(new BorderLayout(0, 0));
			panelInfoCastillo.add(getPanelCabeceraInfo(), BorderLayout.NORTH);
			panelInfoCastillo.add(getPanelInfo(), BorderLayout.CENTER);
		}
		return panelInfoCastillo;
	}
	
	private JPanel getPanelCabeceraInfo() {
		if (panelCabeceraInfo == null) {
			panelCabeceraInfo = new JPanel();
			panelCabeceraInfo.setBackground(SystemColor.window);
			panelCabeceraInfo.setLayout(new BorderLayout(0, 0));
			panelCabeceraInfo.add(getBotonInfoCastillo(), BorderLayout.WEST);
			panelCabeceraInfo.add(getBtnFotoInfo(), BorderLayout.CENTER);
			panelCabeceraInfo.add(getBtnLogo5(), BorderLayout.EAST);
		}
		return panelCabeceraInfo;
	}
	
	private JButton getBotonInfoCastillo() {
		if (btnBACKinfoCastillo == null) {
			btnBACKinfoCastillo = new JButton("");
			btnBACKinfoCastillo.setToolTipText("Vuelve al catalogo de castillos");
			btnBACKinfoCastillo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/FlechaBack.png")));
			btnBACKinfoCastillo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarCatalogo();
					resetearInfo();
				}
			});
			btnBACKinfoCastillo.setBackground(SystemColor.window);
			btnBACKinfoCastillo.setHorizontalAlignment(SwingConstants.LEFT);
			btnBACKinfoCastillo.setBounds(EXIT_ON_CLOSE, ABORT, 90, 90);
			setImagenAdaptada(btnBACKinfoCastillo,"/img/FlechaBack.png");
			}
		return btnBACKinfoCastillo;
	}
	private JPanel getPanelInfo() {
		if (panelInfo == null) {
			panelInfo = new JPanel();
			panelInfo.setBorder(UIManager.getBorder("PasswordField.border"));
			panelInfo.setBackground(SystemColor.window);
			panelInfo.setLayout(null);
			panelInfo.add(getLblNombreCastillo());
			panelInfo.add(getLblPaisCastillo());
			panelInfo.add(getLblDescripcionCastillo());
			panelInfo.add(getScrollPaneDescripcion());
			panelInfo.add(getLblPrecioHabitacionCastillo());
			panelInfo.add(getBtnCalendario());
			panelInfo.add(getLblNPersonas());
			panelInfo.add(getLblNHabitaciones());
			panelInfo.add(getSpinnerNPersonas());
			panelInfo.add(getSpinnerNHabitaciones());
			panelInfo.add(getBtnReservar());
			panelInfo.add(getLblPrecioTotal());
			panelInfo.add(getTextFieldPrecioTotal());
		}
		return panelInfo;
	}
	private JButton getBtnFotoInfo() {
		if (btnFotoInfo == null) {
			btnFotoInfo = new JButton("");
			btnFotoInfo.setBorder(null);
			btnFotoInfo.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, 90);
			btnFotoInfo.setBackground(SystemColor.window);
			btnFotoInfo.setEnabled(false);
		}
		return btnFotoInfo;
	}
	private JLabel getLblNombreCastillo() {
		if (lblNombreCastillo == null) {
			lblNombreCastillo = new JLabel("Nombre del Castillo :");
			lblNombreCastillo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNombreCastillo.setBounds(42, 20, 401, 29);
		}
		return lblNombreCastillo;
	}
	private JLabel getLblPaisCastillo() {
		if (lblPaisCastillo == null) {
			lblPaisCastillo = new JLabel("Pais del Castillo : ");
			lblPaisCastillo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPaisCastillo.setBounds(42, 59, 401, 29);
		}
		return lblPaisCastillo;
	}
	private JLabel getLblDescripcionCastillo() {
		if (lblDescripcionCastillo == null) {
			lblDescripcionCastillo = new JLabel("Descripcion y Encantamientos : ");
			lblDescripcionCastillo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblDescripcionCastillo.setBounds(42, 98, 401, 29);
		}
		return lblDescripcionCastillo;
	}
	private JScrollPane getScrollPaneDescripcion() {
		if (scrollPaneDescripcion == null) {
			scrollPaneDescripcion = new JScrollPane();
			scrollPaneDescripcion.setBorder(null);
			scrollPaneDescripcion.setBounds(42, 137, 401, 195);
			scrollPaneDescripcion.setViewportView(getTextAreaDescripcion());
		}
		return scrollPaneDescripcion;
	}
	private JTextArea getTextAreaDescripcion() {
		if (textAreaDescripcion == null) {
			textAreaDescripcion = new JTextArea(new DefaultStyledDocument());
			textAreaDescripcion.setBorder(null);
			textAreaDescripcion.setEditable(false);
			textAreaDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
		}
		return textAreaDescripcion;
	}

	public Castillo getCastillo() {
		return castillo;
	}

	public void setCastillo(Castillo castillo) {
		this.castillo = castillo;
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logoC.png")));
			lblLogo.setBounds(45, 10, 121, 103);
		}
		return lblLogo;
	}
	private JLabel getLblLogo2() {
		if (lblLogo2 == null) {
			lblLogo2 = new JLabel("");
			lblLogo2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logoC.png")));
			lblLogo2.setBounds(698, 20, 88, 90);
		}
		return lblLogo2;
	}
	private JLabel getLblLogo3() {
		if (lblLogo3 == null) {
			lblLogo3 = new JLabel("CANOSA");
			lblLogo3.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logoCC.png")));
			lblLogo3.setBounds(703, 462, 96, 47);
		}
		return lblLogo3;
	}
	private JLabel getLblLogo4() {
		if (lblLogo4 == null) {
			lblLogo4 = new JLabel("CANOSA");
			lblLogo4.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logoCC.png")));
			lblLogo4.setBounds(703, 315, 96, 47);
		}
		return lblLogo4;
	}
	private JButton getBtnLogo5() {
		if (btnLogo5 == null) {
			btnLogo5 = new JButton("");
			btnLogo5.setBackground(SystemColor.window);
			btnLogo5.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logoC.png")));
			btnLogo5.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logoC.png")));
			btnLogo5.setEnabled(false);
			btnLogo5.setOpaque(false);
			btnLogo5.setContentAreaFilled(false);
			btnLogo5.setBorderPainted(false);
			
		}
		return btnLogo5;
	}
	private JLabel getLblPrecioHabitacionCastillo() {
		if (lblPrecioHabitacionCastillo == null) {
			lblPrecioHabitacionCastillo = new JLabel("Precio por cada dia de estancia : ");
			lblPrecioHabitacionCastillo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPrecioHabitacionCastillo.setBounds(42, 342, 401, 29);
		}
		return lblPrecioHabitacionCastillo;
	}
	private JButton getBtnCalendario() {
		if (btnCalendario == null) {
			btnCalendario = new JButton("");
			btnCalendario.setToolTipText("Click para seleccionar fecha y dias de estancia");
			btnCalendario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					preguntarFecha();
				}
			});
			btnCalendario.setBackground(SystemColor.window);
			btnCalendario.setBounds(495, 20, 289, 126);
			setImagenAdaptada(btnCalendario, "/img/calendario.png");
		}
		return btnCalendario;
	}
	private JLabel getLblNPersonas() {
		if (lblNPersonas == null) {
			lblNPersonas = new JLabel("Nº Personas :");
			lblNPersonas.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNPersonas.setBounds(495, 156, 172, 43);
		}
		return lblNPersonas;
	}
	private JLabel getLblNHabitaciones() {
		if (lblNHabitaciones == null) {
			lblNHabitaciones = new JLabel("Nº Habitaciones:");
			lblNHabitaciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNHabitaciones.setBounds(495, 209, 172, 43);
		}
		return lblNHabitaciones;
	}
	private JSpinner getSpinnerNPersonas() {
		if (spinnerNPersonas == null) {
			spinnerNPersonas = new JSpinner();
			spinnerNPersonas.setFont(new Font("Tahoma", Font.PLAIN, 20));
			spinnerNPersonas.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					if((int)spinnerNPersonas.getValue()%(double)2 !=0) {
						spinnerNHabitaciones.setModel(new SpinnerNumberModel(Integer.valueOf(((int)spinnerNPersonas.getValue()+1)/2),
								Integer.valueOf(((int)spinnerNPersonas.getValue()+1)/2),Integer.valueOf((int)spinnerNPersonas.getValue()), Integer.valueOf(1)));
					}
					canosa.registrarHabitaciones((int)getSpinnerNPersonas().getValue(),(int)getSpinnerNHabitaciones().getValue());
					getTextFieldPrecioTotal().setText(canosa.calcularPrecioFinal()+"€");
					revisarValido();
				} 
			});
			spinnerNPersonas.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
			spinnerNPersonas.setBounds(676, 156, 108, 43);
		}
		return spinnerNPersonas;
	}
	
	private JSpinner getSpinnerNHabitaciones() {
		if (spinnerNHabitaciones == null) {
			int[] numeros = new int[90];
			for (int i = 0; i < 90; i++) {
				numeros[i] = i;
			}
			spinnerNHabitaciones = new JSpinner();
			spinnerNHabitaciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
			spinnerNHabitaciones.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					canosa.registrarHabitaciones((int)getSpinnerNPersonas().getValue(),(int)getSpinnerNHabitaciones().getValue());
					getTextFieldPrecioTotal().setText(canosa.calcularPrecioFinal()+"€");
					revisarValido();
				}
			});
			spinnerNHabitaciones.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1),
					null, Integer.valueOf(1)));
			spinnerNHabitaciones.setBounds(677, 209, 108, 43);
		}
		return spinnerNHabitaciones;
	}
	private JButton getBtnReservar() {
		if (btnReservar == null) {
			btnReservar = new JButton("Reservar");
			btnReservar.setToolTipText("Para poder empezar el registro, debes haber escogido numero de personas, de habitaciones y dias de estancia.");
			btnReservar.setMnemonic('R');
			btnReservar.setEnabled(false);
			btnReservar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarRegistro();
				}
			});
			btnReservar.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnReservar.setBounds(495, 312, 292, 63);
		}
		return btnReservar;
	}
	private JLabel getLblPrecioTotal() {
		if (lblPrecioTotal == null) {
			lblPrecioTotal = new JLabel("Precio Total :");
			lblPrecioTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPrecioTotal.setBounds(495, 262, 172, 40);
		}
		return lblPrecioTotal;
	}
	JTextField getTextFieldPrecioTotal() {
		if (textFieldPrecioTotal == null) {
			textFieldPrecioTotal = new JTextField();
			textFieldPrecioTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
			textFieldPrecioTotal.setBackground(SystemColor.window);
			textFieldPrecioTotal.setEditable(false);
			textFieldPrecioTotal.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldPrecioTotal.setBounds(676, 263, 108, 39);
			textFieldPrecioTotal.setColumns(10);
		}
		return textFieldPrecioTotal;
	}
	private JPanel getPanelRegistro() {
		if (panelRegistro == null) {
			panelRegistro = new JPanel();
			panelRegistro.setBackground(SystemColor.window);
			panelRegistro.setLayout(null);
			panelRegistro.add(getPanelDatosRegistro());
			panelRegistro.add(getChckbxMayorDeEdad());
			panelRegistro.add(getLblLogo5());
			panelRegistro.add(getLbl18());
		}
		return panelRegistro;
	}
	private JPanel getPanelDatosRegistro() {
		if (panelDatosRegistro == null) {
			panelDatosRegistro = new JPanel();
			panelDatosRegistro.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelDatosRegistro.setBackground(SystemColor.window);
			panelDatosRegistro.setBounds(29, 27, 749, 413);
			panelDatosRegistro.setLayout(null);
			panelDatosRegistro.add(getBtnBACKRegistro());
			panelDatosRegistro.add(getPanelDatosEditables());
			panelDatosRegistro.add(getLblPrecioFinalReserva());
			panelDatosRegistro.add(getTextFieldPrecioFinal());
			panelDatosRegistro.add(getBtnConfirmarReserva());
			panelDatosRegistro.add(getLblDescuentoAnuncio());
		}
		return panelDatosRegistro;
	}
	private JCheckBox getChckbxMayorDeEdad() {
		if (chckbxMayorDeEdad == null) {
			chckbxMayorDeEdad = new JCheckBox("Afirmo ser mayor de edad.");
			chckbxMayorDeEdad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chckbxMayorDeEdad.isSelected()) {
						getBtnConfirmarReserva().setEnabled(true);
					}
					else {
						getBtnConfirmarReserva().setEnabled(false);
					}
				}
			});
			chckbxMayorDeEdad.setBackground(Color.WHITE);
			chckbxMayorDeEdad.setMnemonic('S');
			chckbxMayorDeEdad.setBounds(328, 446, 180, 36);
		}
		return chckbxMayorDeEdad;
	}
	private JLabel getLblLogo5() {
		if (lblLogo5 == null) {
			lblLogo5 = new JLabel("CANOSA");
			lblLogo5.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logoCC.png")));
			lblLogo5.setBounds(703, 450, 96, 36);
		}
		return lblLogo5;
	}
	private JButton getBtnBACKcaratula() {
		if (btnBACKcaratula == null) {
			btnBACKcaratula = new JButton("");
			btnBACKcaratula.setToolTipText("Vuelve al titulo de la aplicacion");
			btnBACKcaratula.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnBACKcaratula.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarTitulo();
				}
			});
			btnBACKcaratula.setBackground(Color.WHITE);
			btnBACKcaratula.setBounds(10, 10, 139, 90);
			setImagenAdaptada(btnBACKcaratula, "/img/FlechaBack.png");
		}
		return btnBACKcaratula;
	}
	private JButton getBtnBACKRegistro() {
		if (btnBACKRegistro == null) {
			btnBACKRegistro = new JButton("");
			btnBACKRegistro.setToolTipText("Vuelve al registro de datos de estancia");
			btnBACKRegistro.setBorder(new LineBorder(new Color(0, 0, 0)));
			btnBACKRegistro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarInfoCastillo(castillo);
				}
			});
			btnBACKRegistro.setBackground(Color.WHITE);
			btnBACKRegistro.setBounds(0, 0, 139, 90);
			setImagenAdaptada(btnBACKRegistro, "/img/FlechaBack.png");
		}
		return btnBACKRegistro;
	}
	private JLabel getLblNombreUsuario() {
		if (lblNombreUsuario == null) {
			lblNombreUsuario = new JLabel("Nombre y Apellidos : ");
			lblNombreUsuario.setBounds(10, 20, 192, 39);
			lblNombreUsuario.setDisplayedMnemonic('N');
			lblNombreUsuario.setLabelFor(getTextFieldNombreYApellidos());
			lblNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblNombreUsuario;
	}
	private JTextField getTextFieldNombreYApellidos() {
		if (textFieldNombreYApellidos == null) {
			textFieldNombreYApellidos = new JTextField();
			textFieldNombreYApellidos.setBounds(221, 24, 207, 39);
			textFieldNombreYApellidos.setColumns(10);
		}
		return textFieldNombreYApellidos;
	}
	private JLabel getLblCorreo() {
		if (lblCorreo == null) {
			lblCorreo = new JLabel("Correo Eletrónico :");
			lblCorreo.setLabelFor(getTextFieldCorreo());
			lblCorreo.setBounds(10, 69, 192, 39);
			lblCorreo.setDisplayedMnemonic('E');
			lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblCorreo;
	}
	private JLabel getLblDni() {
		if (lblDni == null) {
			lblDni = new JLabel("DNI :");
			lblDni.setLabelFor(getTextFieldDNI());
			lblDni.setBounds(10, 118, 192, 39);
			lblDni.setDisplayedMnemonic('D');
			lblDni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblDni;
	}
	private JTextField getTextFieldCorreo() {
		if (textFieldCorreo == null) {
			textFieldCorreo = new JTextField();
			textFieldCorreo.setBounds(221, 73, 207, 39);
			textFieldCorreo.setColumns(10);
		}
		return textFieldCorreo;
	}
	private JTextField getTextFieldDNI() {
		if (textFieldDNI == null) {
			textFieldDNI = new JTextField();
			textFieldDNI.setBounds(221, 122, 207, 39);
			textFieldDNI.setColumns(10);
		}
		return textFieldDNI;
	}
	private JLabel getLblComentarios() {
		if (lblComentarios == null) {
			lblComentarios = new JLabel("Comentarios :");
			lblComentarios.setBounds(10, 167, 192, 39);
			lblComentarios.setLabelFor(getTextAreaComentarios());
			lblComentarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblComentarios.setDisplayedMnemonic('C');
		}
		return lblComentarios;
	}
	private JScrollPane getScrollPaneComentarios() {
		if (scrollPaneComentarios == null) {
			scrollPaneComentarios = new JScrollPane();
			scrollPaneComentarios.setBounds(221, 167, 207, 39);
			scrollPaneComentarios.setViewportView(getTextAreaComentarios());
		}
		return scrollPaneComentarios;
	}
	private JTextArea getTextAreaComentarios() {
		if (textAreaComentarios == null) {
			textAreaComentarios = new JTextArea();
		}
		return textAreaComentarios;
	}
	private JPanel getPanelDatosEditables() {
		if (panelDatosEditables == null) {
			panelDatosEditables = new JPanel();
			panelDatosEditables.setBackground(SystemColor.window);
			panelDatosEditables.setBorder(new TitledBorder(null, "Datos de la reserva:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelDatosEditables.setBounds(20, 100, 705, 227);
			panelDatosEditables.setLayout(null);
			panelDatosEditables.add(getLblNombreUsuario());
			panelDatosEditables.add(getLblCorreo());
			panelDatosEditables.add(getLblDni());
			panelDatosEditables.add(getLblComentarios());
			panelDatosEditables.add(getTextFieldNombreYApellidos());
			panelDatosEditables.add(getTextFieldCorreo());
			panelDatosEditables.add(getTextFieldDNI());
			panelDatosEditables.add(getScrollPaneComentarios());
			panelDatosEditables.add(getLblRecuentoPersonas());
			panelDatosEditables.add(getTextRecuentoPersonas());
			panelDatosEditables.add(getLblRecuentoHabitaciones());
			panelDatosEditables.add(getTextRecuentoHabitaciones());
			panelDatosEditables.add(getLblRecuentoDias());
			panelDatosEditables.add(getTextDias());
			panelDatosEditables.add(getLblRecuentoFecha());
			panelDatosEditables.add(getTextFecha());
		}
		return panelDatosEditables;
	}
	private JLabel getLblPrecioFinalReserva() {
		if (lblPrecioFinalReserva == null) {
			lblPrecioFinalReserva = new JLabel("Precio final de la reserva :");
			lblPrecioFinalReserva.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPrecioFinalReserva.setBounds(20, 348, 251, 36);
		}
		return lblPrecioFinalReserva;
	}
	private JTextField getTextFieldPrecioFinal() {
		if (textFieldPrecioFinal == null) {
			textFieldPrecioFinal = new JTextField();
			textFieldPrecioFinal.setBackground(SystemColor.window);
			textFieldPrecioFinal.setEditable(false);
			textFieldPrecioFinal.setFont(new Font("Tahoma", Font.PLAIN, 20));
			textFieldPrecioFinal.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldPrecioFinal.setBounds(280, 348, 165, 36);
			textFieldPrecioFinal.setColumns(10);
		}
		return textFieldPrecioFinal;
	}
	private JLabel getLblRecuentoPersonas() {
		if (lblRecuentoPersonas == null) {
			lblRecuentoPersonas = new JLabel("Nº Personas :");
			lblRecuentoPersonas.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblRecuentoPersonas.setBounds(462, 24, 173, 39);
		}
		return lblRecuentoPersonas;
	}
	private JTextField getTextRecuentoPersonas() {
		if (textRecuentoPersonas == null) {
			textRecuentoPersonas = new JTextField();
			textRecuentoPersonas.setHorizontalAlignment(SwingConstants.CENTER);
			textRecuentoPersonas.setFont(new Font("Tahoma", Font.PLAIN, 20));
			textRecuentoPersonas.setBackground(Color.WHITE);
			textRecuentoPersonas.setEditable(false);
			textRecuentoPersonas.setBounds(637, 24, 58, 39);
			textRecuentoPersonas.setColumns(10);
		}
		return textRecuentoPersonas;
	}
	private JLabel getLblRecuentoHabitaciones() {
		if (lblRecuentoHabitaciones == null) {
			lblRecuentoHabitaciones = new JLabel("Nº Habitaciones :");
			lblRecuentoHabitaciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblRecuentoHabitaciones.setBounds(462, 73, 173, 39);
		}
		return lblRecuentoHabitaciones;
	}
	private JTextField getTextRecuentoHabitaciones() {
		if (textRecuentoHabitaciones == null) {
			textRecuentoHabitaciones = new JTextField();
			textRecuentoHabitaciones.setHorizontalAlignment(SwingConstants.CENTER);
			textRecuentoHabitaciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
			textRecuentoHabitaciones.setEditable(false);
			textRecuentoHabitaciones.setColumns(10);
			textRecuentoHabitaciones.setBackground(Color.WHITE);
			textRecuentoHabitaciones.setBounds(637, 73, 58, 39);
		}
		return textRecuentoHabitaciones;
	}
	private JLabel getLblRecuentoDias() {
		if (lblRecuentoDias == null) {
			lblRecuentoDias = new JLabel("Nº Dias :");
			lblRecuentoDias.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblRecuentoDias.setBounds(462, 118, 173, 39);
		}
		return lblRecuentoDias;
	}
	private JTextField getTextDias() {
		if (textDias == null) {
			textDias = new JTextField();
			textDias.setHorizontalAlignment(SwingConstants.CENTER);
			textDias.setFont(new Font("Tahoma", Font.PLAIN, 20));
			textDias.setEditable(false);
			textDias.setColumns(10);
			textDias.setBackground(Color.WHITE);
			textDias.setBounds(637, 118, 58, 39);
		}
		return textDias;
	}
	private JLabel getLblRecuentoFecha() {
		if (lblRecuentoFecha == null) {
			lblRecuentoFecha = new JLabel("Fecha :");
			lblRecuentoFecha.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblRecuentoFecha.setBounds(462, 167, 89, 39);
		}
		return lblRecuentoFecha;
	}
	private JTextField getTextFecha() {
		if (textFecha == null) {
			textFecha = new JTextField();
			textFecha.setFont(new Font("Tahoma", Font.PLAIN, 20));
			textFecha.setHorizontalAlignment(SwingConstants.CENTER);
			textFecha.setEditable(false);
			textFecha.setColumns(10);
			textFecha.setBackground(Color.WHITE);
			textFecha.setBounds(561, 167, 134, 39);
		}
		return textFecha;
	}
	private JButton getBtnConfirmarReserva() {
		if (btnConfirmarReserva == null) {
			btnConfirmarReserva = new JButton("Confirmar Reserva");
			btnConfirmarReserva.setToolTipText("Confirma la reserva una vez hayas rellenado todos los datos necesarios.");
			btnConfirmarReserva.setEnabled(false);
			btnConfirmarReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					procesarReserva();
				}
			});
			btnConfirmarReserva.setBackground(new Color(250, 235, 215));
			btnConfirmarReserva.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnConfirmarReserva.setBounds(504, 337, 221, 66);
		}
		return btnConfirmarReserva;
	}
	private JButton getBtnApagar() {
		if (btnApagar == null) {
			btnApagar = new JButton("");
			btnApagar.setToolTipText("Apagar el juego y volver a la pagina anterior");
			btnApagar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int respuesta = JOptionPane.showConfirmDialog(null,
							textos.getString("txt55"), "CANOSA España : Juego : Finalizar ",
							JOptionPane.YES_NO_OPTION);

					if (respuesta == JOptionPane.YES_OPTION) {
						mostrarCaratula();
						canosa.iniciarJuego();
					}

				}
			});
			btnApagar.setBounds(685, 124, 76, 70);
			setImagenAdaptada(btnApagar,"/img/Apagar2.png");
			btnApagar.setOpaque(false);
			btnApagar.setContentAreaFilled(false);
			btnApagar.setBorderPainted(false);
		}
		return btnApagar;
	}
	private JButton getBtnDado() {
		if (btnDado == null) {
			btnDado = new JButton("");
			btnDado.setToolTipText("Lanza el dado ");
			btnDado.setBackground(SystemColor.activeCaptionText);
			btnDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					accionarDado();
				}
			});
			btnDado.setBounds(651, 339, 135, 112);
			setImagenAdaptada(btnDado,"/img/Dado.png");
		}
		return btnDado;
	}
	private JTextField getTextDado() {
		if (textDado == null) {
			textDado = new JTextField();
			textDado.setForeground(new Color(255, 0, 0));
			textDado.setBackground(SystemColor.activeCaptionText);
			textDado.setHorizontalAlignment(SwingConstants.CENTER);
			textDado.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
			textDado.setOpaque(false);
			textDado.setEditable(false);
			textDado.setBounds(651, 258, 135, 83);
			textDado.setColumns(10);
		}
		return textDado;
	}

	protected void accionarDado() {
		int resultado = Dado.lanzar();
		getTextDado().setText(resultado+"");
		canosa.dadoLanzado(resultado);
		getBtnDado().setEnabled(false);
		for (int i = 0; i < getPanelEscenarioJuego().getComponents().length; i++) {
			JButton boton = (JButton) (getPanelEscenarioJuego().getComponents()[i]);
			boton.setEnabled(true);
		}
	}
	private JLabel getLbl18() {
		if (lbl18 == null) {
			lbl18 = new JLabel("");
			lbl18.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Menores.png")));
			lbl18.setBounds(277, 450, 45, 32);
		}
		return lbl18;
	}

	public void aplicarDescuento(int DSC) {
		getLblDescuentoAnuncio().setVisible(true);
		getLblDescuentoAnuncio().setText("Se ha aplicado el descuento del "+DSC+ "%");
		canosa.aplicarDescuento(DSC);
		getTextFieldPrecioFinal().setText(canosa.calcularPrecioFinal()+"€");
	}
	
	private JLabel getLblDescuentoAnuncio() {
		if (lblDescuentoAnuncio == null) {
			lblDescuentoAnuncio = new JLabel("Se ha aplicado el descuento del %");
			lblDescuentoAnuncio.setVisible(false);
			lblDescuentoAnuncio.setForeground(Color.RED);
			lblDescuentoAnuncio.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblDescuentoAnuncio.setBounds(188, 27, 468, 45);
		}
		return lblDescuentoAnuncio;
	}
	
	private void reiniciar() {
		eliminarFiltros();
		limpiarRegistro();
		getLblDescuentoAnuncio().setVisible(false);
		JOptionPane.showMessageDialog(null, textos.getString("txt56"));
		mostrarPortada();
	}
	
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBackground(SystemColor.window);
			menuBar.add(getMnApp());
			menuBar.add(getMnIdioma());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnApp() {
		if (mnApp == null) {
			mnApp = new JMenu("App");
			mnApp.setMnemonic('A');
			mnApp.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			mnApp.add(getMntmReservarCastilloDirecto());
			mnApp.add(getMntmJuegaDirecto());
			mnApp.add(getMntmReiniciar());
			mnApp.add(getSeparator());
			mnApp.add(getMntmSalir());
		}
		return mnApp;
	}
	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Salir");
			mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cerrarVentana();
				}
			});
		}
		return mntmSalir;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getMntmReservarCastilloDirecto() {
		if (mntmReservarCastilloDirecto == null) {
			mntmReservarCastilloDirecto = new JMenuItem("Reserva tu castillo");
			mntmReservarCastilloDirecto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarCatalogo();
				}
			});
			mntmReservarCastilloDirecto.setMnemonic('c');
		}
		return mntmReservarCastilloDirecto;
	}
	private JMenuItem getMntmJuegaDirecto() {
		if (mntmJuegaDirecto == null) {
			mntmJuegaDirecto = new JMenuItem("Juega y gana tu descuento");
			mntmJuegaDirecto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarCaratula();
				}
			});
			mntmJuegaDirecto.setMnemonic('J');
		}
		return mntmJuegaDirecto;
	}
	private JMenuItem getMntmReiniciar() {
		if (mntmReiniciar == null) {
			mntmReiniciar = new JMenuItem("Reiniciar");
			mntmReiniciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reiniciar();
				}
			});
			mntmReiniciar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		}
		return mntmReiniciar;
	}
	private JButton getBtnNormas() {
		if (btnNormas == null) {
			btnNormas = new JButton("REGLAS");
			btnNormas.setToolTipText("Obten una breve informacion detallada de las normas de juego");
			btnNormas.setMnemonic('R');
			btnNormas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarReglasJuego();
				}
			});
			btnNormas.setFont(new Font("Tahoma", Font.PLAIN, 28));
			btnNormas.setBackground(Color.WHITE);
			btnNormas.setBounds(421, 286, 233, 58);
		}
		return btnNormas;
	}
	
	protected void mostrarReglasJuego() {
		JOptionPane.showMessageDialog(null,textos.getString("txt57"));
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setMnemonic('H');
			mnHelp.add(getMntmContenidos());
			mnHelp.add(getSeparator_1());
			mnHelp.add(getMntmAcercaDe());
		}
		return mnHelp;
	}
	private JMenuItem getMntmContenidos() {
		if (mntmContenidos == null) {
			mntmContenidos = new JMenuItem("Contenidos de la ayuda");
			mntmContenidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmContenidos;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	private JMenuItem getMntmAcercaDe() {
		if (mntmAcercaDe == null) {
			mntmAcercaDe = new JMenuItem("Acerca De");
			mntmAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,textos.getString("txt58"),textos.getString("txt54"), JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return mntmAcercaDe;
	}
	private JMenu getMnIdioma() {
		if (mnIdioma == null) {
			mnIdioma = new JMenu("Idioma");
			mnIdioma.setMnemonic('I');
			mnIdioma.add(getMntmEspanol());
			mnIdioma.add(getMntmNewMenuItem_1());
		}
		return mnIdioma;
	}
	private JMenuItem getMntmEspanol() {
		if (mntmEspanol == null) {
			mntmEspanol = new JMenuItem("");
			mntmEspanol.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					toEspañol();
				}
			});
			mntmEspanol.setBackground(Color.WHITE);
			mntmEspanol.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/espana.png")));
		}
		return mntmEspanol;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					toIngles();
				}
			});
			mntmNewMenuItem_1.setBackground(Color.WHITE);
			mntmNewMenuItem_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/inglaterra.png")));
		}
		return mntmNewMenuItem_1;
	}
}


