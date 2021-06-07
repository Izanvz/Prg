package excepcions;

public class excepcionmuerto extends Exception{

    public excepcionmuerto(String message) {
        super(message);
    }

    public excepcionmuerto() {
        super("El jugador está muerto");
    }

}
