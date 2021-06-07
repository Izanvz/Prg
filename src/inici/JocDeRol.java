/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inici;
import excepcions.excepcioautoatac;
import excepcions.excepciojugadorsrepetits;
import excepcions.excepciolleverequip;
import excepcions.excepcionmuerto;
import joc.*;

import java.sql.SQLOutput;
import java.util.*;

/**
 *
 * @author izanv
 */

public class JocDeRol {

    //Creamos arraylis para almacenar objetos
    static ArrayList<Player> Players = new ArrayList();
    static ArrayList<Team> Teams = new ArrayList();
    static ArrayList<Item> Items = new ArrayList();

    //inicializamos la funcion Random
    static Random random;

    /**
     *
     * @param args
     * @throws excepcionmuerto
     * @throws excepcioautoatac
     * @throws excepciojugadorsrepetits
     * @throws excepciolleverequip
     */
    public static void main(String[] args) throws excepcionmuerto, excepcioautoatac, excepciojugadorsrepetits, excepciolleverequip {

        //Creamos un Scanner para poder leer texto,numeros...
        Scanner scan = new Scanner(System.in);

        //variable para controlar el while
        boolean continuar = true;

        //While que abarca tudo el main para poder volver a menus anteriores o finalizar el juego cuando quiera//

        while (continuar == true) {

            System.out.println("-----BIENBENIDO AL MI JUEGO DE ROL-----");

            System.out.println("---MENU---");

            //------------------Primer menu--------------------//
            System.out.println("Que deseas hacer?");
            int menuPrincipal;
            System.out.println("\n - 1.Configuracion\n - 2.Jugar\n - 3.Salir");
            menuPrincipal = scan.nextInt();
            scan.nextLine();

            //Usamos un switch case para las opciones anteriores//

            switch (menuPrincipal) {

                case 1:

                    System.out.println("-----CONFIGURACION-----");
                    int menuConfiguracion;
                    System.out.println("\n - 1.Gestion de Jugadores\n - 2.Gestion de Equipos\n - 3.Gestion de Items\n - 4.Salir");
                    menuConfiguracion = scan.nextInt();
                    scan.nextLine();

                    switch (menuConfiguracion) {

                        case 1:

                            System.out.println("-----JUGADORES-----");
                            int menuJugadores;
                            System.out.println("\n - 1.Crear Jugador\n - 2.Mostrar Jugador\n - 3.Borrar Jugador\n - 4.Asignar jugador a equipo\n - 5.Asignar item a jugador\n - 6.Salir");
                            menuJugadores = scan.nextInt();
                            scan.nextLine();

                            switch (menuJugadores) {

                                case 1:

                                    boolean existe = false;

                                    //Pedimos informacion al usuario para crearlo a su gusto//
                                    System.out.println("Que tipo de personaje quieres?");
                                    String eleccionPersonaje;
                                    System.out.println("\n - human\n - warrior\n - alien");
                                    eleccionPersonaje = scan.nextLine();

                                    //Comprobamos que no se equivoque//
                                    if (eleccionPersonaje == "human" || eleccionPersonaje == "warrior" || eleccionPersonaje == "alien") {
                                        System.out.println("Opcion no valida!");
                                        break;
                                    }
                                    //Asignamos las estadisticas //
                                    System.out.println("Tienes un total de 100 PUNTOS para usar en estadisticas entre ataque y defensa, como quieres repartirlos?");
                                    int p_ataque = 0;
                                    int p_defensa = 0;

                                    System.out.println("Puntos en ataque: ");
                                    p_ataque = scan.nextInt();
                                    scan.nextLine();

                                    //Si sobrepasa los puntos indicados cancelar la asignacion de estadisticas //
                                    if (p_ataque < 0 || p_ataque > 100) {

                                        System.out.println("Solo tienes 100 puntos");
                                        break;
                                    }

                                    //formula de la defensa
                                    p_defensa = 100 - p_ataque;

                                    String nombrePersonaje;
                                    System.out.println("Como quieres que se llame tu personaje?");
                                    nombrePersonaje = scan.nextLine();

                                    //CREAMOS LOS PERSONAJES SEGUN LA INFO RECOGIDA//

                                    if (eleccionPersonaje.equals("human")) {

                                        Human humans = new Human(nombrePersonaje, p_ataque, p_defensa, 100);

                                        //COMPROVAMOS QUE NO EXISTA OTRO OBJETO IGUAL//
                                        for (int i = 0; i < Players.size(); i++) {
                                            if (Players.get(i).getName().equals(humans.getName())) {
                                                existe = true;
                                                System.out.println("El nombre del jugador ya existe.");
                                            }
                                        }

                                        if (existe == false) {
                                            Players.add(humans);
                                            System.out.println(nombrePersonaje + " a sido añadido a la lista de Players");
                                        }

                                    }

                                    if (eleccionPersonaje.equals("warrior")) {

                                        Warrior warriors = new Warrior(nombrePersonaje, p_ataque, p_defensa, 150);

                                        for (int i = 0; i < Players.size(); i++) {

                                            if (Players.get(i).getName().equals(warriors.getName())) {
                                                existe = true;
                                                System.out.println("El nombre del jugador ya existe.");
                                            }
                                        }

                                        if (!existe) {
                                            Players.add(warriors);
                                            System.out.println(nombrePersonaje + " a sido añadido a la lista de Players");
                                        }

                                    }

                                    if (eleccionPersonaje.equals("alien")) {

                                        Alien aliens = new Alien(nombrePersonaje, p_ataque, p_defensa, 150);

                                        for (int i = 0; i < Players.size(); i++) {
                                            if (Players.get(i).getName().equals(aliens.getName())) {
                                                existe = true;
                                                System.out.println("El nombre del jugador ya existe.");
                                            }
                                        }

                                        if (!existe) {
                                            Players.add(aliens);
                                            System.out.println(nombrePersonaje + " a sido añadido a la lista de Players");
                                        }

                                    }
                                    break;

                                case 2:

                                    //IMPRIMIMOS LA INFORMACION DE LOS JUGADORES//

                                    for (int i = 0; i < Players.size(); i++) {
                                        System.out.println(Players.get(i).stats());
                                    }

                                    break;
                                case 3:

                                    //BORRAR UN JUGADOR//
                                    String borrar_player = "";
                                    System.out.println("Dime el nombre del jugador que quieres eliminar");
                                    borrar_player = scan.nextLine();

                                    //BUCLE PARA RECORRER EL ARRAYLIST DE JUGADORES PARA BUSCAR EL INDICADO//

                                    for (int i = 0; i < Players.size(); i++) {

                                        if (Players.get(i).getName().equals(borrar_player)) {

                                            Players.remove(i);
                                            System.out.println("Borrando jugador...");

                                        }

                                    }

                                    break;
                                case 4:

                                    //AÑADIMOS UN JUGADOR A UN EQUIPO//

                                    Team capsula_equipo = new Team();
                                    Player capsula_jugador = new Player();

                                    String n_jugador = "";
                                    String n_equipo = "";
                                    System.out.println("Dime el nombre del jugador que quieres añadir");
                                    n_jugador = scan.nextLine();
                                    System.out.println("Dime a que equipo quieres añadirlo");
                                    n_equipo = scan.nextLine();

                                    //COMPRUEBA EL NOMBRE QUE LE HEMOS DADO CON LOS DE LA LISTA//

                                    for (int i = 0; i < Players.size(); i++) {
                                        if (Players.get(i).getName().equals(n_jugador)) {
                                            capsula_jugador = Players.get(i);
                                        }
                                    }

                                    //COMPRUEBA EL NOMBRE QUE LE HEMOS DADO CON LOS DE LA LISTA//
                                    for (int i = 0; i < Teams.size(); i++) {
                                        if (Teams.get(i).getName().equals(n_equipo)) {
                                            capsula_equipo = Teams.get(i);
                                        }
                                    }

                                    //COMPRUEBA EL NOMBRE QUE LE HEMOS DADO CON LOS DE LA LISTA//
                                    try {
                                        capsula_jugador.addTeam(capsula_equipo);
                                    } catch (excepciojugadorsrepetits ex) {
                                        System.out.println("Error: " + ex.getMessage());
                                    }

                                    break;
                                case 5:

                                    //AÑADIMOS UN OBJETO A UN JUGADOR//

                                    Item capsula_item = new Item();
                                    Player capsulaitem_jugador = new Player();

                                    String ni_jugador = "";
                                    String n_item = "";
                                    System.out.println("Dime el nombre del jugador al que quieres añadir un objeto");
                                    ni_jugador = scan.nextLine();
                                    System.out.println("Dime el nombre del objeto que quieres darle");
                                    n_item = scan.nextLine();

                                    //COMPRUEBA EL NOMBRE QUE LE HEMOS DADO CON LOS DE LA LISTA//
                                    for (int i = 0; i < Players.size(); i++) {
                                        if (Players.get(i).getName().equals(ni_jugador)) {
                                            capsulaitem_jugador = Players.get(i);
                                        }
                                    }

                                    //COMPRUEBA EL NOMBRE QUE LE HEMOS DADO CON LOS DE LA LISTA//
                                    for (int i = 0; i < Teams.size(); i++) {

                                        if (Items.get(i).getName().equals(n_item)) {
                                            capsula_item = Items.get(i);
                                        }
                                    }

                                    //LO AÑADIMOS//
                                    capsulaitem_jugador.addItem(capsula_item);

                                    break;
                                case 6:
                                    //PARA VOLVER ATRAS//
                                    break;
                                default:
                                    //POR SI NO SE INTRODUCE NINGUN VALOR//
                                    System.out.println("Opps...");

                            }


                            break;
                        case 2:

                            System.out.println("-----EQUIPOS-----");
                            int menuEquipos;
                            System.out.println("\n - 1.Crear Equipo\n - 2.Mostrar Equipo\n - 3.Borrar Equipo\n - 4.Asignar equipo a jugador\n - 5.Salir");
                            menuEquipos = scan.nextInt();
                            scan.nextLine();

                            switch (menuEquipos) {

                                case 1:

                                    //CREACION DE EQUIPOS//

                                    boolean existe = false;
                                    String nombre_equipo = "";

                                    //SE PIDE LA INFORMACION NECESARIA//
                                    System.out.println("Nombre del equipo:");
                                    nombre_equipo = scan.nextLine();

                                    //LO CREAMOS//

                                    Team teams = new Team(nombre_equipo);

                                    //COMPROBAMOS QUE NO EXSITA OTRO IGUAL EN EL ARRAYLIST//

                                    for (int i = 0; i < Teams.size(); i++) {
                                        if (Teams.get(i).getName().equals(nombre_equipo)) {
                                            existe = true;
                                            System.out.println("El equipo ya existe.");
                                        }
                                    }

                                    if (existe == false) {
                                        Teams.add(teams);
                                        System.out.println(nombre_equipo + " a sido añadido a la lista de Equipos");
                                    }

                                    break;
                                case 2:

                                    //MOSTRAMOS LOS EQUIPOS//

                                    for (int i = 0; i < Teams.size(); i++) {
                                        System.out.println(Teams.get(i).e_info());
                                    }

                                    break;
                                case 3:

                                    //BORRAR UN EQUIPO//

                                    String borrar_team = "";
                                    System.out.println("Dime el nombre del equipo que quieres eliminar");
                                    borrar_team = scan.nextLine();

                                    //COMPROBAMOS QUE EXSITA EN EL ARRAYLIST//

                                    for (int i = 0; i < Teams.size(); i++) {

                                        if (Teams.get(i).getName().equals(borrar_team)) {

                                            Teams.remove(i);


                                            System.out.println("Borrando equipo...");

                                        }

                                    }

                                    break;
                                case 4:

                                    //ASIGNAMOS UN JUGADOR A UN EQUIPO COMPROBANDO COMO LOS HACIAMOS EN EL ANTERIO CASO EN JUGADORES//

                                    Team capsula_equipo = new Team();
                                    Player capsula_jugador = new Player();

                                    String n_jugador = "";
                                    String n_equipo = "";
                                    System.out.println("Dime el nombre del jugador que quieres añadir");
                                    n_jugador = scan.nextLine();
                                    System.out.println("Dime a que equipo quieres añadirlo");
                                    n_equipo = scan.nextLine();

                                    for (int i = 0; i < Players.size(); i++) {
                                        if (Players.get(i).getName().equals(n_jugador)) {
                                            capsula_jugador = Players.get(i);
                                        }
                                    }

                                    for (int i = 0; i < Teams.size(); i++) {
                                        if (Teams.get(i).getName().equals(n_equipo)) {
                                            capsula_equipo = Teams.get(i);
                                        }
                                    }

                                    try {
                                        capsula_equipo.add(capsula_jugador);
                                    } catch (excepciojugadorsrepetits ex) {
                                        System.out.println("Error: " + ex.getMessage());
                                    }


                                    break;
                                case 5:

                                    break;

                                default:
                                    System.out.println("Opps...");

                            }

                            break;
                        case 3:

                            System.out.println("-----ITEMS-----");
                            int menuItems;
                            System.out.println("\n - 1.Crear Item\n - 2.Mostrar Item\n - 3.Borrar Item\n - 4.Asignar item a jugador\n - 5.Asignar item a jugador\n - 6.Salir");
                            menuItems = scan.nextInt();
                            scan.nextLine();

                            switch (menuItems) {

                                case 1:

                                    //CREAMOS UN ITEMS CON LA INFOMACION QUE LE PEDIMOS AL USUARIO//

                                    boolean existe = false;
                                    String nombre_item = "";
                                    int abonus;
                                    int dbonus;

                                    System.out.println("Nombre del Item");
                                    nombre_item = scan.nextLine();
                                    System.out.println("Bonus de ataque del Item");
                                    abonus = scan.nextInt();
                                    System.out.println("Bonus de defensa del Item");
                                    dbonus = scan.nextInt();

                                    Item items = new Item(nombre_item, abonus, dbonus);

                                    //HACEMOS COMPROBACIONES DE SU EXISTENCIA ANTES DE AÑADIRLO//

                                    for (int i = 0; i < Items.size(); i++) {
                                        if (Items.get(i).getName().equals(nombre_item)) {
                                            existe = true;
                                            System.out.println("El Item ya existe.");
                                        }
                                    }

                                    if (existe == false) {
                                        Items.add(items);
                                        System.out.println(nombre_item + " a sido añadido a la lista de Items");
                                    }

                                    break;
                                case 2:

                                    //MOSTRAMOS LOS ITEMS//

                                    for (int i = 0; i < Items.size(); i++) {
                                        System.out.println(Items.get(i).i_info());
                                    }

                                    break;
                                case 3:

                                    //BORRAR UN ITEM TENIENDO EN CUENTA SU EXISTENCIA//

                                    String borrar_item = "";
                                    System.out.println("Dime el nombre del item que quieres eliminar");
                                    borrar_item = scan.nextLine();

                                    for (int i = 0; i < Items.size(); i++) {

                                        if (Items.get(i).getName().equals(borrar_item)) {

                                            Items.remove(i);
                                            System.out.println("Borrando item...");
                                        }
                                    }
                                    break;
                                case 4:

                                    //AÑADIMOS UN ITEM A UN JUGADOR//

                                    Item capsula_item = new Item();
                                    Player capsula_jugador = new Player();

                                    //INFO DEL USUARIO//
                                    String n_jugador = "";
                                    String n_item = "";
                                    System.out.println("Dime el nombre del jugador que quieres añadir");
                                    n_jugador = scan.nextLine();
                                    System.out.println("Dime a que item quieres darle");
                                    n_item = scan.nextLine();

                                    //COMPROBAMOS//

                                    for (int i = 0; i < Players.size(); i++) {
                                        if (Players.get(i).getName().equals(n_jugador)) {
                                            capsula_jugador = Players.get(i);
                                        }
                                    }

                                    for (int i = 0; i < Items.size(); i++) {
                                        if (Items.get(i).getName().equals(n_item)) {
                                            capsula_item = Items.get(i);
                                        }
                                    }

                                    capsula_jugador.addItem(capsula_item);

                                    break;
                                case 5:

                                    return;
                                default:
                                    System.out.println("Opps...");
                                    break;
                            }

                            break;
                        case 4:

                            break;

                        default:
                            System.out.println("Opps...");
                            break;
                    }

                    break;
                case 2:

                    System.out.println("----------JUGAR----------");


                    while (true) {

                        //SI SE LLEGA AL LIMETE DE LA LISTA SIGNIFICA QUE HAY UN GANADOR//
                        if (Players.size() == 2) {
                            System.out.println("El ganador es: " + Players.get(0).getName() + "\n");
                            break;
                        }

                        //NO PUEDEN HABER MENOS DE DOS JUGADORES//

                        if (Players.size() < 2){

                            System.out.println("Se necesitan al menos 2 jugadores!");
                            break;

                        }

                        random = new Random();

                        //Para establecer turnos//
                        int posatacante = 0;

                        //DOS NUEVOS PLAYERS QUE USAREMOS PARA LUCHAR//

                        Player Jugador1 = Players.get(posatacante);
                        Player Jugador2 = elegirenemigo(Jugador1);

                        int vida = Jugador1.getLife();

                        System.out.println(Jugador1.getName() + " contra " + Jugador2.getName() + "\n");

                        //USAMOS UN METODO PARA LUCHAR (HE USADO UN METODO PORQUE SE ME HACIA MAS SENCILLO Y AL CONTRARIO ME DABA UN ERROR)//

                        Player perdedor = pelea(Jugador1, Jugador2);

                        System.out.println("La pelea ha finalizado , el perdedor es " + perdedor.getName() + "\n");
                        //ELIMINAMOS A EL PERDEDOR YA QUE SU VIDA A LLEGADO A 0//
                        Players.remove(perdedor);
                        //LE DEVOLVEMOS LA VIDA QUE TENIA ANTES DE LUCHAR PARA QUE PUEDA SEGUIR LUCHANDO//
                        Jugador1.setLife(vida);

                        posatacante += 1;

                        if (posatacante >= Players.size()) {
                            //Para que se vayan cambiando los turnos
                            posatacante = 0;
                        }

                    }
                    break;

                case 3:
                    System.out.println("Hasta la proxima");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opps...");
                    break;
            }


        }

    }

