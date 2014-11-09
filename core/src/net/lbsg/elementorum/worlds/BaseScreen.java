package net.lbsg.elementorum.worlds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 * @author Nicolás A. Ortega
 * @copyright Stepan Subbotin
 * @license GNU Affero GPLv3
 * @year 2014
 * 
 * Description: A sort of template for all the world classes.
 * 
 */
public class BaseScreen implements Screen {
	// Screen management variables
	private boolean done;
	private String nextScreen;
	
	// Constructor:
	public BaseScreen(String nextScreen) {
		this.nextScreen = nextScreen;
		done = false;
	}
	
	// Update:
	@Override
	public void render(float delta) {
		// Clear the screen
		Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	@Override public void resize(int width, int height) { }	
	@Override public void show() { }
	@Override public void hide() { }
	@Override public void pause() { }
	@Override public void resume() { }
	@Override public void dispose() { }
	
	// Getter methods:
	public boolean isDone() { return done; }
	public String getNextScreen() { return nextScreen; }
	
	// Setter methods:
	public void setDone(boolean done) { this.done = done; }
	public void setNextScreen(String nextScreen) { this.nextScreen = nextScreen; }
}
