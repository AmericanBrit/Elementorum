package net.lbsg.elementorum.worlds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import net.lbsg.elementorum.sprites.*;

/**
 * @author Nicolás A. Ortega
 * @copyright Stepan Subbotin
 * @license GNU Affero GPLv3
 * @year 2014
 * 
 * Description: Where the game works.
 * 
 */
public class Level extends BaseScreen {
	private TiledMap map;
	private OrthographicCamera cam;
	private TiledMapRenderer mapRenderer;
	
	private Player player;
	
	// Constructor:
	public Level() {
		super("Game");
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.update();
		map = new TmxMapLoader().load("gfx/lvl1.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map);
	}
	
	// Update:
	@Override
	public void render(float delta) {
		super.render(delta);
		
		cam.update();
		mapRenderer.setView(cam);
		mapRenderer.render();
	}
	
	// Dispose:
	@Override
	public void dispose() {
		map.dispose();
		mapRenderer.dispose();
	}
}
