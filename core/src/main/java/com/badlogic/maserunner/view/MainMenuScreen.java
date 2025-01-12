package com.badlogic.maserunner.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.maserunner.Main;
import com.badlogic.maserunner.model.Maze;

public class MainMenuScreen implements Screen {

    private Main game; // Référence au jeu principal
    private SpriteBatch batch;
    private BitmapFont font;
    private Texture playButtonTexture;
    private float posX, posY, buttonWidth, buttonHeight;
    private Texture backgroundTexture;
    private Texture titleTexture;

    public MainMenuScreen(Main game) {
        this.game = game;
        this.batch = new SpriteBatch();
        this.font = new BitmapFont(); // Police par défaut
        this.font.setColor(Color.WHITE);
        this.backgroundTexture = new Texture("Menu/background.png");
        this.titleTexture = new Texture("Menu/game_title.png");// Charger l'image de fond
        this.playButtonTexture = new Texture("Menu/play_button_active.png"); // Bouton "Play"

        // Position et taille du bouton
        this.buttonWidth = 200;
        this.buttonHeight = 80;
        this.posX = (Gdx.graphics.getWidth() - buttonWidth) / 2f;
        this.posY = Gdx.graphics.getHeight() / 2f - 50;
    }

    @Override
    public void show() {
        // Initialisation si nécessaire
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        // Dessine l'image de fond sur toute la surface de l'écran
        batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Affiche le titre du jeu
        batch.draw(titleTexture, posX+20, posY+150, 150, 60);

        // Affiche le bouton "Play"
        batch.draw(playButtonTexture, posX, posY, buttonWidth, buttonHeight);

        batch.end();

        // Vérifie si le bouton "Play" est cliqué
        if (Gdx.input.isTouched()) {
            float touchX = Gdx.input.getX();
            float touchY = Gdx.graphics.getHeight() - Gdx.input.getY();

            if (touchX > posX && touchX < posX + buttonWidth &&
                touchY > posY && touchY < posY + buttonHeight) {
                // Charger le jeu principal
                Maze maze = new Maze("maps/simple.tmx");
                game.setScreen(new MazeView(maze, game));
            }
        }
    }

    @Override
    public void resize(int width, int height) {
        // Gérer le redimensionnement si nécessaire
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        playButtonTexture.dispose();
        backgroundTexture.dispose(); // Libérer la texture de fond
    }
}
