package com.dddbomber.fishingjam.menu;

import java.awt.event.KeyEvent;

import com.dddbomber.fishingjam.assets.Screen;
import com.dddbomber.fishingjam.input.InputHandler;
import com.dddbomber.fishingjam.news.News;

public abstract class Menu {
	public static Menu menu = new NewspaperMenu(News.fish);
	
	public abstract void tick(InputHandler input);
	
	public abstract void render(Screen screen, InputHandler input);

	public void keyTyped(KeyEvent e) {
		
	}
}
