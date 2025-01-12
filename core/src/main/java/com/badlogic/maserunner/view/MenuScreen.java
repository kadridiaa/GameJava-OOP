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

public class MenuScreen implements Screen {

    private Main game; // Référence au jeu principal
    private SpriteBatch batch;
    private BitmapFont font;
    private Texture playButtonTexture, exitButtonTexture;
    private float playButtonX, playButtonY, buttonWidth, buttonHeight, exitButtonY;
    private Texture backgroundTexture;

    public MenuScreen(Main game) {
        this.game = game;
        this.batch = new SpriteBatch();
        this.font = new BitmapFont(); // Police par défaut
        this.font.setColor(Color.WHITE);
        this.backgroundTexture = new Texture("Menu/background.png");
        this.playButtonTexture = new Texture("Menu/play_button_active.png"); // Bouton "Play"
        this.exitButtonTexture = new Texture("Menu/exit_button_active.png"); // Bouton "Exit"

        // Position et taille des boutons
        this.buttonWidth = 200;
        this.buttonHeight = 80;
        this.playButtonX = (Gdx.graphics.getWidth() - buttonWidth) / 2f;
        this.playButtonY = Gdx.graphics.getHeight() / 2f + 50; // Position du bouton Play
        this.exitButtonY = playButtonY - buttonHeight - 20; // Position du bouton Exit sous le bouton Play
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        // Dessine l'image de fond sur toute la surface de l'écran
        batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Affiche le bouton "Play"
        batch.draw(playButtonTexture, playButtonX, playButtonY, buttonWidth, buttonHeight);

        // Affiche le bouton "Exit" sous le bouton Play
        batch.draw(exitButtonTexture, playButtonX, exitButtonY, buttonWidth, buttonHeight);

        batch.end();

        // Vérifie si le bouton "Play" est cliqué
        if (Gdx.input.isTouched()) {
            float touchX = Gdx.input.getX();
            float touchY = Gdx.graphics.getHeight() - Gdx.input.getY();

            // Vérifie si le bouton Play est cliqué
            if (touchX > playButtonX && touchX < playButtonX + buttonWidth &&
                touchY > playButtonY && touchY < playButtonY + buttonHeight) {
                // Charger le jeu principal
                Maze maze = new Maze("maps/simple.tmx");
                game.setScreen(new MazeView(maze, game));
            }

            // Vérifie si le bouton Exit est cliqué
            if (touchX > playButtonX && touchX < playButtonX + buttonWidth &&
                touchY > exitButtonY && touchY < exitButtonY + buttonHeight) {
                // Quitter le jeu
                Gdx.app.exit();
            }
        }
    }

    @Override
    public void resize(int width, int height) {
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
        exitButtonTexture.dispose();
        backgroundTexture.dispose(); // Libérer la texture de fond
    }
}
