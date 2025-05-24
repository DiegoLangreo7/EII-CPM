package uo.cpm.p8.ui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import uo.cpm.p8.player.MusicPlayer;
import uo.cpm.p8.player.MyFile;

import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ListSelectionModel;
import javax.help.*;
import java.net.*;

public class VentanaPrincipal extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7416988583409030453L;

	private JFileChooser selector;

	private JPanel contentPane;
	private JPanel panelNorte;
	private JLabel lblTitulo;
	private JSlider sliderVolumen;
	private JPanel panelVolumen;
	private JLabel lblVolumen;
	private JTextField tfVolumen;
	private JPanel panelCentro;
	private JPanel panelLibreria;
	private JPanel panelPlay;
	private JPanel panelBotonesLibreria;
	private JButton btnAdd;
	private JButton btnDeleteLibrary;
	private JLabel lblLibreria;
	private JScrollPane scListLibrary;
	private JList<MyFile> listLibrary;
	private JLabel lblPlayList;
	private JPanel panelBotonesPlay;
	private JButton btnRewind;
	private JButton btnPlay;
	private JButton btnStop;
	private JButton btnForward;
	private JButton btnDeletePlay;
	private JScrollPane scListPlaylist;
	private JList<MyFile> listPlay;
	private DefaultListModel<MyFile> modelolistLibrary;
	private DefaultListModel<MyFile> modelolistPlay;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmOpen;
	private MusicPlayer mP;
	private JButton btnClearLibrary;
	private JButton btnClearPlay;
	private JMenu mnHelp;
	private JMenuItem mntmContents;

	/**
	 * Create the frame.
	 * @param mP 
	 */
	public VentanaPrincipal(MusicPlayer mP) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				minimoVentana();
			}
		});
		cargaAyuda();
		this.mP=mP;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logoTitulo.png")));
		setTitle("EII Music Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 648);
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelNorte(), BorderLayout.NORTH);
		contentPane.add(getPanelCentro(), BorderLayout.CENTER);
		setMinimumSize(new Dimension(551, 225));
	}
	
	private void minimoVentana() {
		Dimension d=this.getSize();
		System.out.println(d);
	}
	
	private JPanel getPanelNorte() {
		if (panelNorte == null) {
			panelNorte = new JPanel();
			panelNorte.setBackground(Color.BLACK);
			panelNorte.setLayout(new GridLayout(1, 3, 0, 0));
			panelNorte.add(getLblTitulo());
			panelNorte.add(getSliderVolumen());
			panelNorte.add(getPanelVolumen());
		}
		return panelNorte;
	}
	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("");
			lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
			lblTitulo.setForeground(Color.BLACK);
			lblTitulo.setBackground(Color.BLACK);
			lblTitulo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
		}
		return lblTitulo;
	}
	private JSlider getSliderVolumen() {
		if (sliderVolumen == null) {
			sliderVolumen = new JSlider();
			sliderVolumen.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					pintaYCambiaVol();
				}
			});
			sliderVolumen.setForeground(Color.WHITE);
			sliderVolumen.setBackground(Color.BLACK);
			sliderVolumen.setPaintTicks(true);
			sliderVolumen.setPaintLabels(true);
			sliderVolumen.setMinorTickSpacing(5);
			sliderVolumen.setMajorTickSpacing(20);
		}
		return sliderVolumen;
	}
	
	private void pintaYCambiaVol() {
		getTfVolumen().setText(String.valueOf(getSliderVolumen().getValue()));
		setVolumen(getSliderVolumen().getValue());
	}
	
	private void setVolumen(double vol) {
		double volMax=getSliderVolumen().getMaximum();
		mP.setVolume(vol, volMax);
	}
	
	private JPanel getPanelVolumen() {
		if (panelVolumen == null) {
			panelVolumen = new JPanel();
			panelVolumen.setBackground(Color.BLACK);
			panelVolumen.add(getLblVolumen());
			panelVolumen.add(getTfVolumen());
		}
		return panelVolumen;
	}
	private JLabel getLblVolumen() {
		if (lblVolumen == null) {
			lblVolumen = new JLabel("VOL:");
			lblVolumen.setForeground(new Color(0, 255, 0));
			lblVolumen.setBackground(Color.WHITE);
			lblVolumen.setFont(new Font("Tahoma", Font.PLAIN, 27));
		}
		return lblVolumen;
	}
	private JTextField getTfVolumen() {
		if (tfVolumen == null) {
			tfVolumen = new JTextField();
			tfVolumen.setForeground(Color.WHITE);
			tfVolumen.setBackground(Color.BLACK);
			tfVolumen.setFont(new Font("Tahoma", Font.PLAIN, 18));
			tfVolumen.setText("50");
			tfVolumen.setColumns(10);
		}
		return tfVolumen;
	}
	private JPanel getPanelCentro() {
		if (panelCentro == null) {
			panelCentro = new JPanel();
			panelCentro.setBackground(new Color(0, 0, 0));
			panelCentro.setLayout(new GridLayout(1, 2, 5, 0));
			panelCentro.add(getPanelLibreria());
			panelCentro.add(getPanelPlay());
		}
		return panelCentro;
	}
	private JPanel getPanelLibreria() {
		if (panelLibreria == null) {
			panelLibreria = new JPanel();
			panelLibreria.setBackground(Color.BLACK);
			panelLibreria.setLayout(new BorderLayout(0, 0));
			panelLibreria.add(getPanelBotonesLibreria(), BorderLayout.SOUTH);
			panelLibreria.add(getLblLibreria(), BorderLayout.NORTH);
			panelLibreria.add(getScListLibrary(), BorderLayout.CENTER);
		}
		return panelLibreria;
	}
	private JPanel getPanelPlay() {
		if (panelPlay == null) {
			panelPlay = new JPanel();
			panelPlay.setBackground(Color.BLACK);
			panelPlay.setLayout(new BorderLayout(0, 0));
			panelPlay.add(getLblPlayList(), BorderLayout.NORTH);
			panelPlay.add(getPanelBotonesPlay(), BorderLayout.SOUTH);
			panelPlay.add(getScListPlaylist(), BorderLayout.CENTER);
		}
		return panelPlay;
	}
	private JPanel getPanelBotonesLibreria() {
		if (panelBotonesLibreria == null) {
			panelBotonesLibreria = new JPanel();
			panelBotonesLibreria.setLayout(new GridLayout(1, 2, 0, 0));
			panelBotonesLibreria.add(getBtnAdd());
			panelBotonesLibreria.add(getBtnDeleteLibrary());
			panelBotonesLibreria.add(getBtnClearLibrary());
		}
		return panelBotonesLibreria;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add to PlayList");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					seleccionarCanciones();
				}
			});
			btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return btnAdd;
	}
	
	private void seleccionarCanciones() {
		for(int i=0;i<getListLibrary().getSelectedValuesList().size();i++) {
			if(modelolistPlay.contains(getListLibrary().getSelectedValuesList().get(i))) {
				
			}else {
				modelolistPlay.addElement(getListLibrary().getSelectedValuesList().get(i));
			}
		}
	}
	
	
	private JButton getBtnDeleteLibrary() {
		if (btnDeleteLibrary == null) {
			btnDeleteLibrary = new JButton("Del");
			btnDeleteLibrary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return btnDeleteLibrary;
	}
	private JLabel getLblLibreria() {
		if (lblLibreria == null) {
			lblLibreria = new JLabel("\u266ALibrary:");
			lblLibreria.setBackground(Color.BLACK);
			lblLibreria.setForeground(Color.GREEN);
			lblLibreria.setFont(new Font("Arial Black", Font.PLAIN, 16));
		}
		return lblLibreria;
	}
	private JScrollPane getScListLibrary() {
		if (scListLibrary == null) {
			scListLibrary = new JScrollPane();
			scListLibrary.setBorder(new LineBorder(new Color(139, 0, 139), 4));
			scListLibrary.setViewportView(getListLibrary());
		}
		return scListLibrary;
	}
	private JList<MyFile> getListLibrary() {
		if (listLibrary == null) {
			modelolistLibrary=new DefaultListModel<MyFile>();
			listLibrary = new JList<MyFile>(modelolistLibrary);
			listLibrary.setBackground(Color.BLACK);
			listLibrary.setForeground(new Color(0, 255, 0));
		}
		return listLibrary;
	}
	private JLabel getLblPlayList() {
		if (lblPlayList == null) {
			lblPlayList = new JLabel("\u266APlayList:");
			lblPlayList.setForeground(Color.GREEN);
			lblPlayList.setFont(new Font("Arial Black", Font.PLAIN, 16));
		}
		return lblPlayList;
	}
	private JPanel getPanelBotonesPlay() {
		if (panelBotonesPlay == null) {
			panelBotonesPlay = new JPanel();
			panelBotonesPlay.setLayout(new GridLayout(1, 5, 0, 0));
			panelBotonesPlay.add(getBtnRewind());
			panelBotonesPlay.add(getBtnPlay());
			panelBotonesPlay.add(getBtnStop());
			panelBotonesPlay.add(getBtnForward());
			panelBotonesPlay.add(getBtnDeletePlay());
			panelBotonesPlay.add(getBtnClearPlay());
		}
		return panelBotonesPlay;
	}
	private JButton getBtnRewind() {
		if (btnRewind == null) {
			btnRewind = new JButton("\u25C4\u25C4");
			btnRewind.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rewind();
				}
			});
			btnRewind.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btnRewind;
	}
	
	
	private void rewind() {
		if(getListPlay().getSelectedIndex()==0) {
			getListPlay().setSelectedIndex(modelolistPlay.size()-1);
		}else {
			getListPlay().setSelectedIndex(getListPlay().getSelectedIndex()-1);	
		}
		mP.play(getListPlay().getSelectedValue().getF());
	}
	
	
	private JButton getBtnPlay() {
		if (btnPlay == null) {
			btnPlay = new JButton("\u25BA");
			btnPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					play();
				}
			});
			btnPlay.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btnPlay;
	}
	
	
	private void play() {
		if(getListPlay().getSelectedIndex()==-1) {
			getListPlay().setSelectedIndex(0);
		}
		mP.play(getListPlay().getSelectedValue().getF());
	}
	
	
	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("\u25A0");
			btnStop.setFont(new Font("Dialog", Font.BOLD, 16));
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					stop();
				}
			});
		}
		return btnStop;
	}
	
	private void stop() {
		mP.stop();
	}
	
	
	private JButton getBtnForward() {
		if (btnForward == null) {
			btnForward = new JButton("\u25BA\u25BA");
			btnForward.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					siguiente();
				}
			});
			btnForward.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btnForward;
	}
	
	
	public void siguiente() {
	   if(getListPlay().getSelectedIndex()!=modelolistPlay.size()-1) {
			getListPlay().setSelectedIndex(getListPlay().getSelectedIndex()+1);
		}else {
			getListPlay().setSelectedIndex(0);	
		}
		mP.play(getListPlay().getSelectedValue().getF());
	}
	
	
	private JButton getBtnDeletePlay() {
		if (btnDeletePlay == null) {
			btnDeletePlay = new JButton("Del");
			btnDeletePlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borrarPlay();
				}
			});
			btnDeletePlay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return btnDeletePlay;
	}
	
	private void borrarPlay() {
		if(mP.getCancionSonando()==getListPlay().getSelectedValue().getF()) {
			mP.stop();
		}
		for(int i=0;i<getListLibrary().getSelectedValuesList().size();i++) {
			modelolistPlay.removeElement(getListPlay().getSelectedValuesList().get(i));
		}
	}
	
	
	private JScrollPane getScListPlaylist() {
		if (scListPlaylist == null) {
			scListPlaylist = new JScrollPane();
			scListPlaylist.setBorder(new LineBorder(new Color(139, 0, 139), 4));
			scListPlaylist.setViewportView(getListPlay());
		}
		return scListPlaylist;
	}
	private JList<MyFile> getListPlay() {
		if (listPlay == null) {
			modelolistPlay=new DefaultListModel<MyFile>();
			listPlay = new JList<MyFile>(modelolistPlay);
			listPlay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listPlay.setForeground(Color.GREEN);
			listPlay.setBackground(Color.BLACK);
		}
		return listPlay;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
		}
		return mnFile;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirFicheros();
				}
			});
		}
		return mntmOpen;
	}
	
	private void abrirFicheros() {
		int respuesta=getSelector().showOpenDialog(null);
		if(respuesta==JFileChooser.APPROVE_OPTION) {
			for(int i=0;i<getSelector().getSelectedFiles().length;i++) {
				modelolistLibrary.addElement(new MyFile(getSelector().getSelectedFiles()[i]));
			}
		}
	}

	public JFileChooser getSelector() {
		if (selector == null) {
			selector=new JFileChooser();
			selector.setMultiSelectionEnabled(true);
			selector.setFileFilter(new FileNameExtensionFilter("Archivos mp3","mp3"));
			String p=System.getProperty("user.home")+"/Desktop";
			selector.setCurrentDirectory(new File(p));
			
			//Este lo fija en el directorio de direcci�n del programa
			//String p=System.getProperty("user.dir");
			//selector.setCurrentDirectory(new File(p));
		}
		return selector;
	}
	private JButton getBtnClearLibrary() {
		if (btnClearLibrary == null) {
			btnClearLibrary = new JButton("Clear");
			btnClearLibrary.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clearLibrary();
				}
			});
		}
		return btnClearLibrary;
	}
	
	public void clearLibrary(){
		modelolistLibrary.clear();
	}
	
	public void clearPlaylist(){
		modelolistPlay.clear();
	}
	
	
	private JButton getBtnClearPlay() {
		if (btnClearPlay == null) {
			btnClearPlay = new JButton("Clear");
			btnClearPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clearPlaylist();
				}
			});
		}
		return btnClearPlay;
	}
	
	private void cargaAyuda(){

		   URL hsURL;
		   HelpSet hs;

		    try {
			    	File fichero = new File("help/ayuda.hs");
			    	hsURL = fichero.toURI().toURL();
			        hs = new HelpSet(null, hsURL);
			      }

		    catch (Exception e){
		      System.out.println("Ayuda no encontrada");
		      return;
		   }

		   HelpBroker hb = hs.createHelpBroker();
		   hb.initPresentation();

		   hb.enableHelpKey(getRootPane(),"introducción", hs);
		   hb.enableHelpOnButton(getMntmContents(), "introducción", hs);
		   hb.enableHelp(getListLibrary(), "añadir", hs);
		   hb.enableHelp(getListPlay(), "reproducir", hs);
		 }
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmContents());
		}
		return mnHelp;
	}
	private JMenuItem getMntmContents() {
		if (mntmContents == null) {
			mntmContents = new JMenuItem("Contents");
		}
		return mntmContents;
	}
}
