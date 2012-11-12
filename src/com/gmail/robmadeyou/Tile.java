package com.gmail.robmadeyou;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import com.gmail.robmadeyou.TileType;
import com.gmail.robmadeyou.World;

public class Tile {

    private TileType type = TileType.AIR;
    private Texture texture = null;
    private float x;
    private float y;

    public Tile(TileType type, float x, float y) {
        this.type = type;
        this.x = x;
        this.y = y;
        try {
            this.texture = TextureLoader.getTexture("PNG", new FileInputStream(new File(type.location)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bind() {
        texture.bind();
    }

    public void draw() {
        texture.bind();
        glLoadIdentity();
        glTranslatef(x, y, 0);
        glBegin(GL_QUADS);
        glTexCoord2f(0, 0);
        glVertex2f(World.BLOCK_SIZE, World.BLOCK_SIZE);
        glTexCoord2f(1, 0);
        glVertex2f(World.BLOCK_SIZE + World.BLOCK_SIZE, World.BLOCK_SIZE);
        glTexCoord2f(1, 1);
        glVertex2f(World.BLOCK_SIZE + World.BLOCK_SIZE, World.BLOCK_SIZE + World.BLOCK_SIZE);
        glTexCoord2f(0, 1);
        glVertex2f(World.BLOCK_SIZE, World.BLOCK_SIZE + World.BLOCK_SIZE);
        glEnd();
        glLoadIdentity();
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
