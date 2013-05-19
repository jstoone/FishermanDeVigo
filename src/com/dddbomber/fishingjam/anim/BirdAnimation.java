package com.dddbomber.fishingjam.anim;

import com.dddbomber.fishingjam.assets.Asset;
import com.dddbomber.fishingjam.assets.Screen;
import com.dddbomber.fishingjam.input.InputHandler;

public class BirdAnimation extends Animation{

	public BirdAnimation(int x, int y) {
		super(x, y);
	}

	public int getFrames() {
		return 9;
	}

	public int getFrameDelay() {
		return 1;
	}

	public void render(Screen screen) {
		screen.draw(Asset.birdAnim, x, y, 0, frame*24, 24, 24);
		screen.drawFlipped(Asset.birdAnim, x, 400-y, 0, frame*24, 24, 24, 50);
	}

	public void tick(InputHandler input){
		delay++;
		if(delay > getFrameDelay()){
			frame++;
			delay = 0;
			if(frame >= getFrames()){
				frame = 0;
			}
		}
		x++;
		if(x > 600)animations.remove(this);
	}
}
