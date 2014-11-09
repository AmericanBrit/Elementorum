package net.lbsg.elementorum.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Wall extends Sprite{
	public Wall(TextureRegion region,xCoor,yCoor){
		
		setOrigin(xCoor,yCoor);
		super(region);

	}
	
}
