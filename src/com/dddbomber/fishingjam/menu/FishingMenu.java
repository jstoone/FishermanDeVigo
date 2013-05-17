package com.dddbomber.fishingjam.menu;

import java.util.ArrayList;

import com.dddbomber.fishingjam.assets.Asset;
import com.dddbomber.fishingjam.assets.Screen;
import com.dddbomber.fishingjam.input.InputHandler;
import com.dddbomber.fishingjam.instance.fish.Fish;

public class FishingMenu extends Menu{
	
	Fish fish = new Fish();
	
	public void tick(InputHandler input) {
		if(input.mouse.left){
			if(input.mouse.y >= 368){
				if(input.mouse.x <= 32){
					System.out.println("NO");
				}
				if(input.mouse.x >= 568){
					System.out.println("YES");
				}
			}
		}
		time++;
		if(time > 7200)time = 0;
	}
	
	public int time;

	public void render(Screen screen, InputHandler input) {
		screen.drawScaled(Asset.bg, 300, 100, 0, time/8, 1, 50, 600, 4);
		if(time < 888){
			screen.draw(Asset.sun, 300-48, 200-time/3, 0, 0, 96, 96);
		}
		screen.drawFlipped(screen, 0, 200, 0, 0, 600, 200);
		screen.fill(0, 201, 600, 200, 0xbcbcff, 25);
		
		//fish.render(screen);
		
		screen.draw(Asset.buttons, 0, 368, 0, 0, 32, 32);
		screen.draw(Asset.buttons, 568, 368, 32, 0, 32, 32);
	}
}
