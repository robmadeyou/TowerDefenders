package com.gmail.robmadeyou;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Input {
	
	static boolean rmbp = false;
	static boolean lmbp = false;
	static int keyPressed = -1;
	
	public static void checkMouseInput(){
		rmbp = false;
		lmbp = false;
		keyPressed = -1;
		while(Mouse.next()){
			if(Mouse.getEventButtonState()){
				if(Mouse.getEventButton() == 0){
				lmbp = true;
				}
				
				if(Mouse.getEventButton() == 1){
					rmbp = true;
				}
			}
		}
	}
	
	public static void checkKeyboardInput(){
		while(Keyboard.next()){
			if(Keyboard.getEventKeyState()){
				if(Keyboard.isKeyDown(Keyboard.getEventKey())){
					keyPressed = Keyboard.getEventKey();
				}
			}
		}
	}
}
