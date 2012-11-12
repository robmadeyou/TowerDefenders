package com.gmail.robmadeyou;

public enum TileType {

    STONE("res/towers/stone.png"), AIR("res/towers/wood.png"), GRASS("res/towers/ArrowTower.png"), DIRT("res/towers/CannonTower.png");
    public final String location;

    TileType(String location) {
        this.location = location;
    }
}