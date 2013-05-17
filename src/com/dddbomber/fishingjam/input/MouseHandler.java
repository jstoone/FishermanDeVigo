package com.dddbomber.fishingjam.input;

import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.dddbomber.fishingjam.Game;

public class MouseHandler implements MouseListener, MouseMotionListener{
	
	public MouseHandler(Canvas c){
		c.addMouseListener(this);
		c.addMouseMotionListener(this);
	}
	
	public int x, y;
	
	public boolean left, right;

	@Override
	public void mouseDragged(MouseEvent arg0) {
		x = arg0.getX()/Game.SCALE;
		y = arg0.getY()/Game.SCALE;
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		x = arg0.getX()/Game.SCALE;
		y = arg0.getY()/Game.SCALE;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if(arg0.getButton() == 1)left = true;
		if(arg0.getButton() == 3)right = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(arg0.getButton() == 1)left = false;
		if(arg0.getButton() == 3)right = false;
	}
}
