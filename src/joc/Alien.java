package joc;

public class Alien extends Player{

    public Alien(String name, int attackPoints, int defensePoints, int life) {
        super(name, attackPoints, defensePoints, life);
        
        if(super.life > 20){
            
            setAttackPoints(attackPoints + 3);
            setDefensePoints(defensePoints - 3);
            
        }
        
    }

}
