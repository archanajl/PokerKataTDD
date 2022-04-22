package com.archanajl.pokerkata;

import java.util.*;

public class WinnerPoker {

    private final String strCard = "23456789TJQKA";
    private final int INVALID_VALUE = 99;

    public String decalreWinner(){
        return "";
    }

    public void decalreWinner(String input){
        String[][] inputArr = getInputPlayersArray(input);
        int numberofentry = inputArr.length;
        String strPlayer1 ;
        String strPlayer2;
        String winner;
        System.out.println(numberofentry);
        for (int i=0; i <= numberofentry - 1; i++ ){
            strPlayer1 = inputArr[i][0];
            strPlayer2 = inputArr[i][1];
            winner = checkWinner(strPlayer1,strPlayer2);
            System.out.println("The result for Game " + (i + 1) + " : " + winner);
        }
    }

    public String[][] getInputPlayersArray(String input){
        String[] inputLine = input.split("\n");
        int numberofentry = inputLine.length;
        String[][] inputArr = new String[numberofentry][2];
        for (int i=0; i <= numberofentry - 1; i++ ){
            int playerIndex = inputLine[i].indexOf("White:");
            String strPlayer1 = inputLine[i].substring(0,playerIndex);
            String strPlayer2 = inputLine[i].substring(playerIndex);
            inputArr[i][0]= strPlayer1.trim().replace("Black: ","");
            inputArr[i][1]= strPlayer2.trim().replace("White: ","");
        }
        return inputArr;
    }

    public String checkWinner(String strPlayer1, String strPlayer2){

        String strResult = "";
        // Check Straight Flush
        strResult = getWinnerStraightFlush(strPlayer1, strPlayer2);
        if (strResult != "") return strResult;

        // Check Four of a kind
        strResult = getWinnerFourOfaKind(strPlayer1, strPlayer2);
        if (strResult != "") return strResult;

        // Check Four of a kind
        strResult = getWinnerFullHouse(strPlayer1, strPlayer2);
        if (strResult != "") return strResult;
        return strResult;
    }

    public String getWinnerStraightFlush(String strPlayer1, String strPlayer2){
        boolean isplayer1SetFive = false;
        boolean isplayer2SetFive = false;
        boolean isPlayerOneStrFlush = false;
        boolean isPlayerTwoStrFlush = false;
        int card1 = INVALID_VALUE;
        int card2 = INVALID_VALUE;
        HashMap<String, ArrayList<Integer>> player1FaceMap = getFaceMap(strPlayer1);
        for (String card : player1FaceMap.keySet()){
            if (player1FaceMap.get(card).size() == 5) isplayer1SetFive = true;
        }
        HashMap<String, ArrayList<Integer>> player2FaceMap = getFaceMap(strPlayer2);
        for (String card : player2FaceMap.keySet()){
            if (player2FaceMap.get(card).size() == 5) isplayer2SetFive = true;
        }
        if (isplayer1SetFive){
            int[] player1cardValues = getCardValues(strPlayer1);
            Arrays.sort(player1cardValues);
            card1 = player1cardValues[player1cardValues.length-1];
            if ( ( player1cardValues[0] + 1 == player1cardValues[1])
                    && ( player1cardValues[1] + 1 == player1cardValues[2])
                    && ( player1cardValues[2] + 1 == player1cardValues[3])
                    && ( player1cardValues[3] + 1 == player1cardValues[4])
            )  isPlayerOneStrFlush = true;
        }
        if (isplayer2SetFive){
            int[] player2cardValues = getCardValues(strPlayer2);
            Arrays.sort(player2cardValues);
            card2 = player2cardValues[player2cardValues.length-1];
            if ( ( player2cardValues[0] + 1 == player2cardValues[1])
                    && ( player2cardValues[1] + 1 == player2cardValues[2])
                    && ( player2cardValues[2] + 1 == player2cardValues[3])
                    && ( player2cardValues[3] + 1 == player2cardValues[4])
            )  isPlayerTwoStrFlush = true;
        }
        if (isPlayerOneStrFlush && isPlayerTwoStrFlush) {
            if (card1 > card2) return "Black wins. - Straight Flush." ;
            else if (card1 < card2) return "White wins. - Straight Flush.";
            else return "Tie.";
        }
        if (isPlayerOneStrFlush) return "Black wins. - Straight Flush.";
        if (isPlayerTwoStrFlush) return "White wins. - Straight Flush.";
        return "";
    }

    public String getWinnerFullHouse(String strPlayer1, String strPlayer2){
        int value1ThreeSet = INVALID_VALUE;
        int value2ThreeSet = INVALID_VALUE;
        int value1TwoSet = INVALID_VALUE;
        int value2TwoSet = INVALID_VALUE;
        boolean isPlayer1FullHouse = false;
        boolean isPlayer2FullHouse = false;
        String strBlackWins ="";
        String strWhiteWins = "";
        HashMap<Integer, ArrayList<String>> player1ValueMap = getValueMap(strPlayer1);
        for (Integer num : player1ValueMap.keySet()){
            if (player1ValueMap.get(num).size() == 3) value1ThreeSet = num;
            if (player1ValueMap.get(num).size() == 2) value1TwoSet = num;
        }

        HashMap<Integer, ArrayList<String>> player2ValueMap = getValueMap(strPlayer2);
        for (Integer num : player2ValueMap.keySet()){
            if (player2ValueMap.get(num).size() == 3) value2ThreeSet = num;
            if (player2ValueMap.get(num).size() == 2) value2TwoSet = num;
        }
        if (value1ThreeSet != INVALID_VALUE && value1TwoSet != INVALID_VALUE) {
            isPlayer1FullHouse = true;
            strBlackWins = "Black wins. - Full House: " + strCard.charAt(value1ThreeSet)
                    + " over " + strCard.charAt(value1TwoSet);
        }
        if (value2ThreeSet != INVALID_VALUE && value2TwoSet != INVALID_VALUE) {
            isPlayer2FullHouse = true;
            strWhiteWins = "White wins. - Full House: " + strCard.charAt(value2ThreeSet)
                    + " over " + strCard.charAt(value2TwoSet);
        }
        if (isPlayer1FullHouse && isPlayer2FullHouse){
            if (value1ThreeSet > value2ThreeSet)
                return strBlackWins;
            else if (value1ThreeSet < value2ThreeSet)
                return strWhiteWins;
            else return "Tie.";
        }
        if(isPlayer1FullHouse)
            return strBlackWins;
        if(isPlayer2FullHouse)
            return strWhiteWins ;
        return "";

    }

