package com.archanajl.pokerkata;

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

    @Test
    public void checkgetWinnerStraightFlushNoWinner(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerStraightFlush("2H 3D 5S 9C KD","2C 3H 4S 8C AH");
        Assertions.assertEquals("", strExpected);
    }

    @Test
    public void checkgetWinnerStraightFlushWinnerOne(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerStraightFlush("5H 3H 4H 2H 6H","AC AH AD AA 6D");
        Assertions.assertEquals("Black wins. - Straight Flush.", strExpected);
    }

    @Test
    public void checkgetWinnerStraightFlushWinnerTwo(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerStraightFlush("5H 5C 5D 5A 6H","5H 3H 4H 2H 6H");
        Assertions.assertEquals("White wins. - Straight Flush.", strExpected);
    }

    @Test
    public void checkgetWinnerStraightFlushBothPlayersWhiteHigh(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerStraightFlush("5H 3H 4H 2H 6H","8C 7C 4C 5C 6C");
        Assertions.assertEquals("White wins. - Straight Flush.", strExpected);
    }

    @Test
    public void checkgetWinnerStraightFlushBothPlayersBlackHigh(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerStraightFlush("KC QC AC JC TC" ,"5D 3D 4D 2D 6D");
        Assertions.assertEquals("Black wins. - Straight Flush.", strExpected);
    }

    @Test
    public void checkgetWinnerStraightFlushBothPlayersTie(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerStraightFlush("7H 8H 5H 6H 9H","5C 6C 7C 8C 9C");
        Assertions.assertEquals("Tie.", strExpected);
    }


    @Test
    public void checkgetWinnerFourOfaKindNoWinner(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFourOfaKind("5H 3H 4H 2H 6H","5H 3H 4H 2H 6H");
        Assertions.assertEquals("", strExpected);
    }

    @Test
    public void checkgetWinnerFourOfaKindWinnerOne(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFourOfaKind("5H 3H 4D 2H 6D","AC AH AD AA 6D");
        Assertions.assertEquals("Black wins. - Four of a Kind: A", strExpected);
    }

    @Test
    public void checkgetWinnerFourOfaKindWinnerTwo(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFourOfaKind("5H 5C 5D 5A 6H","5H 3H 4D 2H 6D");
        Assertions.assertEquals("White wins. - Four of a Kind: 5", strExpected);
    }

    @Test
    public void checkgetWinnerFourOfaKindBothPlayersWhiteHigh(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFourOfaKind("5H 5C 5D 5A 6H","AC AH AD AA 6D");
        Assertions.assertEquals("White wins. - Four of a Kind: A", strExpected);
    }

    @Test
    public void checkgetWinnerFourOfaKindBothPlayersBlackHigh(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFourOfaKind("7H 7C 7D 7A 4H","2C 2H 3D 2A 2D");
        Assertions.assertEquals("Black wins. - Four of a Kind: 7", strExpected);
    }

    @Test
    public void checkgetWinnerFourOfaKindBothPlayersTie(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFourOfaKind("5H 5C 5D 5A 6H","5H 5A 5D 5C AA");
        Assertions.assertEquals("Tie.", strExpected);
    }

    @Test
    public void checkgetWinnerFullHouseNoWinner(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFullHouse("5H 3H 4H 2H 6H","5H 3H 4H 2H 6H");
        Assertions.assertEquals("", strExpected);
    }

    @Test
    public void checkgetWinnerFullHouseWinnerOne(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFullHouse("5H 5C 5D 6A 6H","5H 3H 4D 2H 6D");
        Assertions.assertEquals("Black wins. - Full House: 5 over 6", strExpected);
    }

    @Test
    public void checkgetWinnerFullHouseWinnerTwo(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFullHouse("5H 3H 4D 2H 6D","AC AH AD 4A 4D");
        Assertions.assertEquals("White wins. - Full House: A over 4", strExpected);
    }

    @Test
    public void checkgetWinnerFullHouseBothPlayersWhiteHigh(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFullHouse("5H 5C 5D 6A 6H","AC AH AD 4A 4D");
        Assertions.assertEquals("White wins. - Full House: A over 4", strExpected);
    }

    @Test
    public void checkgetWinnerFullHouseBothPlayersBlackHigh(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFullHouse("AC AH AD 4A 4D","5H 5C 5D 6A 6H");
        Assertions.assertEquals("Black wins. - Full House: A over 4", strExpected);
    }

    @Test
    public void checkgetWinnerFlushNoWinner(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFlush("2H 3D 5S 9C KD","2C 3H 4S 8C AH");
        Assertions.assertEquals("", strExpected);
    }

    @Test
    public void checkgetWinnerFlushWinnerOne(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFlush("5H 3H 8H 2H KH","AC AH AD AA 6D");
        Assertions.assertEquals("Black wins. - Flush.", strExpected);
    }

    @Test
    public void checkgetWinnerFlushWinnerTwo(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFlush("5H 5C 5D 5A 6H","QC 7C TC 5C 6C");
        Assertions.assertEquals("White wins. - Flush.", strExpected);
    }

    @Test
    public void checkgetWinnerFlushBothPlayersWhiteHigh(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFlush("5H 3H 4H 2H 6H","QC 7C TC 5C 6C");
        Assertions.assertEquals("White wins. - Straight Flush.", strExpected);
    }

    @Test
    public void checkgetWinnerFlushBothPlayersBlackHigh(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFlush("KC QC AC JC TC" ,"5D 3D 4D 2D 6D");
        Assertions.assertEquals("Black wins. - Straight Flush.", strExpected);
    }

    @Test
    public void checkgetWinnerFlushBothPlayersTie(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFlush("7H 8H 5H 6H 9H","5C 6C 7C 8C 9C");
        Assertions.assertEquals("Tie.", strExpected);
    }
}

