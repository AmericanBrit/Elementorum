package net.lbsg.elementorum.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Luke Lemke, Nicolás A. Ortega
 * @copyright Stepan Subbotin
 * @license GNU Affero GPLv3
 * @year 2014
 * 
 * Description: Where the game works.
 * 
 */
public class Spell extends Sprite{
	private int direction;
	private final float SPEED = 30; //Don't raise any higher: was 300, which is why the spells weren't working - Meek 
	private String type;

	public Spell(String imgpath, int direction, String type, float x, float y){
		super(new Texture(imgpath));
		this.direction = direction;
		this.type = type;
		if (type== "Fire" || type == "Rock") this.setRotation((direction-1)*90);
		else if(type == "Water"|| type == "Hooman") this.setRotation((direction)*90); // I see what you did there, hooman :D
		setCenter(x,y);
	}
	
	public void render(float delta, SpriteBatch batch) {
		if(direction == 0) translateY(SPEED);
		else if(direction == 1) translateX(-SPEED);
		else if(direction == 2) translateY(-SPEED);
		else translateX(SPEED);
		
		super.draw(batch);
	}
	
	public int getDirection() { return direction; }
	public String getType() { return type; }
}
