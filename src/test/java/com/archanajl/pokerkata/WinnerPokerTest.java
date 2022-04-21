package com.archanajl.pokerkata;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class WinnerPokerTest {

    @Test
    public void checkdeclareWinner(){
        WinnerPoker poker = new WinnerPoker();
        String strWinner = poker.decalreWinner();
        Assertions.assertEquals(strWinner, "");
    }

    @Test
    public void checkgetInputPlayersArray(){
        WinnerPoker poker = new WinnerPoker();
        String[][] strExpected =  {{"2H 3D 5S 9C KD","2C 3H 4S 8C AH"}, {"2H 3D 5S 9C KD","2C 3H 4S 8C AH"}};
        String[][] strWinner = poker.getInputPlayersArray("Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH\nBlack: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH");
        Assertions.assertTrue(Arrays.deepEquals(strWinner,strExpected));
    }
}
