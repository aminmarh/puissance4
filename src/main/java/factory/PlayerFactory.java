package factory;

import game.IPlayer;
import game.Table;
import game.Token;
import player.AI;
import player.Human;

public class PlayerFactory implements IPlayerFactory {
    private IPlayer[] players;
    private int currentPlayer;
    private Token[] tokens;

    public PlayerFactory() {
        this.players = new IPlayer[Table.NB_JOUEURS];
        this.currentPlayer = 0;
        this.tokens = new Token[]{Token.Red, Token.Yellow};
    }

    @Override
    public void createPlayer(int type, String name) throws InvalidPlayerTypeException {
        if (type == 1){
            players[currentPlayer] = new Human(name, tokens[currentPlayer]);
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
