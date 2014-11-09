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

public class MainMenu extends BaseScreen {
	
	private BitmapFont textFont;
	private BitmapFont buttonFont;
	private TextButtonStyle buttonStyle;
	private Stage mainStage;
	private boolean oldMousePressed = false;
	
	public MainMenu() {
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
		TextButton playButton = new TextButton("Play", buttonStyle);
		playButton.setPosition(Gdx.graphics.getWidth() / 2 - playButton.getWidth() / 2, 250);
		mainStage.addActor(playButton);
		playButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				setNextScreen("Game");
				setDone(true);
			}
		});
		
		TextButton creditsButton = new TextButton("Credits", buttonStyle);
		creditsButton.setPosition(Gdx.graphics.getWidth() / 2 - creditsButton.getWidth() / 2, 200);
		mainStage.addActor(creditsButton);
		creditsButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				// Change to Credits Menu
			}
		});
		
		if(Gdx.app.getType() == ApplicationType.Desktop) {
			TextButton exitButton = new TextButton("Exit", buttonStyle);
			exitButton.setPosition(Gdx.graphics.getWidth() / 2 - exitButton.getWidth() / 2, creditsButton.getY() - exitButton.getHeight());
			mainStage.addActor(exitButton);
			exitButton.addListener(new ChangeListener() {
				public void changed(ChangeEvent event, Actor actor) {
					// Quit the application
					Gdx.app.exit();
				}
			});
		}		
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
