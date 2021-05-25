/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inici;
import joc.*;

/**
 *
 * @author izanv
 */

public class JocDeRol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        provaFase();

    }
    
    
    public static void provaFase(){

        Human human2 = new Human("human2", 26,17,150);
        Warrior warrior2 = new Warrior("warrior2", 25,20,100);
        Alien alien2 = new Alien("alien2", 1,20,100);

        warrior2.Attack(alien2);

    }
                                                                                  
}
