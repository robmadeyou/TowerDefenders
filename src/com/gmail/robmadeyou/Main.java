package com.gmail.robmadeyou;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
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
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.glVertex2i;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.GL_QUADS;
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
    
	static int displayX = 640;
	static int displayY = 480;
	public Main(){
		try {
			Display.setDisplayMode(new DisplayMode(displayX,displayY));
			Display.setTitle("");
			Display.create();
			Display.setResizable(true);
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

		TowerList.addEntity(new TowerList.Towerse(10, 20, 20, 20, "arrow"));
		TowerList.addEntity(new TowerList.Towerse(50, 50, 50, 50, "arrow"));
		TowerList.addEntity(new TowerList.Towerse(100,100,50,50, "cannon"));
		
		EnemyList.addEnemy(new EnemyList.Enemies(200, 200, 40, 40));
		EnemyList.addEnemy(new EnemyList.Enemies(200, 240, 40, 40));
		Textures.loadTextures();
		boolean pressed = false;
		while(!Display.isCloseRequested()){
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			
			int delta = getDelta();
			
			
			while(Keyboard.next()){
				if(Keyboard.getEventKeyState()){
					if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
						pressed = true;
						TowerList.towerList[1].fire(EnemyList.enemy[EnemyList.enemyAttack], delta);
					}
				}
			}
			if(pressed){
				
			}
			onUpdate(delta);
			
			Display.update();
			Display.sync(60);
		}
	}
	
	public void onUpdate(int delta){
		TowerList.renderAll();
		TowerList.updateAll(delta);
		EnemyList.renderAll();
		EnemyList.updateAll();
		BulletList.draw();
		BulletList.onUpdate();
	}
	
	public static void main(String[]args){
		new Main();
	}
}
