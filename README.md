# Puissance 4

Bienvenue sur le repository GitHub de **Puissance 4**. Ce projet vise à reproduire un jeu de Puissance 4 sur console.

## Membres de l'équipe

- [Seghdau Yanis](https://github.com/YanisGlg95)
- [Marheraroui Amin](https://github.com/aminmarh)
- [Abbassi Ilyes](https://github.com/dijxt)
- [Ibouda Yasser](https://github.com/Yasser1080)
- [Souissi Dhia-Eddine](https://github.com/Dhia78)

## Fonctionnalités

Notre application permet de jouer au jeu de Puissance 4 sur console. Voici comment y jouer :

- **Choix du mode de jeu** : Au début de la partie, vous pouvez choisir de jouer contre un autre joueur ou contre une IA (ou alors faire jouer 2 IA). Vous devez alors donner le nom des joueurs.

- **Saisie de la colonne** : Pour jouer un coup, la console vous invitera à saisir le numéro de la colonne dans laquelle vous voulez placer votre jeton. La colonne doit être un nombre entier compris entre 1 et 7.

- **Fin de la partie** : La partie se termine lorsqu'un joueur aligne 4 jetons horizontalement, verticalement ou diagonalement. Si la grille est pleine et qu'aucun joueur n'a aligné 4 jetons, la partie se termine par un match nul.

## Organisation du projet

Au cours du développement de ce projet, nous avons utilisé plusieurs outils et méthodes pour faciliter la collaboration et la gestion du code. Voici quelques outils et méthodes que nous avons utilisés :

- **Trello** : Nous avons choisi Trello pour le suivi de l'avancement du projet. Nous créons un ticket avec des spécifications pour intégrer une nouvelle fonctionnalité ou résoudre un problème de notre application. Ce ticket est ensuite assigné à un membre de l'équipe qui se charge de le réaliser. Une fois le ticket terminé, il est déplacé dans la colonne "Fait" pour indiquer qu'il est terminé. Voici le lien vers notre tableau Trello : [Trello](https://trello.com/invite/b/YfXafSrf/ATTI017cd0e8e341ace6cc525a3377692bf3BE2850FF/projet-puissance-4)

- **Discord** : Nous avons utilisé Discord pour communiquer en temps réel. Nous avons créé un serveur Discord pour notre équipe et nous avons utilisé les canaux textuels pour discuter de l'avancement du projet et des problèmes rencontrés. Nous avons également utilisé les canaux vocaux pour organiser des réunions et discuter de questions plus complexes.

- **Github** : Le versioning a été effectué sur Github, un outil dont la connaissane et l'utilisation varie selon chaque membre. Pour l'intégration du nouveau code, des Pull Requests ont été effectuées et vérifiées par chacun des membres avant d'être Merge sur la branche Master. Un WorkFlow GitHub Actions a été mis en place sur notre repository pour permettre une meilleure intégration du code. Lorsque l'on Merge une Pull Request sur la branche Master, les tests sont executés automatiquement afin de s'assurer que le code publié fonctionne comme prévu.

- **IntelliJ** : L'ensemble de l'équipe a travaillé sur IntelliJ et parfois nous avons utilisé la fonctionnalité "Code With Me" afin de faire du pair programming. De plus nous avons utilisé le plugin SonarLint pour analyser la qualité du code et détécter les mauvaises pratiques.



## Difficultés Rencontrées

Au cours du développement de ce projet, nous avons rencontré plusieurs défis :

- **Injections de dépendances** : Nous avons eu du mal à comprendre quels composants de notre application devaient être injectés et comment les injecter correctement. Nous nous sommes donc référés à notre diagramme de classes pour savoir quels composants devaient être injectés.

- **Gestion des entrées utilisateur et des sorties console** : Nous avons eu du mal à gérer les entrées et sorties en respectant les bonnes pratiques Java. En effet, nous avons eu des diffcultés vis à vis des erreurs de saisie de l'utilisateur et des messages à afficher en prenant compte l'internationalisation.

- **Algorithme de joueur IA** : Nous avons eu du mal à comprendre et implémenter un algorithme de la famille Minimax pour la création d'une IA. Nous avons donc décidé de créer une IA simple qui choisit une colonne semi-aléatoirement en bloquant les coups gagnants de l'adversaire et en essayant de gagner si elle en a l'occasion.

## Bilan

Ce projet nous a permis de mettre en pratique les concepts que nous avons appris en cours. Nous avons pu travailler en équipe et utiliser des outils de gestion de projet pour faciliter la collaboration. Nous avons également pu améliorer nos compétences en conception et architecture afin de créer une application bien structurée et facile à maintenir.