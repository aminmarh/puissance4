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
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Save manages the saving and loading of game states for the Puissance 4 game.
 * It provides methods for saving the current game state to a JSON file and loading a game state from a JSON file.
 */
@Component
public class Save {
    private String filePath = "save.json";
    private Table table;
    private IPlayerFactory playerFactory;

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
    public void saveBoardOnJson(Board board){
        try {
            String content = Files.lines(Paths.get(filePath)).collect(Collectors.joining());
            JSONObject jsonObject = new JSONObject(content);
            JSONArray jsonBoard = new JSONArray();
            Token[][] boardArray = board.getBoard();
            for (int i = 0; i < Board.ROWS; i++) {
                JSONArray jsonRow = new JSONArray();
                for (int j = 0; j < Board.COLUMNS; j++) {
                    jsonRow.put(boardArray[i][j]);
                }
                jsonBoard.put(jsonRow);
            }

            jsonObject.put("board", jsonBoard);
            Files.write(Paths.get(filePath), jsonObject.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the current game state to a JSON file.
     * The method reads the current game state from the table and saves it to a JSON file.
     * The file is saved in the default file path specified in the filePath attribute.
     */
    public void savePlayersToJson(IPlayer[] players) {
        try {
            String content = Files.lines(Paths.get(filePath)).collect(Collectors.joining());
            JSONObject jsonObject = new JSONObject(content);
            JSONArray jsonPlayers = new JSONArray();

            for (IPlayer player : players) {
                JSONObject jsonPlayer = new JSONObject();
                jsonPlayer.put("name", player.getName());
                jsonPlayer.put("token", player.getToken());
                jsonPlayer.put("type", player instanceof AI ? "AI" : "Human");
                jsonPlayers.put(jsonPlayer);
            }

            jsonObject.put("player", jsonPlayers);
            Files.write(Paths.get(filePath), jsonObject.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads a game state from a JSON file.
     * The method reads the game state from a JSON file and constructs a new game table with the saved state.
     * The file is loaded from the default file path specified in the filePath attribute.
     * @return A new game table with the loaded game state.
     */
    public Table loadGame(){
        try {
            String content = Files.lines(Paths.get(filePath)).collect(Collectors.joining());
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
            return table;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidPlayerTypeException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
