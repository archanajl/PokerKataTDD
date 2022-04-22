package com.archanajl.pokerkata;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        strResult = getWinnerNOfaKind(strPlayer1, strPlayer2,4);
        if (strResult != "") return strResult;

        // Check Four of a kind
        strResult = getWinnerFullHouse(strPlayer1, strPlayer2);
        if (strResult != "") return strResult;

        // Check Flush
        strResult = getWinnerFlush(strPlayer1, strPlayer2);
        if (strResult != "") return strResult;

        // Check Straight
        strResult = getWinnerStraight(strPlayer1, strPlayer2);
        if (strResult != "") return strResult;

        // Check Three of a kind
        strResult = getWinnerNOfaKind(strPlayer1, strPlayer2,3);
        if (strResult != "") return strResult;

        // Check High card
        strResult = getWinnerHighCard(strPlayer1, strPlayer2);
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

    public  String getWinnerNOfaKind(String strPlayer1, String strPlayer2, int n){
        int value1Four = INVALID_VALUE;
        int value2Four = INVALID_VALUE;
        String strWinnerType = "";
        if (n==4) strWinnerType = "Four of a Kind";
        if (n==3) strWinnerType = "Three of a Kind";
        HashMap<Integer, ArrayList<String>> player1ValueMap = getValueMap(strPlayer1);
        for (Integer num : player1ValueMap.keySet()){
            if (player1ValueMap.get(num).size() == n) value1Four = num;
        }
        HashMap<Integer, ArrayList<String>> player2ValueMap = getValueMap(strPlayer2);
        for (Integer num : player2ValueMap.keySet()){
            if (player2ValueMap.get(num).size() == n) value2Four = num;
        }
        if ((value1Four != INVALID_VALUE) && (value2Four != INVALID_VALUE)){
            if (value1Four > value2Four) return "Black wins. - "+ strWinnerType + ": " + strCard.charAt(value1Four);
            else if (value1Four < value2Four) return "White wins. - "+ strWinnerType + ": " + strCard.charAt(value2Four);
            else return "Tie.";
        }
        if(value1Four != INVALID_VALUE) return "Black wins. - "+ strWinnerType + ": " + strCard.charAt(value1Four) ;
        if(value2Four != INVALID_VALUE) return "White wins. - "+ strWinnerType + ": " + strCard.charAt(value2Four) ;
        return "";
    }

    public String getWinnerFlush(String strPlayer1, String strPlayer2){
        boolean isplayer1SetFive = false;
        boolean isplayer2SetFive = false;
        ArrayList<Integer> card1List = new ArrayList<>();
        ArrayList<Integer> card2List = new ArrayList<>();

        int card1 = INVALID_VALUE;
        int card2 = INVALID_VALUE;
        HashMap<String, ArrayList<Integer>> player1FaceMap = getFaceMap(strPlayer1);
        for (String card : player1FaceMap.keySet()){
            if (player1FaceMap.get(card).size() == 5) {
                isplayer1SetFive = true;
                card1List =player1FaceMap.get(card);
            }
        }
        HashMap<String, ArrayList<Integer>> player2FaceMap = getFaceMap(strPlayer2);
        for (String card : player2FaceMap.keySet()){
            if (player2FaceMap.get(card).size() == 5) {
                isplayer2SetFive = true;
                card2List =player2FaceMap.get(card);
            }
        }

        if (isplayer1SetFive && isplayer2SetFive) {
            return getHighCardWinnerString(card1List,card2List,"Flush");
        }
        if (isplayer1SetFive) return "Black wins. - Flush.";
        if (isplayer2SetFive) return "White wins. - Flush.";
        return "";
    }

    public String getWinnerStraight(String strPlayer1, String strPlayer2){

        boolean isPlayerOneStrFlush = false;
        boolean isPlayerTwoStrFlush = false;

        int[] player1cardValues = getCardValues(strPlayer1);
        Arrays.sort(player1cardValues);
        if ( ( player1cardValues[0] + 1 == player1cardValues[1])
                && ( player1cardValues[1] + 1 == player1cardValues[2])
                && ( player1cardValues[2] + 1 == player1cardValues[3])
                && ( player1cardValues[3] + 1 == player1cardValues[4])
        )  isPlayerOneStrFlush = true;

        int[] player2cardValues = getCardValues(strPlayer2);
        Arrays.sort(player2cardValues);
        if ( ( player2cardValues[0] + 1 == player2cardValues[1])
                && ( player2cardValues[1] + 1 == player2cardValues[2])
                && ( player2cardValues[2] + 1 == player2cardValues[3])
                && ( player2cardValues[3] + 1 == player2cardValues[4])
        )  isPlayerTwoStrFlush = true;

        if (isPlayerOneStrFlush && isPlayerTwoStrFlush) {
            ArrayList<Integer> player1List = IntStream.of(player1cardValues)
                    .boxed()
                    .collect(Collectors.toCollection(ArrayList::new));
            ArrayList<Integer> player2List = IntStream.of(player2cardValues)
                    .boxed()
                    .collect(Collectors.toCollection(ArrayList::new));
            return getHighCardWinnerString(player1List, player2List,"Straight");
        }
        if (isPlayerOneStrFlush) return "Black wins. - Straight.";
        if (isPlayerTwoStrFlush) return "White wins. - Straight.";
        return "";
    }

    public String getWinnerHighCard(String strPlayer1, String strPlayer2){

        ArrayList<Integer> card1List = new ArrayList<>();
        ArrayList<Integer> card2List = new ArrayList<>();
        int value;
        String[] str1Entries = strPlayer1.split(" ");

        for (String strEntry:str1Entries ) {
            value = strCard.indexOf(strEntry.charAt(0));
            card1List.add(value);
        }
        String[] str2Entries = strPlayer2.split(" ");
        for (String strEntry:str2Entries ) {
            value = strCard.indexOf(strEntry.charAt(0));
            card2List.add(value);
        }

        return getHighCardWinnerString(card1List,card2List,"High card");

    }

    public String getHighCardWinnerString(ArrayList<Integer> player1List, ArrayList<Integer> player2List, String winnerType){

        boolean foundMax = false;
        while(!foundMax ) {
            Optional<Integer> max1Number = player1List.stream()
                    .max((i, j) -> i.compareTo(j));
            Optional<Integer> max2Number = player2List.stream()
                    .max((i, j) -> i.compareTo(j));
            if (max1Number.get() > max2Number.get()){
                foundMax =true;
                return "Black wins. - " + winnerType + ".";
            }else if (max1Number.get() < max2Number.get()){
                foundMax =true;
                return "White wins. - " + winnerType + ".";
            }else{
                foundMax = false;
                player1List.remove(max1Number.get());
                player2List.remove(max2Number.get());
                if (player1List.size() == 0 && player2List.size() == 0) return "Tie.";
                if (player1List.size() == 0) return "Black wins. - " + winnerType + ".";
                if (player2List.size() == 0) return "White wins. - " + winnerType + ".";
            }
        }

        return "";
    }
    public HashMap<Integer,ArrayList<String>>  getValueMap(String strPlayer){

        HashMap<Integer, ArrayList<String>> valueMap = new HashMap<>();
        String[] strEntries = strPlayer.split(" ");
        for (String strEntry:strEntries ) {
            if (!valueMap.containsKey(strCard.indexOf(strEntry.charAt(0)))) {
                ArrayList<String> stringList = new ArrayList<>();
                stringList.add(Character.toString(strEntry.charAt(1)));
                valueMap.put(strCard.indexOf(strEntry.charAt(0)), stringList);
            } else {
                ArrayList<String> stringList = new ArrayList<>();
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

}