    /**
     *
     * @param jugador1
     * @param jugador2
     * @return
     * @throws excepcionmuerto
     * @throws excepcioautoatac
     */
    public static Player pelea(Player jugador1, Player jugador2) throws excepcionmuerto , excepcioautoatac{

        while (true) {

            //EXCEPCION POR SI EL RANDOM ELIGE EL MISMO NUMERO//
            try {
                if (jugador1.equals(jugador2)) {
                    throw new excepcioautoatac("No puede atacarse a si mismo");
                }
            } catch (excepcioautoatac ex) {
                System.out.println("**Error: "+ex.getMessage());
            }

            try {
                jugador1.Attack(jugador2);
            } catch (excepcionmuerto ex) {
                System.out.println("Error: el jugador esta muerto " + ex.getMessage());//EXCEPCION POR SI EL JUGADOR ESTA MUERTO//
            }
            if (jugador1.getLife() == 0) {//DEVUELVE EL JUGADOR QUE PIERDE (SU VIDA LLEGA A 0)//
                return jugador1;
            }
            if (jugador2.getLife() == 0) {
                return jugador2;
            }
            try {
                jugador2.Attack(jugador1);
            } catch (excepcionmuerto ex) {
                System.out.println("Error: el jugador esta muerto " + ex.getMessage());
            }
            if (jugador1.getLife() == 0) {
                return jugador1;
            }
            if (jugador2.getLife() == 0) {
                return jugador2;
            }
        }
    }




