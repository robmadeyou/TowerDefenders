package old.com.gmail.robmadeyou;


public class GuiEditorMenuGrid {
	private int maxButtonsTop = 32;
	private static int maxButtonsLeft = 16;
	private GuiEditorMenuButtons[] buttonsTop = new GuiEditorMenuButtons[maxButtonsTop];
	public static GuiEditorMenuButtons[] buttonsLeft = new GuiEditorMenuButtons[maxButtonsLeft];
	
	
	
	public GuiEditorMenuGrid(){
		for(int x = 0; x < maxButtonsTop; x++){
			buttonsTop[x] = new GuiEditorMenuButtons(TileType.QUICK_TILE_EMPTY, x * World.BLOCK_SIZE, 0 * World.BLOCK_SIZE);
		}
		for(int y = 0; y < maxButtonsLeft; y++){
			buttonsLeft[y] = new GuiEditorMenuButtons(TileType.QUICK_TILE_EMPTY, 0, y * World.BLOCK_SIZE + 32);
		}
	}
	
	public void draw(){
		for(int x = 0; x < maxButtonsTop; x++){
			buttonsTop[x].draw();
		}
		for(int y = 0; y < maxButtonsLeft; y++){
			buttonsLeft[y].draw();
		}
	}
	public void setAt(int x, TileType t, String xOrY){
		if(xOrY.toLowerCase().equals("x")){
			buttonsTop[x].setType(t);
		}else{
			buttonsLeft[x].setType(t);
		}
	}
	public GuiEditorMenuButtons getType(int x){
		return buttonsTop[x];
	}
}
