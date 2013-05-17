package com.dddbomber.fishingjam;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.dddbomber.fishingjam.assets.Asset;
import com.dddbomber.fishingjam.assets.AssetLoader;
import com.dddbomber.fishingjam.assets.Screen;
import com.dddbomber.fishingjam.input.InputHandler;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	public static int WIDTH = 600, HEIGHT = 400;
	public static int SCALE = 2;
	public static final String NAME = "Fisherman De Vigo";

	public Screen screen;
	public InputHandler input;
	
	public Game(){
		setSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		screen = new Screen(WIDTH, HEIGHT);
		input = new InputHandler(this);
	}
	
	public static int ticks, renders;
	
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000.0 / 60.0;
		
		double time = 0;
		
		long lastSecond = System.currentTimeMillis();
		
		while(true){
			long now = System.nanoTime();
			time += (now - lastTime) / nsPerTick;
			lastTime = now;
			while(time >= 1){
				tick();
				time -= 1;
				render();
			}
			if(System.currentTimeMillis() - lastSecond > 1000){
				lastSecond += 1000;
				System.out.println("FPS - " +renders +", TICKS - " + ticks);
				ticks = renders = 0;
			}
		}
	}

	private void render() {
		renders++;
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		for(int i = 0; i < screen.pixels.length; i++){
			screen.pixels[i] = 0;
		}
		
		screen.drawScaled(Asset.test, 0, 0, 0, 0, WIDTH, HEIGHT, xScale, yScale);
		
		g.drawImage(screen.getImage(), 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();
		bs.show();
	}
	
	public double xScale, yScale;

	private void tick() {
		ticks++;
		if(input.keyboard.keys[KeyEvent.VK_DOWN])yScale += 0.01;
		if(input.keyboard.keys[KeyEvent.VK_UP])yScale -= 0.01;
		if(input.keyboard.keys[KeyEvent.VK_RIGHT])xScale += 0.01;
		if(input.keyboard.keys[KeyEvent.VK_LEFT])xScale -= 0.01;
	}
	
	public static void main(String[] args){
		Game game = new Game();
		JFrame frame = new JFrame(NAME);
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(game, BorderLayout.CENTER);
		frame.setContentPane(panel);
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
	}
	
	private Thread gameThread;

	private void start() {
		gameThread = new Thread(this);
		gameThread.start();
	}
}