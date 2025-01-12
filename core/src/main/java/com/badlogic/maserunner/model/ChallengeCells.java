package com.badlogic.maserunner.model;

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
        TiledMapTileLayer tileLayer = (TiledMapTileLayer) tiledMap.getLayers().get("challenge");
        for (int row = 0; row < tileLayer.getHeight(); row++) {
            for (int column = 0; column < tileLayer.getWidth(); column++) {
                TiledMapTileLayer.Cell tiledCell = tileLayer.getCell(column, row);
                Cell cell = new Cell(column, row, tiledCell);

                if (cell.isChallengeCell()) {
                    challengeCells.add(cell);
                }
            }
        }
        System.out.println("Nombre de cellules de défi: " + challengeCells.size());
    }

    public boolean isChallengeCell(int column, int row) {
        for (Cell cell : challengeCells) {
            if (cell.getColumn() == column && cell.getRow() == row) {
                return true;
            }
        }
        return false;
    }

    public List<Cell> getChallengeCells() {
        return challengeCells;
    }
}
