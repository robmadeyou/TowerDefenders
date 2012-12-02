package com.gmail.robmadeyou;


import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;



public class Main {
	
    private static long lastFrame;
    private static long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    private static int getDelta() {
        long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = getTime();
        return delta;
    }
    
	static int displayX = 1024;
	static int displayY = 512;
	static boolean test1 = false;
	
	public Main(){
		try {
			Display.setDisplayMode(new DisplayMode(displayX,displayY));
			Display.setTitle("");
			Display.create();
			Display.setResizable(false);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		glEnable(GL_TEXTURE_2D);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho( 0, displayX, displayY, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
	    glEnable(GL_BLEND);
	    glBlendFunc(GL_SRC_ALPHA , GL_ONE_MINUS_SRC_ALPHA);
	    Textures.loadTextures();
		TowerList.addEntity(new TowerList.Towerse(10, 20, 20, 20, 70, "arrow"));
		TowerList.addEntity(new TowerList.Towerse(50, 50, 50, 50, 50, "arrow"));
		TowerList.addEntity(new TowerList.Towerse(100,100,50,50, 50, "cannon"));
		
		EnemyList.addEnemy(new EnemyList.Enemies(0, 200, 50, 50, 1));
		int enemyies = 0;
		while(!Display.isCloseRequested()){
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			
			int delta = getDelta();
			enemyies++;
			
			if(enemyies >= 10){
				EnemyList.addEnemy(new EnemyList.Enemies(0, 200, 50, 50, 1));
				EnemyList.addEnemy(new EnemyList.Enemies(0, 400, 50, 50, 1));
				enemyies = 0;
				
			}
			
			onUpdate(delta);
			
			Display.update();
			Display.sync(60);
		}
	}
	
	public void onUpdate(int delta){
		State.onUpdate(delta);
		if(test1 == false){
			State.changeBackground(Textures.backgroundMenu);
			test1 = true;
		}
		Input.checkMouseInput();
		Input.checkKeyboardInput();
	}
	
	public static void main(String args[]){
		new Main();
	}
}
