[English](README.md) | [Français](README.fr.md)
# Puissance 4

Bienvenue sur le repository GitHub de **Puissance 4**. Ce projet vise à reproduire un jeu de Puissance 4 sur console.

## Membres de l'équipe

- [Seghdau Yanis](https://github.com/YanisGlg95)
- [Marheraroui Amin](https://github.com/aminmarh)
- [Abbassi Ilyes](https://github.com/dijxt)
- [Ibouda Yasser](https://github.com/Yasser1080)
- [Souissi Dhia-Eddine](https://github.com/Dhia78)

## Prérequis

Pour exécuter ce projet, vous aurez besoin des outils suivants installés sur votre machine :

- **[Java JDK 21](https://www.oracle.com/fr/java/technologies/downloads/#java21)** : Assurez-vous d'avoir Java JDK 21 installé pour exécuter le code source. Vous pouvez vérifier cela en tapant `java --version` dans votre terminal.

- **[Maven](https://maven.apache.org/download.cgi)** : Maven est utilisé pour la gestion des dépendances et pour automatiser le build de l'application. Assurez-vous que Maven est installé sur votre système. Vous pouvez vérifier cela en tapant `mvn --version` dans votre terminal.
## Clonage du projet

Pour obtenir une copie du projet sur votre machine locale pour le développement et les tests, suivez ces étapes :

1. Ouvrez un terminal.
2. Changez le répertoire courant en un emplacement où vous souhaitez cloner le répertoire.
3. Tapez la commande suivante pour cloner le dépôt Git :
   ```bash
   git clone https://github.com/aminmarh/puissance4.git
   ```
4. Après avoir cloné le dépôt, changez le répertoire courant en `puissance4` :
   ```bash
    cd puissance4
    ```
5. Vous êtes prêt à exécuter le projet !

## Lancement du projet

Pour lancer le projet, suivez les instructions ci-dessous :

1. Construisez le projet avec Maven pour générer l'exécutable. Dans le répertoire racine du projet, exécutez :
   ```bash
   mvn clean package
   ```
   Cette commande générera un fichier .jar dans le répertoire target.

2. Exécutez l'application en utilisant le fichier JAR généré. Assurez-vous d'être toujours dans le répertoire racine du projet et tapez :
   ```bash
   java -jar target/puissance4-0.0.1-SNAPSHOT.jar
   ```
   Cette commande démarrera l'application en mode console, prête à jouer.

## Utilisation de Docker

Si vous préférez utiliser Docker pour exécuter l'application, assurez-vous que Docker est installé sur votre machine. Ensuite, suivez ces étapes pour construire l'image Docker et exécuter le conteneur :

1. Construisez l'image Docker :
   ```bash
   docker build -t puissance4 .
   ```
2. Une fois l'image construite, lancez l'application dans un conteneur Docker: 
   ```bash
   docker run -it puissance4
   ```
   Cela lancera l'application dans un conteneur Docker, où vous pourrez jouer au jeu en mode console.

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