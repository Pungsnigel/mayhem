package com.piggy.raingame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.piggy.raingame.entity.mob.Player;
import com.piggy.raingame.graphics.Screen;
import com.piggy.raingame.graphics.Sprite;
import com.piggy.raingame.input.KeyBoard;
import com.piggy.raingame.input.Mouse;
import com.piggy.raingame.levels.Level;
import com.piggy.raingame.levels.TileCoordinate;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 300;
	private static final int HEIGHT = WIDTH / 16 * 9;
	private static final int SCALE = 3;

	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	private Level level;
	private Player player;
	private KeyBoard key;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int [] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	private Screen screen;
	
	public Game() {
		Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(size);

		this.frame = new JFrame();
		this.screen = new Screen(WIDTH, HEIGHT);
		this.key = new KeyBoard();
		this.level = Level.example;
		TileCoordinate spawn = new TileCoordinate(15, 15);
		this.player = new Player(spawn.getX(), spawn.getY(),key);
		player.init(level);
		this.level.add(player);
		
		Mouse mouse = new Mouse();
		addKeyListener(key);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}

	public synchronized void start() {
		this.running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime 	= System.nanoTime();
		long timer 		= System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta 	= 0;
		int frames  	= 0;
		int updates 	= 0;
		
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {		// Cap at 60fps
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle("Marina MAYHAM | " + "UPS: " + updates +  "FPS:" + frames);
				updates = frames = 0;
			}
		}
		stop();
	}

	public void update() {
		this.key.update();
		this.level.update();
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		screen.clear();
		int xScroll = player.x -screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		level.render(xScroll, yScroll, screen);

		/*
		 *  Take everything rendered onto the screens pixel-array and put it in our image
		 *  Array is big enough to motivate use of arraycopy for performance.
		 */
		System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length);
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose(); 		// Cleanup graphics after drawing
		bs.show(); 			// Make next buffer visable
	}
	
	public static int getWindowWidth() {
		return WIDTH * SCALE;
	}
	
	public static int getWindowHeight() {
		return HEIGHT * SCALE;
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}

}
