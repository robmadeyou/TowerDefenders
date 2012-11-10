package com.gmail.robmadeyou;

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
	
	public static void onUpdate(int delta){
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
}
