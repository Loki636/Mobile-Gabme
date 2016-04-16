package GameWorld.Skins.Handler;

import com.badlogic.gdx.InputProcessor;

import java.util.ArrayList;

import GameWorld.Maps.MapsWorld;
import GameWorld.Skins.SkinsWorld;

/**
 * Created by broff on 15.04.2016.
 */
public class SkinsInputHandler implements InputProcessor {

    SkinsWorld world;
    private int _oldX;
    private int temp;
    private boolean isTouched;
    private float min=100000, max=0;

    public SkinsInputHandler(SkinsWorld world){
        this.world = world;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        isTouched = true;
        _oldX = screenX;
        world.getUI().getStage().touchDown(screenX, screenY, pointer, button);
        world.getUI().getGuiStage().touchDown(screenX, screenY, pointer, button);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        isTouched = false;
        world.getUI().getStage().touchUp(screenX, screenY, pointer, button);
        world.getUI().getGuiStage().touchUp(screenX, screenY, pointer, button);
        return true;
    }


    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        //world.getUI().getStage().getCamera().position.x+=temp-screenX;

        temp = _oldX;
        if ((isTouched)){

            _oldX = screenX;
            world.getSkins().moveX(-1* (temp-screenX));
        }
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        return true;
    }

}