/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.guilford;

/**
 *
 * @author axelsandoval
 */
public class Player {

    // attributes
    private int playerHP;
    private String weapon;

    // constructors
    public Player(int HP, String weapon) {
        this.playerHP = HP;
        this.weapon = weapon;
    }

    // methods
    public int getPlayerHP() {
        return playerHP;
    }

    public void setPlayerHP(int playerHP) {
        this.playerHP = playerHP;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

}
