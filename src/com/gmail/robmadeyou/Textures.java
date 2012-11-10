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

	public static Texture marker;
	public static void loadTextures(){

		try {
			//Textures for in game objects like towers and whatnot.
			turretArrow1 = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/towers/ArrowTower.png")));
			
			
			
			turretCannon1 = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/towers/CannonTower.png")));
			
			
			enemy1 = TextureLoader.getTexture("PING", new FileInputStream(new File("res/enemies/enemy.png")));
			
			
			marker = TextureLoader.getTexture("PING", new FileInputStream(new File("res/marker.png")));
			
			//Textures for Buttons and GUI stuff. Int MatyldaCookies = 0; MatyldaCookies++;
			
			
		} catch (IOException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
    	}
	}
}
