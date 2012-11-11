package com.gmail.robmadeyou;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

public class State {
	/*
	 * Select from:
	 * 
	 *  * MAIN_MENU
	 *  * LEVEL_EDIT
	 *  * CREDITS
	 *  * GAME
	 *  * LEVEL_SELECT
	 *  
	 *   ...and many more!
	 */
	static String state = "MAIN_MENU";
	static String prevState = "MAIN_MENU";
	
	public static class Background extends GuiBackground{

		public Background(int x, int y, int w, int h, Texture tex) {
			super(x, y, w, h, tex);
		}
		
	}
	
	static Background backg = new Background(0, 0, 1024, 512, Textures.backgroundMenu);
	
	public static void onUpdate(int delta){
		if(!state.equals("GAME") && !state.equals("LEVEL_EDIT")){
			backg.draw();
			System.out.println("bah");
		}
		GuiButtonList.drawAll(state);
		GuiButtonList.onUpdate(state);
		
		
		
		if(state.equals("MAIN_MENU")){
			StateMenu.onUpdate();
		}else if(state.equals("GAME")){
			TowerList.renderAll();
			TowerList.updateAll(delta);
			EnemyList.renderAll();
			EnemyList.updateAll(delta);
			BulletList.draw();
			BulletList.onUpdate(delta);
			GuiButtonList.drawAll("menu");
		}
	}
	public static void changeState(String s){
		prevState = state;
		state = s;
		
	}
	public static void changeBackground(Texture tex){
		backg.tex = tex;
	}
}
