package com.badlogic.maserunner.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
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
import com.badlogic.maserunner.model.ChallengePopup;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


import javax.swing.JFrame;


public class MazeView implements Screen {

    private Maze maze;  // Référence à notre modèle
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private Player player;
    private PlayerInputProcessor inputProcessor;
    private Wall wall;
    private GameController gameController;
    private Main game;
    private ChallengeCells challengeCells;
    private static final int STARTX = 1 ;
    private static final int STARTY = 32 ;
    private static final int cellSize = 16 ;
    private JFrame frame;
    private Stage stage;





    // Constructeur de MazeView qui prend un modèle de labyrinthe
    public MazeView(Maze maze , Main game ) {
        this.maze = maze;
        this.game = game;
        wall = new Wall();
        WinCells winCells = new WinCells();
        stage = new Stage(new ScreenViewport());
        challengeCells = new ChallengeCells();
        wall.loadBlockedCells(maze.getMap());
        challengeCells.loadChallengeCells(maze.getMap());
        winCells.loadWinCells(maze.getMap());// Chargement des cellules bloquées depuis le modèle
        player = new Player(STARTX*cellSize, STARTY*cellSize, wall); // Passer "wall" au constructeur de Player
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

        // Créer un nouveau PlayerInputProcessor et l'associer avec l'InputProcessor de GDX
        inputProcessor = new PlayerInputProcessor(gameController);  // Passer le contrôleur au lieu du joueur

        // Use InputMultiplexer to handle input for both PlayerInputProcessor and Stage
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage); // Stage for UI
        multiplexer.addProcessor(inputProcessor); // Player input
        Gdx.input.setInputProcessor(multiplexer); // Set the multiplexer as the input processor

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


//        if (challengeCells.isChallengeCell(playerX, playerY)){
//            String question = "What is 5 + 5?";
//            String[] options = {"10", "15", "20"};
//            String selectedOption = ChallengePopup.showPopup(frame, question, options);
//
//            if (selectedOption != null) {
//                if (selectedOption.equals("10")) {
//                    System.out.println("Correct Answer!");
//                    TiledMapTileLayer tileLayer = (TiledMapTileLayer) maze.getMap().getLayers().get("challenge");
//                    tileLayer.setCell(playerX, playerY, null);
//                }
//                else {
//                    System.out.println("Wrong Answer!");
//                }
//
//            }
//
//
//        }


        if (challengeCells.isChallengeCell(playerX, playerY)) {
            String question = "Quel est le résultat de 5 + 5 ?";
            String[] options = {"10", "15", "20"};

            String selectedOption = ChallengePopup.showPopup(frame, question, options);

            if (selectedOption != null) {
                if (selectedOption.equals("10")) {
                    System.out.println("Bonne réponse !");
                    player.moveByLastDirection(2); // Déplace le joueur de 2 cases dans la dernière direction

                    // Supprime la tuile du challenge après la bonne réponse
                    TiledMapTileLayer tileLayer = (TiledMapTileLayer) maze.getMap().getLayers().get("challenge");
                    tileLayer.setCell(playerX, playerY, null);
                } else {
                    System.out.println("Mauvaise réponse !");
                }
            }
        }
        gameController.update(); // Mise à jour du contrôleur, gérant la logique du joueur et les collisions

        // Rendre la carte
        renderer.setView(camera);  // Appliquer la caméra à l'affichage
        renderer.render();  // Rendre la carte


        SpriteBatch batch = new SpriteBatch();
        batch.begin();
        player.draw(batch);  // Dessiner le joueur
        batch.end();
        stage.act(delta);
        stage.draw();
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
