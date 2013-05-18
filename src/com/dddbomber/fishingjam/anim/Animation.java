package com.dddbomber.fishingjam.anim;

import java.util.ArrayList;

import com.dddbomber.fishingjam.assets.Screen;
import com.dddbomber.fishingjam.input.InputHandler;

public abstract class Animation {
	public static ArrayList<Animation> animations = new ArrayList<Animation>();
	
	public Animation(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int frame, delay, x, y;
	
	public abstract int getFrames();
	
	public abstract int getFrameDelay();
	
	public abstract void render(Screen screen);
	
	public void tick(InputHandler input){
		delay++;
		if(delay > getFrameDelay()){
			frame++;
			delay = 0;
			if(frame >= getFrames()){
				animations.remove(this);
			}
		}
	}
}
