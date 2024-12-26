package com.badlogic.maserunner.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player {

    private Vector2 position;
    private Texture texture; // Texture pour le joueur
    private float speed = 1.0f; // Vitesse du joueur
    private Wall wall; // Référence à Wall pour vérifier les collisions

    public Player(float startX, float startY, Wall wall) {
        this.position = new Vector2(startX, startY);
        this.texture = new Texture("Entite/player.png"); // Assurez-vous que l'image est dans le dossier assets
        this.wall = wall; // Initialisation de Wall pour vérifier les collisions
    }

//    public void update() {
//        // Déplacement du joueur en fonction des touches du clavier
//        boolean moved = false; // Flag pour vérifier si une touche est pressée
//
//        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
//            move(-speed, 0);  // Déplacement vers la gauche
//            moved = true;
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
//            move(speed, 0);  // Déplacement vers la droite
//            moved = true;
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
//            move(0, speed);  // Déplacement vers le haut
//            moved = true;
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
//            move(0, -speed);  // Déplacement vers le bas
//            moved = true;
//        }
//
//        if (!moved) {
//            System.out.println("Aucune touche pressée, le joueur est immobile.");
//        }
//    }


    public void move(float dx, float dy) {
        // Calcul de la nouvelle position
        float newX = position.x + dx;
        float newY = position.y + dy;

        // Vérifier si la nouvelle position est bloquée avant de déplacer
        if (wall.isBlocked((int) newX / 16, (int) newY / 16)) {
            System.out.println("J'ai rencontré un mur !");
        } else {
            // Si la position n'est pas bloquée, déplacer le joueur
            position.x = newX;
            position.y = newY;
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(float x, float y) {
        this.position.set(x, y);
    }


}
