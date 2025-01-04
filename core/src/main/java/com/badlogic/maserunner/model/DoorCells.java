package com.badlogic.maserunner.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.maserunner.controller.PadlockController;

import java.util.ArrayList;
import java.util.List;

public class DoorCells {
    private List<Cell> blockedDoorCells;
    private TiledMap map;

    public DoorCells() {
        blockedDoorCells = new ArrayList<>();
    }


    public void loadblockedDoorCells(TiledMap tiledMap) {
        TiledMapTileLayer tileLayer = (TiledMapTileLayer) tiledMap.getLayers().get("door");
        int cptBlocked = 0;
        for (int row = 0; row < tileLayer.getHeight(); row++) {
            for (int column = 0; column < tileLayer.getWidth(); column++) {
                TiledMapTileLayer.Cell tiledCell = tileLayer.getCell(column, row);
                // Crée une instance de Cell pour chaque cellule
                Cell cell = new Cell(column, row, tiledCell);
                if (cell.isBlockedDoor()) {
                    blockedDoorCells.add(cell);
                    cptBlocked++;
                }
            }
        }
        System.out.println("Blocked door cells: " + cptBlocked);
        for (int i=0 ; i<blockedDoorCells.size() ; i++){
        System.out.println("la cell 1 de blockedCells x : "+blockedDoorCells.get(i).getRow()+" position y: " +blockedDoorCells.get(i).getColumn());
        }

    }

    public boolean isBlockedDoor(int column, int row) {
        for (Cell cell : blockedDoorCells) {
            if (cell.getColumn() == column && cell.getRow() == row) {
                return true;
            }
        }
        return false;
    }



    public void clearBlockedCells() {
        blockedDoorCells.clear(); // Supprime toutes les cellules bloquées
        System.out.println("Toutes les cellules bloquées ont été supprimées.");
    }

}
