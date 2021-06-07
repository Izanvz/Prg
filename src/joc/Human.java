package joc;

public class Human extends Player{

    /**
     *
     * @param name
     * @param attackPoints
     * @param defensePoints
     * @param life
     */
    public Human(String name, int attackPoints, int defensePoints, int life) {
        super(name, attackPoints, defensePoints, life);
        System.out.println("New Human...");
            
    }

}
        

