package com.mygdx.game;

import Helper.AssetLoader;
import Helper.BuffsInfo;
import Helper.DailyGiftHandler;
import Helper.FontLoader;
import Helper.InputHandler;
import Helper.Statistic;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.game.screen.AbstractScreen;
import com.mygdx.game.screen.GameScreen;
import com.mygdx.game.screen.MainScreen;

public class GameLibGDX extends ApplicationAdapter {
    
    private Screen screen;
	
    @Override
    public void create () {
        Gdx.app.log("YetiGame", "app created");
        loadResources();
        setScreen(new MainScreen(this));
    }
    
    private void loadResources(){   
        AssetLoader.load();
        FontLoader.load();
        Statistic.load();
        BuffsInfo.load();
        DailyGiftHandler.load();
    }
        
    public void setScreen (Screen screen) {
        if (this.screen != null) {
            this.screen.hide();
            //this.screen.dispose();
        }
        this.screen = screen;
        if (this.screen != null) {
            this.screen.show();
            this.screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
    }
    
    @Override
    public void render(){
        screen.render(Gdx.graphics.getDeltaTime());
    }
    
    @Override
    public void dispose(){
        AssetLoader.dispose();
        FontLoader.dispose();
    }
    
    public Screen getScreen () {
        return screen;
    }
}
