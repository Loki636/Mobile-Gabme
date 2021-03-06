/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.screen;

import GameWorld.BuyCoins.BuyCoinsRenderer;
import GameWorld.BuyCoins.BuyCoinsWorld;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.GameLibGDX;

/**
 *
 * @author qw
 */
public class BuyCoinsScreen extends AbstractScreen {

    public BuyCoinsWorld world;
    public BuyCoinsRenderer render;

    public BuyCoinsScreen(GameLibGDX game) {
        super(game);
        Gdx.app.log("BuyCoinsScreen", "main screen created");
    }

    @Override
    protected void initScene() {
        Gdx.app.log("BuyCoinsScreen", "initScene");
        this.world = new BuyCoinsWorld(ui, game);
        this.render = new BuyCoinsRenderer(world);
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        render.render();
    }

    @Override
    public void backPress(){
        game.setScreen(new MainScreen(game));
    }
}