    //FUNCION PARA ELEGIR UN JUGADOR ALEATORIAMENTE//

    /**
     *
     * @param jugador1
     * @return
     */
    public static Player elegirenemigo(Player jugador1) {
        while (true) {
            Player jugador2 = Players.get(random.nextInt(Players.size()));
            if (!jugador1.equals(jugador2)) {
                return jugador2;
            }
        }
    }
    
    
    public static void provaFase(){
/*
        Human human2 = new Human("human2", 25,20,150);
        Warrior warrior2 = new Warrior("warrior2", 25,20,100);
        Alien alien2 = new Alien("alien2", 40,20,100);

        Team passif = new Team("passifteam");
        Team macia = new Team("maciteam");
        Item espada = new Item("espadote",4, 2);


        System.out.println("--ALIEN VS WARRIOR--\n");
        alien2.Attack(warrior2);
        System.out.println("*****************************************************************************************************\n");
        System.out.println("--WARRIOR VS HUMAN--\n");
        warrior2.Attack(human2);
        System.out.println("*****************************************************************************************************\n");
        System.out.println("--HUMAN VS ALIEN--\n");
        human2.Attack(alien2);
        System.out.println("*****************************************************************************************************\n");


        alien2.addTeam(macia);

        human2.addItem(espada);



        System.out.println(human2.stats());
        System.out.println(alien2.stats());
*/
    }

}
