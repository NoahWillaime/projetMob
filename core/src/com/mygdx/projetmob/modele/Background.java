package com.mygdx.projetmob.modele;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.projetmob.dataFactories.TextureFactory;

/**
 * Created by willaime3u on 29/03/18.
 */

public class Background {
    private GameWorld gw;

    public Background(GameWorld gaw){
        gw = gaw;
    }

    public void draw(SpriteBatch sb){
        Vector2 pos = new Vector2();
        pos.x = 0;
        pos.y = 0;
        sb.draw(TextureFactory.getTexBack(), pos.x, pos.y);
    }
}
