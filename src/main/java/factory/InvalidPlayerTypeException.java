package factory;

public class InvalidPlayerTypeException extends Exception {
    public InvalidPlayerTypeException() {
        super("Invalid player type");
    }
}
