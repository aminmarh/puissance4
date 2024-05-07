package com.example.puissance4.factory;

import com.example.puissance4.game.IPlayer;
import com.example.puissance4.game.Table;
import com.example.puissance4.game.Token;
import org.springframework.stereotype.Component;
import com.example.puissance4.player.AI;
import com.example.puissance4.player.Human;
import com.example.puissance4.player.IPlayerHumanComputerInterface;

@Component
public class PlayerFactory implements IPlayerFactory {
    private IPlayer[] players;
    private int currentPlayer;
    private Token[] tokens;
    private IPlayerHumanComputerInterface playerHumanComputerInterface;


    public PlayerFactory(IPlayerHumanComputerInterface playerHumanComputerInterface) {
        this.players = new IPlayer[Table.NB_JOUEURS];
        this.currentPlayer = 0;
        this.tokens = new Token[]{Token.Red, Token.Yellow};
        this.playerHumanComputerInterface = playerHumanComputerInterface;
    }

    @Override
    public void createPlayer(int type, String name) throws InvalidPlayerTypeException {
        if (type == 1){
            players[currentPlayer] = new Human(name, tokens[currentPlayer], this.playerHumanComputerInterface);
        } else if (type == 2) {
            players[currentPlayer] = new AI(name, tokens[currentPlayer]);
        } else {
            throw new InvalidPlayerTypeException();
        }
        currentPlayer++;
    }

    @Override
    public IPlayer[] getPlayers() {
        return players;
    }
}
