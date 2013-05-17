package com.dddbomber.fishingjam.menu;

import java.awt.event.KeyEvent;

import com.dddbomber.fishingjam.Game;
import com.dddbomber.fishingjam.assets.Asset;
import com.dddbomber.fishingjam.assets.Screen;
import com.dddbomber.fishingjam.input.InputHandler;

public class TestMenu extends Menu{
	public double xScale, yScale;

	public void tick(InputHandler input) {
		if(input.keyboard.keys[KeyEvent.VK_DOWN])yScale += 0.01;
		if(input.keyboard.keys[KeyEvent.VK_UP])yScale -= 0.01;
		if(input.keyboard.keys[KeyEvent.VK_RIGHT])xScale += 0.01;
		if(input.keyboard.keys[KeyEvent.VK_LEFT])xScale -= 0.01;
	}

	public void render(Screen screen, InputHandler input) {
		screen.draw(Asset.map, 0, 0, 0, 0, 600, 400);
		
		screen.drawScaled(Asset.salmon, input.mouse.x, input.mouse.y, 0, 0, 256, 100, xScale, yScale);
	}

}
