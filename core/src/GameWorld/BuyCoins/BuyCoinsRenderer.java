/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameWorld.BuyCoins;

import GameWorld.Renderer;
import GameWorld.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 *
 * @author qw
 */
public class BuyCoinsRenderer extends Renderer {

    public BuyCoinsRenderer(World world) {
        super(world);
        Gdx.app.log("BuyCoinsRenderer", "create");
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
    
}