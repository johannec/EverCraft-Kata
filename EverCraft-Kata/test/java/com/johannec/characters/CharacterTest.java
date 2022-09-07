package com.johannec.characters;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;


@DisplayName("Characters test class")
public class CharacterTest {

    private static Character characterJohannes;
    private static Character enemy;
    private static final String characterJohannesName = "Johannes";


    @Before
    public void setUp() throws Exception {
        try {
            characterJohannes = new Character(characterJohannesName);
            enemy = new Character("Enemy");

        } catch (Exception exception) {
            throw new Exception("Something went wrong with character creation in the test class. Error: ", exception.getCause());
        }
    }

    @Test
    public void givenCharacterWithNameJohannes_whenGettingCharacterName_shouldReturnJohannes() {
        assertEquals("Johannes", characterJohannes.getName());
    }

    @Test
    public void givenCharacterWithNeutralAlignment_whenGettingAlignment_shouldReturnNeutral() {
        characterJohannes.setAlignment(Alignment.NEUTRAL);
        assertEquals(Alignment.NEUTRAL, characterJohannes.getAlignment());
    }
    @Test
    public void givenCharacterWithDefaultArmorClass_whenGettingArmorClass_shouldReturn10() {
        assertEquals(10, characterJohannes.getArmorClass());
    }

    @Test
    public void givenCharacterWithDefaultHitPoints_whenGettingHitPoints_shouldReturn5() {
        assertEquals(5, characterJohannes.getHitPoints());
    }

    @Test
    public void givenCharacterWithAttackRoll11_whenHittingEnemyWithLowerArmorClass_shouldLowerEnemyHitPoints() {
        assertEquals(5, enemy.getHitPoints());
        int attackRoll = 11;
        characterJohannes.attack(attackRoll, enemy);
        assertEquals(4, enemy.getHitPoints());
    }

    @Test
    public void givenAttackRoll9_whenHittingEnemyWithHigherArmorClass_shouldNotLowerEnemyHitPoints() {
        assertEquals(5, enemy.getHitPoints());
        int attackRoll = 9;
        characterJohannes.attack(attackRoll, enemy);
        assertEquals(5, enemy.getHitPoints());
    }
    @Test
    public void givenAttackValue10_whenHittingEnemyWithEqualArmorClass_shouldLowerEnemyHitPoints() {
        assertEquals(5, enemy.getHitPoints());
        int attackRoll = 10;
        characterJohannes.attack(attackRoll, enemy);
        assertEquals(4, enemy.getHitPoints());
    }
    
    @Test
    public void givenAttackRoll20_whenHittingEnemyWithHigherArmorClass_shouldIgnoreEnemyArmorClassAndReturn3HitPoints() {
        assertEquals(5, enemy.getHitPoints());
        int attackRoll = 20;
        enemy.setArmorClass(999);
        characterJohannes.attack(attackRoll, enemy);
        assertEquals(3, enemy.getHitPoints());
    }

    @Test
    public void givenEnoughAttacksToKillTheEnemy_whenEnemyIsDead_shouldReturnFalseAliveStatus() {
        int attackRoll = 20;
        assertTrue(enemy.getIsAlive());

        characterJohannes.attack(attackRoll, enemy);
        characterJohannes.attack(attackRoll, enemy);
        characterJohannes.attack(attackRoll, enemy);
        assertEquals(false, enemy.getIsAlive());
    }







}