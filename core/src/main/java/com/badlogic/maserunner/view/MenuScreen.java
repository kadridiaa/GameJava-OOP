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
    private Texture buttonTexture;
    private float buttonX, buttonY, buttonWidth, buttonHeight;

    public MenuScreen(Main game) {
        this.game = game;
        this.batch = new SpriteBatch();
        this.font = new BitmapFont(); // Police par défaut
        this.font.setColor(Color.WHITE);
        this.buttonTexture = new Texture("Menu/exit_button_active.png");

        // Position et taille du bouton
        this.buttonWidth = 200;
        this.buttonHeight = 80;
        this.buttonX = (Gdx.graphics.getWidth() - buttonWidth) / 2f;
        this.buttonY = Gdx.graphics.getHeight() / 2f - 50;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        // Affiche le texte de victoire
        font.draw(batch, "Tu as gagné !", Gdx.graphics.getWidth() / 2f - 50, Gdx.graphics.getHeight() / 2f + 100);

        // Affiche le bouton
        batch.draw(buttonTexture, buttonX, buttonY, buttonWidth, buttonHeight);
        //font.draw(batch, "Rejouer", buttonX + 50, buttonY + 50);

        batch.end();

        // Vérifie si le bouton est cliqué
        if (Gdx.input.isTouched()) {
            float touchX = Gdx.input.getX();
            float touchY = Gdx.graphics.getHeight() - Gdx.input.getY();

            if (touchX > buttonX && touchX < buttonX + buttonWidth &&
                touchY > buttonY && touchY < buttonY + buttonHeight) {
                // Charger un nouveau labyrinthe et retourner à MazeView
                Maze maze = new Maze("maps/simple.tmx");
                game.setScreen(new MazeView(maze , game));
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
        buttonTexture.dispose();
    }
}
