package uo294255.cpm.modulo;

import java.awt.EventQueue;

import javax.swing.UIManager;

import uo294255.cpm.modulo.service.*;
import uo294255.cpm.modulo.ui.VentanaPrincipal;

public class Main {
	public static void main(String[] args) {
		CANOSA SA = new CANOSA();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					VentanaPrincipal frame = new VentanaPrincipal(SA);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}