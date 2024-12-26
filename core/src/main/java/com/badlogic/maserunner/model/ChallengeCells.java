package com.badlogic.maserunner.model;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.ArrayList;
import java.util.List;

public class ChallengeCells {
    private List<Cell> challengeCells;

    public ChallengeCells() {
        challengeCells = new ArrayList<>();
    }

    public void loadChallengeCells(TiledMap tiledMap) {
        TiledMapTileLayer tileLayer = (TiledMapTileLayer) tiledMap.getLayers().get("Calque de Tuiles 1");

        for (int row = 0; row < tileLayer.getHeight(); row++) {
            for (int column = 0; column < tileLayer.getWidth(); column++) {
                TiledMapTileLayer.Cell tiledCell = tileLayer.getCell(column, row);

                if (tiledCell != null && tiledCell.getTile() != null) {
                    MapProperties properties = tiledCell.getTile().getProperties();

                    if (properties.containsKey("Challenge") && properties.get("Challenge").equals("true")) {
                        // Ajoutez la cellule à la liste des challengeCells
                        challengeCells.add(new Cell(column, row, tiledCell));
                    }
                }
            }
        }
    }

    public boolean isChallengeCell(int column, int row) {
        for (Cell cell : challengeCells) {
            if (cell.getColumn() == column && cell.getRow() == row) {
                return true;  // La cellule contient un défi
            }
        }
        return false;  // Pas de défi sur cette cellule
    }
}
