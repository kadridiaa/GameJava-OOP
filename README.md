# Maze Runner

Maze Runner est un jeu 2D où le joueur doit naviguer dans un labyrinthe pour atteindre la sortie, tout en interagissant avec des éléments comme des portes et des cadenas. Le projet est développé en utilisant la bibliothèque **LibGDX** et l'outil **Tiled** pour la création de cartes.

## Prérequis

- **Java 8 ou version supérieure** (JDK)
- **LibGDX** : Version compatible avec le projet
- **Tiled** : Utilisé pour la création des cartes
- **Android Studio** : IDE recommandé pour la compilation et l'exécution du projet

## Installation

1. Clonez ce dépôt sur votre machine locale en utilisant la commande suivante :
    ```bash
    git clone https://github.com/kadridiaa/GameJava-OOP.git
    ```
2. Ouvrez Android Studio et sélectionnez **Open an existing project**.
3. Sélectionnez le dossier cloné pour ouvrir le projet dans Android Studio.

## Compilation et Exécution

1. Après avoir ouvert le projet dans Android Studio, configurez le projet pour correspondre à votre environnement (par exemple, version de SDK, etc.).
2. Une fois la configuration terminée, cliquez sur **Run** pour compiler et exécuter le jeu sur un appareil ou un émulateur Android.

## Fonctionnalités

- **Naviguer dans le labyrinthe** avec les touches du clavier (ou l'écran tactile pour les appareils Android).
- **Interagir avec des éléments** comme des portes et des cadenas pour progresser.
- **Terminer le jeu** en atteignant la sortie du labyrinthe.

## Architecture du Jeu

Le moteur du jeu est basé sur une architecture modulaire avec plusieurs composants :

- **Maze** : Classe principale pour l'initialisation du jeu.
- **Scene (MazeView)** : Gère l'affichage et la mise à jour des objets du jeu.
- **CollisionSystem** : Gère les collisions entre objets.
- **InputHandler** : Gère les entrées utilisateur.
- **GameChallenge** : Gère le défi à résoudre pour progresser.
- **GameWin** : Gère l'ouverture de la porte de sortie.
- **Menu** : Gère les menus du jeu.

## Contributions

Tous les membres ont contribué activement au code Java et ont travaillé ensemble pour intégrer de manière fluide les différents modules du jeu.

## Perspectives

Quelques améliorations possibles :

- Ajouter des niveaux avec des difficultés croissantes.
- Implémenter un système de score et un chronomètre.
- Ajouter des ennemis et des obstacles pour rendre le jeu plus difficile.
