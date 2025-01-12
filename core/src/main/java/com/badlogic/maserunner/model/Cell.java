package com.badlogic.maserunner.model;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.maserunner.controller.CellManager;

public class Cell {
    private int column;  // Colonne de la cellule
    private int row;     // Rangée de la cellule
    private TiledMapTileLayer.Cell tiledCell;  // Cellule du TiledMap
    private boolean blocked;  // Si la cellule est bloquée
    private boolean win;  // Si la cellule est une cellule de victoire
    private boolean challenge;  // Si la cellule est un défi
    private boolean padlock;  // Si la cellule a un cadenas
    private boolean blockedDoor;
    private CellManager cellManager;

    public Cell(int column, int row, TiledMapTileLayer.Cell tiledCell) {
        this.column = column;
        this.row = row;
        this.tiledCell = tiledCell;
        this.cellManager = new CellManager("maps/simple.tmx" , 0);
        this.blocked = checkBlockedProperty();
        this.win = checkWinProperty();
        this.challenge = checkChallengeProperty();
        this.padlock = checkPadlockProperty();
        this.blockedDoor = checkBlockDoorProperty();
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

    public boolean isWin() {
        return win;
    }

    public boolean isChallengeCell() {
        return challenge;
    }

    public boolean isPadlockCell() {
        return padlock;
    }

    public boolean isBlockedDoor() {
        return blockedDoor;
    }

    // Vérifie si la cellule a la propriété "blocked"
    private boolean checkBlockedProperty() {
        return tiledCell != null && tiledCell.getTile() != null && tiledCell.getTile().getProperties().containsKey("blocked");
    }

    // Vérifie si la cellule a la propriété "win"
    private boolean checkWinProperty() {
        return tiledCell != null && tiledCell.getTile() != null && tiledCell.getTile().getProperties().containsKey("win");
    }

    // Vérifie si la cellule a la propriété "challenge"
    private boolean checkChallengeProperty() {
        return tiledCell != null && tiledCell.getTile() != null && tiledCell.getTile().getProperties().containsKey("challenge");
    }

    // Vérifie si la cellule a la propriété "padlock"
    private boolean checkPadlockProperty() {
        return tiledCell != null && tiledCell.getTile() != null && tiledCell.getTile().getProperties().containsKey("padlock");
    }

    // Vérifie si la cellule a la propriété "blockedDoor"
    private boolean checkBlockDoorProperty() {
        return tiledCell != null && tiledCell.getTile() != null && tiledCell.getTile().getProperties().containsKey("blocked");
    }

    public TiledMapTileLayer getAllCell(){
        return cellManager.loadCellsLayer();
    }
}
