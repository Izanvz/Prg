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

        Alien alien2 = new Alien("personajea2", 7,4,4);
        Warrior warrior2 = new Warrior("personajew2", 6,6,5);

        warrior2.Attack(alien2);

    }
                                                                                  
}
