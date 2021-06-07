package joc;

import java.util.ArrayList;

public class Item {

    private String name;

    private int attackBonus;
    private int defenseBonus;

    /**
     *
     * @param name
     * @param attackBonus
     * @param defenseBonus
     */
    public Item(String name, int attackBonus, int defenseBonus) {
        this.name = name;
        this.attackBonus = attackBonus;
        this.defenseBonus = defenseBonus;
        System.out.println("item creado");
    }

    public Item() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }

    public void setDefenseBonus(int defenseBonus) {
        this.defenseBonus = defenseBonus;
    }

    /**
     *
     * @return
     */
    public String i_info() {
        return "Item{" +
                "name='" + name + '\'' +
                ", attackBonus=" + attackBonus +
                ", defenseBonus=" + defenseBonus +
                '}';
    }

}
