package net.lbsg.elementorum.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.lbsg.elementorum.Elementorum;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Elementorum";
		config.width = 640;
		config.height = 480;
		config.foregroundFPS = 15;
		config.backgroundFPS = 45;
		new LwjglApplication(new Elementorum(), config);
	}
}
