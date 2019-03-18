package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Cannon {
    private Texture texture;
    private Vector2 mousePosition;
    private float x,y;

    public Cannon() {
        texture = new Texture("cannon512.png");
        mousePosition = new Vector2(0.0f, 0.0f);
    }

    public void render(SpriteBatch batch) {batch.draw(texture, 0, 0, 0,0,512,512,0.1f,0.1f,0.0f, 0, 0, 512, 512, false, false);}

    public void update(float dt) {
        if (Gdx.input.isTouched()) {
            mousePosition.x=Gdx.input.getX()*dt*50;
            mousePosition.y=(720-Gdx.input.getY())*dt*50;
        }
        if (!VectorGame.rock.activity){
            shot();
        }
    }

    public void shot(){
        VectorGame.rock.shot(mousePosition);
    }
}
