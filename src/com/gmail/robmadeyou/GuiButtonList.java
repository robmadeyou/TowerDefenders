package com.gmail.robmadeyou;

import org.newdawn.slick.opengl.Texture;

public class GuiButtonList {
	static int maxButtons = 50;
	static GuiButton[] button = new GuiButton[maxButtons];
	
	public static class GuiButtons extends GuiButton{

		public GuiButtons(int x, int y, int h, int w, String state, String name, Texture tex) {
			super(x, y, h, w, state, name, tex);
		}
	}
	
	public static void addButton(GuiButton b){
		//What if I told you, you deserve all the cookies?
		for(int i = 0; i < maxButtons; i++){
			if(button[i] == null){
				button[i] = b;
				break;
			}
		}
	}
	public static void onUpdate(String state){
		for(int i = 0; i < maxButtons; i++){
			if(button[i] != null){
				button[i].onUpdate();
			}
		}
	}
	public static void drawAll(String state){
		for(int i = 0; i < maxButtons; i++){
			if(button[i] != null){
				if(button[i].state.equals(state)){
					button[i].draw();
				}
			}
		}
	}
}
