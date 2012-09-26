package shameless;


import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glClear;


import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/*  _____________________________________________________________________
 * |.....................................................................|
 * |.....................................................................|
 * |.....##########..###########..###....###..##########..##########.....|
 * |.....##########..###########..###....###..##########..##########.....|
 * |.....###.............###......###....###..###.........###....###.....|
 * |.....###.............###......###....###..###.........###....###.....|
 * |.....##########......###......##########..##########..##########.....|
 * |.....##########......###......##########..##########..######.........|
 * |.....###.............###......###....###..###.........###.###........|
 * |.....###.............###......###....###..###.........###..###.......|
 * |.....##########......###......###....###..##########..###...###......|
 * |.....##########......###......###....###..##########..###....###.....|
 * |.....................................................................|
 * |.....................................................................|
 * 
 * 
 * A game made by Shameless and xFlakesID for fun and learning purposes. 
 * 
 * Feel free to use any of the code at your own will, if you have some upgrades
 * would like to show them off feel free to join our IRC on Esper.net #EtherIRC,
 * 
 * Have a fun day ;)
 * 
 *  - Shameless
 */

public class Main {
	
	public Main(){
		
		try {
			Display.setDisplayMode(new DisplayMode(840,480));
			Display.setTitle("Tower Defence 0.01");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho( 0, 840, 480, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		
		Textures.loadTextures();
		while(!Display.isCloseRequested()){
			glClear(GL_COLOR_BUFFER_BIT);
			
			guiButton.button[0] = new guiButton(20, 30, 50, 50, "GAME",true, Textures.arrowTower);
			guiButton.button[1] = new guiButton(100, 100, 50, 50, "GAME",true, Textures.cannonTower);
			guiButton.button[0].onUpdate("GAME");
			guiButton.button[1].onUpdate("GAME");
			onUpdate();
			
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
		System.exit(0);
	
	}
	
	
	public void onUpdate(){
		
	}
	
	public static void main(String args[]){
		new Main();
	}
}
