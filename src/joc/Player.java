package joc;

import java.util.ArrayList;

public class Player {

    private String name;
    private int attackPoints;
    private int defensePoints;
    private int life;
    protected ArrayList<Team> teams;
    protected ArrayList<Item> items;


    public Player(String name, int attackPoints, int defensePoints, int life) {
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.life = life;
        setTeams(new ArrayList<>());
        setItems(new ArrayList<>());
    }

    //----------------------------------Atacar-----------------------------------//
    public void Attack(Player p){

        System.out.println("Estadisticas");
        
        System.out.println(p.stats());
        
        System.out.println("\n---------------------------------------------------------------------------------------------------- ");
        System.out.println("Resutado de la pelea :");
        p.hit(p.attackPoints);
        System.out.println("---------------------------------------------------------------------------------------------------- ");

        System.out.println(p.stats());

    }

    protected void hit(int PAtaque) {


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

    public void addTeam(Team t) {

        if (this.teams.contains(t)) return;
        this.teams.add(t);
        t.add(this);
    }

    public void removeTeam(Team t) {

        if (!this.teams.contains(t)) return;
        this.teams.remove(t);
        t.remove(this);
    }

    public void lista(Player p){ System.out.println(this); }

    //----------------------------------Items------------------------------------//

    public void addItem(Item i){
        if (this.items.contains(i)) return;
        this.items.add(i);
    }

    public void removeItem(Item i){
        if (!this.items.contains(i)) return;
        this.items.remove(i);
    }

    public String listaItem(){

        String inventario = " ";

        for (int i = 0; i < items.size(); i++) {
        inventario += items.get(i);
        }

        return inventario;

    }

    //----------------------------------Equals------------------------------------//

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

    public String stats() {

        String info= "\nPlayerInfo { "+ name + " PA :"+attackPoints+" / PD : "+ defensePoints +" / PV : "+ life +"}\n{Equipos : "+this.getTeams().size()+"}\n{Items : ";

        for (int j = 0; j < items.size(); j++) {
            Item i = items.get(j);
            if (!(j == items.size() - 1)) {
                info += "- " + i.getName() + " BA: " + i.getAttackBonus() + " / BD: " + i.getDefenseBonus() + "\n";
            } else {
                info += "- " + i.getName() + " BA: " + i.getAttackBonus() + " / BD: " + i.getDefenseBonus();
            }
    }


        return info;
    }


}