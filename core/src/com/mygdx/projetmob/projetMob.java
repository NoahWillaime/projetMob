package com.mygdx.projetmob;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.projetmob.views.GameScreen;

public class projetMob extends Game {
	private GameScreen gs;
	
	@Override
	public void create () {
		gs = new GameScreen();
		setScreen(gs);
	}
	
	@Override
	public void dispose () {
		gs.dispose();
	}
}
