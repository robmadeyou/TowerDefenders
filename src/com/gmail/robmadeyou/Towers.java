package com.gmail.robmadeyou;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.util.Random;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

public abstract class Towers implements Entity {

	protected int x;
	protected int y;
	protected int m1, m2, m3, m4;
	protected int mX, mY, mW, mH;
	protected int width;
	protected int height;
	protected int number;
	protected int enemyToAttack;
	protected int cooldown = 0;
	protected int upgrade;
	protected int upgrades;
	protected String name;
	protected float r , g, b;
	protected boolean selected;
	protected Texture texture;
	
	public Towers(int x, int y, int width, int height, String name) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.name = name;
        upgrades = 1;
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
		this.number = num;

	}

	@Override
	public void setTexture(Texture tex) {
		this.texture = tex;
	}

	@Override
	public void setColor(String color) {
		if(color.toLowerCase().equals("white")){
			r = 1;
			g = 1;
			b = 1;
		}else if(color.toLowerCase().equals("red")){
			r = 1;
			g = 0;
			b = 0;
		}else if(color.toLowerCase().equals("green")){
			r = 0;
			g = 1;
			b = 0;
		}else if(color.toLowerCase().equals("blue")){
			r = 0;
			g = 0;
			b = 1;
		}else if(color.toLowerCase().equals("black")){
			r = 0;
			g = 0;
			b = 0;
		}else if(color.toLowerCase().equals("random")){
			Random ran = new Random();
			r = ran.nextFloat();
			g = ran.nextFloat();
			b = ran.nextFloat();
		}else{
		
			r = 1;
			g = 1;
			b = 1;
		}
	}
	@Override
	public String getColor(){
		return "white";
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public boolean isSelected() {
		if(isMouseOver() && Mouse.isButtonDown(0)){
			return true;
		}
		return false;
	}
	public boolean isMouseOver() {
		if(Mouse.getX() > x && Mouse.getX() < x + width && Display.getHeight() - Mouse.getY() > y && Display.getHeight() - Mouse.getY() < y + height){
			return true;
		}
		return false;
	}

	public void upgrade() {
		
	}

	public int upgrades() {
		// TODO Auto-generated method stub
		return upgrades;
	}

	public void name() {
		if(name.equals("arrow") && upgrades == 1){
			texture = Textures.turretArrow1;
			
			m1 = x - 60;
			m2 = y - 60;
			m3 = x + width + 60;
			m4 = y + height + 60;
			
		}else if(name.equals("cannon") && upgrades == 1){
			texture = Textures.turretCannon1;
			m1 = x - 30;
			m2 = y - 30;
			m3 = x + width + 30;
			m4 = y + height + 30;
		}
		mX = m1;
		mY = m2;
		mW = m3 - m1;
		mH = m4 - m2;

	}
	
	public void onUpdate(int delta){
		name();
		if(isSelected()){
			x += Mouse.getDX();
			y += -Mouse.getDY();
		}
		EnemyList.attackEnemy(mX, mY, mW, mH);
		fire(EnemyList.enemy[EnemyList.enemyAttack], EnemyList.enemyAttack);
	}
	public void Render(){
		if(texture != null){
			texture.bind();
		}
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(x , y);
			glTexCoord2f(1, 0);
			glVertex2f(x + width, y);
			glTexCoord2f(1, 1);
			glVertex2f(x + width, y + height);
			glTexCoord2f(0, 1);
			glVertex2f(x , y + height);
		glEnd();
		if(isMouseOver()){
			Textures.marker.bind();
			glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(m1, m2);
			glTexCoord2f(1, 0);
			glVertex2f(m3, m2);
			glTexCoord2f(1, 1);
			glVertex2f(m3, m4);
			glTexCoord2f(0, 1);
			glVertex2f(m1, m4);
		glEnd();
		}
	}
	
	public void fire(Entity other, int toAttack){
		if(isInMarker(other)){
			if(cooldown >= 30){
				enemyToAttack = EnemyList.enemyAttack;
				System.out.println(enemyToAttack);
				BulletList.addBullet(new BulletList.bullets(x - (width / 2), y - (height / 2), 10, 10, toAttack, number));
				cooldown = 0;
			}
		}

		cooldown++;
	}
	public boolean isInMarker(Entity other){
		if((other.getX() + (other.getWidth() / 2) <= mX + mW && other.getX() + (other.getWidth() / 2) >= mX && other.getY() + (other.getHeight() / 2) >= mY
				&& other.getY() + (other.getHeight() / 2) <= mY + mH)){
			return true;
		}
		return false;
	}

}
