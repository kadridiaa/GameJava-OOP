package com.badlogic.maserunner.controller;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.maserunner.model.Cell;

import java.util.ArrayList;
import java.util.List;

public class CellManager {
    private List<Cell> cells;
    private String mapFilePath ;
    private int layerId;

    public CellManager(String mapFilePath ,int layerId) {
        cells = new ArrayList<>();
        this.mapFilePath = mapFilePath;
        this.layerId = layerId;

    }

    public TiledMapTileLayer loadCellsLayer() {
        // Charger la map Tiled
        TiledMap tiledMap = new TmxMapLoader().load(mapFilePath);
        // Récupérer une couche spécifique
        TiledMapTileLayer tileLayer = (TiledMapTileLayer) tiledMap.getLayers().get(0);
        return tileLayer;

    }


}

