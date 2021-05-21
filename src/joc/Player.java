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

        p.hit(this.attackPoints);


        System.out.println("Resutado de la pelea :");

        System.out.println(this.name);
        stats();

        System.out.println(getName());
        p.stats();

    }


    protected void hit(int attackPoints) {

        System.out.println(stats());

        int dmg = 0;
        dmg = this.attackPoints - getDefensePoints();
        int lifeF = getLife();


        System.out.println(this.name+" a atacado a "+getName()+" con "+this.attackPoints+" de daño pero se defiende con "+getDefensePoints()+" puntos de armadura ");
        System.out.print(dmg+" - "+getLife()+" = ");
        lifeF -= dmg;
        System.out.print(lifeF);

        setLife(lifeF);

        System.out.println(stats());

        if(lifeF > 0) {
            System.out.println("Ha sido golpedo con " + dmg + " de daño");
        }
        if(lifeF <= 0){
            System.out.println("Ha sido eliminado tras ser golpeado con "+dmg+" y perder toda tu vida");
        }

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
