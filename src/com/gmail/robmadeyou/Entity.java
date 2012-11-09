package com.gmail.robmadeyou;

import org.newdawn.slick.opengl.Texture;

public interface Entity {
	
	void setLocation(int x, int y);
	
	void setX(int x);

	void setY(int y);
	
	void setWidth(int width);
	
	void setHeight(int height);
	
	void number(int num);
	
	void setTexture(Texture tex);
	
	void setColor(String color);
	
	String getColor();
	
	int getX();
	
	int getY();
	
	int getWidth();
	
	int getHeight();
	
	boolean isSelected();
	
	void draw();
}
