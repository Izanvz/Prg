package joc;

public class Alien extends Player{

    public Alien(String name, int attackPoints, int defensePoints, int life) {
        super(name, attackPoints, defensePoints, life);
        System.out.println("New Alien...");
        if(super.getLife() > 20){

            setAttackPoints(attackPoints + 3);
            setDefensePoints(defensePoints - 3);

        }
        
    }

}
