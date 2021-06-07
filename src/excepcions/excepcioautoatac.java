package excepcions;

public class excepcioautoatac extends Exception{

    public excepcioautoatac(String message) {
        super(message);
    }

    public excepcioautoatac() {
        super("El jugador está muerto");
    }

}