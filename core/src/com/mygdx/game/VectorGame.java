package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class VectorGame extends ApplicationAdapter {
    // Домашнее задание:
    // У нас есть пушка в левом нижнем углу экрана (пушку можно не рисовать)
    // Кликая мышкой по экрану пушка должна стрельнуть камнем в этом направлении
    // На камень действует сила тяжести
    // Камнем можно повторно стрельнуть, только если он вылетел за пределы экрана

    SpriteBatch batch;
    Texture textureAsteroids;
    TextureRegion astReg;
    static Rock rock;
    Cannon cannon;


    @Override
    public void create() {
        batch = new SpriteBatch();
        textureAsteroids = new Texture("asteroids64.png");
        astReg = new TextureRegion(textureAsteroids, 0, 0, 64, 64);
        rock = new Rock(astReg);
        cannon = new Cannon();
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        update(dt);
        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        if (rock.activity){
            rock.render(batch);
        }
        cannon.render(batch);
        batch.end();
    }

    public void update(float dt) {
        cannon.update(dt);
        if (rock.activity){
            rock.update(dt);
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
