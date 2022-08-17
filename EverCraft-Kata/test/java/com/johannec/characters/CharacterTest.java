package com.johannec.characters;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;


@DisplayName("Characters test class")
public class CharacterTest {

    private static Character characterJohannes;
    private static final String characterJohannesName = "Johannes";


    @Before
    public void setUp() throws Exception {
        try {
            characterJohannes = new Character(characterJohannesName);

        } catch (Exception exception) {
            throw new Exception("Something went wrong with character creation in the test class. Error: ", exception.getCause());
        }
    }

    @Test
    public void givenCharacterWithNameJohannes_whenGettingCharacterName_shouldReturnJohannes() {
        assertEquals(characterJohannes.getName(), "Johannes");
    }

}