package uo294255.cpm.modulo.ui;

import javax.swing.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.*;
import javax.swing.border.LineBorder;

import uo294255.cpm.modulo.model.Castillo;

public class RecorteInfoCastillo extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblPais;
	private JLabel lblImagen;
	private JButton btAnadir;
	private VentanaPrincipal vP;
	private Castillo castillo;
	private JLabel lblPrecio;
	private ImageIcon imagen = null;
	private Adaptar aD;
	private JPanel panelDatos;
	private JPanel panelTexto;
	private JTextField textNombreCastillo;
	private JPanel panelParaBoton;
	private JPanel panelPaLaFoto;
	ResourceBundle textos;

	public RecorteInfoCastillo(VentanaPrincipal vp, Castillo c,Locale localizacion)  {
		textos = ResourceBundle.getBundle("rcs/Textos",localizacion);
		this.vP = vp;
		this.castillo = c;
		aD = new Adaptar();
		setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		setBackground(Color.white);
		setLayout(new GridLayout(1,0,0,0));
		add(getLblImagen());
		add(getPanelDatos());
	}

	private JLabel getLbPais() {
		if (lblPais == null) {
			lblPais = new JLabel();
			lblPais.setHorizontalAlignment(SwingConstants.CENTER);
			lblPais.setBounds(79, 31, 58, 13);
			lblPais.setBackground(Color.WHITE);
			lblPais.setIcon(new ImageIcon (RecorteInfoCastillo.class.getResource("/img/"+castillo.getCodigo().substring(0, 3)+".png")));
			}
		return lblPais;
	}
	
	private JLabel getLblImagen() {
		if (lblImagen == null) {
			lblImagen = new JLabel("");
			lblImagen.setFocusable(false);
			imagen = new ImageIcon (RecorteInfoCastillo.class.getResource("/img/"+castillo.getCodigo()+".png"));
			lblImagen.setBackground(Color.WHITE);
			lblImagen.addComponentListener(aD);
		}
		return lblImagen;
	}

	private JButton getBtAnadir() {
		if (btAnadir == null) {
			btAnadir = new JButton(textos.getString("txt22"));
			btAnadir.setToolTipText(textos.getString("txt82"));
			btAnadir.setFont(new Font("Tahoma", Font.BOLD, 20));
			btAnadir.setBackground(Color.WHITE);
			btAnadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vP.mostrarInfoCastillo(castillo);
				}
			});
		}
		return btAnadir;
	}
	
	private JLabel getLblPrecio() {
		if (lblPrecio == null) {
			lblPrecio = new JLabel();
			lblPrecio.setBounds(16, 5, 25, 21);
			lblPrecio.setFont(new Font("Arial Black", Font.BOLD, 14));
			lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
			lblPrecio.setText(String.valueOf(castillo.getPrecio()));
		}
		return lblPrecio;
	}
	
	private void adaptarImagenLabel(){
		  Image imgOriginal = imagen.getImage();
		  Image imgEscalada = imgOriginal.getScaledInstance(getLblImagen().getWidth(), (int) (250),Image.SCALE_SMOOTH);
		  getLblImagen().setIcon(new ImageIcon(imgEscalada));
		}
	
	class Adaptar extends ComponentAdapter {
		@Override
		public void componentResized(ComponentEvent e) {
			adaptarImagenLabel();
		}
	}
	private JPanel getPanelDatos() {
		if (panelDatos == null) {
			panelDatos = new JPanel();
			panelDatos.setBackground(Color.WHITE);
			panelDatos.setLayout(new GridLayout(1,0,0,0));
			panelDatos.add(getPanelTexto());
			panelDatos.add(getPanelParaBoton());
			
		}
		return panelDatos;
	}
	private JPanel getPanelTexto() {
		if (panelTexto == null) {
			panelTexto = new JPanel();
			panelTexto.setBackground(Color.WHITE);
			panelTexto.setBounds(142, 148, -61, -110);
			panelTexto.setLayout(new GridLayout(3,1,0,0));
			panelTexto.add(getTextNombreCastillo());
			panelTexto.add(getPanelPaLaFoto());
			panelTexto.add(getLblPrecio());
		}
		return panelTexto;
	}

	private JTextField getTextNombreCastillo() {
		if (textNombreCastillo == null) {
			textNombreCastillo = new JTextField();
			textNombreCastillo.setText(castillo.getDenominacion());
			textNombreCastillo.setHorizontalAlignment(SwingConstants.CENTER);
			textNombreCastillo.setFont(new Font("Arial Black", Font.PLAIN, 13));
			textNombreCastillo.setEditable(false);
			textNombreCastillo.setColumns(10);
			textNombreCastillo.setBorder(null);
			textNombreCastillo.setBackground(Color.WHITE);
		}
		return textNombreCastillo;
	}
	private JPanel getPanelParaBoton() {
		if (panelParaBoton == null) {
			panelParaBoton = new JPanel();
			panelParaBoton.setBackground(Color.WHITE);
			panelParaBoton.setLayout(new BoxLayout(panelParaBoton, BoxLayout.X_AXIS));
			panelParaBoton.add(getBtAnadir());
		}
		return panelParaBoton;
	}
	private JPanel getPanelPaLaFoto() {
		if (panelPaLaFoto == null) {
			panelPaLaFoto = new JPanel();
			panelPaLaFoto.setBackground(SystemColor.window);
			panelPaLaFoto.setLayout(new BorderLayout(0, 0));
			panelPaLaFoto.add(getLbPais());
		}
		return panelPaLaFoto;
	}
}
