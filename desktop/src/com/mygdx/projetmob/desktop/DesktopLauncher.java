package com.mygdx.projetmob.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.projetmob.dataFactories.TextureFactory;
import com.mygdx.projetmob.projetMob;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new projetMob(), config);
		config.a = 8;
		/*config.width = 1800;
		config.height = 1400;*/
		new LwjglApplication(new projetMob(), config);
	}
}
