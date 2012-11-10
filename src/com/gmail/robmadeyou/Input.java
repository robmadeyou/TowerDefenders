package com.gmail.robmadeyou;

import org.lwjgl.input.Mouse;

public class Input {
	
	static boolean rmbp = false;
	public static void checkMouseInput(){
		while(Mouse.next()){
			if(Mouse.getEventButtonState()){
				if(Mouse.isButtonDown(0));
				rmbp = true;
			}
		}
	}
}
