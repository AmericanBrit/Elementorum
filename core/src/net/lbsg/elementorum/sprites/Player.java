package net.lbsg.elementorum.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends Sprite{
	private final float SPEED = 50f;
	private int direction;
	public Player(String imgpath, float x, float y){
		super(new Texture(imgpath));
		direction = 0;
		setOrigin(x, y);
	}
	
	public void render(float delta, SpriteBatch batch) {
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			translateX(-SPEED);
			direction = 1;
		} else if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			translateX(SPEED);
			direction = 3;
		} else if(Gdx.input.isKeyPressed(Input.Keys.W)){
			translateY(SPEED);
			direction = 0;
		} else if(Gdx.input.isKeyPressed(Input.Keys.S)){
			translateY(-SPEED);
			direction = 2;
		}
		
		super.draw(batch);
	}
	
	public int getDirection(){
		return direction;
	
	}
}
