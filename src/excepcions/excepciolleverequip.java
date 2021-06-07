package excepcions;

public class excepciolleverequip extends Exception{

    public excepciolleverequip(String message) {
        super(message);
    }

    public excepciolleverequip() {
        super("El jugador está muerto");
    }

}
