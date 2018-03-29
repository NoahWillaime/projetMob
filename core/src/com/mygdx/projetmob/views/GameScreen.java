package com.mygdx.projetmob.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.projetmob.dataFactories.TextureFactory;
import com.mygdx.projetmob.modele.GameWorld;
import com.mygdx.projetmob.modele.Poele;

/**
 * Created by willaime3u on 29/03/18.
 */

public class GameScreen extends ScreenAdapter {
    private OrthographicCamera camera;
    private Viewport vp;
    private SpriteBatch sb;
    private GameWorld gw;
    private Box2DDebugRenderer debugRenderer;

    public GameScreen(){
        gw = new GameWorld(this);
        sb = new SpriteBatch();
        camera = new OrthographicCamera(TextureFactory.getTexBack().getWidth(), TextureFactory.getTexBack().getHeight());
        vp = new FitViewport(TextureFactory.getTexBack().getWidth(), TextureFactory.getTexBack().getHeight(), camera);
        vp.apply();
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0);
        debugRenderer = new Box2DDebugRenderer();
    }

    public void resize(int width, int height){
        vp.update(width, height);
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0);
    }

    public void render(float delta){
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        update();
        gw.draw(sb);
        sb.end();
    }

    public void update(){
        gw.update();
        float ratio = (float)TextureFactory.getTexBack().getWidth() / (float)Gdx.graphics.getWidth();
        if (Gdx.input.isTouched()){
            Poele poele = gw.getPoele();
            poele.moveTouch(Gdx.input.getX() * ratio);
        }
    }

    public void dispose(){
        sb.dispose();
    }
}
