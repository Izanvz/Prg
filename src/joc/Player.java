package joc;

import java.util.ArrayList;

public class Player {

    private String name;
    private int attackPoints;
    private int defensePoints;
    private int life;
    protected ArrayList<Team> teams;
    protected ArrayList<Item> items;

    //CONTRUCTOR BASE//

    /**
     *
     * @param name
     * @param attackPoints
     * @param defensePoints
     * @param life
     */
    public Player(String name, int attackPoints, int defensePoints, int life) {
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.life = life;
        setTeams(new ArrayList<>());
        setItems(new ArrayList<>());
    }
    //Constructor para usarlo como capsula(transportar objetos de Player)
    public Player() { }

    //----------------------------------Atacar-----------------------------------//

    /**
     *
     * @param p
     * @throws excepcions.excepcionmuerto
     */
    public void Attack(Player p) throws excepcions.excepcionmuerto {

        p.hit(p.attackPoints);

    }

    /**
     *
     * @param PAtaque
     */
    protected void hit(int PAtaque){


        int dmg = 0;
        dmg = PAtaque - getDefensePoints();
        int lifeF = getLife();
        
        if(dmg <= 0){dmg = 0;}
        
        System.out.println(name+" a sido atacado con "+PAtaque+" de daño pero se defiende con "+getDefensePoints()+" puntos de armadura ");
        lifeF -= dmg;
        System.out.println("Resultado : "+getLife()+" - "+dmg+" = "+lifeF);
        
        
        
        setLife(lifeF);

    }

    //----------------------------------Teams------------------------------------//

    /**
     *
     * @param t
     * @throws excepcions.excepciojugadorsrepetits
     */
    public void addTeam(Team t) throws excepcions.excepciojugadorsrepetits{

        if (this.teams.contains(t)) return;
        this.teams.add(t);
        t.add(this);
    }

    /**
     *
     * @param t
     * @throws excepcions.excepciolleverequip
     */
    public void removeTeam(Team t) throws excepcions.excepciolleverequip{

        if (!this.teams.contains(t)) return;
        this.teams.remove(t);
        t.remove(this);
    }

    //----------------------------------Items------------------------------------//

    /**
     *
     * @param i
     */
    public void addItem(Item i){
        if (this.items.contains(i)) return;
        this.items.add(i);
    }

    /**
     *
     * @param i
     */
    public void removeItem(Item i){
        if (!this.items.contains(i)) return;
        this.items.remove(i);
    }

    //----------------------------------Equals------------------------------------//

    /**
     *
     * @param p
     * @return
     */
    public boolean equals(Player p) {

        boolean res = false;

        if (this.name == p.getName()) { res = true; }

        else if (this.name != p.getName()) { res = false; }


        return res;

    }

    //-----------------------------Getters/Setters-------------------------------//

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
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

    //---------------------------------toString-----------------------------------//

    /**
     *
     * @return
     */
    public String stats() {

        String info = "";

        for (int i = 0; i < items.size(); i++) {
                info += items.get(i).getName() + " BA: " + items.get(i).getAttackBonus() + " / BD: " + items.get(i).getDefenseBonus() + "\n";
        }


        return  "\n{ Nombre "+ getName() + " PA :"+getAttackPoints()+" / PD : "+ getDefensePoints() +" / PV : "+ getLife() +"}" +
                "\n{ Equipos : "+this.getTeams().size()+" }" +
                "\n{ Items : "+ info +" }";
    }


}