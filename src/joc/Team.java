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

    private ArrayList<Player> players = new ArrayList();

    public Team(String name) {
        this.name = name;
    }
    
    public void add(Player p){

        players.add(p);

    }
    
    public void remove(Player p){

        players.remove(p);

    }
    
    public void lista(Player p){

        System.out.println(this);

    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Team{" + "Nombre=" + name + '}';
    }
    
    
}
