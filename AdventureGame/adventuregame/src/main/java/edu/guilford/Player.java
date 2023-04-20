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
    private int monsterHP;
    private String position;
    private String weapon;

    // player constructor
    public Player(int HP, String weapon) {
        this.playerHP = HP;
        this.weapon = weapon;
    }

    // random hp constructor
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

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getMonsterHP() {
        return monsterHP;
    }

    public void setMonsterHP(int monsterHP) {
        this.monsterHP = monsterHP;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // toString method
    @Override
    public String toString() {
        return "Player{" + "playerHP=" + playerHP + ", monsterHP=" + monsterHP + ", position=" + position + ", weapon="
                + weapon + '}';
    }

    // helper methods
    public void attack() {
        System.out.println("You attack the monster with your " + weapon);
    }

    public void checkHealth() {
        System.out.println("Your health right now is " + playerHP);
    }
}
