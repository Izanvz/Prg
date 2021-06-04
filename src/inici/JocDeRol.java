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

        Human human2 = new Human("human2", 25,20,150);
        Warrior warrior2 = new Warrior("warrior2", 25,20,100);
        Alien alien2 = new Alien("alien2", 40,20,100);

        Team passif = new Team("passifteam");
        Team macia = new Team("maciteam");

/*
        System.out.println("--ALIEN VS WARRIOR--\n");
        alien2.Attack(warrior2);
        System.out.println("*****************************************************************************************************\n");
        System.out.println("--WARRIOR VS HUMAN--\n");
        warrior2.Attack(human2);
        System.out.println("*****************************************************************************************************\n");
        System.out.println("--HUMAN VS ALIEN--\n");
        human2.Attack(alien2);
        System.out.println("*****************************************************************************************************\n");
*/

        human2.addTeam(passif);
        alien2.addTeam(macia);




        System.out.println(human2.stats());
        System.out.println(alien2.stats());

        Team.list(passif);
    }
                                                                                  
}
