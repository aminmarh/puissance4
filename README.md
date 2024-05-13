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
4. After cloning the repository, change the current directory to `power4`:
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

## Features

Our application allows you to play the game of Puissance 4 on console. Here's how to play it:

- **Choice of game mode**: At the start of the game, you can choose to play against another player or against an AI (or have 2 AI play). You must then give the names of the players.

- **Entering the column**: To play a move, the console will prompt you to enter the number of the column in which you want to place your token. The column must be an integer between 1 and 7.

- **End of the game**: The game ends when a player aligns 4 tokens horizontally, vertically or diagonally. If the grid is full and no player has lined up 4 tokens, the game ends in a draw.

## Project organisation

During the development of this project, we used several tools and methods to facilitate collaboration and code management. Here are some tools and methods we used:

- **Trello**: We chose Trello for monitoring the progress of the project. We create a ticket with specifications to integrate a new feature or resolve an issue in our application. This ticket is then assigned to a member of the team who is responsible for carrying it out. Once the ticket is completed, it is moved to the "Done" column to indicate that it is complete. Here is the link to our Trello board: [Trello](https://trello.com/invite/b/YfXafSrf/ATTI017cd0e8e341ace6cc525a3377692bf3BE2850FF/projet-peut-4)

- **Discord**: We used Discord to communicate in real time. We created a Discord server for our team and used the text channels to discuss the progress of the project and any issues encountered. We also used voice channels to hold meetings and discuss more complex issues.

- **Github**: Versioning was carried out on Github, a tool whose knowledge and use varies according to each member. For the integration of the new code, Pull Requests were made and verified by each member before being Merged onto the Master branch. A GitHub Actions WorkFlow has been set up on our repository to allow better code integration. When you merge a Pull Request on the Master branch, tests are run automatically to ensure that the published code works as expected.

- **IntelliJ**: The entire team worked on IntelliJ and sometimes we used the "Code With Me" functionality to do pair programming. In addition, we used the SonarLint plugin to analyze the quality of the code and detect bad practices.



## Encountered difficulties

During the development of this project, we encountered several challenges:

- **Dependency injections**: We had difficulty understanding which components of our application should be injected and how to inject them correctly. So we referred to our class diagram to find out which components should be injected.

- **Management of user input and console output**: We had difficulty managing input and output while respecting Java best practices. Indeed, we had difficulties with user input errors and messages to display while taking internationalization into account.

- **AI player algorithm**: We had difficulty understanding and implementing an algorithm from the Minimax family for creating an AI. So we decided to create a simple AI that chooses a column semi-randomly by blocking the opponent's winning moves and trying to win if it gets the chance.

## Assessment

This project allowed us to put into practice the concepts we learned in class. We were able to work as a team and use project management tools to facilitate collaboration. We were also able to improve our design and architecture skills to create a well-structured and easy-to-maintain application.