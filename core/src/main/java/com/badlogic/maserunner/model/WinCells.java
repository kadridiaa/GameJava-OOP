package com.badlogic.maserunner.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.ArrayList;
import java.util.List;

public class WinCells {

    private List<Cell> winCells ; // Liste des cellules de victoire

    public WinCells() {
        winCells = new ArrayList<>();
    }

    // Méthode pour charger les cellules de victoire
    public void loadWinCells(TiledMap tiledMap) {
        TiledMapTileLayer tileLayer = (TiledMapTileLayer) tiledMap.getLayers().get("Calque de Tuiles 1");
        int cptWin = 0;
        for (int row = 0; row < tileLayer.getHeight(); row++) {
            for (int column = 0; column < tileLayer.getWidth(); column++) {
                TiledMapTileLayer.Cell tiledCell = tileLayer.getCell(column, row);

                // Vérifie si la cellule contient la clé "win"
                Cell cell = new Cell(column, row, tiledCell);

                // Vérifie si la cellule est bloquée
                if (cell.isWin()){
                    winCells.add(cell);
                    cptWin++;
                }
            }
        }
        System.out.println("Nombre de cellules de victoire: " + winCells.size());
    }


    // Méthode pour obtenir la liste des cellules de victoire (optionnel)
    public List<Cell> getWinCells() {
        return winCells;
    }

    public boolean isWinTile(int column, int row) {
        for (Cell cell : winCells) {
            if (cell.getColumn() == column && cell.getRow() == row) {
                return true;  // La cellule est bloquée
            }
        }
        return false;  // La cellule n'est pas bloquée
    }
}
