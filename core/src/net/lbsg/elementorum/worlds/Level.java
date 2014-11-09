package net.lbsg.elementorum.worlds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

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
	
	// Entity variables
	private SpriteBatch batch;
	private Player player;
	private Array<Rectangle> walls = new Array<Rectangle>();
	
	// Constructor:
	public Level() {
		super("Game");
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		cam.update();
		
		batch = new SpriteBatch();
		map =  new TmxMapLoader().load("Lvl1.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map);
		
		MapObjects wallobjects = map.getLayers().get("Walls").getObjects();
		for(int i = 0; i < wallobjects.getCount(); i++) {
			RectangleMapObject obj = (RectangleMapObject) wallobjects.get(i);
			Rectangle rect = obj.getRectangle();
			walls.add(new Rectangle(rect.x, rect.y, 16, 16));
		}
		player = new Player("Player.png", 128, 128, walls);
	}
	
	// Update:
	@Override
	public void render(float delta) {
		super.render(delta);
		
		cam.position.set(player.getX(), player.getY(), 0f);
		cam.update();
		mapRenderer.setView(cam);
		mapRenderer.render();
		
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		player.render(delta, batch);
		batch.end();
	}
	
	// Dispose:
	@Override
	public void dispose() {
		map.dispose();
	}
}