    public  String getWinnerFourOfaKind(String strPlayer1, String strPlayer2){
        int value1Four = INVALID_VALUE;
        int value2Four = INVALID_VALUE;
        HashMap<Integer, ArrayList<String>> player1ValueMap = getValueMap(strPlayer1);
        for (Integer num : player1ValueMap.keySet()){
            if (player1ValueMap.get(num).size() == 4) value1Four = num;
        }
        HashMap<Integer, ArrayList<String>> player2ValueMap = getValueMap(strPlayer2);
        for (Integer num : player2ValueMap.keySet()){
            if (player2ValueMap.get(num).size() == 4) value2Four = num;
        }
        if ((value1Four != INVALID_VALUE) && (value2Four != INVALID_VALUE)){
            if (value1Four > value2Four) return "Black wins. - Four of a Kind: " + strCard.charAt(value1Four);
            else if (value1Four < value2Four) return "White wins. - Four of a Kind: " + strCard.charAt(value2Four);
            else return "Tie.";
        }
        if(value1Four != INVALID_VALUE) return "White wins. - Four of a Kind: " + strCard.charAt(value1Four) ;
        if(value2Four != INVALID_VALUE) return "Black wins. - Four of a Kind: " + strCard.charAt(value2Four) ;
        return "";
    }

    public HashMap<Integer,ArrayList<String>>  getValueMap(String strPlayer){

        HashMap<Integer, ArrayList<String>> valueMap = new HashMap<>();
        String[] strEntries = strPlayer.split(" ");
        for (String strEntry:strEntries ) {
            if (!valueMap.containsKey(strCard.indexOf(strEntry.charAt(0)))) {
                ArrayList<String> stringList = new ArrayList<String>();
                stringList.add(Character.toString(strEntry.charAt(1)));
                valueMap.put(strCard.indexOf(strEntry.charAt(0)), stringList);
            } else {
                ArrayList<String> stringList = new ArrayList<String>();
                stringList = valueMap.get(strCard.indexOf(strEntry.charAt(0)));
                stringList.add(Character.toString(strEntry.charAt(1)));
                valueMap.put(strCard.indexOf(strEntry.charAt(0)),stringList);
            }
      }
        return valueMap;
    }

    public HashMap<String,ArrayList<Integer>>  getFaceMap(String strPlayer){
        HashMap<String, ArrayList<Integer>> faceMap = new HashMap<>();
        String[] strEntries = strPlayer.split(" ");
        int value;
        for (String strEntry:strEntries ) {
             value = strCard.indexOf(strEntry.charAt(0));//Integer.parseInt(String.valueOf(strEntry.charAt(0)));
            if (!faceMap.containsKey(Character.toString(strEntry.charAt(1)))) {
                ArrayList<Integer> integerList = new ArrayList<Integer>();
                integerList.add(value);
                faceMap.put(Character.toString(strEntry.charAt(1)), integerList);
            } else {
                ArrayList<Integer> integerList = new ArrayList<Integer>();
                integerList = faceMap.get(Character.toString(strEntry.charAt(1)));
                integerList.add(value);
                faceMap.put(Character.toString(strEntry.charAt(1)),integerList);
            }
        }
        return faceMap;
    }

    public int[] getCardValues(String strPlayer){

        String[] strEntry = strPlayer.split(" ");
        int[] cardValues = { strCard.indexOf(strEntry[0].charAt(0)), strCard.indexOf(strEntry[1].charAt(0)),
                strCard.indexOf(strEntry[2].charAt(0)),strCard.indexOf(strEntry[3].charAt(0)),
                strCard.indexOf(strEntry[4].charAt(0)) };
        return cardValues;
    }

    public char[] getFaceValues(String strPlayer){

        String[] strEntry = strPlayer.split(" ");
        char[] faceValues = { strEntry[0].charAt(1), strEntry[1].charAt(1),
                strEntry[2].charAt(1),strEntry[3].charAt(1),strEntry[4].charAt(1)};
        return faceValues;
    }

    public boolean isPlayerStraightFlush(int[] cardValues, char[] faceValues){
        String strCard = "23456789TJQK";
        if ((faceValues[0] == faceValues[1])
                && (faceValues[1] == faceValues[2])
                && (faceValues[2] == faceValues[3])
                && (faceValues[3] == faceValues[4])
                && (faceValues[4] == faceValues[0])
        ){
            Arrays.sort(cardValues);
            if ( ( cardValues[0] + 1 == cardValues[1])
                    && ( cardValues[1] + 1 == cardValues[2])
                    && ( cardValues[2] + 1 == cardValues[3])
                    && ( cardValues[3] + 1 == cardValues[4])
            ) {
                return true;
            }
        }
        return false;
    }
}
