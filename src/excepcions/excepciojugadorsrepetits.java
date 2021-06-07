package excepcions;

public class excepciojugadorsrepetits extends Exception{

    public excepciojugadorsrepetits(String message) {
        super(message);
    }

    public excepciojugadorsrepetits() {
        super("El jugador está muerto");
    }

}