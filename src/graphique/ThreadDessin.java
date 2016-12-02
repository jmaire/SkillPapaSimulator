package graphique;

import java.util.Date;

public class ThreadDessin extends Thread {

	Game game;
	
	public ThreadDessin(Game game){
		this.game = game;
	}
	public void run(){
		Date time = new Date();
		long last = time.getTime();
		while(true) {
			time = new Date();
			game.draw(time.getTime() - last);
			last = time.getTime();
		}
	}
}
