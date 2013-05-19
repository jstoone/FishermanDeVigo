package com.dddbomber.fishingjam;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.dddbomber.fishingjam.assets.Asset;
import com.dddbomber.fishingjam.assets.Screen;
import com.dddbomber.fishingjam.assets.Sound;
import com.dddbomber.fishingjam.input.InputHandler;
import com.dddbomber.fishingjam.instance.family.Person;
import com.dddbomber.fishingjam.menu.Menu;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	public static int WIDTH = 600, HEIGHT = 400;
	public static int SCREENWIDTH = 900, SCREENHEIGHT = 600;
	public static final String NAME = "Fisherman De Vigo";

	public Screen screen;
	public InputHandler input;
	
	public Game(){
		setSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
		screen = new Screen(WIDTH, HEIGHT);
		input = new InputHandler(this);
	}
	
	public static int ticks, renders;
	
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000.0 / 60.0;
		
		double time = 0;
		
		long lastSecond = System.currentTimeMillis();
		
		this.requestFocus();
		
		while(running){
			long now = System.nanoTime();
			time += (now - lastTime) / nsPerTick;
			lastTime = now;
			while(time >= 1){
				tick();
				time -= 1;
			}
			render();
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
		
		if(Menu.menu != null)Menu.menu.render(screen, input);
		
		if(!input.focus.hasFocus){
			screen.fill(0, 0, WIDTH, HEIGHT, 0, 50);
			String msg = "CLICK TO FOCUS";
			screen.draw(msg, 300-msg.length()*7, 190, 0xffffff, 2);
		}
		
		g.drawImage(screen.getImage(), 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();
		bs.show();
	}

	private void tick() {
		if(!input.focus.hasFocus)return;
		ticks++;
		if(Menu.menu != null && Menu.menu.canTick())Menu.menu.tick(input);
		if(input.keyboard.keys[KeyEvent.VK_ESCAPE]){
			
		}
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
		for(int i = 0; i < 25; i++){
			new Person(false, false);
		}
	}
	
	private Thread gameThread;
	
	public boolean running = false;

	public void start() {
		running = true;
		gameThread = new Thread(this);
		gameThread.start();
		Asset.music.loop();
	}
	
	public void stop() {
		Sound.stopAll();
		running = false;
	}
}
