package com.badlogic.maserunner.controller;

import static java.nio.file.Files.move;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.maserunner.model.Player;
import com.badlogic.maserunner.model.Wall;
import com.badlogic.maserunner.view.PlayerInputProcessor;

public class GameController {

    private Player player;
    private Wall wall;
    private float speed = 1.0f;

    public GameController(Player player, Wall wall) {
        this.player = player;
        this.wall = wall;
    }

    public void update() {

    }

    public void handleInput(int keycode) {
        // Traitez l'entrée utilisateur ici pour éviter de le faire dans PlayerInputProcessor
        switch (keycode) {
            case Input.Keys.UP:
                player.move(0, 14);  // Exemple de mouvement vers le haut
                break;
            case Input.Keys.DOWN:
                player.move(0, -14);  // Exemple de mouvement vers le bas
                break;
            case Input.Keys.LEFT:
                player.move(-14, 0);  // Exemple de mouvement vers la gauche
                break;
            case Input.Keys.RIGHT:
                player.move(14, 0);  // Exemple de mouvement vers la droite
                break;
        }
    }

}
