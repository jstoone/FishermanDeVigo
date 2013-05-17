package com.dddbomber.fishingjam.menu;

import com.dddbomber.fishingjam.assets.Asset;
import com.dddbomber.fishingjam.assets.Screen;
import com.dddbomber.fishingjam.fish.Fish;
import com.dddbomber.fishingjam.input.InputHandler;

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
	}

	public void render(Screen screen, InputHandler input) {
		for(int i = 0; i < screen.pixels.length; i++)screen.pixels[i] = 0;
		fish.render(screen);
		
		screen.draw(Asset.buttons, 0, 368, 0, 0, 32, 32);
		screen.draw(Asset.buttons, 568, 368, 32, 0, 32, 32);
	}
	
}
