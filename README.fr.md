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

## Specifications

Cliquez [ici](SPECS.md) pour lire les spécifications de notre jeu.
