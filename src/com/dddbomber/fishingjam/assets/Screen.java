package com.dddbomber.fishingjam.assets;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen extends Bitmap{
	
	private BufferedImage img;

	public Screen(int width, int height) {
		super(width, height);
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
	}
	
	public BufferedImage getImage(){
		return img;
	}
}
