package com.dddbomber.fishingjam.input;

import java.awt.Canvas;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FocusHandler implements FocusListener{
	
	public FocusHandler(Canvas c){
		c.addFocusListener(this);
	}
	public boolean hasFocus;
	@Override
	public void focusGained(FocusEvent arg0) {
		hasFocus = true;
	}
	@Override
	public void focusLost(FocusEvent arg0) {
		hasFocus = false;
	}
}
