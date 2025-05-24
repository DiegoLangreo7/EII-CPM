package uo294255.cpm.modulo.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uo294255.cpm.modulo.service.CANOSA;

import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Calendar;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class VentanaFechaReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelDatosFechaYDias;
	private JButton btnConfirmarFecha;
	private JLabel lblIntroducirFecha;
	private JSpinner spinnerFecha;
	private JLabel lblIntroducirDiasEstancia;
	private JSpinner spinnerDias;
	private CANOSA canosa;
	private VentanaPrincipal vp;
	ResourceBundle textos;

	public VentanaFechaReserva(CANOSA canosa, VentanaPrincipal ventanaPrincipal,Locale localizacion) {
		textos = ResourceBundle.getBundle("rcs/Textos",localizacion);
		this.canosa = canosa;
		vp  = ventanaPrincipal;
		vp.setEnabled(false);
		this.setTitle(textos.getString("txt73") + " : " + textos.getString("txt76")+ vp.getCastillo().getDenominacion() + " : "+ textos.getString("txt95"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaFechaReserva.class.getResource("/img/logo.png")));
		setResizable(false);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelDatosFechaYDias(), BorderLayout.CENTER);
		contentPane.add(getBtnConfirmarFecha(), BorderLayout.SOUTH);
		
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarVentana(); 
            }
        });
	}

	protected void cerrarVentana() {
		vp.setEnabled(true);
		this.dispose();
	}

	private JPanel getPanelDatosFechaYDias() {
		if (panelDatosFechaYDias == null) {
			panelDatosFechaYDias = new JPanel();
			panelDatosFechaYDias.setBackground(SystemColor.window);
			panelDatosFechaYDias.setLayout(null);
			panelDatosFechaYDias.add(getLblIntroducirFecha());
			panelDatosFechaYDias.add(getSpinnerFecha());
			panelDatosFechaYDias.add(getLblIntroducirDiasEstancia());
			panelDatosFechaYDias.add(getSpinnerDias());
		}
		return panelDatosFechaYDias;
	}
	private JButton getBtnConfirmarFecha() {
		if (btnConfirmarFecha == null) {
			btnConfirmarFecha = new JButton(textos.getString("txt100"));
			btnConfirmarFecha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	                confirmarFecha();
				}
			});
			btnConfirmarFecha.setBounds(new Rectangle(0, 0, 0, 100));
			btnConfirmarFecha.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, 90);
			btnConfirmarFecha.setBackground(SystemColor.activeCaption);
			btnConfirmarFecha.setMnemonic('F');
		}
		return btnConfirmarFecha;
	}
	protected void confirmarFecha() {
		
		Date fecha = (Date)getSpinnerFecha().getValue();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaString = formato.format(fecha);
        canosa.registrarFecha(fechaString, (int)getSpinnerDias().getValue());
        JOptionPane.showMessageDialog(contentPane, textos.getString("txt98") + " " +fechaString + " - " + textos.getString("txt99")  + (int)getSpinnerDias().getValue());
        vp.setEnabled(true);
        vp.getTextFieldPrecioTotal().setText(canosa.calcularPrecioFinal()+"€");
        vp.revisarValido();
        this.dispose();
	}

	private JLabel getLblIntroducirFecha() {
		if (lblIntroducirFecha == null) {
			lblIntroducirFecha = new JLabel(textos.getString("txt96"));
			lblIntroducirFecha.setLabelFor(getSpinnerFecha());
			lblIntroducirFecha.setDisplayedMnemonic('F');
			lblIntroducirFecha.setHorizontalAlignment(SwingConstants.CENTER);
			lblIntroducirFecha.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblIntroducirFecha.setBounds(10, 10, 406, 55);
		}
		return lblIntroducirFecha;
	}
	private JSpinner getSpinnerFecha() {
		if (spinnerFecha == null) {
	        spinnerFecha = new JSpinner();	 
	        spinnerFecha.setModel(new SpinnerDateModel(new Date(), new Date(), null, Calendar.DAY_OF_YEAR));
	        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy");
	        spinnerFecha.setEditor(dateEditor);
	        spinnerFecha.setFont(new Font("Tahoma", Font.PLAIN, 20));
			spinnerFecha.setBounds(121, 86, 188, 32);
		}
		return spinnerFecha;
	}
	private JLabel getLblIntroducirDiasEstancia() {
		if (lblIntroducirDiasEstancia == null) {
			lblIntroducirDiasEstancia = new JLabel(textos.getString("txt97"));
			lblIntroducirDiasEstancia.setLabelFor(getSpinnerDias());
			lblIntroducirDiasEstancia.setDisplayedMnemonic('I');
			lblIntroducirDiasEstancia.setHorizontalAlignment(SwingConstants.CENTER);
			lblIntroducirDiasEstancia.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblIntroducirDiasEstancia.setBounds(10, 128, 406, 55);
		}
		return lblIntroducirDiasEstancia;
	}
	private JSpinner getSpinnerDias() {
		if (spinnerDias == null) {
			spinnerDias = new JSpinner();
			spinnerDias.setBackground(SystemColor.window);
			spinnerDias.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
			spinnerDias.setFont(new Font("Tahoma", Font.PLAIN, 20));
			spinnerDias.setBounds(170, 178, 88, 32);
		}
		return spinnerDias;
	}
}
