package joc;

public class Warrior extends Human{

    /**
     *
     * @param name
     * @param attackPoints
     * @param defensePoints
     * @param life
     */
    public Warrior(String name, int attackPoints, int defensePoints, int life) {
        super(name, attackPoints, defensePoints, life);
        System.out.println("New Warrior...");
    }
    //LE DAMOS A WARRIOR SU PROPIO ATTACK Y HIT POR SUS CARACTERISTICAS ESPECIALES//

    /**
     *
     * @param p
     */
     public void Attack(Player p){
        p.hit(p.getAttackPoints());
    }

    //MODIFICAMOS HIT PARA WARRIOR Y SU HABILIDAD DE AGILIDAD//

    /**
     *
     * @param PAtaque
     */
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