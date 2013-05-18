package com.dddbomber.fishingjam.menu;

import java.awt.event.KeyEvent;

import com.dddbomber.fishingjam.assets.Asset;
import com.dddbomber.fishingjam.assets.Screen;
import com.dddbomber.fishingjam.input.InputHandler;
import com.dddbomber.fishingjam.instance.Instance;
import com.dddbomber.fishingjam.instance.family.Person;
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
		if(input.mouse.left && play){
			Menu.menu = new FishingMenu();
		}
	}

	public void render(Screen screen, InputHandler input) {
		screen.fill(0, 0, 600, 400, 0, 100);
		screen.drawScaled(Asset.newspaper, 300, 250, 0, 0, 80, 60, 5, 5);
		
		screen.draw(date, 110, 110, 0x725C45, 1.5);
		
		screen.draw(headline, 300-headline.length()*7, 138, 0x725C45, 2);
		
		screen.drawScaled(Asset.title, 300, 40, 0, play ? 50 : 0, 200, 50, 2, 1);
		
		String msg = "CONTINUE";
		screen.draw(msg, 300-msg.length()*14, 29, 0, 4);
	}

}
