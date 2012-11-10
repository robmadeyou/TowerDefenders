package com.gmail.robmadeyou;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

public abstract class GuiButton implements Gui {
	
	protected int x, y, h, w;
	protected String state, name;
	protected Texture tex;
	
	public GuiButton(int x, int y, int h, int w, String state, String name, Texture tex){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.state = state;
		this.name = name;
		this.tex = tex;
	}
	@Override
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;

	}

	@Override
	public void setWidth(int w) {
		this.w = w;

	}

	@Override
	public void setHeight(int h) {
		this.h = h;

	}

	@Override
	public boolean isMouseOver(){
		int mX = Mouse.getX();
		int mY = Display.getHeight() - Mouse.getY();
		if(mX >= x && mX <= x + w && mY >= y && mY <= y + h ){
			System.out.println("fawef");
			return true;
		}
		return false;
	}
	public void onUpdate(){
		isMouseOver();
	}
	public void draw(){
		
		if(tex != null){
			tex.bind();
		}
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(x , y);
			glTexCoord2f(1, 0);
			glVertex2f(x + w, y);
			glTexCoord2f(1, 1);
			glVertex2f(x + w, y + h);
			glTexCoord2f(0, 1);
			glVertex2f(x , y + h);
		glEnd();
	}

}
