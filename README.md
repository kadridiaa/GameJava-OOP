MaseRunner
Un projet libGDX généré avec gdx-liftoff.

Ce projet a été généré avec un modèle comprenant des lanceurs d'applications simples et une extension ApplicationAdapter qui dessine le logo de libGDX.

Plateformes
core: Module principal contenant la logique de l'application partagée par toutes les plateformes.
lwjgl3: Plateforme principale de bureau utilisant LWJGL3; était appelée 'desktop' dans les anciennes documentations.
Gradle
Ce projet utilise Gradle pour gérer les dépendances.
Le wrapper Gradle est inclus, tu peux donc exécuter des tâches Gradle en utilisant les commandes gradlew.bat ou ./gradlew.
Voici quelques tâches et options utiles de Gradle :

--continue : avec cette option, les erreurs ne stopperont pas l'exécution des tâches.
--daemon : avec cette option, le démon Gradle sera utilisé pour exécuter les tâches choisies.
--offline : avec cette option, les archives de dépendances mises en cache seront utilisées.
--refresh-dependencies : cette option force la validation de toutes les dépendances. Utile pour les versions instantanées.
build : compile les sources et génère les archives de tous les projets.
cleanEclipse : supprime les données du projet Eclipse.
cleanIdea : supprime les données du projet IntelliJ.
clean : supprime les dossiers build qui contiennent les classes compilées et les archives générées.
eclipse : génère les données du projet Eclipse.
idea : génère les données du projet IntelliJ.
lwjgl3:jar : génère le fichier jar exécutable de l'application, qui se trouve dans lwjgl3/build/libs.
lwjgl3:run : lance l'application.
test : exécute les tests unitaires (s'il y en a).
Maze Runner
Maze Runner est un jeu 2D où le joueur doit naviguer dans un labyrinthe pour atteindre la sortie, tout en interagissant avec des éléments comme des portes et des cadenas. Le projet est développé en utilisant la bibliothèque LibGDX et l'outil Tiled pour la création de cartes.

Prérequis
Java 8 ou version supérieure (JDK)
LibGDX : Version compatible avec le projet
Tiled : Utilisé pour la création des cartes
Android Studio : IDE recommandé pour la compilation et l'exécution du projet
Installation
Clonez ce dépôt sur votre machine locale en utilisant la commande suivante :

git clone https://github.com/kadridiaa/GameJava-OOP.git
Ouvrez Android Studio et sélectionnez Open an existing project.
Sélectionnez le dossier cloné pour ouvrir le projet dans Android Studio.
Compilation et Exécution
Après avoir ouvert le projet dans Android Studio, configurez le projet en modifiant la configuration comme indiqué sur le rapport.
Une fois la configuration terminée, cliquez sur Run pour compiler et exécuter le jeu sur un appareil ou un émulateur Android.
Fonctionnalités
Naviguer dans le labyrinthe avec les touches du clavier (ou l'écran tactile pour les appareils Android).
Interagir avec des éléments comme des portes et des cadenas pour progresser.
Terminer le jeu en atteignant la sortie du labyrinthe.
Architecture du Jeu
Le moteur du jeu est basé sur une architecture modulaire avec plusieurs composants :

Maze : Classe principale pour l'initialisation du jeu.
Scene (MazeView) : Gère l'affichage et la mise à jour des objets du jeu.
CollisionSystem : Gère les collisions entre objets.
InputHandler : Gère les entrées utilisateur.
GameChallenge : Gère le défi à résoudre pour progresser.
GameWin : Gère l'ouverture de la porte de sortie.
Menu : Gère les menus du jeu.
Contributions
Tous les membres ont contribué activement au code Java et ont travaillé ensemble pour intégrer de manière fluide les différents modules du jeu.

Perspectives
Quelques améliorations possibles :

Ajouter des niveaux avec des difficultés croissantes.
Implémenter un système de score et un chronomètre.
Ajouter des ennemis et des obstacles pour rendre le jeu plus difficile.
