package com.badlogic.maserunner.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import java.util.AbstractMap;

import java.util.ArrayList;
import java.util.List;

public class DoorCells {
    private List<Cell> blockedDoorCells;
    List<AbstractMap.SimpleEntry<Integer, Integer>> cellsPosition;


    public DoorCells() {
        blockedDoorCells = new ArrayList<>();
        cellsPosition  = new ArrayList<>();
    }


    public void loadblockedDoorCells(TiledMap tiledMap) {
        TiledMapTileLayer tileLayer = (TiledMapTileLayer) tiledMap.getLayers().get("door");
        int cptBlocked = 0;
        for (int row = 0; row < tileLayer.getHeight(); row++) {
            for (int column = 0; column < tileLayer.getWidth(); column++) {
                TiledMapTileLayer.Cell tiledCell = tileLayer.getCell(column, row);
                // Crée une instance de Cell pour chaque cellule
                Cell cell = new Cell(column, row, tiledCell);
                cellsPosition.add(new AbstractMap.SimpleEntry<>(column, row));
                if (cell.isBlockedDoor()) {
                    blockedDoorCells.add(cell);
                    cptBlocked++;
                }
            }
        }
        System.out.println("Blocked door cells: " + cptBlocked);

    }

    public boolean isBlockedDoor(int column, int row) {
        for (Cell cell : blockedDoorCells) {
            if (cell.getColumn() == column && cell.getRow() == row) {
                return true;
            }
        }
        return false;
    }

    public List<Cell> getBlockedDoorCells() {
        return blockedDoorCells;
    }

    public List<AbstractMap.SimpleEntry<Integer, Integer>> getCellsPosition() {
        return cellsPosition;
    }
}
