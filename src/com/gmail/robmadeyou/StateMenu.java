package com.gmail.robmadeyou;


public class StateMenu {
	public static void onUpdate(){
		for(int i = 0; i < GuiButtonList.maxButtons; i++){
			if(GuiButtonList.button[i] != null){
				if(GuiButtonList.button[i].name.equals("start")){
					if(GuiButtonList.button[i].isMouseOver() && Input.rmbp){
						State.state = "GAME";
					}
				}
			}
		}
	}
}
