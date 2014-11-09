package net.lbsg.elementorum.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends Sprite{
	private final float SPEED = 300f;
	
	public Player(String imgpath, float x, float y){
		super(new Texture(imgpath));
		
		setOrigin(x, y);
	}
	
	public void render(float delta, SpriteBatch batch) {
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			translateX(-SPEED*delta);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			translateX(SPEED*delta);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			translateY(SPEED*delta);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)){
			translateY(-SPEED*delta);
		}
		
		super.draw(batch);
	}
}
