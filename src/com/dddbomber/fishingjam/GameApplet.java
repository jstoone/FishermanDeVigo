package com.dddbomber.fishingjam;

import java.applet.Applet;
import java.awt.BorderLayout;

public class GameApplet extends Applet{
	private static final long serialVersionUID = 1L;
	Game game = new Game();
	
	public void init(){
		setSize(Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);
		setLayout(new BorderLayout());
		add(game, BorderLayout.CENTER);
	}
	
	public void start(){
		game.start();
	}
	
	public void stop(){
		
	}
}