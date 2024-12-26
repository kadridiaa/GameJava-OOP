package com.badlogic.maserunner.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.ArrayList;
import java.util.List;

public class Wall {
    private List<Cell> blockedCells;

    public Wall() {
        blockedCells = new ArrayList<>();
    }

    public void loadBlockedCells(TiledMap tiledMap) {
        TiledMapTileLayer tileLayer = (TiledMapTileLayer) tiledMap.getLayers().get("Calque de Tuiles 1");
        int cptBlocked = 0;

        for (int row = 0; row < tileLayer.getHeight(); row++) {
            for (int column = 0; column < tileLayer.getWidth(); column++) {
                TiledMapTileLayer.Cell tiledCell = tileLayer.getCell(column, row);
                // Crée une instance de Cell pour chaque cellule
                Cell cell = new Cell(column, row, tiledCell);
                // Vérifie si la cellule est bloquée
                if (cell.isBlocked()) {
                    blockedCells.add(cell);
                    cptBlocked++;
                }

            }
        }
        System.out.println("Blocked cells: " + cptBlocked);
    }

    public boolean isBlocked(int column, int row) {
        for (Cell cell : blockedCells) {
            if (cell.getColumn() == column && cell.getRow() == row) {
                return true;  // La cellule est bloquée
            }
        }
        return false;  // La cellule n'est pas bloquée
    }
}
