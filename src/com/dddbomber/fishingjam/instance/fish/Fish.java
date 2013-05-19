package com.dddbomber.fishingjam.instance.fish;

import java.util.Random;

import com.dddbomber.fishingjam.assets.*;

public class Fish {
	public double length = 1.0;
	public double weight = 1.0;
	
	Random random = new Random();
	
	public int type = random.nextInt(2);
	
	public void render(Screen screen){
		screen.drawScaled(getSprite(), 300, 200, 0, 0, 256, 100, length, weight);
	}
	
	public double getValue(){
		return length+weight;
	}
	
	public Bitmap getSprite(){
		if(type == 0)return Asset.salmon;
		if(type == 1)return Asset.atlantic_bluefin;
		return null;
	}
}
