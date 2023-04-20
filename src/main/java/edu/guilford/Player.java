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
    private int wolfHP;
    private String weapon;
    private String position;

    // player constructor
    public Player(int HP, int wolfHP, String weapon, String position) {
        this.playerHP = HP;
        this.wolfHP = wolfHP;
        this.weapon = weapon;
        this.position = position;
    }

    // random playerhp constructor
    public int randomHP() {
        int min = 1;
        int max = 100;
        int range = max - min + 1;
        int randomHP = (int) (Math.random() * range) + min;
        return randomHP;
    }

    // getters and setters
    public int getPlayerHP() {
        return playerHP;
    }

    public void setPlayerHP(int playerHP) {
        this.playerHP = playerHP;
    }

    public int getMonsterHP() {
        return wolfHP;
    }

    public void setMonsterHP(int wolfHP) {
        this.wolfHP = wolfHP;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // tostring method
    @Override
    public String toString() {
        return "Player{" + "playerHP=" + playerHP + ", wolfHP=" + wolfHP + ", weapon=" + weapon + ", position="
                + position + '}';
    }

    // helper methods
    public void attack() {
        System.out.println("You attack the monster with your " + weapon);
    }

    public void healthCheck() {
        System.out.println("Your current health is " + playerHP);
    }

}
