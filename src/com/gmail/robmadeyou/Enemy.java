package com.gmail.robmadeyou;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.glColor3f;

import java.util.Random;

import org.newdawn.slick.opengl.Texture;

public abstract class Enemy implements Entity {

	
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected int health = 1;
	protected int currentFrame = 0;
	protected int maxFrame = 3;
	protected int number = 0;
	/*
	 * Direction in wich the enemy is going on. 0 = default but
	 * 
	 * 0 = North
	 * 1 = East
	 * 2 = South
	 * 4 = West
	 * 
	 */
	protected int direction = 0;
	protected boolean hasBulletTargeted = false;
	protected float r , g, b;
	protected boolean isLiving = true;
	protected Texture texture = Textures.enemy1;
	
	
	public Enemy(int x, int y, int width, int height, int health) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.health = health;
    }
	@Override
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void number(int num) {
	}

	@Override
	public void setTexture(Texture tex) {
	}

	@Override
	public void setColor(String color) {
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
	public void onUpdate(){
		animate();
	}
	public void animate(){
		if(currentFrame == 0){
			this.texture = Textures.enemy1;
		}else if(currentFrame == 5){
			this.texture = Textures.enemy3;
		}else if(currentFrame == 10){
			this.texture = Textures.enemy4;
		}
		currentFrame++;
		if(currentFrame == maxFrame * 5){
			currentFrame = 0;
		}
	}

	@Override
	public void draw() {
		if(texture != null){
			texture.bind();
			//Change the texture loaders. Silly stuff
		}
		glBegin(GL_QUADS);
			glColor3f(1, 1, 1);
			glTexCoord2f(0, 0);
			glVertex2f(x , y);
			glTexCoord2f(1, 0);
			glVertex2f(x + width, y);
			glTexCoord2f(1, 1);
			glVertex2f(x + width, y + height);
			glTexCoord2f(0, 1);
			glVertex2f(x , y + height);
		glEnd();
		glColor3f(1, 1, 1);
	}

}
