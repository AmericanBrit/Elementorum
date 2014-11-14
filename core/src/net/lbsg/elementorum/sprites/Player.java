package net.lbsg.elementorum.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

/**
 * @author Ethan Skier, Luke Lemke, Nicolás A. Ortega
 * @copyright Stepan Subbotin
 * @license GNU Affero GPLv3
 * @year 2014
 * 
 * Description: Where the game works.
 * 
 */
public class Player extends Sprite {
	private Array<Rectangle> walls;
	private final float SPEED = 8f;
	private int direction;
	private Texture[] texture = new Texture[6];
	
	private int timer = 0;
	
	public Player(String imgpath, float x, float y, Array<Rectangle> walls, Texture[] tex) {
		super(new Texture(imgpath));
		direction = 2;
		setCenter(x, y);
		this.walls = walls;
		for(int i = 0; i < 6; i++){
		texture[i] = tex[i];
		}
	}
	
	public void render(float delta, SpriteBatch batch) {
		setBounds(getX(), getY(), 16, 16);
		
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			translateX(-SPEED);
			setTexture(texture[0]);
			
			collisionLoop:
			for(int i = 0; i < walls.size; i++) {
				if(getBoundingRectangle().overlaps(walls.get(i))) {
					translateX(SPEED);
					break collisionLoop;
				}
			}
			direction = 1;
		} else if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			translateX(SPEED);
			setTexture(texture[1]);
			collisionLoop:
			for(int i = 0; i < walls.size; i++) {
				if(getBoundingRectangle().overlaps(walls.get(i))) {
					translateX(-SPEED);
					break collisionLoop;
				}
			}
			direction = 3;
		} else if(Gdx.input.isKeyPressed(Input.Keys.W)){
			translateY(SPEED);
			if(timer < 4) setTexture(texture[2]);
			else setTexture(texture[3]);
			
			collisionLoop:
			for(int i = 0; i < walls.size; i++) {
				if(getBoundingRectangle().overlaps(walls.get(i))) {
					translateY(-SPEED);
					break collisionLoop;
				}
			}
			direction = 0;
		} else if(Gdx.input.isKeyPressed(Input.Keys.S)){
			translateY(-SPEED);
			if(timer < 4) setTexture(texture[4]);
			else { setTexture(texture[5]); }
			
			collisionLoop:
			for(int i = 0; i < walls.size; i++) {
				if(getBoundingRectangle().overlaps(walls.get(i))) {
					translateY(SPEED);
					break collisionLoop;
				}
			}
			direction = 2;
		}
		
		timer++;
		if(timer == 7) timer = 0;
		
		super.draw(batch);
	}
	
	public int getDirection() { return direction; }
}
