package com.dddbomber.fishingjam.assets;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class AssetLoader {
	public static Bitmap loadBitmap(String location){
		try{
			BufferedImage img = ImageIO.read(AssetLoader.class.getResource(location));
			int w = img.getWidth();
			int h = img.getHeight();
			Bitmap result = new Bitmap(w, h);
			img.getRGB(0, 0, w, h, result.pixels, 0, w);
			System.out.println(result.pixels[0]);
			for(int i = 0; i < result.pixels.length; i++){
				int src = result.pixels[i];
				if(src == 0 || src == 16777215){
					src = -2;
				}
				result.pixels[i] = src;
			}
			
			System.out.println("Loaded Bitmap: " +location);
			return result;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
