package com.dddbomber.fishingjam.anim;

import com.dddbomber.fishingjam.assets.Asset;
import com.dddbomber.fishingjam.assets.Screen;
import com.dddbomber.fishingjam.input.InputHandler;

public class FishJumpAnimation extends Animation{

	public FishJumpAnimation(int x, int y) {
		super(x, y);
	}

	public int getFrames() {
		return 13;
	}

	public int getFrameDelay() {
		return 1;
	}

	public void render(Screen screen) {
		screen.draw(Asset.fishAnim, x, y, 0, frame*12, 25, 12);
		screen.drawFlipped(Asset.fishAnim, x, y+12, 0, frame*12, 25, 12, 50);
	}

	public void tick(InputHandler input){
		super.tick(input);
		x++;
	}
}
