package com.archanajl.pokerkata;

import java.util.*;

public class WinnerPoker {

    private final String strCard = "23456789TJQKA";
    public String decalreWinner(){
        return "";
    }

    public void sortInput(String input){
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
            System.out.println(winner);
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
        int[] player1cardValues = getCardValues(strPlayer1);
        char[] player1faceValues = getFaceValues(strPlayer1);
        int[] player2cardValues = getCardValues(strPlayer2);
        char[] player2faceValues = getFaceValues(strPlayer2);
        // Check Straight Flush
        boolean isPlayerOneStrFlush = isPlayerStraightFlush(player1cardValues,player1faceValues );
        boolean isPlayerTwoStrFlush = isPlayerStraightFlush(player2cardValues,player2faceValues );
        if (isPlayerOneStrFlush && isPlayerTwoStrFlush) {
            Arrays.sort(player1cardValues);
            Arrays.sort(player2cardValues);
            int card1 = player1cardValues[0];
            int card2 = player2cardValues[0];
            if (card1 > card2) return "Black wins. - Straight Flush." ;
            else if (card1 < card2) return "White wins. - Straight Flush.";
            else return "Tie.";
        }
        // Check Four of a kind
        strResult = getWinnerFourOfaKind(strPlayer1, strPlayer2);
        if (strResult != "") return strResult;

        // Check Four of a kind
        strResult = getWinnerFullHouse(strPlayer1, strPlayer2);
        if (strResult != "") return strResult;
        return strResult;
    }

    public String getWinnerFullHouse(String strPlayer1, String strPlayer2){
        return "";
    }

    public  String getWinnerFourOfaKind(String strPlayer1, String strPlayer2){
        int value1Four = 99;
        int value2Four = 99;
        HashMap<Integer, ArrayList<String>> player1ValueMap = getValueMap(strPlayer1);
        for (Integer num : player1ValueMap.keySet()){
            if (player1ValueMap.get(num).size() == 4) value1Four = num;
        }
        HashMap<Integer, ArrayList<String>> player2ValueMap = getValueMap(strPlayer2);
        for (Integer num : player2ValueMap.keySet()){
            if (player2ValueMap.get(num).size() == 4) value2Four = num;
        }
        if ((value1Four != 99) && (value2Four != 99)){
            if (value1Four > value2Four) return "Black wins. - Four of a Kind: " + strCard.charAt(value1Four);
            else if (value1Four < value2Four) return "White wins. - Four of a Kind: " + strCard.charAt(value2Four);
            else return "Tie.";
        }
        if(value1Four != 99) return "White wins. - Four of a Kind: " + strCard.charAt(value1Four) ;
        if(value2Four != 99) return "Black wins. - Four of a Kind: " + strCard.charAt(value2Four) ;
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
        ArrayList<Integer> integerList = new ArrayList<Integer>();
        String[] strEntry = strPlayer.split(" ");
        List<String> uList = new ArrayList<String>();
        faceMap.put(Character.toString(strEntry[0].charAt(1)), integerList);
        faceMap.get(Character.toString(strEntry[0].charAt(1))).add(strCard.indexOf(strEntry[0].charAt(0)));
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
