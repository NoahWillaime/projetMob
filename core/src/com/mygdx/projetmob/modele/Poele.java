package com.mygdx.projetmob.modele;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.mygdx.projetmob.dataFactories.TextureFactory;

/**
 * Created by willaime3u on 29/03/18.
 */

public class Poele {
    private GameWorld gw;
    private Vector2 pos;
    private Body body;

    public Poele(GameWorld gw){
        this.gw = gw;
        pos = new Vector2();
        pos.x = TextureFactory.getTexBack().getWidth()/2 - TextureFactory.getTexPoele().getWidth()/2;
        pos.y = (TextureFactory.getTexBack().getHeight()/20);
        float convert = GameWorld.getPixelsToMeters();
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set((pos.x)*convert, (pos.y-1)*convert);
        body = gw.getWorld().createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape ps = new PolygonShape();
        int height = TextureFactory.getTexPoele().getHeight();
        int width = TextureFactory.getTexPoele().getWidth();
        float pts[] = {(pos.x)*convert, (pos.y)*convert, (pos.x)*convert, (pos.y + height)*convert, (pos.x+width)*convert, (pos.y+height)*convert, (pos.x+width)*convert, (pos.y)*convert};
        ps.set(pts);
        fixtureDef.shape = ps;
        fixtureDef.density = 1f;
        fixtureDef.restitution = 1f;
        fixtureDef.friction = 0f;
        body.createFixture(fixtureDef);
        ps.dispose();
    }

    public void moveTouch(float x){
        if (x < body.getPosition().x * GameWorld.getMetersToPixels()){
            moveLeft();
        } else if (x > (body.getPosition().x * GameWorld.getMetersToPixels()) + TextureFactory.getTexPoele().getWidth()) {
            moveRight();
        }
    }

    public void moveRight(){
        Vector2 pos = body.getPosition();
        if (pos.x*GameWorld.getMetersToPixels() + 10 < TextureFactory.getTexBack().getWidth()){
            pos.x += 10*GameWorld.getPixelsToMeters();
            body.setTransform(pos, 0);
        }
    }

    public void moveLeft(){
        Vector2 pos = body.getPosition();
        if (pos.x * GameWorld.getMetersToPixels() - 10 > 0){
            pos.x -= 10*GameWorld.getPixelsToMeters();
            body.setTransform(pos, 0);
        }
    }

    public void draw(SpriteBatch sb){
        Vector2 pos = body.getPosition();
        pos.x *= GameWorld.getMetersToPixels();
        pos.y *= GameWorld.getMetersToPixels();
        sb.draw(TextureFactory.getTexPoele(), pos.x, pos.y);
    }

    public Vector2 getPos(){
        return body.getPosition();
    }
}
