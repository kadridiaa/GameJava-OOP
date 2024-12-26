package com.badlogic.maserunner.controller;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.maserunner.model.Cell;
import com.badlogic.maserunner.model.Wall;

import java.util.ArrayList;
import java.util.List;

public class CellManager {
    private List<Cell> cells;

    public CellManager(String mapFilePath) {
        cells = new ArrayList<>();
        loadCells(mapFilePath);
    }

    private void loadCells(String mapFilePath) {
        // Charger la map Tiled
        TiledMap tiledMap = new TmxMapLoader().load(mapFilePath);

        // Récupérer une couche spécifique (par exemple, la première couche)
        TiledMapTileLayer tileLayer = (TiledMapTileLayer) tiledMap.getLayers().get(0);

    }

    public List<Cell> getCells() {
        return cells;
    }

}

