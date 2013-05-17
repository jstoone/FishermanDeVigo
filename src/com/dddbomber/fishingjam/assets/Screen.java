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
	
	public void draw(Bitmap image, int xPos, int yPos, int xo, int yo, int w , int h){
		for(int y = 0; y < h; y++){
			int yPix = y+yPos;
			if(yPix < 0 || yPix >= height)continue;
			for(int x = 0; x < w; x++){
				int xPix = x+xPos;
				if(xPix < 0 || xPix >= width)continue;
				
				int src = image.pixels[(x+xo) + (y+yo) * image.width];
				if(src != -2)pixels[xPix + yPix * width] = src;
			}
		}
	}
	
	public void drawScaled(Bitmap image, int xPos, int yPos, int xo, int yo, int w , int h, double xScale, double yScale){
		w *= xScale;
		h *= yScale;
		for(int y = 0; y < h; y++){
			int yPix = y+yPos-h/2;
			if(yPix < 0 || yPix >= height)continue;
			for(int x = 0; x < w; x++){
				int xPix = x+xPos-w/2;
				if(xPix < 0 || xPix >= width)continue;

				int xDraw = (int) (x/xScale+xo);
				int yDraw = (int) (y/yScale+yo);
				int src = image.pixels[(int) (xDraw + yDraw * image.width)];
				if(src != -2)pixels[xPix + yPix * width] = src;
			}
		}
	}
}
