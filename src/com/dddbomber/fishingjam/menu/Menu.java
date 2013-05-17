package com.dddbomber.fishingjam.menu;

import com.dddbomber.fishingjam.assets.Screen;
import com.dddbomber.fishingjam.input.InputHandler;

public abstract class Menu {
	
	public static Menu menu = new TestMenu();
	
	public abstract void tick(InputHandler input);
	
	public abstract void render(Screen screen, InputHandler input);
}
