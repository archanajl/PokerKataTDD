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

    @Test
    public void checkisPlayerStraightFlushValid(){
        WinnerPoker poker = new WinnerPoker();
        int[] cardValues = poker.getCardValues("2H 3H 4H 5H 6H");
        char[] faceValues = poker.getFaceValues("2H 3H 4H 5H 6H");
        Assertions.assertTrue(poker.isPlayerStraightFlush(cardValues,faceValues));
    }

    @Test
    public void checkisPlayerStraightFlushInOrderButDifferentSet(){
        WinnerPoker poker = new WinnerPoker();
        int[] cardValues = poker.getCardValues("2H 3H 4C 5H 6H");
        char[] faceValues = poker.getFaceValues("2H 3H 4C 5H 6H");
        Assertions.assertFalse(poker.isPlayerStraightFlush(cardValues,faceValues));
    }

    @Test
    public void checkisPlayerStraightFlushNotInOrderButsameSet(){
        WinnerPoker poker = new WinnerPoker();
        int[] cardValues = poker.getCardValues("2H TH 4H 5H 6H");
        char[] faceValues = poker.getFaceValues("2H TH 4H 5H 6H");
        Assertions.assertFalse(poker.isPlayerStraightFlush(cardValues,faceValues));

    }

    @Test
    public void checkisPlayerStraightFlushNotInOrderAndDifferentSet(){
        WinnerPoker poker = new WinnerPoker();
        int[] cardValues = poker.getCardValues("2H TH 4H 5C AA");
        char[] faceValues = poker.getFaceValues("2H TH 4H 5C AA");
        Assertions.assertFalse(poker.isPlayerStraightFlush(cardValues,faceValues));

    }

    @Test
    public void checkisPlayerStraightFlushInOrderButnotintheString(){
        WinnerPoker poker = new WinnerPoker();
        int[] cardValues = poker.getCardValues("5H 3H 4H 2H 6H");
        char[] faceValues = poker.getFaceValues("5H 3H 4H 2H 6H");
        Assertions.assertTrue(poker.isPlayerStraightFlush(cardValues,faceValues));

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
        Assertions.assertEquals("White wins. - Full House : A over 4", strExpected);
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


}

