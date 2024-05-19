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

@Component
public class Save {
    private String filePath = "save.json";
    private Table table;
    private IPlayerFactory playerFactory;

    public Save (Table table, IPlayerFactory playerFactory){
        this.table = table;
        this.playerFactory = playerFactory;
    }

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
