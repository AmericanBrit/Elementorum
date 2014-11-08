package net.lbsg.elementorum.sprites;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Sprite;
public class Player extends Sprite{
	public Player(TextureRegion region){
		super(region);
		
		
	}
	
	
	    public void render() {        
	       
	        
	        if(Gdx.input.isKeyPressed(Input.Keys.A)){
	                translateX(-1f);
	                
	            
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.D)){
	                translateX(1f);
	           
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.W)){
	        		translateY(1f);
	        		
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.D)){
	        		translateY(-1f);
	        }
	    }
}
