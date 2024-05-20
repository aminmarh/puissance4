[English](SPECS.md) | [Français](SPECS.fr.md)
# Spécifications Puissance 4

Voici les spécifications de notre jeu Puissance 4.

## Fonctionnalités

### 1. Affichage et options du menu
- **Description** : Un menu est présenté avec les options suivantes :
  - **Jouer** : Commencer le jeu
  - **Langue** : Choisir la langue de l'interface (français ou anglais). Si l'utilisateur ne choisit pas, la langue de base sera l'anglais. Les messages de jeu sont initialisées dans des fichiers properties et sont récupérés en fonction du choix de langue de l'utilisateur.
  - **Quitter** : Quitter l'application
  
- **Entrées** :
  - Entrer le chiffre correspondant
  - Sélection de la langue pour basculer entre français et anglais ce qui va changer le texte de toute l'interface si l'utilisateur souhaite la changer.

### 2. Choix du mode de jeu
- **Description** : Au début de la partie, les utilisateurs peuvent choisir :
    - Le nom du premier joueur et son type (1 : Humain ou 2 : IA)
    - Le nom du deuxième joueur et son type (1 : Humain ou 2 : IA)
Ensuite, la partie se lance en fonction des choix qui ont été saisi (Humain contre Humain ou Humain contre IA ou IA contre IA)
- **Entrées** :
    - Type de partie 
    - Noms des joueurs

### 3. Type de joueur
- **Description** : Nous avons 2 types de joueur : Humain et IA. Chaque joueur a un nom et un jeton assigné. Le premier joueur a le jeton Rouge "R" et le deuxième le jeton Jaune "Y". Le joueur Humain va choisir de placer son jeton et si son choix est correcte, le jeton est placé sinon une exception est renvoyée et le joueur est invité à saisir une nouvelle valeur.
Quant au joueur IA, il va essayer de trouver le meilleur coup possible en fonction de l'état actuel du plateau. 
Il vérifie d'abord s'il existe un coup gagnant, puis un coup pour bloquer la victoire de l'adversaire, et enfin, par défaut, un coup aléatoire.

### 4. Déroulement de la partie 
- **Description** : À chaque tour, on demande à chaque joueur de déposer un jeton en affichant la grille de jeu 7x6, et en invitant le joueur à joueur par son nom s'il s'agit d'un humain.
Lorsque 2 IA jouent entre elles, la partie se déroule automatiquement et la grille s'affiche à la fin avec le nom de l'IA gagnante ou match nul
Pour un meilleur design et une meilleure compréhension, le joueur 1 a la couleur rouge avec la lettre "R" et le joueur 2 la couleur jaune avec la lettre "Y".
- **Affichage** :
    - Grille de jeu 7x6
    - Indicateurs de tour pour les joueurs et si la valeur entrée n'est pas valide
  
- **Entrées** :
    - Entrer le chiffre à la colonne correspondante pour placer un pion

### 5. Gestion des erreurs
- **Description** : Lorsqu'un utilisateur fait une entrée, des vérifications sont effectuées pour s'assurer que la valeur entrée est valide.
- **Vérifications** :
  - Menu principal : Lors du choix d'une option du menu, l'entrée doit être comprise entre 1 et 3 (Play, Langage, Quit). Si ce n'est pas le cas, une exception est lancée et l'utilisateur est invité à saisir une nouvelle valeur.
  - Menu choix de la langue : Lors du choix d'une langue, l'entrée doit être comprise entre 1 et 3 (English, French, Return). Si ce n'est pas le cas, une exception est lancée et l'utilisateur est invité à saisir une nouvelle valeur.
  - Choix du type de partie : Lors de l'entrée du type de joueur entre 1 et 2 (Humain, IA), des vérifications sont faites pour s'assurer que l'entrée soit valide. Si ce n'est pas le cas, une exception est lancée et l'utilisateur est invité à saisir une nouvelle valeur.
  - Choix de colonne : Lors de l'entrée du numéro de colonne pour placer un jeton, la valeur doit correspondre à une colonne valide du jeu entre 1 et 7. Si ce n'est pas le cas ou si la colonne est pleine, une exception est lancée et l'utilisateur est invité à saisir une nouvelle valeur.
  
### 6. Conditions de victoire ou nul
- **Description** : Détection de la victoire lorsqu'un joueur aligne quatre jetons horizontalement, verticalement ou en diagonale. Détection de match nul si la grille est pleine et qu'aucun joueur n'a aligné quatre jetons, la partie se termine en match nul.
- **Vérifications** :
    - Alignement horizontal de quatre jetons
    - Alignement vertical de quatre jetons
    - Alignement diagonal de quatre jetons
    - Grille complète sans aucun alignement de 4 jetons

### 7. Fin de partie
- **Description** : Annonce du gagnant et retour automatique au menu principal.

### 8. Fontionnalité pour mettre le jeu en pause
- **Description** : Lorsque une partie (avec au moins un joueur humain) est en cours, le joueur peut mettre le jeu en pause à tout moment (celle-ci est sauvegardée) et reprendre la partie plus tard. Si une nouvelle partie est lancée, la partie en pause est écrasée.
- **Entrée** : Dans le cas de la console, le chiffre 0 mettera le jeu en pause. Le joueur est redirigé vers le menu principal.
- **Mise en place** : 
  - Lorsque la pause est demandée nous devons pouvoir enregistrer la table de jeu (joueurs et plateau) dans un fichier json avec la librairie JSON.
  - Lorsque le joueur veut reprendre la partie, nous devons pouvoir lire le fichier json et reprendre la partie là où elle s'est arrêtée (en vérifiant le dernier joueur ayant joué).
- **Modifications du menu** :
  - Ajout de l'option "Reprendre" dans le menu principal (si une partie est en pause).
  - Affichage ou non de l'option "Reprendre" en fontion de la présence d'une partie en pause.
---
Fin des spécifications
