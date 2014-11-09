package net.lbsg.elementorum.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Object extends Sprite{
	private float direction;
	private String type;
	public Object(TextureRegion region, float x, float y, String type){
		super(region);
		this.direction = direction;
		this.type = type;
		setOrigin(x,y);
		direction = 0;
	}
	
	
	public String getType() { return type; }
}
