package net.lbsg.elementorum;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import net.lbsg.elementorum.worlds.*;

/**
 * @author Nicolás A. Ortega
 * @copyright Stepan Subbotin
 * @license GNU Affero GPLv3
 * @year 2014
 * 
 * Description: The main class for the game.
 * 
 */
public class Elementorum extends Game {
	// Create:
	@Override
	public void create() {
		setScreen(new Level());
	}
	
	// Update:
	@Override
	public void render() {
		// Obtain the current running screen
		BaseScreen currentScreen = (BaseScreen)super.getScreen();
		
		// Update the screen
		currentScreen.render(Gdx.graphics.getDeltaTime());
		
		// Switch if screen is done
		if(currentScreen.isDone()) {
			// Dispose of screen for proper memory management
			currentScreen.dispose();
			// Set the new screen:
			if(currentScreen.getNextScreen().equals("Level")) {
				setScreen(new Level());
			}
		}
	}
	
	// Dispose:
	@Override
	public void dispose() {
		super.getScreen().dispose();
		super.dispose();
	}
}
