package factory;

import game.IPlayer;
import game.Table;
import game.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import player.AI;
import player.Human;
import player.IPlayerHumanComputerInterface;

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
