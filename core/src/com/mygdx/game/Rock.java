package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Rock {
    Vector2 position;
    Vector2 speed;
    TextureRegion region;
    boolean activity;

    public Rock(TextureRegion region) {
        this.position = new Vector2(0, 0);
        this.region = region;
        this.activity = false;
    }

    public void departure(){
        this.activity = false;
        position.x = 30.0f;
        position.y = 30.0f;
    }

    public void shot(Vector2 speed){
        this.activity = true;
        this.speed = speed;
    }

    public void render(SpriteBatch batch) {
        batch.draw(region, position.x, position.y, 10, 10, 64, 64, 0.3f, 0.3f, 0.0f);
    }

    public void update(float dt) {
        if (this.activity){
            speed.y -= 300.0f * dt;
            position.mulAdd(speed,dt);
            if (position.y < 0.0f) {
                position.y = 0.0f;
                speed.y *= -0.3f;
                speed.x/=10;
            }
            if (speed.x<5 || position.x>1300 || position.y>740){
                departure();
            }
        }
    }
}
