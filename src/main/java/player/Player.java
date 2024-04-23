package player;

import game.Board;
import game.IPlayer;
import game.InvalidMoveException;
import game.Token;

public abstract class Player implements IPlayer {
    private String name;
    private Token token;

    public Player(String name, Token token){
        this.name=name;
        this.token=token;
    }

    public String getName(){
        return name;
    }

    public Token getToken(){
        return token;
    }

    public abstract void play(Board board);
}
