package game;

public interface IHumanComputerInterface {
    public void initGame();
    public void finishGame(IPlayer winner);
    public void showBoard(Board board);
}
