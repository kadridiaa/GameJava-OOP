package com.badlogic.maserunner.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.ArrayList;
import java.util.List;

public class PadlockCells {

    private List<Cell> padlockCells; // Liste des cellules de cadenas

    public PadlockCells() {
        padlockCells = new ArrayList<>();
    }

    public void loadPadlockCells(TiledMap tiledMap) {
        TiledMapTileLayer tileLayer = (TiledMapTileLayer) tiledMap.getLayers().get("padlock");
        for (int row = 0; row < tileLayer.getHeight(); row++) {
            for (int column = 0; column < tileLayer.getWidth(); column++) {
                TiledMapTileLayer.Cell tiledCell = tileLayer.getCell(column, row);

                Cell cell = new Cell(column, row, tiledCell);

                if (cell.isPadlockCell()){
                    padlockCells.add(cell);
                }

            }
        }
        System.out.println("padlock cells : "+padlockCells.size());
    }


    public int nbrCells(){
        return  padlockCells.size();
    }



    public boolean isPadlockCell(int column, int row) {
        for (Cell cell : padlockCells) {
            if (cell.getColumn() == column && cell.getRow() == row) {
                return true;
            }
        }
        return false;
    }
}
