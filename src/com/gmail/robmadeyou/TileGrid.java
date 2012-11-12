package com.gmail.robmadeyou;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.gmail.robmadeyou.World.*;

public class TileGrid {

    private Tile[][] blocks = new Tile[BLOCKS_WIDTH][BLOCKS_HEIGHT];

    public TileGrid(File loadFile) {
    }

    public TileGrid() {
        for (int x = 0; x < BLOCKS_WIDTH - 1; x++) {
            for (int y = 0; y < BLOCKS_HEIGHT - 1; y++) {
                blocks[x][y] = new Tile(TileType.AIR, x * BLOCK_SIZE, y
                        * BLOCK_SIZE);
            }
        }
    }
    public void setAt(int x, int y, TileType b) {
        blocks[x][y] = new Tile(b, x * BLOCK_SIZE, y * BLOCK_SIZE);
    }

    public Tile getAt(int x, int y) {
        return blocks[x][y];
    }

    public void draw() {
        for (int x = 0; x < BLOCKS_WIDTH - 1; x++) {
            for (int y = 0; y < BLOCKS_HEIGHT - 1; y++) {
                blocks[x][y].draw();
            }
        }
    }

    public void clear() {
        for (int x = 0; x < BLOCKS_WIDTH - 1; x++) {
            for (int y = 0; y < BLOCKS_HEIGHT - 1; y++) {
                blocks[x][y] = new Tile(TileType.AIR, x * BLOCK_SIZE, y * BLOCK_SIZE);
            }
        }
    }
}