/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameWorld.Game.Objects;

import GameObjects.AbstractWindow;
import GameObjects.Button;
import GameWorld.Maps.MapsWorld;
import Helper.FontLoader;
import Helper.Statistic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.mygdx.game.GameLibGDX;
import com.mygdx.game.screen.GameScreen;
import com.mygdx.game.screen.MainScreen;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class BuyMapWindow extends AbstractWindow {
    
    private static BuyMapWindow instance;

    private unScrollWindowThread mapSwt;
    private Thread mapThread;
    
    private int mapCost = 0;
    private MapsWorld mapsWorld;

    private BuyMapWindow(Stage stage, MapsWorld mapsWorld) {
        super(stage);
        width = stage.getWidth() / 2;
        height = stage.getHeight() * 3 / 5;
        this.mapsWorld = mapsWorld;
    }
    
    public void Check(GameLibGDX game){  //ЧЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕК
        super.createWindow(game);
    }
    

        public static BuyMapWindow GetInstance(Stage stage, MapsWorld mapsWorld){
        if (instance==null){
            instance = new BuyMapWindow(stage, mapsWorld);
        }
        return instance;
    }

    @Override
    protected void initText() {
        Label textLabel;
        Label.LabelStyle labelS = new Label.LabelStyle();
        labelS.font = new BitmapFont();
        labelS.fontColor = Color.WHITE;
        textLabel = new Label("", labelS);
        textLabel.setAlignment(Align.center);
        textLabel.setFontScale(1);
        textLabel.setSize(width / 3, height / 6);
        textLabel.setText("Buy map");
        textLabel.setPosition(xPos + width / 2 - textLabel.getWidth() / 2,
                yPos + height - textLabel.getHeight());
        group.addActor(textLabel);

        Label costLabel;
        costLabel = new Label("", labelS);
        costLabel.setAlignment(Align.center);
        costLabel.setFontScale(1);
        costLabel.setSize(width / 3, height / 6);
        costLabel.setText("" + mapCost);
        costLabel.setPosition(xPos + width / 2 - costLabel.getWidth() / 2,
                yPos + height * 2 / 3);
        group.addActor(costLabel);
    }

    @Override
    protected void initButtons(final GameLibGDX game) {
        Button buyButton = new Button("Buy", normalState, pressedState, "BUY", FontLoader.font) {
            public void action() {
                Gdx.app.log("check", "CONFIRM");
                mapsWorld.touchConfirm();
                //game.setScreen(new GameScreen(game));
            }
        };
        buyButton.setSize(width / 5, height / 6);
        buyButton.setPosition(xPos, yPos);
        group.addActor(buyButton);

        Button cancelButton = new Button("Cancel", normalState, pressedState, "CANCEL", FontLoader.font) {
            public void action() {
                Gdx.app.log("check", "CANCEL");

                mapsWorld.setIsCancel(true);
            }
        };
        cancelButton.setSize(width / 5, height / 6);
        cancelButton.setPosition(xPos + width - cancelButton.getWidth(), yPos);
        group.addActor(cancelButton);
    }
    
        public void unScroll() {
        mapSwt = new unScrollWindowThread();
        mapThread = new Thread(mapSwt);
        mapThread.start();
        if (group.getY()<=0){
            this.deleteWindow();
        }
        
        
    }
    
        public class unScrollWindowThread implements Runnable {

        public unScrollWindowThread() {
        }

        @Override
        public void run() {
            do {
                group.setY(group.getY() - 1);
                try {
                    sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AbstractWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (group.getY() > 0);
            
        }

    }
        

    
}