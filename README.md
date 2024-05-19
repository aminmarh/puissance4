[English](README.md) | [Français](README.fr.md)
# Connect Four

Welcome to the GitHub repository for **Connect Four**. This project aims to replicate a Connect Four game on console.

## Team Members

- [Seghdau Yanis](https://github.com/YanisGlg95)
- [Marheraroui Amin](https://github.com/aminmarh)
- [Abbassi Ilyes](https://github.com/dijxt)
- [Ibouda Yasser](https://github.com/Yasser1080)
- [Souissi Dhia-Eddine](https://github.com/Dhia78)

## Prerequisites

To run this project, you will need the following tools installed on your machine:

- **[Java JDK 21](https://www.oracle.com/fr/java/technologies/downloads/#java21)**: Make sure you have Java JDK 21 installed to execute the source code. You can verify this by typing `java --version` in your terminal.

- **[Maven](https://maven.apache.org/download.cgi)**: Maven is used for dependency management and to automate the building of the application. Ensure that Maven is installed on your system. You can check this by typing `mvn --version` in your terminal.
## Cloning the Project

To get a copy of the project on your local machine for development and testing, follow these steps:

1. Open a terminal.
2. Change the current directory to a location where you want to clone the repository.
3. Type the following command to clone the Git repository:
   ```bash
   git clone https://github.com/aminmarh/puissance4.git
   ```
4. After cloning the repository, change the current directory to `puissance4`:
    ```bash
     cd puissance4
     ```
5. You are ready to execute the project!

## Project launch

To start the project, follow the instructions below:

1. Build the project with Maven to generate the executable. In the project root directory, run:
    ```bash
    mvn clean package
    ```
   This command will generate a .jar file in the target directory.

2. Run the application using the generated JAR file. Make sure you are still in the project root directory and type:
    ```bash
    java -jar target/puissance4-0.0.1-SNAPSHOT.jar
    ```
   This command will start the application in console mode, ready to play.

## Using Docker

If you prefer to use Docker to run the application, make sure that Docker is installed on your machine. Then follow these steps to build the Docker image and run the container:

1. Build the Docker image:
    ```bash
    docker build -t puissance4 .
    ```
2. Once the image is built, launch the application in a Docker container:
    ```bash
    docker run -it puissance4
    ```
   This will launch the application in a Docker container, where you can play the game in console mode.

## Specifications 

Click [here](SPECS.md) to read the specifications for our game.
