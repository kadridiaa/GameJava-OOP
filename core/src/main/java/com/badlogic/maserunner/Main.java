package com.badlogic.maserunner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.maserunner.model.Maze;
import com.badlogic.maserunner.model.Wall;
import com.badlogic.maserunner.model.WinCells;
import com.badlogic.maserunner.view.MainMenuScreen;
import com.badlogic.maserunner.view.MazeView;


public class Main extends Game {

    @Override
    public void create() {
        // Créer une instance du modèle Maze
            Maze maze = new Maze("maps/simple.tmx");  // Charger le fichier TMX du labyrinthe
        // Créer une instance de la vue MazeView en lui passant l'instance de Maze
        MazeView mazeView = new MazeView(maze , this);
        // Définir MazeView comme l'écran actuel du jeu
        setScreen(new MainMenuScreen(this));
        Wall wall = new Wall();
        WinCells win = new WinCells();
        TiledMap tiledMap = new TmxMapLoader().load("maps/simple.tmx");
        wall.loadBlockedCells(tiledMap);
        win.loadWinCells(tiledMap);


    }

    @Override
    public void render() {
        super.render();
    }



    @Override
    public void dispose() {
        super.dispose();
    }
}
