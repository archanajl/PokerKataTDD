package com.archanajl.pokerkata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;

public class GetWinnerPokerTest {

    @Test
    public void checkdeclareWinner(){
        GetWinnerPoker poker = new GetWinnerPoker();
        String strWinner = poker.decalreWinner();
        Assertions.assertEquals(strWinner, "");
    }

    @Test
    public void checkgetInputPlayersArray(){
        GetWinnerPoker poker = new GetWinnerPoker();
        String[][] strExpected =  {{"2H 3D 5S 9C KD","2C 3H 4S 8C AH"}, {"2H 3D 5S 9C KD","2C 3H 4S 8C AH"}};
        String[][] strWinner = poker.getInputPlayersArray("Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH\nBlack: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH");
        Assertions.assertTrue(Arrays.deepEquals(strWinner,strExpected));
    }

    @Test
    public void checkgetWinnerStraightFlushNoWinner(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerStraightFlush("2H 3D 5S 9C KD","2C 3H 4S 8C AH");
        Assertions.assertEquals("", strExpected);
    }

    @Test
    public void checkgetWinnerStraightFlushWinnerOne(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerStraightFlush("5H 3H 4H 2H 6H","AC AH AD AA 6D");
        Assertions.assertEquals("Black wins. - Straight Flush.", strExpected);
    }

    @Test
    public void checkgetWinnerStraightFlushWinnerTwo(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerStraightFlush("5H 5C 5D 5A 6H","5H 3H 4H 2H 6H");
        Assertions.assertEquals("White wins. - Straight Flush.", strExpected);
    }

