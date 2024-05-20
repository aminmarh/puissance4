package com.example.puissance4.savegame;

import com.example.puissance4.factory.IPlayerFactory;
import com.example.puissance4.factory.InvalidPlayerTypeException;
import com.example.puissance4.game.Board;
import com.example.puissance4.game.IPlayer;
import com.example.puissance4.game.Table;
import com.example.puissance4.game.Token;
import com.example.puissance4.player.AI;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Save manages the saving and loading of game states for the Puissance 4 game.
 * It provides methods for saving the current game state to a JSON file and loading a game state from a JSON file.
 */
@Component
public class Save implements ISave {
    private static final String FILE_PATH = "save.json";
    private final Table table;
    private final IPlayerFactory playerFactory;

    /**
     * Constructs a Save object with a specified game table and player factory.
     * @param table the game table to save or load.
     * @param playerFactory the player factory used to create players during loading.
     */
    public Save (Table table, IPlayerFactory playerFactory){
        this.table = table;
        this.playerFactory = playerFactory;
    }

    /**
     * Saves the current game state to a JSON file.
     * The method reads the current game state from the table and saves it to a JSON file.
     * The file is saved in the default file path specified in the filePath attribute.
     */
    private JSONArray saveBoardOnJson(Board board){
        JSONArray jsonBoard = new JSONArray();
        Token[][] boardArray = board.getBoard();
        for (int i = 0; i < Board.ROWS; i++) {
            JSONArray jsonRow = new JSONArray();
            for (int j = 0; j < Board.COLUMNS; j++) {
                jsonRow.put(boardArray[i][j].name());
            }
            jsonBoard.put(jsonRow);
        }
        return jsonBoard;
    }

    /**
     * Saves the current game state to a JSON file.
     * The method reads the current game state from the table and saves it to a JSON file.
     * The file is saved in the default file path specified in the filePath attribute.
     */
    private JSONArray savePlayersToJson(IPlayer[] players) {
        JSONArray jsonPlayers = new JSONArray();
        for (IPlayer player : players) {
            JSONObject jsonPlayer = new JSONObject();
            jsonPlayer.put("name", player.getName());
            jsonPlayer.put("token", player.getToken().name());
            jsonPlayer.put("type", player instanceof AI ? "AI" : "Human");
            jsonPlayers.put(jsonPlayer);
        }
        return jsonPlayers;
    }

    /**
     * Loads a game state from a JSON file.
     * The method reads the game state from a JSON file and constructs a new game table with the saved state.
     * The file is loaded from the default file path specified in the filePath attribute.
     */
    @Override
    public void loadGame(){
        try {
            String content;
            try (Stream<String> lines = Files.lines(Paths.get(FILE_PATH))) {
                content = lines.collect(Collectors.joining());
            }
            JSONObject jsonObject = new JSONObject(content);

            Board board = new Board();
            JSONArray jsonBoard = jsonObject.getJSONArray("board");
            Token[][] boardArray = new Token[Board.ROWS][Board.COLUMNS];
            for (int i = 0; i < Board.ROWS; i++) {
                JSONArray jsonRow = jsonBoard.getJSONArray(i);
                for (int j = 0; j < Board.COLUMNS; j++) {
                    boardArray[i][j] = jsonRow.get(j).toString().equals("EMPTY") ? Token.Empty : Token.valueOf(jsonRow.getString(j));
                }
            }
            board.setBoard(boardArray);
            JSONArray jsonPlayers = jsonObject.getJSONArray("player");
            playerFactory.resetPlayers();
            for (int i = 0; i < Table.NB_JOUEURS; i++) {
                JSONObject jsonPlayer = jsonPlayers.getJSONObject(i);
                String name = jsonPlayer.getString("name");
                String type = jsonPlayer.getString("type");
                playerFactory.createPlayer(type.equals("AI")? 2 : 1,name);

            }
            this.table.setBoard(board);
            this.table.setPlayers(playerFactory.getPlayers());
        } catch (IOException e) {
            Logger.getAnonymousLogger().severe("Error loading game state from file: " + e.getMessage());
        } catch (InvalidPlayerTypeException e) {
            Logger.getAnonymousLogger().severe("Error creating player: " + e.getMessage());
        }
    }

    /**
     * Saves the current game state to a JSON file.
     * The method reads the current game state from the table and saves it to a JSON file.
     * The file is saved in the default file path specified in the filePath attribute.
     */
    @Override
    public void saveGame() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("board", saveBoardOnJson(table.getBoard()));
        jsonObject.put("player", savePlayersToJson(table.getPlayers()));
        try {
            Files.write(Paths.get(FILE_PATH), jsonObject.toString().getBytes());
        } catch (IOException e) {
            Logger.getAnonymousLogger().severe("Error saving game state to file: " + e.getMessage());
        }
    }

    /**
     * Deletes the saved game state file.
     * The method deletes the file containing the saved game state.
     */
    @Override
    public boolean isSavedGame() {
        return Files.exists(Paths.get(FILE_PATH));
    }

    /**
     * Deletes the saved game state file.
     * The method deletes the file containing the saved game state.
     */
    @Override
    public void deleteSavedGame() {
        try {
            Path path = Paths.get(FILE_PATH);
            if (Files.exists(path)){
                Files.delete(path);
            }
        } catch (IOException e) {
            Logger.getAnonymousLogger().severe("Error deleting save file: " + e.getMessage());
        }
    }
}
