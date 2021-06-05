/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inici;
import joc.*;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 *
 * @author izanv
 */

public class JocDeRol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("-----BIENBENIDO AL MI JUEGO DE ROL-----");

        System.out.println("---MENU---");

        System.out.println("Que deseas hacer?");
        int menuPrincipal;
        System.out.println("\n - 1.Configuracion\n - 2.Jugar\n - 3.Salir");
        menuPrincipal = scan.nextInt();
        scan.nextLine();

            switch(menuPrincipal){

                case 1:

                    System.out.println("-----CONFIGURACION-----");
                    int menuConfiguracion;
                    System.out.println("\n - 1.Gestion de Jugadores\n - 2.Gestion de Equipos\n - 3.Gestion de Items\n - 4.Salir");
                    menuConfiguracion = scan.nextInt();
                    scan.nextLine();

                    switch(menuConfiguracion){

                        case 1:

                            System.out.println("-----JUGADORES-----");
                            int menuJugadores;
                            System.out.println("\n - 1.Crear Jugador\n - 2.Mostrar Jugador\n - 3.Borrar Jugador\n - 4.Asignar jugador a equipo\n - 5.Asignar item a jugador\n - 6.Salir");
                            menuJugadores = scan.nextInt();
                            scan.nextLine();

                            switch(menuJugadores){

                                case 1:

                                    String nombreUsuario;
                                    System.out.println("Cual quieres que sea tu nombre de usuario?");
                                    nombreUsuario = scan.nextLine();
                                    System.out.println("Que tipo de personaje quieres?");
                                    String eleccionPersonaje;
                                    System.out.println("\n - human\n - warrior\n - alien");
                                    eleccionPersonaje = scan.nextLine();
                                    String nombrePersonaje;
                                    System.out.println("Como quieres que se llame tu personaje?");
                                    nombrePersonaje = scan.nextLine();

                                    System.out.println("Tienes un total de 100 PUNTOS para usar en estadisticas entre ataque y defensa, como quieres repartirlos?");
                                    int p_ataque = 0;
                                    int p_defensa = 0;

                                    while((p_ataque+p_defensa)<100) {

                                        System.out.println("Puntos en ataque: ");
                                        p_ataque = scan.nextInt();
                                        scan.nextLine();
                                        System.out.println("Puntos en defensa: ");
                                        p_defensa = scan.nextInt();
                                        scan.nextLine();
                                    }

                                    if(eleccionPersonaje == "human"){ Human humans = new Human(nombrePersonaje, p_ataque, p_defensa,150); }

                                    if(eleccionPersonaje == "warrior"){ Warrior warriors = new Warrior(nombrePersonaje, p_ataque, p_defensa,150); }

                                    if(eleccionPersonaje == "alien"){ Alien aliens = new Alien(nombrePersonaje, p_ataque, p_defensa,150); }

                                case 2:

                                    break;
                                case 3:

                                    break;
                                case 4:

                                    break;
                                case 5:

                                    break;
                                case 6:
                                    System.out.println("Hasta la proxima");
                                    break;
                                default:
                                    System.out.println("Opps...");
                                    break;
                            }


                            break;
                        case 2:

                            System.out.println("-----EQUIPOS-----");
                            int menuEquipos;
                            System.out.println("\n - 1.Crear Equipo\n - 2.Mostrar Equipo\n - 3.Borrar Equipo\n - 4.Asignar equipo a jugador\n - 5.Salir");
                            menuEquipos = scan.nextInt();
                            scan.nextLine();

                            switch(menuEquipos){

                                case 1:

                                    break;
                                case 2:

                                    break;
                                case 3:

                                    break;
                                case 4:

                                    break;
                                case 5:
                                    System.out.println("Hasta la proxima");
                                    break;
                                default:
                                    System.out.println("Opps...");
                                    break;
                            }

                            break;
                        case 3:

                            System.out.println("-----ITEMS-----");
                            int menuItems;
                            System.out.println("\n - 1.Crear Item\n - 2.Mostrar Item\n - 3.Borrar Item\n - 4.Asignar item a jugador\n - 5.Asignar item a jugador\n - 6.Salir");
                            menuItems = scan.nextInt();
                            scan.nextLine();

                            switch(menuItems){

                                case 1:

                                    break;
                                case 2:

                                    break;
                                case 3:

                                    break;
                                case 4:

                                    break;
                                case 5:

                                    break;
                                case 6:
                                    System.out.println("Hasta la proxima");
                                    break;
                                default:
                                    System.out.println("Opps...");
                                    break;
                            }

                            break;
                        case 4:
                            System.out.println("Hasta la proxima");
                            break;

                        default:
                            System.out.println("Opps...");
                            break;
                    }

                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("Hasta la proxima");
                    break;
                default:
                    System.out.println("Opps...");
                    break;
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
