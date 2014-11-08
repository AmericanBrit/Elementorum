package net.lbsg.elementorum.sprites;
package input.gamefromscratch.com;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
public class Player extends Sprite{
	public Player(TextureRegion region){
		super(region);
		
		
	}
	
	 @Override
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
