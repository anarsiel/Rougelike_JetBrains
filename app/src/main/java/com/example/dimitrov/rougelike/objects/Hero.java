package com.example.dimitrov.rougelike.objects;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.dimitrov.rougelike.core.Graphics;

public class Hero extends Character {
    public Hero(int x, int y, int hp) {
        super(x, y, hp);
        texture = "green";
        viewRadius = (255 / fadeRate + 1.71f) * thickness;
    }

    public double viewRadius;

    float thickness = .5f;
    int fadeRate = 10;

    @Override
    public void onDraw(Canvas canvas, Graphics core) {
        super.onDraw(canvas, core);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(thickness * core.scale);

        int alpha = 0;
        for (float i = 0; i < core.sideSize * 2; i += thickness*0.98) {
            if (alpha > 255)
                alpha = 255;
            paint.setAlpha(alpha);
            canvas.drawCircle(
                    (int) ((x - core.cameraX + .5f) * core.scale),
                    (int) ((y - core.cameraY + .5f) * core.scale), i * core.scale, paint);
            alpha += fadeRate;
        }
    }
}
