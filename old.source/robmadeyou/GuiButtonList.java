package old.com.gmail.robmadeyou;

import org.newdawn.slick.opengl.Texture;

public class GuiButtonList {
	static int maxButtons = 50;
	static int numOfMenuButtons = 0;
	static GuiButton[] button = new GuiButton[maxButtons];
	
	public static class GuiButtons extends GuiButton{

		public GuiButtons(int x, int y, int w, int h, int number, String state, String name, Texture tex) {
			super(x, y, w, h, number, state, name, tex);
		}
	}
	
	public static void addButton(GuiButton b){
		//What if I told you, you deserve all the cookies?
		for(int i = 0; i < maxButtons; i++){
			if(button[i] == null){
				button[i] = b;
				if(b.state.equals("MAIN_MENU")){
					numOfMenuButtons ++;
				}
				break;
			}
		}
	}
	public static void onUpdate(String state){
		for(int i = 0; i < maxButtons; i++){
			if(button[i] != null){
				if(button[i].state.equals(state)){
					button[i].onUpdate();
				}
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
