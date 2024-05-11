# Utilisez l'image Java 21 JDK officielle comme base
FROM openjdk:21-slim

# Définissez le répertoire de travail dans le conteneur
WORKDIR /app

# Copiez le fichier .jar construit localement dans le répertoire de travail du conteneur
COPY target/puissance4-0.0.1-SNAPSHOT.jar puissance4.jar

# Exposez le port sur lequel votre application s'exécute
EXPOSE 8080

# Commande pour exécuter l'application
CMD ["java", "-jar", "puissance4.jar"]
