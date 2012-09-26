package shameless;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Textures {
	
	//Turret textures
	public static Texture arrowTower;
	public static Texture cannonTower;
	
	public static void loadTextures(){
		try {
			//Turret textures
			arrowTower = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/towers/ArrowTower.png")));
			cannonTower = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/towers/CannonTower.png")));
			
			
		} catch (IOException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
	}
}
