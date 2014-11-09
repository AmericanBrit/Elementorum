package net.lbsg.elementorum.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Spell extends Sprite{
	private int direction;
	private final float SPEED = 300;
	private String type;

	public Spell(String imgpath, int direction, String type, float x, float y){
		super(new Texture(imgpath));
		this.direction = direction;
		this.type = type;
		if (type== "Fire" || type == "Rock"){
			this.setRotation((direction-1)*90);
		}
		else if(type == "Water"|| type == "Hooman"){
			this.setRotation((direction)*90);
		}
		setCenter(x,y);
	}
	
	public void render(float delta, SpriteBatch batch){
		if (direction == 0)
			translateY(SPEED*delta);
		else if (direction == 1)
			translateX(SPEED*delta*-1);
		else if (direction == 2)
			translateY(SPEED*delta*-1);
		else
			translateX(SPEED*delta);
		super.draw(batch);
	}
	
	public int getDirection(){
		return direction;
	}
	
	
	
	public String getType() { return type; }
}
