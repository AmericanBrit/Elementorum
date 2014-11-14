package net.lbsg.elementorum.worlds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * @author Stepan Subbotin, Nicolás A. Ortega
 * @copyright Stepan Subbotin
 * @license GNU Affero GPLv3
 * @year 2014
 * 
 * Description: The main menu of the game
 * 
 */
public class MainMenu extends BaseScreen {
	
	private BitmapFont textFont;
	private BitmapFont buttonFont;
	private TextButtonStyle buttonStyle;
	private Stage mainStage;
	private boolean oldMousePressed = false;
	
	public MainMenu() {
		super("MainMenu");
		mainStage = new Stage();
		TextureAtlas buttonAtlas = new TextureAtlas("ui/Buttons.pack");
		Skin buttonSkin = new Skin(buttonAtlas);
		
		Gdx.input.setInputProcessor(mainStage);
		
		buttonFont = new BitmapFont();
		buttonFont.scale(1.25f);
		
		buttonStyle = new TextButtonStyle();
		buttonStyle.up = buttonSkin.getDrawable("Button2");
		buttonStyle.font = buttonFont;
		
		createButtons();
	}		
	
	private void createButtons() {
		TextButton playButton = new TextButton("Play", buttonStyle);
		playButton.setPosition(Gdx.graphics.getWidth() / 2 - playButton.getWidth() / 2, 300);
		mainStage.addActor(playButton);
		playButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				setNextScreen("Level");
				setDone(true);
			}
		});
		
		/*TextButton creditsButton = new TextButton("Credits", buttonStyle);
		creditsButton.setPosition(Gdx.graphics.getWidth() / 2 - creditsButton.getWidth() / 2, 250);
		mainStage.addActor(creditsButton);
		creditsButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				// Change to Credits Menu
			}
		});*/
		
		if(Gdx.app.getType() == ApplicationType.Desktop) {
			TextButton exitButton = new TextButton("Exit", buttonStyle);
			exitButton.setPosition(Gdx.graphics.getWidth() / 2 - exitButton.getWidth() / 2, 200);
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
