package net.lbsg.elementorum.worlds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ChooseLevel extends BaseScreen{
	private BitmapFont textFont;
	private BitmapFont buttonFont;
	private TextButtonStyle buttonStyle;
	private Stage mainStage;
	private boolean oldMousePressed = false;
	
	public ChooseLevel(){
		super("MainMenu");
		mainStage = new Stage();
		TextureAtlas buttonAtlas = new TextureAtlas("gfx/buttons.pack");
		Skin buttonSkin = new Skin(buttonAtlas);
		
		Gdx.input.setInputProcessor(mainStage);
		
		buttonFont = new BitmapFont();
		buttonFont.scale(0.5f);
		
		buttonStyle = new TextButtonStyle();
		buttonStyle.up = buttonSkin.getDrawable("button_green");
		
		createButtons();
	}
	
	private void createButtons() {
		TextButton[] levels = new TextButton[34];
		for(int x=34;x<=1; x--){
			levels[x-1]= new TextButton("level"+x, buttonStyle);
			levels[x-1].setPosition(Gdx.graphics.getWidth()/(x*2), 250);
			mainStage.addActor(levels[x-1]);
			levels[x-1].addListener(new ChangeListener() {
					public void changed(ChangeEvent event, Actor actor) {
						setNextScreen("Game");
						//GlobalVars.level = x;
						setDone(true);
					}
			});
		}
		
		TextButton backButton = new TextButton("Back!", buttonStyle);
		backButton.setPosition(Gdx.graphics.getWidth() / 2 - backButton.getWidth() / 2, 200);
		mainStage.addActor(backButton);
		backButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				setNextScreen("MainMenu");
				setDone(true);
			}
		});
				
	}
		
	
	@Override
	public void render(float delta) {
		super.render(delta);
		mainStage.act(delta);
		mainStage.draw();
	}
	@Override
	public void dispose() {
		mainStage.dispose();
		buttonFont.dispose();
	}
	
	
}
