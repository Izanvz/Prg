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

        public Team(String name) {
            this.name = name;
            this.players = new ArrayList<>();
        }

        public void add(Player p) {
            if (players.contains(p)) return;
            this.players.add(p);
            p.addTeam(this);
        }

        public void remove(Player p) {
            if (!players.contains(p)) return;
            this.players.remove(p);
            p.removeTeam(this);
        }

    public static void list(Team t){

        System.out.println(t);

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
