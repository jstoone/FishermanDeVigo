package com.dddbomber.fishingjam.menu;

import java.awt.event.KeyEvent;

import com.dddbomber.fishingjam.assets.Screen;
import com.dddbomber.fishingjam.input.InputHandler;

public abstract class Menu {
	public static Menu menu = new MainMenu();
	
	public abstract void tick(InputHandler input);
	
	public abstract void render(Screen screen, InputHandler input);

	public void keyTyped(KeyEvent e) {
		
	}
	
	public boolean shouldTickTime = true;
	
	public int time, animTime;
	
	public int delay = 30;
	
	public boolean canTick(){
		if(delay > 0)delay--;
		if(shouldTickTime)time++;
		animTime++;
		return delay == 0;
	}
}
