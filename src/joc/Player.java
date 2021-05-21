package joc;

public class Player {

    private String name;
    private int attackPoints;
    private int defensePoints;
    private int life;


    public Player(String name, int attackPoints, int defensePoints, int life) {
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.life = life;
    }

    public void Attack(Player p){

        System.out.println("Estadisticas");
        
        System.out.println(stats());
        
        System.out.println(p.stats());
        
        p.hit(this.attackPoints);
        
        System.out.println("\n---------------------------------------------------------------------------------------------------- ");
        System.out.println("Resutado de la pelea :");
        System.out.println(this.name+" a atacado a "+p.getName()+" con "+this.attackPoints+" de daño pero se defiende con "+p.getDefensePoints()+" puntos de armadura ");
        System.out.println("---------------------------------------------------------------------------------------------------- ");
        
        System.out.println(stats());

        System.out.println(p.stats());

    }


    protected void hit(int attackPoints) {


        int dmg = 0;
        dmg = this.attackPoints - getDefensePoints();
        int lifeF = getLife();

        lifeF -= dmg;
        
        setLife(lifeF);

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }


    public String stats() {
        return "\nPlayerInfo { "+ name + " PA :"+attackPoints+" / PD : "+ defensePoints +" / PV : "+ life +"}";
    }
}
