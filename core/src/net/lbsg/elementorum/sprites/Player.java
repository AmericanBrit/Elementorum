package net.lbsg.elementorum.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class Player extends Sprite{
	private Array<Rectangle> walls;
	private final float SPEED = 16f;
	private int direction;
	public Player(String imgpath, float x, float y, Array<Rectangle> walls){
		super(new Texture(imgpath));
		direction = 0;
		setCenter(x, y);
		this.walls = walls;
	}
	
	public void render(float delta, SpriteBatch batch) {
		setBounds(getX(), getY(), 16, 16);
		
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			translateX(-SPEED);
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
			collisionLoop:
			for(int i = 0; i < walls.size; i++) {
				if(getBoundingRectangle().overlaps(walls.get(i))) {
					translateY(SPEED);
					break collisionLoop;
				}
			}
			direction = 2;
		}
		
		super.draw(batch);
	}
	
	public int getDirection() { return direction; }
}
