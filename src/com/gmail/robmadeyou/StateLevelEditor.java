package com.gmail.robmadeyou;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2i;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.gmail.robmadeyou.Tile;
import com.gmail.robmadeyou.TileGrid;
import com.gmail.robmadeyou.TileType;
import com.gmail.robmadeyou.World;

public class StateLevelEditor {
	
    private static TileGrid grid;
    private static GuiEditorMenuGrid menuGrids;
    private static TileType selection = TileType.STONE;
    private static int selector_x = 0, selector_y = 0;
    private static int MenuSelector_x = 0;
    private static boolean isInTopMenu = false;
    private static int selectedTile = 0;
    private static int selectedTexPack = 0;
    
    static boolean hasIni = false;
    static boolean firstClick = false;
    
	public static void onUpdate(){
		if(!hasIni){
			grid = new TileGrid();
			menuGrids = new GuiEditorMenuGrid();
			hasIni = true;
		}
		if(firstClick){
			checkInput();
			menuGrids.draw();
			grid.draw();
			drawSelectionBox();
			checkTopMenu();
			drawMenuSelectionBox();
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
    
    
    private static void checkTopMenu(){
    	if(selectedTexPack == 0){
    		menuGrids.setAt(4, TileType.SELECTED_TILE);
    		menuGrids.setAt(5, TileType.DIRT);
    		menuGrids.setAt(6, TileType.GRASS);
    		menuGrids.setAt(7, TileType.STONE);
    		menuGrids.setAt(0, TileType.P1_DIRT);
    		menuGrids.setAt(1, TileType.P1_STONE);
    		menuGrids.setAt(2, TileType.P1_GRASS);
    		menuGrids.setAt(3, TileType.P1_GRASS2);
    	}else if(selectedTexPack == 1){
    		menuGrids.setAt(7, TileType.AIR);
    	}
    	if(Input.lmbp && isInTopMenu && menuGrids.getType(MenuSelector_x).getType() != TileType.QUICK_TILE_EMPTY){
    		selection = menuGrids.getType(MenuSelector_x).getType();
    		selectedTile = MenuSelector_x;
    		
    	}
    }
    private static void drawMenuSelectionBox(){
    	new Tile(TileType.SELECTED_TILE, (selectedTile - 1) * World.BLOCK_SIZE, -32).draw();
    }
    private static void checkInput(){
    	int mouseX = Mouse.getX();
        int mouseY = 512 - Mouse.getY() - 1;
        if(mouseX >= 0 && mouseX <= 1024 && mouseY >= 0 && mouseY < 32){
        	isInTopMenu = true;
        }else{
        	isInTopMenu = false;
        }
        MenuSelector_x = Math.round(mouseX / World.BLOCK_SIZE);
        if(mouseX >= 32 && mouseX <= 1024 && mouseY >= 32 && mouseY <= 512){
        	selector_x = Math.round(mouseX / World.BLOCK_SIZE) - 1;
        	selector_y = Math.round(mouseY / World.BLOCK_SIZE) - 1;
        	if(selector_x < 0){
        		selector_x = 0;
        	}
        	if(selector_y < 0){
        		selector_y = 0;
        	}
        	if(Input.lmbd){
        		grid.setAt(selector_x, selector_y, selection);
        	}
        	if(Input.rmbd){
        		grid.setAt(selector_x, selector_y, TileType.AIR);
        	}
        	if(Input.keyPressed == Keyboard.KEY_0){
        		selectedTexPack = 0;
        	}else if(Input.keyPressed == Keyboard.KEY_1){
        		selectedTexPack = 1;
        	}
        	if(Input.keyPressed == Keyboard.KEY_ESCAPE){
        		State.changeState(State.prevState);
        	}
        	if(Input.keyPressed == Keyboard.KEY_C){
        		grid.clear();
        	}
        	if(Input.keyPressed == Keyboard.KEY_R){
        		grid.setRotation(selector_x, selector_y, 90);
        		System.out.println("adw");
        	}
        }
    }
}
