package com.dddbomber.fishingjam.menu;

import java.awt.event.KeyEvent;
import java.util.Random;

import com.dddbomber.fishingjam.anim.Animation;
import com.dddbomber.fishingjam.anim.BirdAnimation;
import com.dddbomber.fishingjam.anim.FishJumpAnimation;
import com.dddbomber.fishingjam.assets.Asset;
import com.dddbomber.fishingjam.assets.Screen;
import com.dddbomber.fishingjam.input.InputHandler;
import com.dddbomber.fishingjam.instance.Instance;
import com.dddbomber.fishingjam.instance.fish.Fish;

public class FishingMenu extends Menu{
	
	public boolean spaceToggle;
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
		if(input.keyboard.keys[KeyEvent.VK_RIGHT]){
			time += 15;
		}

		if(input.keyboard.keys[KeyEvent.VK_SPACE]){
			if(spaceToggle){
				spaceToggle = false;
				if(fishOnLine){
					fishCatchAmount += 10;
				}
			}
		}else{
			spaceToggle = true;
		}
		
		if(time >= 6800)endDay();
		for(int i = 0; i < Animation.animations.size(); i++){
			Animation a = Animation.animations.get(i);
			a.tick(input);
		}
		if(time % 30 == 0 && random.nextBoolean())Animation.animations.add(new FishJumpAnimation(100+random.nextInt(300), 200+random.nextInt(180)));
		int height = random.nextInt(40);
		if(time % 900 == 0 && random.nextBoolean()){
			for(int i = 0; i < 4; i++)Animation.animations.add(new BirdAnimation(-10-random.nextInt(100), height + i * 20));
		}
		if(fishOnLine){
			if(fishCatchAmount >= 200){
				fishOnLine = false;
				fishCatchAmount = 0;
				Instance.getInstance().fishInBoat.add(new Fish());
			}
			if(fishCatchAmount > 0 && time % 5 == 0)fishCatchAmount--;
		}else{
			if(random.nextBoolean() && time % 180 == 0){
				fishOnLine = true;
			}
		}
	}
	
	public Fish currentFish;

	public  boolean fishOnLine = false;
	public int fishCatchAmount = 0;
	
	Random random = new Random();
	
	public void endDay(){
		Instance.getInstance().nextDay();
	}
	
	public String getTime(){
		int hour = time/425+6;
		int minute = time%425/7;
		String minuteString = "" +minute;
		String hourString = "" +hour;
		if(minute < 10){
			minuteString = "0"+minute;
		}
		if(hour < 10){
			hourString = "0"+hour;
		}
		return hourString +":" +minuteString;
	}
	
	public void render(Screen screen, InputHandler input) {
		screen.drawScaled(Asset.bg, 300, 100, 0, time/8, 1, 50, 600, 4);
		
		if(time < 1038){
			screen.draw(Asset.sun, 300-48, 250-time/3, 0, 0, 96, 96);
		}else if(time > 6162){
			screen.draw(Asset.sun, 300-48, 200+(6162-time)/3, 96, 0, 96, 96);
		}
		

		//screen.fill(0, 200, 600, 200, 0xbcbcff, 100);
		screen.draw(Instance.getInstance().selectedBoat.render, 172, 85, 0, 128*((time/5)%8), 256, 128);
		for(int x = -2; x < 7; x++){
			int xo = x;
			while(xo < 0)xo += 2;
			int trans = (time-6162)/3;
			if(trans > 50)trans = 50;
			screen.drawTrans(Asset.cloud, x*200-time%400, 20+(xo%2)*20, 0, 0, 96, 32, 50);
		}

		screen.drawFlipped(screen, 0, 200, 0, 0, 600, 200, 100);

		for(int i = 0; i < 100; i++){
			int yo = i*2+(time%10 < 5 ? 1 : 0);
			screen.drawScaled(screen, 300, yo+200+1, 0, yo+200, 600, 1, 0.950+yo*0.0005, 1);
		}
		
		for(int x = -1; x < 3; x++){
			for(int y = 0; y < 4; y++){
				int anim = (time/10+x+y)%10;
				screen.drawTrans(Asset.wave, x*200+11  + time%200 + y%2*100, y*50+11 + 200, 0, 16*(anim), 77, 16, 25);
			}
		}

		for(int i = 0; i < Animation.animations.size(); i++){
			Animation a = Animation.animations.get(i);
			a.render(screen);
		}
		screen.fill(0, 200, 600, 2, 0x79AEEA, 100);

		screen.fill(0, 200, 600, 200, 0xbcbcff, 35);

		String msg = Instance.getInstance().fishInBoat.size()+"/25";
		screen.draw(msg, 600-msg.length()*14-2, 2, 0, 2);
		
		screen.draw(getTime(), 2, 2, 0, 2);
		
		
		//screen.draw(Asset.buttons, 0, 368, 0, 0, 32, 32);
		//screen.draw(Asset.buttons, 568, 368, 32, 0, 32, 32);
		
		if(fishOnLine){
			screen.fill(198, 28, 204, 20, 0, 100);
			screen.fill(200, 30, 200, 16, 0xff0000, 75);
			screen.fill(200, 30, fishCatchAmount, 16, 0x00ff00, 75);
		}
	}
}
