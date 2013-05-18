package com.dddbomber.fishingjam.menu;

import java.awt.event.KeyEvent;

import com.dddbomber.fishingjam.assets.Asset;
import com.dddbomber.fishingjam.assets.Screen;
import com.dddbomber.fishingjam.input.InputHandler;
import com.dddbomber.fishingjam.instance.Instance;
import com.dddbomber.fishingjam.instance.family.Person;

public class FamilyMenu extends Menu{
	
	public Menu nextMenu;
	
	public FamilyMenu(Menu nextMenu){
		this.nextMenu = nextMenu;
	}

	public boolean toggle = false, play;
	
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
		
		boolean up = input.keyboard.keys[KeyEvent.VK_UP];
		boolean down = input.keyboard.keys[KeyEvent.VK_DOWN];
		if(!up && !down)toggle = false;
		if(toggle)return;
		if(up || down){
			toggle = true;
			Person p = Instance.getInstance().family.get(selected);
			if(p.name.length() == 0){
				p.name = "Unnamed";
			}
		}
		if(up){
			if(selected > 0)selected--;
		}else if(down){
			if(selected < Instance.getInstance().family.size()-1)selected++;
		}
	}

	public int selected = 0;


	public void keyTyped(KeyEvent e) {
		Person p = Instance.getInstance().family.get(selected);
		if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE){
			if(p.name.length() < 40)p.name += e.getKeyChar();
		}else if(p.name.length() > 0){
			p.name = p.name.substring(0, p.name.length()-1);
		}
	}

	public void render(Screen screen, InputHandler input) {
		screen.fill(0, 0, 600, 400, 0, 100);
		for(int i = 0; i < Instance.getInstance().family.size(); i++){
			Person p = Instance.getInstance().family.get(i);
			i += 2;
			if(i == selected)screen.fill(1, i*64+1, 598, 14, 0xbcbcbc, 100);
			screen.draw(p.name, 2, i*64+2, 0xffffff, 2);

			screen.draw(Asset.counter, 2, i*64+20, (int)(8-p.health/12.5)*32, 0, 32, 32);
			screen.draw("Health", 40, i*64+30, 0xffffff, 2);

			screen.draw(Asset.counter, 130, i*64+20, (int)(8-p.hunger/12.5)*32, 0, 32, 32);
			screen.draw("Hunger", 168, i*64+30, 0xffffff, 2);

			screen.draw(Asset.counter, 258, i*64+20, (int)(8-p.happiness/12.5)*32, 0, 32, 32);
			screen.draw("Happy", 296, i*64+30, 0xffffff, 2);
			i -= 2;
		}
		screen.drawScaled(Asset.title, 300, 40, 0, play ? 50 : 0, 200, 50, 2, 1);

		String msg = "CONTINUE";
		screen.draw(msg, 300-msg.length()*14, 29, 0, 4);
	}

}
