package com.dddbomber.fishingjam.menu;

import com.dddbomber.fishingjam.assets.Asset;
import com.dddbomber.fishingjam.assets.Screen;
import com.dddbomber.fishingjam.input.InputHandler;
import com.dddbomber.fishingjam.news.News;

public class NewspaperMenu extends Menu{

	public String date, headline;
	public boolean play;
	
	public NewspaperMenu(News n){
		this.date = n.date;
		this.headline = n.headline;
	}
	
	public void tick(InputHandler input) {
		play = false;
		if(input.mouse.y >= 15 && input.mouse.y <= 65){
			if(input.mouse.x >= 100 && input.mouse.x <= 500){
				play = true;
			}
		}
		if(input.mouse.left && play && yOffset == 0){
			Menu.menu = new FishingMenu();
		}
		if(yOffset > 0)yOffset-=5;
	}
	
	public int yOffset = 300;

	public void render(Screen screen, InputHandler input) {
		screen.fill(0, 0, 600, 400, 0x949494, 100);
		screen.drawScaled(Asset.newspaper, 300, 250+yOffset, 0, 0, 80, 60, 5, 5);
		
		screen.draw(date, 110, 110+yOffset, 0x725C45, 1.5);
		
		screen.draw(headline, 300-headline.length()*7, 138+yOffset, 0x725C45, 2);
		
		if(yOffset != 0)return;
		
		screen.drawScaled(Asset.title, 300, 40, 0, play ? 50 : 0, 200, 50, 2, 1);
		
		String msg = "CONTINUE";
		screen.draw(msg, 300-msg.length()*14, 29, 0, 4);
	}

}
