package com.gmail.robmadeyou;

import static com.gmail.robmadeyou.World.*;

public class TileGrid {

    private Tile[][] tiles = new Tile[BLOCKS_WIDTH][BLOCKS_HEIGHT];

    public TileGrid() {
        for (int x = 0; x < BLOCKS_WIDTH - 1; x++) {
            for (int y = 0; y < BLOCKS_HEIGHT - 1; y++) {
                tiles[x][y] = new Tile(TileType.AIR, x * BLOCK_SIZE, y
                        * BLOCK_SIZE);
            }
        }
    }
    public void setAt(int x, int y, TileType b) {
        tiles[x][y] = new Tile(b, x * BLOCK_SIZE, y * BLOCK_SIZE);
    }

    public Tile getAt(int x, int y) {
        return tiles[x][y];
    }
    public void setRotation(int x, int y, int rotation){
    	tiles[x][y].rotation += rotation;
    }

    public void draw() {
        for (int x = 0; x < BLOCKS_WIDTH - 1; x++) {
            for (int y = 0; y < BLOCKS_HEIGHT - 1; y++) {
                tiles[x][y].draw();
            }
        }
    }

    public void clear() {
        for (int x = 0; x < BLOCKS_WIDTH - 1; x++) {
            for (int y = 0; y < BLOCKS_HEIGHT - 1; y++) {
                tiles[x][y] = new Tile(TileType.AIR, x * BLOCK_SIZE, y * BLOCK_SIZE);
            }
        }
    }
}