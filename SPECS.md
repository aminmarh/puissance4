[English](SPECS.md) | [Français](SPECS.fr.md)
# Connect Four Specifications

Here are the specifications for our Connect Four game.

## Features

### 1. Menu Display and Options
- **Description**: A menu is presented with the following options:
  - **Play**: Start the game
  - **Language**: Choose the interface language (French or English). If the user does not choose, the default language will be English. The game messages are initialized in properties files and are retrieved based on the user's language choice.
  - **Quit**: Exit the application

- **Inputs**:
  - Enter the corresponding number
  - Select the language to switch between French and English, changing the text of the entire interface if the user wishes to do so.

### 2. Game Mode Selection
- **Description**: At the beginning of the game, users can choose:
  - The name of the first player and their type (1: Human or 2: AI)
  - The name of the second player and their type (1: Human or 2: AI)
    Then, the game starts based on the chosen settings (Human vs. Human, Human vs. AI, or AI vs. AI).
- **Inputs**:
  - Type of game
  - Player names

### 3. Player Types
- **Description**: There are two types of players: Human and AI. Each player has a name and an assigned token. The first player has the red token "R" and the second player has the yellow token "Y".
  - **Human Player**: The human player chooses a column to place their token. If the choice is correct, the token is placed; otherwise, an exception is thrown, and the player is prompted to enter a new value.
  - **AI Player**: The AI player tries to find the best possible move based on the current state of the board. It first checks for a winning move, then a move to block the opponent's win, and finally defaults to a random move.

### 4. Game Flow
- **Description**: Each turn, the game asks each player to drop a token, displaying the 7x6 game grid and prompting the player by name if it is a human player. When two AIs play against each other, the game runs automatically, and the grid is displayed at the end with the name of the winning AI or a draw message. For better design and understanding, player 1 has the red token with the letter "R" and player 2 has the yellow token with the letter "Y".
- **Display**:
  - 7x6 game grid
  - Turn indicators for the players and error messages if the input is invalid

- **Inputs**:
  - Enter the number corresponding to the column to place a token

### 5. Error Handling
- **Description**: When a user makes an input, checks are performed to ensure the entered value is valid.
- **Checks**:
  - **Main Menu**: When choosing a menu option, the input must be between 1 and 3 (Play, Language, Quit). If it is not, an exception is thrown, and the user is prompted to enter a new value.
  - **Language Menu**: When choosing a language, the input must be between 1 and 3 (English, French, Return). If it is not, an exception is thrown, and the user is prompted to enter a new value.
  - **Game Type Selection**: When entering the type of player between 1 and 2 (Human, AI), checks are made to ensure the input is valid. If it is not, an exception is thrown, and the user is prompted to enter a new value.
  - **Column Selection**: When entering the column number to place a token, the value must correspond to a valid game column between 1 and 7. If it is not or if the column is full, an exception is thrown, and the user is prompted to enter a new value.

### 6. Win or Draw Conditions
- **Description**: A win is detected when a player aligns four tokens horizontally, vertically, or diagonally. A draw is detected if the grid is full and no player has aligned four tokens, ending the game in a draw.
- **Checks**:
  - Horizontal alignment of four tokens
  - Vertical alignment of four tokens
  - Diagonal alignment of four tokens
  - Full grid with no alignment of four tokens

### 7. End of Game
- **Description**: The winner is announced, and the game automatically returns to the main menu.

---
End of specifications