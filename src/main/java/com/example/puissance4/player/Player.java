package com.example.puissance4.player;

import com.example.puissance4.game.IPlayer;
import com.example.puissance4.game.Token;

public abstract class Player implements IPlayer {
    private String name;
    private Token token;

    protected Player(String name, Token token){
        this.name=name;
        this.token=token;
    }

    public String getName(){
        return name;
    }

    public Token getToken(){
        return token;
    }
}
