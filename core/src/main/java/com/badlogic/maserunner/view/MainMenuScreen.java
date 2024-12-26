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
    private float buttonX, buttonY, buttonWidth, buttonHeight;



    public MainMenuScreen(Main game) {
        this.game = game;
        this.batch = new SpriteBatch();
        this.font = new BitmapFont(); // Police par défaut
        this.font.setColor(Color.WHITE);
        this.playButtonTexture = new Texture("Menu/play_button_active.png"); // Bouton "Play"

        // Position et taille du bouton
        this.buttonWidth = 200;
        this.buttonHeight = 80;
        this.buttonX = (Gdx.graphics.getWidth() - buttonWidth) / 2f;
        this.buttonY = Gdx.graphics.getHeight() / 2f - 50;
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

        // Affiche le titre du jeu
        font.draw(batch, "Maze Runner", Gdx.graphics.getWidth() / 2f - 80, Gdx.graphics.getHeight() / 2f + 100);

        // Affiche le bouton "Play"
        batch.draw(playButtonTexture, buttonX, buttonY, buttonWidth, buttonHeight);
        //font.draw(batch, "Jouer", buttonX + 50, buttonY + 50);

        batch.end();

        // Vérifie si le bouton "Play" est cliqué
        if (Gdx.input.isTouched()) {
            float touchX = Gdx.input.getX();
            float touchY = Gdx.graphics.getHeight() - Gdx.input.getY();

            if (touchX > buttonX && touchX < buttonX + buttonWidth &&
                touchY > buttonY && touchY < buttonY + buttonHeight) {
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
    }
}