    @Test
    public void checkgetWinnerStraightFlushBothPlayersWhiteHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerStraightFlush("5H 3H 4H 2H 6H","8C 7C 4C 5C 6C");
        Assertions.assertEquals("White wins. - Straight Flush.", strExpected);
    }

    @Test
    public void checkgetWinnerStraightFlushBothPlayersBlackHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerStraightFlush("KC QC AC JC TC" ,"5D 3D 4D 2D 6D");
        Assertions.assertEquals("Black wins. - Straight Flush.", strExpected);
    }

    @Test
    public void checkgetWinnerStraightFlushBothPlayersTie(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerStraightFlush("7H 8H 5H 6H 9H","5C 6C 7C 8C 9C");
        Assertions.assertEquals("Tie.", strExpected);
    }

    @Test
    public void checkgetWinnerFourOfaKindNoWinner(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerNOfaKind("5H 3H 4H 2H 6H","5H 3H 4H 2H 6H",4);
        Assertions.assertEquals("", strExpected);
    }

    @Test
    public void checkgetWinnerFourOfaKindWinnerOne(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerNOfaKind("5H 5C 5D 5A 6H","5H 3H 4D 2H 6D",4);
        Assertions.assertEquals("Black wins. - Four of a Kind: 5", strExpected);
    }

    @Test
    public void checkgetWinnerFourOfaKindWinnerTwo(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerNOfaKind("5H 3H 4D 2H 6D","AC AH AD AA 6D",4);
        Assertions.assertEquals("White wins. - Four of a Kind: A", strExpected);
    }

    @Test
    public void checkgetWinnerFourOfaKindBothPlayersWhiteHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerNOfaKind("5H 5C 5D 5A 6H","AC AH AD AA 6D",4);
        Assertions.assertEquals("White wins. - Four of a Kind: A", strExpected);
    }

    @Test
    public void checkgetWinnerFourOfaKindBothPlayersBlackHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerNOfaKind("7H 7C 7D 7A 4H","2C 2H 3D 2A 2D",4);
        Assertions.assertEquals("Black wins. - Four of a Kind: 7", strExpected);
    }

    @Test
    public void checkgetWinnerFullHouseNoWinner(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerFullHouse("5H 3H 4H 2H 6H","5H 3H 4H 2H 6H");
        Assertions.assertEquals("", strExpected);
    }

    @Test
    public void checkgetWinnerFullHouseWinnerOne(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerFullHouse("5H 5C 5D 6A 6H","5H 3H 4D 2H 6D");
        Assertions.assertEquals("Black wins. - Full House: 5 over 6", strExpected);
    }

    @Test
    public void checkgetWinnerFullHouseWinnerTwo(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerFullHouse("5H 3H 4D 2H 6D","AC AH AD 4A 4D");
        Assertions.assertEquals("White wins. - Full House: A over 4", strExpected);
    }

    @Test
    public void checkgetWinnerFullHouseBothPlayersWhiteHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerFullHouse("5H 5C 5D 6A 6H","AC AH AD 4A 4D");
        Assertions.assertEquals("White wins. - Full House: A over 4", strExpected);
    }

    @Test
    public void checkgetWinnerFullHouseBothPlayersBlackHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerFullHouse("AC AH AD 4A 4D","5H 5C 5D 6A 6H");
        Assertions.assertEquals("Black wins. - Full House: A over 4", strExpected);
    }

    @Test
    public void checkgetWinnerFlushNoWinner(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerFlush("2H 3D 5S 9C KD","2C 3H 4S 8C AH");
        Assertions.assertEquals("", strExpected);
    }

    @Test
    public void checkgetWinnerFlushWinnerOne(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerFlush("5H 3H 8H 2H KH","AC AH AD AA 6D");
        Assertions.assertEquals("Black wins. - Flush.", strExpected);
    }

    @Test
    public void checkgetWinnerFlushWinnerTwo(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerFlush("5H 5C 5D 5A 6H","QC 7C TC 5C 6C");
        Assertions.assertEquals("White wins. - Flush.", strExpected);
    }

    @Test
    public void checkgetWinnerFlushBothPlayersWhiteHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerFlush("5H 3H 4H 2H 6H","QC 7C TC 5C 6C");
        Assertions.assertEquals("White wins. - Flush.", strExpected);
    }

    @Test
    public void checkgetWinnerFlushBothPlayersBlackHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerFlush("KC QC AC JC TC" ,"5D 3D 4D 2D 6D");
        Assertions.assertEquals("Black wins. - Flush.", strExpected);
    }

    @Test
    public void checkgetWinnerFlushBothPlayersTie(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerFlush("7H 8H 5H 6H 9H","5C 6C 7C 8C 9C");
        Assertions.assertEquals("Tie.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerStringBlackWin(){
        SetRulesPoker rules = new SetRulesPoker();
        ArrayList<Integer> player1List  = new ArrayList<>(Arrays.asList(7, 8, 5, 6, 9));
        ArrayList<Integer> player2List  = new ArrayList<>(Arrays.asList(5,6,7,3,2));
        String strExpected = rules.getHighCardWinnerString(player1List, player2List,"Flush");
        Assertions.assertEquals("Black wins. - Flush.", strExpected);
    }
/////////////////
    @Test
    public void checkgetHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        ArrayList<Integer> player1List  = new ArrayList<>(Arrays.asList(5, 6, 3, 4, 7));
        ArrayList<Integer> player2List  = new ArrayList<>(Arrays.asList(3,4,5,1,0));
        String strExpected = rules.getHighCardWinnerString(player1List, player2List,"Flush");
        Assertions.assertEquals("Black wins. - Flush.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerStringWhiteWin() {
        SetRulesPoker rules = new SetRulesPoker();
        ArrayList<Integer> player1List = new ArrayList<>(Arrays.asList(7, 8, 5, 6, 9));
        ArrayList<Integer> player2List = new ArrayList<>(Arrays.asList(5, 6, 12, 3, 2));
        String strExpected = rules.getHighCardWinnerString(player1List, player2List, "Flush");
        Assertions.assertEquals("White wins. - Flush.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerStringBlackWinWithRepeat(){
        SetRulesPoker rules = new SetRulesPoker();
        ArrayList<Integer> player1List  = new ArrayList<>(Arrays.asList(7, 9, 5, 6, 9));
        ArrayList<Integer> player2List  = new ArrayList<>(Arrays.asList(7,6,7,3,2));
        String strExpected = rules.getHighCardWinnerString(player1List, player2List,"Flush");
        Assertions.assertEquals("Black wins. - Flush.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerStringBlackWinWithRepeatMax(){
        SetRulesPoker rules = new SetRulesPoker();
        ArrayList<Integer> player1List  = new ArrayList<>(Arrays.asList(7, 9, 5, 6, 9));
        ArrayList<Integer> player2List  = new ArrayList<>(Arrays.asList(9,6,9,3,2));
        String strExpected = rules.getHighCardWinnerString(player1List, player2List,"Flush");
        Assertions.assertEquals("Black wins. - Flush.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerStringWhiteWinWithRepeatMax(){
        SetRulesPoker rules = new SetRulesPoker();
        ArrayList<Integer> player1List  = new ArrayList<>(Arrays.asList(7, 9, 5, 6, 9));
        ArrayList<Integer> player2List  = new ArrayList<>(Arrays.asList(9,8,9,3,2));
        String strExpected = rules.getHighCardWinnerString(player1List, player2List,"Flush");
        Assertions.assertEquals("White wins. - Flush.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerStringWithTie(){
        SetRulesPoker rules = new SetRulesPoker();
        ArrayList<Integer> player1List  = new ArrayList<>(Arrays.asList(8, 9, 2, 3, 9));
        ArrayList<Integer> player2List  = new ArrayList<>(Arrays.asList(9,8,9,3,2));
        String strExpected = rules.getHighCardWinnerString(player1List, player2List,"Flush");
        Assertions.assertEquals("Tie.", strExpected);
    }

    @Test
    public void checkgetWinnerStraightNoWinner(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerStraight("2H 3D 5S 9C KD","2C 3H 4S 8C AH");
        Assertions.assertEquals("", strExpected);
    }

    @Test
    public void checkgetWinnerStraightWinnerOne(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerStraight("5H 3C 4H 2D 6H","AC AH AD AA 6D");
        Assertions.assertEquals("Black wins. - Straight.", strExpected);
    }

    @Test
    public void checkgetWinnerStraightWinnerTwo(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerStraight("5H 5C 5D 5A 6H","7H 5C 4H 3D 6H");
        Assertions.assertEquals("White wins. - Straight.", strExpected);
    }

    @Test
    public void checkgetWinnerStraightBothPlayersWhiteHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerStraight("5H 3C 4H 2D 6H","7H 5C 4H 3D 6H");
        Assertions.assertEquals("White wins. - Straight.", strExpected);
    }

    @Test
    public void checkgetWinnerStraightBothPlayersBlackHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerStraight("KC QC AD JC TC" ,"5S 3D 4H 2D 6D");
        Assertions.assertEquals("Black wins. - Straight.", strExpected);
    }

    @Test
    public void checkgetWinnerStraightBothPlayersTie(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerStraight("7D 8H 5S 6H 9H","5C 6S 7C 8D 9C");
        Assertions.assertEquals("Tie.", strExpected);
    }

    @Test
    public void checkgetWinnerThreeOfaKindNoWinner(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerNOfaKind("5H 3H 4H 2H 6H","5H 3H 4H 2H 6H",3);
        Assertions.assertEquals("", strExpected);
    }

    @Test
    public void checkgetWinnerThreeOfaKindWinnerOne(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerNOfaKind("5H 5C 5D TA 6H","5H 3H 4D 2H 6D",3);
        Assertions.assertEquals("Black wins. - Three of a Kind: 5", strExpected);
    }

    @Test
    public void checkgetWinnerThreeOfaKindWinnerTwo(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerNOfaKind("5H 3H 4D 2H 6D","AC AH AD 9S 6D",3);
        Assertions.assertEquals("White wins. - Three of a Kind: A", strExpected);
    }

    @Test
    public void checkgetWinnerThreeOfaKindBothPlayersWhiteHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerNOfaKind("5H 2C 5D 5A 6H","AC AH AD 9S 6D",3);
        Assertions.assertEquals("White wins. - Three of a Kind: A", strExpected);
    }

    @Test
    public void checkgetWinnerThreeOfaKindBothPlayersBlackHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerNOfaKind("7H 7C 8D 7S 4H","2C 2H 3D 8S 2D",3);
        Assertions.assertEquals("Black wins. - Three of a Kind: 7", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerBlackWin(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerHighCard("7H 8S 5D 6C 9S","5S 6C 7D 3C 2H");
        Assertions.assertEquals("Black wins. - High card.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerWhiteWin() {
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerHighCard("7H 8S 5D 6C 9S","5S 6C QD 3C 2H");
        Assertions.assertEquals("White wins. - High card.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerBlackWinWithRepeat(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerHighCard("7H 9S 5D 6C 9S","7S 6C 7D 3C 2H");
        Assertions.assertEquals("Black wins. - High card.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerBlackWinWithRepeatMax(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerHighCard("7H 9S 5D 6C 9S","9C 6C 9D 3C 2H");
        Assertions.assertEquals("Black wins. - High card.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerWhiteWinWithRepeatMax(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerHighCard("7H 9S 5D 6C 9D","9H 8C 9C 3C 2H");
        Assertions.assertEquals("White wins. - High card.", strExpected);
    }

    @Test
    public void checkgetHighCardWinnerWithTie(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getWinnerHighCard("8H 9S 2D 3C 9H","9C 8C 9D 3C 2H");
        Assertions.assertEquals("Tie.", strExpected);
    }


    @Test
    public void checkgetTwoPairNoWinner(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getPair("7H 9S 5D 6C AD","9H 8C KC 3C 2H");
        Assertions.assertEquals("", strExpected);
    }

    @Test
    public void checkgetTwoPairWinnerOne(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getPair("AH AC 6C TA 6H","5H 3H AD 8H TD");
        Assertions.assertEquals("Black wins. - Two Pairs.", strExpected);
    }

    @Test
    public void checkgetTwoPairWinnerTwo(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getPair("5H 3H AD 8H TD","5H 5C 6C TA 6H");
        Assertions.assertEquals("White wins. - Two Pairs.", strExpected);
    }

    @Test
    public void checkgetTwoPairBothPlayersWhiteHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getPair("5H 5C 6C TA 6H","AH AC 6C KA 6H");
        Assertions.assertEquals("White wins. - Two Pairs.", strExpected);
    }

    @Test
    public void checkgetTwoPairBothPlayersBlackHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getPair("AH AC 6C TA 6H","5H 5C 6C TA 6H");
        Assertions.assertEquals("Black wins. - Two Pairs.", strExpected);
    }

    @Test
    public void checkgetTwoPairBothPlayersBlackNotPairHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getPair("AH AC 9C 6A 6H","AS AD 8D 6D 6S");
        Assertions.assertEquals("Black wins. - Two Pairs.", strExpected);
    }

    @Test
    public void checkgetPairTwoBothPlayersWhiteNotPairHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getPair("AH AC 6C TA 6H","AS AD 6D KA 6S");
        Assertions.assertEquals("White wins. - Two Pairs.", strExpected);
    }

    @Test
    public void checkgetPairNoWinner(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getPair("7H 9S 5D 6C AD","9H 8C KC 3C 2H");
        Assertions.assertEquals("", strExpected);
    }

    @Test
    public void checkgetPairWinnerOne(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getPair("AH AC 5C TA 6H","5H 3H AD 8H TD");
        Assertions.assertEquals("Black wins. - Pair.", strExpected);
    }

    @Test
    public void checkgetPairWinnerTwo(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getPair("5H 3H AD 8H TD","5H 5C AC TA 6H");
        Assertions.assertEquals("White wins. - Pair.", strExpected);
    }

    @Test
    public void checkgetPairBothPlayersWhiteHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getPair("5H 5C 8C TA 6H","AH AC 5C TA 6H");
        Assertions.assertEquals("White wins. - Pair.", strExpected);
    }

    @Test
    public void checkgetPairBothPlayersBlackHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getPair("AH AC 6C TA 8H","5H 5C 6C TA 8H");
        Assertions.assertEquals("Black wins. - Pair.", strExpected);
    }

    @Test
    public void checkgetPairBothPlayersBlackNotPairHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getPair("AH AC 9C TA 7H","AS AD 8D 5A 6S");
        Assertions.assertEquals("Black wins. - Pair.", strExpected);
    }

    @Test
    public void checkgetPairBothPlayersWhiteNotPairHigh(){
        SetRulesPoker rules = new SetRulesPoker();
        String strExpected = rules.getPair("AH AC 6C TA 5H","AS AD 8D KA 6S");
        Assertions.assertEquals("White wins. - Pair.", strExpected);
    }
}



