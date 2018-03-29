package com.mygdx.projetmob.dataFactories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by willaime3u on 29/03/18.
 */

public class TextureFactory {
    private static final Texture texBack = new Texture(Gdx.files.internal("images/cuisine.jpeg"));
    private static final Texture texPoele = new Texture(Gdx.files.internal("images/poele.png"));
    private static final Texture texCrepe = new Texture(Gdx.files.internal("images/crepe.png"));
    public static Texture getTexBack() {
        return texBack;
    }

    public static Texture getTexPoele() {
        return texPoele;
    }

    public static Texture getTexCrepe() {
        return texCrepe;
    }
}
