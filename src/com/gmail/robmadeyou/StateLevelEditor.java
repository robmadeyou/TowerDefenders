package com.gmail.robmadeyou;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2i;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.gmail.robmadeyou.Tile;
import com.gmail.robmadeyou.TileGrid;
import com.gmail.robmadeyou.TileType;
import com.gmail.robmadeyou.World;

public class StateLevelEditor {
	
    private static TileGrid grid;
    private static TileType selection = TileType.STONE;
    private static int selector_x = 0, selector_y = 0;
    
    static boolean hasIni = false;
    static boolean firstClick = false;
    
	public static void onUpdate(){
		if(!hasIni){
			grid = new TileGrid();
			hasIni = true;
		}
		if(firstClick){
			grid.draw();
			checkInput();
			drawSelectionBox();
			System.out.println("heyoyo");
		}
		firstClick = true;
	}
    private static void drawSelectionBox() {
    	
        
    	
        int x = selector_x * World.BLOCK_SIZE;
        int y = selector_y * World.BLOCK_SIZE;
        int x2 = x + World.BLOCK_SIZE;
        int y2 = y + World.BLOCK_SIZE;
        if (grid.getAt(selector_x, selector_y).getType() != TileType.AIR
                || selection == TileType.AIR) {
            glBindTexture(GL_TEXTURE_2D, 0);
            glColor4f(1f, 1f, 1f, 0.5f);
            glBegin(GL_QUADS);
            glVertex2i(x + 32, y + 32);
            glVertex2i(x2 + 32, y + 32);
            glVertex2i(x2 + 32, y2 + 32);
            glVertex2i(x + 32, y2 + 32);
            glEnd();
            glColor4f(1f, 1f, 1f, 1f);
        } else {
            glColor4f(1f, 1f, 1f, 0.5f);
            new Tile(selection, selector_x * World.BLOCK_SIZE, selector_y
                    * World.BLOCK_SIZE).draw();
            glColor4f(1f, 1f, 1f, 1f);
        }
    }
    public static void checkInput(){
    	
    	int mousex = Mouse.getX();
        int mousey = 480 - Mouse.getY() - 1;
        boolean mouseClicked = Mouse.isButtonDown(0);
        selector_x = Math.round(mousex / World.BLOCK_SIZE) -1;
        selector_y = Math.round(mousey / World.BLOCK_SIZE);
        if(selector_x < 0){
        	selector_x = 0;
        }
        if(selector_y < 0){
        	selector_y = 0;
        }
        if (mouseClicked) {
            grid.setAt(selector_x, selector_y, selection);
        }
        
    	if(Input.keyPressed == Keyboard.KEY_ESCAPE){
    		State.changeState(State.prevState);
    	}
    }
}
