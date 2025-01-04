package com.badlogic.maserunner.model;
import javax.swing.*;


public class ChallengePopup {


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






