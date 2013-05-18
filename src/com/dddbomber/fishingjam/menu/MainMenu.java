package com.dddbomber.fishingjam.menu;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import com.dddbomber.fishingjam.anim.Animation;
import com.dddbomber.fishingjam.anim.FishJumpAnimation;
import com.dddbomber.fishingjam.assets.Asset;
import com.dddbomber.fishingjam.assets.Bitmap;
import com.dddbomber.fishingjam.assets.Screen;
import com.dddbomber.fishingjam.input.InputHandler;
import com.dddbomber.fishingjam.instance.fish.Fish;

public class MainMenu extends Menu{

	public boolean play;

	public void tick(InputHandler input) {
		play = false;
		if(input.mouse.y >= 315 && input.mouse.y <= 365){
			if(input.mouse.x >= 200 && input.mouse.x <= 400){
				play = true;
			}
		}
		if(input.mouse.left){
			if(play)Menu.menu = new FishingMenu();
		}
		for(int i = 0; i < Animation.animations.size(); i++){
			Animation a = Animation.animations.get(i);
			a.tick(input);
		}
		animTime++;
		if(random.nextInt(30) == 0 && random.nextBoolean())Animation.animations.add(new FishJumpAnimation(100+random.nextInt(300), 200+random.nextInt(180)));

		
	}
	
	public int time = 6450, animTime;

	Random random = new Random();
	
	public void render(Screen screen, InputHandler input) {
		screen.drawScaled(Asset.bg, 300, 100, 0, time/8, 1, 50, 600, 4);
		if(time < 1038){
			screen.draw(Asset.sun, 300-48, 250-time/3, 0, 0, 96, 96);
		}if(time > 6162){
			screen.draw(Asset.sun, 300-48, 200+(6162-time)/3, 96, 0, 96, 96);
		}
		

		//screen.fill(0, 200, 600, 200, 0xbcbcff, 100);
		screen.draw(Asset.smallRowboat, 172, 85, 0, 128*((animTime/5)%8), 256, 128);
		for(int x = -2; x < 7; x++){
			int xo = x;
			while(xo < 0)xo += 2;
			screen.drawTrans(Asset.cloud, x*200-animTime%400, 20+(xo%2)*20, 0, 0, 96, 32, 50);
		}

		screen.drawFlipped(screen, 0, 200, 0, 0, 600, 200, 100);

		for(int i = 0; i < 100; i++){
			int yo = i*2+(animTime%10 < 5 ? 1 : 0);
			screen.drawScaled(screen, 300, yo+200+1, 0, yo+200, 600, 1, 0.950+yo*0.0005, 1);
		}
		
		for(int x = -1; x < 3; x++){
			for(int y = 0; y < 4; y++){
				int anim = (animTime/10+x+y)%10;
				screen.drawTrans(Asset.wave, x*200+11  + animTime%200 + y%2*100, y*50+11 + 200, 0, 16*(anim), 77, 16, 25);
			}
		}

		for(int i = 0; i < Animation.animations.size(); i++){
			Animation a = Animation.animations.get(i);
			a.render(screen);
		}
		screen.fill(0, 200, 600, 2, 0x79AEEA, 100);

		screen.fill(0, 200, 600, 200, 0xbcbcff, 25);

		screen.drawScaled(Asset.title, 300, 35, 0, 0, 200, 50, 2.5, 1);
		
		String msg = "Fisherman De Vigo";
		screen.draw(msg, 300-msg.length()*14, 24, 0, 4);
		

		screen.drawScaled(Asset.title, 300, 340, 0, play ? 50 : 0, 200, 50, 1, 1);
		
		msg = "Play";
		screen.draw(msg, 300-msg.length()*14, 329, 0, 4);
		
		msg = "By DDDBOMBER and JStoone";
		screen.draw(msg, 300-msg.length()*7, 380, 0, 2);
	}
}
