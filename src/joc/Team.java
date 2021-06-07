/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joc;

import java.util.*;

/**
 *
 * @author izanv
 */
public class Team {
    
    private String name;

    private ArrayList<Player> players;

    /**
     *
     * @param name
     */
    public Team(String name) {
            this.name = name;
            this.players = new ArrayList<>();
        }

//Constructor para usarlo como capsula(transportar objetos de Team)//
    public Team() { }

    //-----------------------AÑADIR Y BORRAR------------------------------//

    public void add(Player p) throws excepcions.excepciojugadorsrepetits{
            if (players.contains(p)) return;
            this.players.add(p);
            p.addTeam(this);
        }

    public void remove(Player p) throws excepcions.excepciolleverequip {
        if (!players.contains(p)) return;
        this.players.remove(p);
        p.removeTeam(this);
    }

    //-------------------------GETTERS Y SETTERS--------------------------//

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public String getName() {
        return name;
    }

    //---------------------------TOSTRING---------------------------//

    public void setName(String name) {
        this.name = name;
    }

    public String e_info() {
        return "Team{" +
                "name='" + name + '\'' +
                ", players=" + players +
                '}';
    }
}
