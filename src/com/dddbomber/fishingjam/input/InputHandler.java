package com.dddbomber.fishingjam.input;

import java.awt.Canvas;

public class InputHandler {
	public KeyboardHandler keyboard;
	public MouseHandler mouse;
	
	public InputHandler(Canvas c){
		keyboard = new KeyboardHandler(c);
		mouse = new MouseHandler(c);
	}
}
