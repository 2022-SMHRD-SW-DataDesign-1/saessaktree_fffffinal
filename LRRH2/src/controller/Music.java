package controller;

import javazoom.jl.player.MP3Player;
public class Music {

	public void music() {
	
		MP3Player mp3 = new MP3Player();
	
		mp3.play(".music\\mainBGM.mp3");
		mp3.play(".music\\공포브금10초1번.mp3");
		mp3.play(".music\\공포브금10초2번.mp3");
		mp3.play(".music\\딩동댕.mp3");
		mp3.play(".music\\땡.mp3");
		mp3.play(".music\\시간은흘러.mp3");
		mp3.play(".music\\happyending.mp3");
		
	}
	
}
