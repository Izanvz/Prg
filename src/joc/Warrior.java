package joc;

public class Warrior extends Human{

    public Warrior(String name, int attackPoints, int defensePoints, int life) {
        super(name, attackPoints, defensePoints, life);
        
    }
    
     public void Attack(Player p){

        System.out.println("Estadisticas");
        
        System.out.println(p.stats());
        
        System.out.println("\n---------------------------------------------------------------------------------------------------- ");
        System.out.println("Resutado de la pelea :");
        p.hit(p.getAttackPoints());
        System.out.println("---------------------------------------------------------------------------------------------------- ");

        System.out.println(p.stats());

    }


    protected void hit(int PAtaque) {


        int dmg = 0;
        dmg = PAtaque - getDefensePoints();
        int lifeF = getLife();
        
        System.out.println(getName()+" a sido atacado con "+PAtaque+" de daño pero se defiende con "+this.getDefensePoints()+" puntos de armadura ");
       
        if(dmg <= 5){
            dmg = 0;
            System.out.println("Agilidad activada");
        }
        
        lifeF -= dmg;
        System.out.println("Resultado : "+getLife()+" - "+dmg+" = "+lifeF);
        
        
        
        setLife(lifeF);

    }
    
}