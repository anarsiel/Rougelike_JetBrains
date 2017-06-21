package com.example.dimitrov.rougelike.objects;

import android.graphics.Canvas;

import com.example.dimitrov.rougelike.R;
import com.example.dimitrov.rougelike.core.Graphics;
import com.example.dimitrov.rougelike.core.GraphicsUser;


public class Character implements GraphicsUser {
    private int X;
    private int Y;
    private int hp;
    protected String texture;

    public Character(int x, int y, int hp) {
        X = x;
        Y = y;
        this.hp = hp;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public void onDraw(Canvas canvas, Graphics core) {
        core.drawBitmap(canvas, core.resizeBitmap(core.getBitmap(texture),
                (int) (core.scale) + 1, (int) (core.scale) + 1),
                (int) ((X - core.cameraX) * core.scale),
                (int) ((Y - core.cameraY) * core.scale));
    }

    @Override
    public void getBitmaps(Graphics core) {
        core.setBitmap("green", core.readBitmap(R.mipmap.green));
        core.setBitmap("greenzombie", core.readBitmap(R.mipmap.greenzombie));
        core.setBitmap("red", core.readBitmap(R.mipmap.red));
        core.setBitmap("triangle", core.readBitmap(R.mipmap.triangle));
    }
}
