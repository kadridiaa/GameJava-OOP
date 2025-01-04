package com.badlogic.maserunner.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Maze {
    private TiledMap map;
    private Player player;
    private Wall wall;  // Référence à Wall pour gérer les collisions

    // Constructeur de Maze qui charge la carte et initialise le joueur et le mur
    public Maze(String mapFilePath) {
        this.map = new TmxMapLoader().load(mapFilePath);
        this.wall = new Wall();
        wall.loadBlockedCells(map);  // Charger les cellules bloquées dans le wall
        this.player = new Player(100, 100, wall);  // Passer Wall au joueur
    }

    // Méthode pour obtenir la carte
    public TiledMap getMap() {
        return map;
    }

    // Méthode pour obtenir le joueur
    public Player getPlayer() {
        return player;
    }

    // Méthode pour libérer les ressources liées à la carte
    public void dispose() {
        if (map != null) {
            map.dispose();
        }
    }
}
