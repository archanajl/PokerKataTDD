package com.archanajl.pokerkata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
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
        String strExpected = poker.getWinnerNOfaKind("5H 3H 4H 2H 6H","5H 3H 4H 2H 6H",4);
        Assertions.assertEquals("", strExpected);
    }

    @Test
    public void checkgetWinnerFourOfaKindWinnerOne(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerNOfaKind("5H 5C 5D 5A 6H","5H 3H 4D 2H 6D",4);
        Assertions.assertEquals("Black wins. - Four of a Kind: 5", strExpected);
    }

    @Test
    public void checkgetWinnerFourOfaKindWinnerTwo(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerNOfaKind("5H 3H 4D 2H 6D","AC AH AD AA 6D",4);
        Assertions.assertEquals("White wins. - Four of a Kind: A", strExpected);
    }

    @Test
    public void checkgetWinnerFourOfaKindBothPlayersWhiteHigh(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerNOfaKind("5H 5C 5D 5A 6H","AC AH AD AA 6D",4);
        Assertions.assertEquals("White wins. - Four of a Kind: A", strExpected);
    }

    @Test
    public void checkgetWinnerFourOfaKindBothPlayersBlackHigh(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerNOfaKind("7H 7C 7D 7A 4H","2C 2H 3D 2A 2D",4);
        Assertions.assertEquals("Black wins. - Four of a Kind: 7", strExpected);
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
        Assertions.assertEquals("White wins. - Flush.", strExpected);
    }

    @Test
    public void checkgetWinnerFlushBothPlayersBlackHigh(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFlush("KC QC AC JC TC" ,"5D 3D 4D 2D 6D");
        Assertions.assertEquals("Black wins. - Flush.", strExpected);
    }

    @Test
    public void checkgetWinnerFlushBothPlayersTie(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerFlush("7H 8H 5H 6H 9H","5C 6C 7C 8C 9C");
        Assertions.assertEquals("Tie.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerStringBlackWin(){
        WinnerPoker poker = new WinnerPoker();
        ArrayList<Integer> player1List  = new ArrayList<>(Arrays.asList(7, 8, 5, 6, 9));
        ArrayList<Integer> player2List  = new ArrayList<>(Arrays.asList(5,6,7,3,2));
        String strExpected = poker.getHighCardWinnerString(player1List, player2List,"Flush");
        Assertions.assertEquals("Black wins. - Flush.", strExpected);
    }
/////////////////
    @Test
    public void checkgetHigh(){
        WinnerPoker poker = new WinnerPoker();
        ArrayList<Integer> player1List  = new ArrayList<>(Arrays.asList(5, 6, 3, 4, 7));
        ArrayList<Integer> player2List  = new ArrayList<>(Arrays.asList(3,4,5,1,0));
        String strExpected = poker.getHighCardWinnerString(player1List, player2List,"Flush");
        Assertions.assertEquals("Black wins. - Flush.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerStringWhiteWin() {
        WinnerPoker poker = new WinnerPoker();
        ArrayList<Integer> player1List = new ArrayList<>(Arrays.asList(7, 8, 5, 6, 9));
        ArrayList<Integer> player2List = new ArrayList<>(Arrays.asList(5, 6, 12, 3, 2));
        String strExpected = poker.getHighCardWinnerString(player1List, player2List, "Flush");
        Assertions.assertEquals("White wins. - Flush.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerStringBlackWinWithRepeat(){
        WinnerPoker poker = new WinnerPoker();
        ArrayList<Integer> player1List  = new ArrayList<>(Arrays.asList(7, 9, 5, 6, 9));
        ArrayList<Integer> player2List  = new ArrayList<>(Arrays.asList(7,6,7,3,2));
        String strExpected = poker.getHighCardWinnerString(player1List, player2List,"Flush");
        Assertions.assertEquals("Black wins. - Flush.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerStringBlackWinWithRepeatMax(){
        WinnerPoker poker = new WinnerPoker();
        ArrayList<Integer> player1List  = new ArrayList<>(Arrays.asList(7, 9, 5, 6, 9));
        ArrayList<Integer> player2List  = new ArrayList<>(Arrays.asList(9,6,9,3,2));
        String strExpected = poker.getHighCardWinnerString(player1List, player2List,"Flush");
        Assertions.assertEquals("Black wins. - Flush.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerStringWhiteWinWithRepeatMax(){
        WinnerPoker poker = new WinnerPoker();
        ArrayList<Integer> player1List  = new ArrayList<>(Arrays.asList(7, 9, 5, 6, 9));
        ArrayList<Integer> player2List  = new ArrayList<>(Arrays.asList(9,8,9,3,2));
        String strExpected = poker.getHighCardWinnerString(player1List, player2List,"Flush");
        Assertions.assertEquals("White wins. - Flush.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerStringWithTie(){
        WinnerPoker poker = new WinnerPoker();
        ArrayList<Integer> player1List  = new ArrayList<>(Arrays.asList(8, 9, 2, 3, 9));
        ArrayList<Integer> player2List  = new ArrayList<>(Arrays.asList(9,8,9,3,2));
        String strExpected = poker.getHighCardWinnerString(player1List, player2List,"Flush");
        Assertions.assertEquals("Tie.", strExpected);
    }

    @Test
    public void checkgetWinnerStraightNoWinner(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerStraight("2H 3D 5S 9C KD","2C 3H 4S 8C AH");
        Assertions.assertEquals("", strExpected);
    }

    @Test
    public void checkgetWinnerStraightWinnerOne(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerStraight("5H 3C 4H 2D 6H","AC AH AD AA 6D");
        Assertions.assertEquals("Black wins. - Straight.", strExpected);
    }

    @Test
    public void checkgetWinnerStraightWinnerTwo(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerStraight("5H 5C 5D 5A 6H","7H 5C 4H 3D 6H");
        Assertions.assertEquals("White wins. - Straight.", strExpected);
    }

    @Test
    public void checkgetWinnerStraightBothPlayersWhiteHigh(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerStraight("5H 3C 4H 2D 6H","7H 5C 4H 3D 6H");
        Assertions.assertEquals("White wins. - Straight.", strExpected);
    }

    @Test
    public void checkgetWinnerStraightBothPlayersBlackHigh(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerStraight("KC QC AD JC TC" ,"5S 3D 4H 2D 6D");
        Assertions.assertEquals("Black wins. - Straight.", strExpected);
    }

    @Test
    public void checkgetWinnerStraightBothPlayersTie(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerStraight("7D 8H 5S 6H 9H","5C 6S 7C 8D 9C");
        Assertions.assertEquals("Tie.", strExpected);
    }

    @Test
    public void checkgetWinnerThreeOfaKindNoWinner(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerNOfaKind("5H 3H 4H 2H 6H","5H 3H 4H 2H 6H",3);
        Assertions.assertEquals("", strExpected);
    }

    @Test
    public void checkgetWinnerThreeOfaKindWinnerOne(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerNOfaKind("5H 5C 5D TA 6H","5H 3H 4D 2H 6D",3);
        Assertions.assertEquals("Black wins. - Three of a Kind: 5", strExpected);
    }

    @Test
    public void checkgetWinnerThreeOfaKindWinnerTwo(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerNOfaKind("5H 3H 4D 2H 6D","AC AH AD 9S 6D",3);
        Assertions.assertEquals("White wins. - Three of a Kind: A", strExpected);
    }

    @Test
    public void checkgetWinnerThreeOfaKindBothPlayersWhiteHigh(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerNOfaKind("5H 2C 5D 5A 6H","AC AH AD 9S 6D",3);
        Assertions.assertEquals("White wins. - Three of a Kind: A", strExpected);
    }

    @Test
    public void checkgetWinnerThreeOfaKindBothPlayersBlackHigh(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerNOfaKind("7H 7C 8D 7S 4H","2C 2H 3D 8S 2D",3);
        Assertions.assertEquals("Black wins. - Three of a Kind: 7", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerBlackWin(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerHighCard("7H 8S 5D 6C 9S","5S 6C 7D 3C 2H");
        Assertions.assertEquals("Black wins. - High card.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerWhiteWin() {
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerHighCard("7H 8S 5D 6C 9S","5S 6C QD 3C 2H");
        Assertions.assertEquals("White wins. - High card.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerBlackWinWithRepeat(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerHighCard("7H 9S 5D 6C 9S","7S 6C 7D 3C 2H");
        Assertions.assertEquals("Black wins. - High card.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerBlackWinWithRepeatMax(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerHighCard("7H 9S 5D 6C 9S","9C 6C 9D 3C 2H");
        Assertions.assertEquals("Black wins. - High card.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerWhiteWinWithRepeatMax(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerHighCard("7H 9S 5D 6C 9D","9H 8C 9C 3C 2H");
        Assertions.assertEquals("White wins. - High card.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerWithTie(){
        WinnerPoker poker = new WinnerPoker();
        String strExpected = poker.getWinnerHighCard("8H 9S 2D 3C 9H","9C 8C 9D 3C 2H");
        Assertions.assertEquals("Tie.", strExpected);
    }


}



