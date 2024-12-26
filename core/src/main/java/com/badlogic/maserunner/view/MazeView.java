package com.badlogic.maserunner.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.maserunner.Main;
import com.badlogic.maserunner.controller.GameController;
import com.badlogic.maserunner.model.ChallengeCells;
import com.badlogic.maserunner.model.Maze;
import com.badlogic.maserunner.model.Player;
import com.badlogic.maserunner.model.Wall;
import com.badlogic.maserunner.model.WinCells;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;




public class MazeView implements Screen {

    private Maze maze;  // Référence à notre modèle
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private Player player;
    private PlayerInputProcessor inputProcessor;
    private Wall wall;
    private GameController gameController;
    private BitmapFont font;
    private Stage stage;
    private TextButton replayButton;
    private boolean hasWon = false; // Pour savoir si le joueur a gagné
    private Main game;
    private ChallengeCells challengeCells;
    private boolean challengeActive = false; // État du défi actif
    private Dialog mathChallengeDialog;





    // Constructeur de MazeView qui prend un modèle de labyrinthe
    public MazeView(Maze maze , Main game) {
        this.maze = maze;
        this.game = game;
        wall = new Wall();
        WinCells winCells = new WinCells();
        challengeCells = new ChallengeCells();
        wall.loadBlockedCells(maze.getMap());
        challengeCells.loadChallengeCells(maze.getMap());
        winCells.loadWinCells(maze.getMap());// Chargement des cellules bloquées depuis le modèle
        player = new Player(19, 500, wall); // Passer "wall" au constructeur de Player
        gameController = new GameController(player, wall); // Création du GameController
    }

    @Override
    public void show() {
        TiledMap map = maze.getMap();  // Utilisation du modèle pour obtenir la carte
        renderer = new OrthogonalTiledMapRenderer(map);
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);  // Définir la caméra pour l'affichage
        camera.update();

        // Ajuster la taille de la police


        // Créer un nouveau PlayerInputProcessor et l'associer avec l'InputProcessor de GDX
        inputProcessor = new PlayerInputProcessor(gameController);  // Passer le contrôleur au lieu du joueur
        Gdx.input.setInputProcessor(inputProcessor);// Associer l'inputProcessor pour les entrées clavier

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        WinCells winCells = new WinCells();
        winCells.loadWinCells(maze.getMap());

        int playerX = (int) player.getPosition().x / 16; // Diviser par la taille des tuiles (par ex. 32)
        int playerY = (int) player.getPosition().y / 16;
        if (winCells.isWinTile(playerX, playerY)) {
            game.setScreen(new MenuScreen((Main) Gdx.app.getApplicationListener()));
            return;
        }
        // Mettre à jour la logique du joueur
        gameController.update(); // Mise à jour du contrôleur, gérant la logique du joueur et les collisions

        // Rendre la carte
        renderer.setView(camera);  // Appliquer la caméra à l'affichage
        renderer.render();  // Rendre la carte


        SpriteBatch batch = new SpriteBatch();
        batch.begin();
        player.draw(batch);  // Dessiner le joueur
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);  // Réajuster la caméra lors d'un redimensionnement de la fenêtre
        camera.update();
    }

    @Override
    public void pause() {
        // Pas nécessaire dans cet exemple
    }

    @Override
    public void hide() {
        // Pas nécessaire dans cet exemple
    }

    @Override
    public void dispose() {
        if (renderer != null) {
            renderer.dispose();  // Libérer les ressources du renderer
        }
        maze.dispose();  // Libérer les ressources de la carte
    }

    @Override
    public void resume() {
        // Pas nécessaire dans cet exemple
    }



}
