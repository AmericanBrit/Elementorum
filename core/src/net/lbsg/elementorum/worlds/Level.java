package net.lbsg.elementorum.worlds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;

import net.lbsg.elementorum.sprites.*;

/**
 * @author Luke Lemke, Nicolás A. Ortega, Meekialle McGee
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
	private Texture wall;
	private Spell spell;
	private Rectangle spellBounds;
	private char ranLetter;
	private Texture[] tex;
	private int timer;
	private final int rockLimit = 10; //Sets total number of rocks allowed to be set
	private Spell[] rockSpell = new Spell[rockLimit];//Array of rocks spell
	private int rockCount = 0; //Counts number of rocks used
	
	// Constructor: 
	public Level() {
		super("Game");
		
		cam = new OrthographicCamera();
		// Setup camera viewport
		cam.setToOrtho(false, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		cam.update();
		
		batch = new SpriteBatch();
		// Load map
		map =  new TmxMapLoader().load("Lvl1.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map);
		
		// Load walls as rectangles in an array
		MapObjects wallobjects = map.getLayers().get("Walls").getObjects();
		for(int i = 0; i < wallobjects.getCount(); i++) {
			RectangleMapObject obj = (RectangleMapObject) wallobjects.get(i);
			Rectangle rect = obj.getRectangle();
			walls.add(new Rectangle(rect.x, rect.y, 16, 16));
		}
		Texture[] tex = new Texture[]{new Texture("Player_Side_Left.png"),new  Texture("Player_Side_Right.png"), new Texture("Player_Behind_1.png"), new Texture("Player_Behind_2.png"),new Texture("Player_Forward1.png"),new Texture("Player.png")};
		player = new Player("Player.png", 120, 120, walls, tex);
		wall = new Texture("Wall.png");
	}
	
	// Update:
	@Override
	public void render(float delta) {
		super.render(delta);
		
		// Center camera on player
		cam.position.set(player.getX(), player.getY(), 0f);
		cam.update();
		// Render the map
		mapRenderer.setView(cam);
		mapRenderer.render();
		
		// Makes spells
		shootSpell();
		
		// Draw player
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		for(int i = 0; i < walls.size; i++) {
			batch.draw(wall, walls.get(i).x, walls.get(i).y);
		}
		
		player.render(delta, batch);
		
		// Draw spell
		if(spell != null) spell.render(delta, batch);
		
		//Check if rockSpell has been used
		if(rockSpell[0] != null){
			//Render all the rocks
			for(int i = 0; i < rockCount; i++){
				rockSpell[i].render(delta, batch);
			}
		}
		batch.end();
		
		//Checks for collisions between spells and walls
		if(spell != null) {
		collisionLoop:
			for(int i = 0; i < walls.size; i++) {
				if(spell.getBoundingRectangle().overlaps(walls.get(i))) {
					spell = null;
					break collisionLoop;
				}
			}
		}
		
		if(spell != null && (spell.getType()=="Water")){
			if(timer > 8){
				timer = 0;
				spell = null;
			}
			timer++;
		}
		
	}
	
	// Dispose:
	@Override
	public void dispose() {
		map.dispose();
	}
	
	public void shootSpell(){
			
		if(Gdx.input.isKeyPressed(Input.Keys.P)&& spell==null){
			spell = new Spell("Player_Forward1.png", player.getDirection(), "Hooman", player.getX(), player.getY());
		}
		if(Gdx.input.isKeyPressed(Input.Keys.U)&&spell==null){
			spell = new Spell("fireball1.png", player.getDirection(), "Fire", player.getX(), player.getY());
		}
		if(Gdx.input.isKeyPressed(Input.Keys.I)&& spell==null){
			spell = new Spell("waterspout2.png", player.getDirection(), "Water", player.getX(), player.getY());
		}
		//Creates rock as long as total number of rocks is less than limit
		if(Gdx.input.isKeyPressed(Input.Keys.O) && rockCount < rockLimit){
			boolean rockColliding = false; 
			//If the rock is not on the wall, create a rock
			rockSpell[rockCount] = new Spell("Rock.png", player.getDirection(), "Rock", player.getX(), player.getY());
			//Checks for collisions between created rock and wall
			rockWallCollisionLoop:
				for(int i = 0; i < walls.size; i++) {
					if(rockSpell[rockCount].getBoundingRectangle().overlaps(walls.get(i))){
						rockColliding = true;
						break rockWallCollisionLoop;
					}
					
				}
			rockSelfCollisionLoop:
				for(int i = 0; i < rockCount; i++){
					if(rockSpell[rockCount].getBoundingRectangle().overlaps(rockSpell[i].getBoundingRectangle())){
						if(!rockColliding) rockColliding = true;
						break rockSelfCollisionLoop;
					}
				}
			if(!rockColliding)
			{
				rockCount ++;
				//Shows that a rock actually HAS been created, only if the created rock doesn't overlap with a wall
				System.out.println("Rock #: " + rockCount + " has been created!");
				rockColliding = false;
			}
		}
	}
	
}
