package com.gmail.robmadeyou;

public enum TileType {

    STONE("res/towers/stone.png", false), AIR("res/towers/wood.png", false), GRASS("res/towers/ArrowTower.png", false), DIRT("res/towers/CannonTower.png", false), 
    
    //Pack Nr 1!
    P1_DIRT("res/gui/editor/texPack1/dirt.png", false), P1_STONE("res/gui/editor/texPack1/stone.png", false),P1_GRASS("res/gui/editor/texPack1/grass.png", false), P1_GRASS2("res/gui/editor/texPack1/grass2.png", false),
    
    //Editor QuickSelect tiles
    QUICK_TILE_EMPTY("res/gui/editor/noQuickTile.png", false), SELECTED_TILE("res/gui/editor/selectedTile.png", false), SELECTED_TILE_LEFT("res/gui/editor/selectedTexture.png", false),
    
    
    //Editor Movement tiles
    PATHFINDING_START("res/gui/editor/paths/start.png", true), PATHFINDING_EMPTY("res/gui/editor/paths/empty.png", true), PATHFINDING_END("res/gui/editor/paths/end.png", true), PATHFINDING_PATH("res/gui/editor/paths/path.png", true)
    
    
    
    
    ;
    public final String location;
    public final boolean editorMovement;

    TileType(String location, boolean editorMovement) {
        this.location = location;
        this.editorMovement = editorMovement;
    }
}