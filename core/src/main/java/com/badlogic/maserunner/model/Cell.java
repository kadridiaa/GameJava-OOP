package com.badlogic.maserunner.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class Cell {
    private int column;
    private int row;
    private TiledMapTileLayer.Cell tiledCell;
    private boolean blocked;
    private boolean win;

    public Cell(int column, int row, TiledMapTileLayer.Cell tiledCell) {
        this.column = column;
        this.row = row;
        this.tiledCell = tiledCell;
        this.blocked = checkBlockedProperty();
        this.win = checkWinProperty();
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public boolean isWin(){
        return win;
    }

    public TiledMapTileLayer.Cell getTiledCell() {
        return tiledCell;
    }





    // Vérifier si la cellule a la propriété "blocked"
    private boolean checkBlockedProperty() {
        if (tiledCell != null && tiledCell.getTile() != null) {
            return tiledCell.getTile().getProperties().containsKey("blocked");
        }
        return false;
    }

    private boolean checkWinProperty() {
        if (tiledCell != null && tiledCell.getTile() != null) {
            return tiledCell.getTile().getProperties().containsKey("win");
        }
        return false;
    }


}
