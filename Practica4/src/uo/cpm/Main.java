/**
 * 
 */
package uo.cpm;

import java.awt.EventQueue;

import javax.swing.UIManager;

import uo.cpm.service.McDonalds;
import uo.cpm.ui.VPrincipal;

/**
 * @author UO294255
 *
 */
public class Main {

	/**
	 * 
	 */
	public static void main(String[] args){
		McDonalds mc = new McDonalds();
		
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					VPrincipal frame = new VPrincipal(mc);
					frame.setVisible(true);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}); 
	}

}
