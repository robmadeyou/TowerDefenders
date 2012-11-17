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
    private static TileGrid pathsGrid;
    private static GuiEditorMenuGrid menuGrids;
    private static TileType selection = TileType.STONE;
    private static int selector_x = 0, selector_y = 0;
    private static int MenuSelector_x = 0;
    private static int MenuSelector_y = 0;
    private static boolean isEditingPaths = false;
    private static boolean isInTopMenu = false;
    private static boolean isInLeftMenu = false;
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
			grid.draw(0);
			if(isEditingPaths){
				grid.draw(1);
			}
			drawSelectionBox();
			checkTopMenu();
			checkLeftMenu();
			drawMenuSelectionBox();
			drawLeftMenuSelectionBox();
			System.out.println(selectedTexPack);
		}
		firstClick = true;
	}
    private static void drawSelectionBox() {
        int x = selector_x * World.BLOCK_SIZE;
        int y = selector_y * World.BLOCK_SIZE;
        int x2 = x + World.BLOCK_SIZE;
        int y2 = y + World.BLOCK_SIZE;
        if (grid.getAt(selector_x, selector_y, 2).getType() != TileType.AIR
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
    		menuGrids.setAt(4, TileType.SELECTED_TILE, "x");
    		menuGrids.setAt(5, TileType.DIRT, "x");
    		menuGrids.setAt(6, TileType.GRASS, "x");
    		menuGrids.setAt(7, TileType.STONE, "x");
    		menuGrids.setAt(0, TileType.P1_DIRT, "x");
    		menuGrids.setAt(1, TileType.P1_STONE, "x");
    		menuGrids.setAt(2, TileType.P1_GRASS, "x");
    		menuGrids.setAt(3, TileType.P1_GRASS2, "x");
    	}else if(selectedTexPack == 1){
    		menuGrids.setAt(7, TileType.AIR, "x");
    	}
    	if(Input.lmbp && isInTopMenu && menuGrids.getType(MenuSelector_x).getType() != TileType.QUICK_TILE_EMPTY){
    		selection = menuGrids.getType(MenuSelector_x).getType();
    		selectedTile = MenuSelector_x;
    		
    	}
    }
    private static void drawMenuSelectionBox(){
    	new Tile(TileType.SELECTED_TILE, (selectedTile - 1) * World.BLOCK_SIZE, -32).draw();
    }
    private static void checkLeftMenu(){
    	menuGrids.setAt(1, TileType.DIRT, "y");
    	if(Input.lmbp && isInLeftMenu && MenuSelector_y - 1 < 7){
    		selectedTexPack = MenuSelector_y - 1;
    		
    	}
    	if(Input.lmbp && isInLeftMenu &&  MenuSelector_y - 1 >= 7){
    		
    	}
    }
    private static void drawLeftMenuSelectionBox(){
    	new Tile(TileType.SELECTED_TILE_LEFT, -32, (selectedTexPack) * World.BLOCK_SIZE).draw();
    }
    private static void checkInput(){
    	int mouseX = Mouse.getX();
        int mouseY = 512 - Mouse.getY() - 1;
        if(mouseX >= 0 && mouseX <= 1024 && mouseY >= 0 && mouseY < 32){
        	isInTopMenu = true;
        }else{
        	isInTopMenu = false;
        }
        if(mouseX >= 0 && mouseX < 32 && mouseY >= 32 && mouseY <= 512){
        	isInLeftMenu = true;
        }else{
        	isInLeftMenu = false;
        }
        MenuSelector_x = Math.round(mouseX / World.BLOCK_SIZE);
        MenuSelector_y = Math.round(mouseY / World.BLOCK_SIZE);
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
        		if(!isEditingPaths){
        			grid.setAt(selector_x, selector_y, selection, 0);
        		}
        		if(isEditingPaths){
        			grid.setAt(selector_x, selector_y, selection, 1);
        		}
        	}
        	if(Input.rmbd){
        		if(!isEditingPaths){
        			grid.setAt(selector_x, selector_y, TileType.AIR, 0);
        		}
        		if(isEditingPaths){
        			grid.setAt(selector_x, selector_y, TileType.PATHFINDING_EMPTY, 1);
        		}
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
        		if(!isEditingPaths){
        			grid.clear(0);
        		}else{
        			grid.clear(1);
        		}
        		
        	}
        	if(Input.keyPressed == Keyboard.KEY_R){
        		grid.addRotation(selector_x, selector_y, 90);
        	}
        	if(Input.keyPressed == Keyboard.KEY_P){
        		if(isEditingPaths == true){
        			isEditingPaths = false;
        		}else{
        			isEditingPaths = true;
        		}
        	}
        }
    }
}
