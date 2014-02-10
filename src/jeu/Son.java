package jeu;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Map;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Son {
	protected MediaPlayer mediaPlayer;
	public Son(){
		
	}
	

	
	public void playMP3(String file){
		JFXPanel fxPanel = new JFXPanel();
		Media zik = new Media(file);
		mediaPlayer = new MediaPlayer(zik);
		mediaPlayer.play();
		}






}
