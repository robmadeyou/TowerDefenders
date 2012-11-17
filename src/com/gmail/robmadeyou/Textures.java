package com.gmail.robmadeyou;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;


public class Textures {
	
	public static Texture turretArrow1;
	
	
	public static Texture turretCannon1;
	
	public static Texture enemy1;
	public static Texture enemy2;
	public static Texture enemy3;
	public static Texture enemy4;
	

	public static Texture marker;
	
	
	
	public static Texture startButton;
	public static Texture startButtonU;
	
	public static Texture creditsButton;
	public static Texture creditsButtonU;
	
	public static Texture levelEditButton;
	public static Texture levelEditButtonU;
	
	public static Texture quitButton;
	public static Texture quitButtonU;
	
	
	
	
	public static Texture backgroundMenu;
	public static void loadTextures(){

		try {
			//Textures for in game objects like towers and whatnot.
			turretArrow1 = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/towers/ArrowTower.png")));
			
			
			
			turretCannon1 = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/towers/CannonTower.png")));
			
			
			enemy1 = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/enemies/enemy.png")));
			enemy2 = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/enemies/enemy2.png")));
			enemy3 = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/enemies/enemy3.png")));
			enemy4 = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/enemies/enemy4.png")));
			
			
			marker = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/marker.png")));
			
			//Textures for Buttons and GUI stuff. Int MatyldaCookies = 0; MatyldaCookies++;
			
			startButton = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/gui/buttons/startbutton.png")));
			startButtonU = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/gui/buttons/startbuttonU.png")));
			
			creditsButton = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/gui/buttons/creditsButton.png")));
			creditsButtonU = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/gui/buttons/creditsButtonU.png")));
			
			levelEditButton = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/gui/buttons/levelEditButton.png")));
			levelEditButtonU = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/gui/buttons/levelEditButtonU.png")));
			
			quitButton = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/gui/buttons/quitButton.png")));
			quitButtonU = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/gui/buttons/quitButtonU.png")));
			
			
			//Textures for Background stuff and stuff y'know?
			backgroundMenu = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/gui/background/menu.png")));
		} catch (IOException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
    	}
	}
}
