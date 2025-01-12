package com.badlogic.maserunner.view;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.maserunner.controller.GameController;

public class PlayerInputProcessor implements InputProcessor {

    private GameController gameController;

    public PlayerInputProcessor(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public boolean keyDown(int keycode) {
        // Transférer les événements de touche au GameController
        gameController.handleInput(keycode);
        return true;  // L'événement est traité
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
