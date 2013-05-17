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
	
	public void drawFlipped(Bitmap image, int xPos, int yPos, int xo, int yo, int w , int h){
		for(int y = 0; y < h; y++){
			int yPix = y+yPos;
			if(yPix < 0 || yPix >= height)continue;
			for(int x = 0; x < w; x++){
				int xPix = x+xPos;
				if(xPix < 0 || xPix >= width)continue;
				
				int src = image.pixels[(x+xo) + (h-y+yo) * image.width];
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
	
	public void drawRotated(Bitmap bitmap, int xOffs, int yOffs, int xo, int yo, int w, int h, double rotation) {
        final double radians = Math.toRadians(rotation);
        final double cos = Math.cos(radians);
        final double sin = Math.sin(radians);
        for(int y = 0; y < w; y++){
            int yPix = y + yo;
            for(int x = 0; x < h; x++){
                int xPix = x + xo;

                int centerX = w / 2;
                int centerY = h / 2;
                int m = x - centerX;
                int n = y - centerY;
                int j = ((int) (m * cos + n * sin)) + centerX;
                int k = ((int) (n * cos - m * sin)) + centerY;

                int src = bitmap.pixels[xPix + yPix * bitmap.width];

                int xDraw = xOffs+j;
                int yDraw = yOffs+k;

                if(xDraw < 0 || xDraw >= width-1 || yDraw < 0 || yDraw >= height-1)continue;
                if(src != -2){
                	pixels[xDraw + yDraw * width] = src;
                	if(x < w-1)pixels[xDraw + 1 + yDraw * width] = src;
                	if(y < h-1)pixels[xDraw + (yDraw + 1) * width] = src;
                }

            }
        }
    }
	
	public void drawTrans(Bitmap image, int xPos, int yPos, int xo, int yo, int w , int h, int amount){
		for(int y = 0; y < h; y++){
			int yPix = y+yPos;
			if(yPix < 0 || yPix >= height)continue;
			for(int x = 0; x < w; x++){
				int xPix = x+xPos;
				if(xPix < 0 || xPix >= width)continue;

				int src = image.pixels[(x+xo) + (y+yo) * image.width];
				int merged = merge(src, pixels[xPix + yPix * width], amount);
				if(src != -2)pixels[xPix + yPix * width] = merged;
			}
		}
	}
	
	public int merge(int color, int color2, int amount) {

        int r = (color >> 16) & 0xff;
        int g = (color >> 8) & 0xff;
        int b = (color) & 0xff;

        int r2 = (color2 >> 16) & 0xff;
        int g2 = (color2 >> 8) & 0xff;
        int b2 = (color2) & 0xff;

        int a = 100 - amount;

        int tr = (r * amount + r2 * a) / 100;
        int tg = (g * amount + g2 * a) / 100;
        int tb = (b * amount + b2 * a) / 100;

        return tr << 16 | tg << 8 | tb;
    }
}
