package old.com.gmail.robmadeyou;

import org.lwjgl.input.Keyboard;

public class StateCredits {
	public static void onUpdate(){
		if(Input.keyPressed == Keyboard.KEY_ESCAPE){
			State.changeState(State.prevState);
		}
	}
}
