package com.gmail.robmadeyou;

public enum TileType {

    STONE("res/towers/stone.png"), AIR("res/towers/wood.png"), GRASS("res/towers/ArrowTower.png"), DIRT("res/towers/CannonTower.png"), 
    
    //Pack Nr 1!
    P1_DIRT("res/gui/editor/texPack1/dirt.png"), P1_STONE("res/gui/editor/texPack1/stone.png"),P1_GRASS("res/gui/editor/texPack1/grass.png"), P1_GRASS2("res/gui/editor/texPack1/grass2.png"),
    
    //Editor QuickSelect tiles
    QUICK_TILE_EMPTY("res/gui/editor/noQuickTile.png"), SELECTED_TILE("res/gui/editor/selectedTile.png");
    
    
    public final String location;

    TileType(String location) {
        this.location = location;
    }
}