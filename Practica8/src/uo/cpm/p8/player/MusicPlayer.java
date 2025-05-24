package uo.cpm.p8.player;


import java.io.File;

import javazoom.jlgui.basicplayer.*;

public class MusicPlayer {
	private File cancionSonando;
	private double volumen;
	public static final double VOLMAX = 100;
	private BasicPlayer basicPlayer = null;
	
	public MusicPlayer(){
		basicPlayer = new BasicPlayer();
	}
	
	public void play (File file){
		try {
			cancionSonando=file;
			basicPlayer.open(file);
			basicPlayer.play();
		}
		catch (Exception e){	
			
		}
	}
	
	public void stop(){
		try {
			basicPlayer.stop();
		}
		catch (BasicPlayerException e){
		}
	}
	
	public void setVolume(double vol, double volMax){
		try{
			
			basicPlayer.setGain(vol/volMax);
		}
		catch (BasicPlayerException e){
		}
	}
	
	public File getCancionSonando() {
		return cancionSonando;
	}
	
	public double getVolumen() {
		return volumen;
	}
	
}
