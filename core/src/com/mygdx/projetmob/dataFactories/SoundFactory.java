package com.mygdx.projetmob.dataFactories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by willaime3u on 29/03/18.
 */

public class SoundFactory {
    private static final Sound soundCollecte = Gdx.audio.newSound(Gdx.files.internal("sounds/collecte.mp3"));

    public static void listenCollecte(float volume){
        soundCollecte.play(volume);
    }
}
