package com.badlogic.maserunner.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import javax.swing.*;



import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class ChallengePopup {
    private static Texture backgroundTexture;

//    public static void showCustomPopup(Stage stage, String question, String[] options, Runnable onCorrect, Runnable onWrong) {
//        // Créez une table pour afficher le popup
//        Table table = new Table();
//        table.setFillParent(true);
//
//        // Chargez la texture pour l'arrière-plan
//        backgroundTexture = new Texture(Gdx.files.internal("Challenge/dialogue_bg.jpg"));
//        table.setBackground(new TextureRegionDrawable(new TextureRegion(backgroundTexture)));
//
//        // Ajoutez les autres éléments (question, boutons, etc.)
//        Label.LabelStyle labelStyle = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
//        Label questionLabel = new Label(question, labelStyle);
//        questionLabel.setAlignment(Align.center);
//        questionLabel.setWrap(true);
//        table.add(questionLabel).width(400).pad(20);
//        table.row();
//
//        for (int i = 0; i < options.length; i++) {
//            final boolean isCorrect = (i == 0); // Assume que la première option est correcte
//            TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
//            buttonStyle.font = new BitmapFont();
//            buttonStyle.fontColor = Color.WHITE;
//            buttonStyle.up = new TextureRegionDrawable(new Texture("Menu/play_button_active.png"));
//
//            TextButton optionButton = new TextButton(options[i], buttonStyle);
//            optionButton.addListener(event -> {
//                if (event.toString().equals("touchDown")) {
//                    if (isCorrect) {
//                        onCorrect.run();
//                    } else {
//                        onWrong.run();
//                    }
//                    table.remove(); // Supprime la table du popup
//                    disposePopupResources(); // Libère les ressources
//                    return true;
//                }
//                return false;
//            });
//
//            table.add(optionButton).width(300).height(50).pad(10);
//            table.row();
//        }
//
//        stage.addActor(table);
//    }
//
//    private static void disposePopupResources() {
//        if (backgroundTexture != null) {
//            backgroundTexture.dispose();   // Libère la texture
//            backgroundTexture = null;   // Évite les fuites mémoire
//            System.out.println("background est : " +backgroundTexture);
//        }
//    }


    public static String showPopup(JFrame parentFrame, String question, String[] options) {
        return (String) JOptionPane.showInputDialog(
            parentFrame,
            question,
            "Challenge",
            JOptionPane.QUESTION_MESSAGE,
            null, // No custom icon
            options,
            options[0] // Default selection
        );
    }
}






