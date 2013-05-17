package com.dddbomber.fishingjam.instance.fish;

import com.dddbomber.fishingjam.assets.*;

public class Fish {
	public double length = 1.0;
	public double weight = 1.0;
	
	public void render(Screen screen){
		screen.drawScaled(Asset.salmon, 300, 200, 0, 0, 256, 100, length, weight);
	}
	
	public double getValue(){
		return length+weight;
	}
}
