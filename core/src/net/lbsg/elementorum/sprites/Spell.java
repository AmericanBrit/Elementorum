package net.lbsg.elementorum.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Spell extends Sprite{
	private int direction;
	private final float SPEED = 500;
	public Spell(TextureRegion region, int direction){
		super(region);
		this.direction = direction;
		this.setRotation(direction*90);
	}
	
	public void render(float delta){
		if (direction == 0)
			translateY(SPEED*delta);
		else if (direction == 1)
			translateX(SPEED*delta);
		else if (direction == 2)
			translateY(SPEED*delta*-1);
		else
			translateX(SPEED*delta*-1);
	}
	
}
