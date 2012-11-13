package com.gmail.robmadeyou;


import static com.gmail.robmadeyou.World.*;

public class GuiEditorMenuGrid {
	private int maxButtonsTop = 32;
	private int maxButtonsLeft = 16;
	private GuiEditorMenuButtons[] buttonsTop = new GuiEditorMenuButtons[maxButtonsTop];
	private GuiEditorMenuButtons[] buttonsLeft = new GuiEditorMenuButtons[maxButtonsLeft];
	
	
	
	public GuiEditorMenuGrid(){
		for(int x = 0; x < maxButtonsTop; x++){
			buttonsTop[x] = new GuiEditorMenuButtons(TileType.QUICK_TILE_EMPTY, x * BLOCK_SIZE, 0 * BLOCK_SIZE);
		}
	}
	
	public void draw(){
		for(int x = 0; x < maxButtonsTop; x++){
			buttonsTop[x].draw();
		}
	}
	public void setAt(int x, TileType t){
		buttonsTop[x].setType(t);
	}
	public GuiEditorMenuButtons getType(int x){
		return buttonsTop[x];
	}
}
