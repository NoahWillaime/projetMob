package com.mygdx.projetmob.modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.WorldManifold;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.projetmob.dataFactories.SoundFactory;
import com.mygdx.projetmob.views.GameScreen;

import java.util.ArrayList;

/**
 * Created by willaime3u on 29/03/18.
 */

public class GameWorld {
    private static float METERS_TO_PIXELS = 250f;
    private static float PIXELS_TO_METERS = 1f/METERS_TO_PIXELS;
    private World world;
    private Background background;
    private Poele poele;
    private Crepe crepe;
    private ArrayList<Crepe> crepes;
    private Timer.Task timer;
    private boolean timerOk;

    public GameWorld(GameScreen screen){
        world = new World(new Vector2(0, -0.5f), true);
        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                WorldManifold wm = contact.getWorldManifold();
                Body obj1 = contact.getFixtureA().getBody();
                Body obj2 = contact.getFixtureB().getBody();
                SoundFactory.listenCollecte(0.5f);
                if (obj1.getType() == BodyDef.BodyType.DynamicBody){
                    crepes.remove(obj1.getUserData());
                } else{
                    crepes.remove(obj2.getUserData());
                }
                System.out.println("Contaxt !");
            }

            @Override
            public void endContact(Contact contact) {

            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });
        background = new Background(this);
        poele = new Poele(this);
        crepes = new ArrayList<Crepe>(1);
        timerOk = true;
        timer = new Timer.Task() {
            @Override
            public void run() {
                createCrepe();
                timerOk = true;
            }
        };
    }

    public void draw(SpriteBatch sb){
        background.draw(sb);
        poele.draw(sb);
        for (Crepe c : crepes) {
            c.draw(sb);
        }
    }

    public void update(){
        world.step(Gdx.graphics.getDeltaTime(),6, 2);
        if (timerOk){
            Timer.schedule(timer, 2);
            timerOk = false;
        }
    }

    public void createCrepe(){
        crepes.add(new Crepe(this));
    }

    public Poele getPoele() {
        return poele;
    }

    public static float getMetersToPixels() {
        return METERS_TO_PIXELS;
    }

    public static float getPixelsToMeters() {
        return PIXELS_TO_METERS;
    }

    public World getWorld() {
        return world;
    }
}
