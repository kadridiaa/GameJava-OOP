package com.badlogic.maserunner.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player {

    private Vector2 position;
    private Texture texture; // Texture pour le joueur
    private float speed = 1.0f; // Vitesse du joueur
    private Wall wall; // Référence à Wall pour vérifier les collisions
    private Direction lastDirection = Direction.NONE;
    private DoorCells doorCells = new DoorCells();

    public Player(float startX, float startY, Wall wall) {
        this.position = new Vector2(startX, startY);
        this.texture = new Texture("Entite/player.png"); // Assurez-vous que l'image est dans le dossier assets
        this.wall = wall;

    }






    public void move(float dx, float dy) {
        // Calcul de la nouvelle position
        float newX = position.x + dx;
        float newY = position.y + dy;

        if (dx > 0) {
            lastDirection = Direction.RIGHT;
        } else if (dx < 0) {
            lastDirection = Direction.LEFT;
        } else if (dy > 0) {
            lastDirection = Direction.UP;
        } else if (dy < 0) {
            lastDirection = Direction.DOWN;
        }


        // Vérifier si la nouvelle position est bloquée avant de déplacer
        if (wall.isBlocked((int) newX / 16, (int) newY / 16) ) {
            System.out.println("J'ai rencontré un mur !");
            System.out.println("la var isBlocked pour wall est : " + wall.isBlocked((int) newX / 16, (int) newY / 16));
        } else if (doorCells.isBlockedDoor((int) newX / 16, (int) newY / 16)) {
            System.out.println("la var isBlocked pour door est : "+doorCells.isBlockedDoor((int) newX / 16, (int) newY / 16));
        } else {

            position.x = (int) newX;
            position.y = (int) newY;
           // System.out.println("current position x : " + (int) newX  / 16+ "position Y : " + (int) newY / 16  );

        }
    }

    public void moveByLastDirection(int steps) {
        float dx = 0, dy = 0;

        switch (lastDirection) {
            case UP:
                dy = steps * 16;
                break;
            case DOWN:
                dy = -steps * 16;
                break;
            case LEFT:
                dx = -steps * 16;
                break;
            case RIGHT:
                dx = steps * 16;
                break;
            default:
                System.out.println("Aucune direction enregistrée !");
                return;
        }
        move(dx, dy);
    }


    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public Vector2 getPosition() {
        return position;
    }




}
