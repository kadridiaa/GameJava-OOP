package com.badlogic.maserunner.controller;

import com.badlogic.gdx.Input;
import com.badlogic.maserunner.model.Direction;
import com.badlogic.maserunner.model.Player;
import com.badlogic.maserunner.model.Wall;

public class GameController {

    private Player player;
    private Wall wall;
    private float speed = 1.0f;

    public GameController(Player player, Wall wall) {
        this.player = player;
        this.wall = wall;
    }



    public void update() {}

    public void handleInput(int keycode) {
        Direction direction = getDirectionFromKeycode(keycode);

        switch (direction) {
            case UP:
                player.move(0, 16);
                break;
            case DOWN:
                player.move(0, -16);
                break;
            case LEFT:
                player.move(-16, 0);
                break;
            case RIGHT:
                player.move(16, 0);
                break;
            default:
                // Ne rien faire si aucune direction n'est valide
                break;
        }
    }

    private Direction getDirectionFromKeycode(int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
                return Direction.UP;
            case Input.Keys.DOWN:
                return Direction.DOWN;
            case Input.Keys.LEFT:
                return Direction.LEFT;
            case Input.Keys.RIGHT:
                return Direction.RIGHT;
            default:
                return Direction.NONE;
        }
    }
}
