package com.mygdx.projetmob.modele;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.mygdx.projetmob.dataFactories.TextureFactory;

import java.util.Random;

/**
 * Created by willaime3u on 29/03/18.
 */

public class Crepe {
    private GameWorld gw;
    private Vector2 pos;
    private Body body;

    public Crepe(GameWorld gaw){
        gw = gaw;
        pos = new Vector2();
        Random rand = new Random();
        pos.x = rand.nextInt(TextureFactory.getTexBack().getWidth() - TextureFactory.getTexCrepe().getWidth());
        pos.y = TextureFactory.getTexBack().getHeight() - TextureFactory.getTexCrepe().getHeight();
        float convert = GameWorld.getPixelsToMeters();
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set((pos.x)*convert, (pos.y-1)*convert);
        body = gw.getWorld().createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape ps = new PolygonShape();
        int height = TextureFactory.getTexCrepe().getHeight();
        int width = TextureFactory.getTexCrepe().getWidth();
        float pts[] = {(pos.x)*convert, (pos.y)*convert, (pos.x)*convert, (pos.y + height)*convert, (pos.x+width)*convert, (pos.y+height)*convert, (pos.x+width)*convert, (pos.y)*convert};
        ps.set(pts);
        fixtureDef.shape = ps;
        fixtureDef.density = 1f;
        fixtureDef.restitution = 1f;
        fixtureDef.friction = 0f;
        body.createFixture(fixtureDef);
        ps.dispose();
        body.setUserData(this);
    }

    public void draw(SpriteBatch sb){
        Vector2 pos = body.getPosition();
        pos.x *= GameWorld.getMetersToPixels();
        pos.y *= GameWorld.getMetersToPixels();
        sb.draw(TextureFactory.getTexCrepe(), pos.x, pos.y);
    }

    public Vector2 getPos(){
        return body.getPosition();
    }
}
