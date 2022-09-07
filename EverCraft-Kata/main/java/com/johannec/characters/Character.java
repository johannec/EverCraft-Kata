package com.johannec.characters;

public class Character {
    private String name;
    private Alignment alignment;
    private int armorClass = 10;
    private int hitPoints = 5;
    private boolean isAlive = true;

    public Character(String name) {
        this.name = name;
    }

    public void attack(int attackValue, Character enemy) {
        if(attackValue == 20) {
            enemy.takeDamage(2);
        } else if (attackValue >= enemy.getArmorClass()) {
            enemy.takeDamage(1);
        }

        if(enemy.getHitPoints() <= 0) {
            System.out.println("The character " + enemy.getName() + " is dead!");
            enemy.setAsDead();
        }
    }

    public void takeDamage(int damage) {
        this.setHitPoints(this.getHitPoints()-damage);
    }

    public void setAsDead() {
        this.setHitPoints(0);
        this.isAlive = false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }
}
