package com.badlogic.maserunner.controller;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.maserunner.model.DoorCells;
import com.badlogic.maserunner.model.Player;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class PadlockController {
    private Map<String, Cell> savedCells = new HashMap<>();


    public void hidePadlocks(TiledMapTileLayer padlockLayer) {
        if (padlockLayer != null) {
            for (int x = 0; x < padlockLayer.getWidth(); x++) {
                for (int y = 0; y < padlockLayer.getHeight(); y++) {
                    Cell cell = padlockLayer.getCell(x, y);
                    if (cell != null) {
                        savedCells.put(x + "," + y, cell);
                        padlockLayer.setCell(x, y, null);
                    }
                }
            }
        }
    }

    public void showPadlocks(TiledMapTileLayer padlockLayer) {
        if (padlockLayer != null) {
            for (Map.Entry<String, Cell> entry : savedCells.entrySet()) {
                String[] coords = entry.getKey().split(",");
                int x = Integer.parseInt(coords[0]);
                int y = Integer.parseInt(coords[1]);
                // Restaure la cellule sauvegardée
                padlockLayer.setCell(x, y, entry.getValue());
            }

            // Nettoyer les cellules sauvegardées
            savedCells.clear();
        }
    }

    public void onPadlockReached(Player player, DoorCells doorCells, TiledMap tiledMap) {
        TiledMapTileLayer padlockLayer = (TiledMapTileLayer) tiledMap.getLayers().get("padlock");

        int playerX = (int) player.getPosition().x / 16;
        int playerY = (int) player.getPosition().y / 16;

        if (padlockLayer != null) {
            TiledMapTileLayer.Cell padlockCell = padlockLayer.getCell(playerX, playerY);
            if (padlockCell != null) {
                // Débloquer les portes
                padlockLayer.setCell(playerX, playerY, null);
                System.out.println("Le joueur a atteint un cadenas. Les portes sont débloquées.");
                doorCells.getBlockedDoorCells().clear();
                TiledMapTileLayer tileLayer = (TiledMapTileLayer) tiledMap.getLayers().get("door");

                for (AbstractMap.SimpleEntry<Integer, Integer> ele : doorCells.getCellsPosition()) {
                    tileLayer.setCell(ele.getKey(), ele.getValue(), null);
                }
            }
        }
    }





}


