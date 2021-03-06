/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameWorld.Maps;

import GameObjects.Map;
import Helper.AssetLoader;
import Helper.FontLoader;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.screen.GameScreen;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public final class MapsLoader {
    private static ArrayList<Map> allMaps;
    private static TextureRegion firstButtonNormalState = AssetLoader.btn;
    private static TextureRegion firstButtonnPressedState = AssetLoader.btnPress;
    private static TextureRegion firstButtonUnboughtState = AssetLoader.btn;
    private static ArrayList<Float> mapLocations;
    public static ArrayList<Map> GetMaps( final MapsWorld world){
        allMaps = new ArrayList<Map>();
        mapLocations = new ArrayList<Float>();
        
          Map tempMap = new Map("0", firstButtonNormalState,
                firstButtonnPressedState, firstButtonUnboughtState, "0", FontLoader.font){
                  
            public void action() {
                System.out.println(this.IsMapBought());
                if (IsMapBought()) {
                    world.getGame().setScreen(new GameScreen(world.getGame()));
                } else {
                    //world.mapToBuy = this;
                    //world.isTouchUnboughtMap = true;
                    world.buyMapWindow.showWindow(world.getGame());
                }
            }
        };
        tempMap.setSize(world.getUI().getStage().getWidth() * 0.4f, world.getUI().getStage().getHeight() / 5);
        tempMap.setPosition((world.getUI().getStage().getWidth() - tempMap.getWidth()) / 2,
                (world.getUI().getStage().getHeight() - tempMap.getHeight()) / 2);

        allMaps.add(tempMap);
        mapLocations.add(tempMap.getX() + tempMap.getWidth() / 2);
        //stage.addActor(tempMap);

        Map tempMap2 = new Map("1", firstButtonNormalState,
                firstButtonnPressedState, firstButtonUnboughtState, "1", FontLoader.font) {
            public void action() {
                System.out.println(this.IsMapBought());
                if (IsMapBought()) {
                    world.getGame().setScreen(new GameScreen(world.getGame()));
                } else {
                    world.mapToBuy = this;
                    world.isTouchUnboughtMap = true;
                    
                    world.buyMapWindow.setCheck(false);
                    
                    world.buyMapWindow.showWindow(world.getGame());
                }
            }
        };
        tempMap2.SetPrice(20);
        tempMap2.setSize(world.getUI().getStage().getWidth() * 0.4f, world.getUI().getStage().getHeight() / 5);
        tempMap2.setPosition((world.getUI().getStage().getWidth() - tempMap.getWidth()) / 2 + tempMap2.getWidth() * 2,
                (world.getUI().getStage().getHeight() - tempMap.getHeight()) / 2);

        allMaps.add(tempMap2);
        mapLocations.add(tempMap2.getX() + tempMap2.getWidth() / 2);
        //stage.addActor(tempMap2);
        
        
                Map tempMap3 = new Map("3", firstButtonNormalState,
                firstButtonnPressedState, firstButtonUnboughtState, "3", FontLoader.font) {
            public void action() {
                System.out.println(this.IsMapBought());
                if (IsMapBought()) {
                    world.getGame().setScreen(new GameScreen(world.getGame()));
                } else {
                    world.mapToBuy = this;
                    world.isTouchUnboughtMap = true;
                    
                    world.buyMapWindow.setCheck(false);
                    
                    world.buyMapWindow.showWindow(world.getGame());
                }
            }
        };
        tempMap3.SetPrice(20);
        tempMap3.setSize(world.getUI().getStage().getWidth() * 0.4f, world.getUI().getStage().getHeight() / 5);
        tempMap3.setPosition((world.getUI().getStage().getWidth() - tempMap.getWidth()) / 2 + tempMap3.getWidth() * 4,
                (world.getUI().getStage().getHeight() - tempMap.getHeight()) / 2);

        allMaps.add(tempMap3);
        mapLocations.add(tempMap3.getX() + tempMap3.getWidth() / 2);
        

        return allMaps;
        
    }
    
    public static ArrayList<Float> GetMapsLocations(){
        return mapLocations;
    }
}
