package com.archanajl.pokerkata;

import java.util.Arrays;

public class WinnerPoker {


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
        boolean isPlayerOneWinner = false;
        boolean isPlayerTwoWinner = false;
        isPlayerOneWinner = isPlayerStraightFlush(strPlayer1);
        isPlayerTwoWinner = isPlayerStraightFlush(strPlayer2);
        if (isPlayerOneWinner && isPlayerTwoWinner) return "Tie.";
        if (isPlayerOneWinner ) return "Black wins.";
        if (isPlayerTwoWinner) return "White wins.";
        return strResult;
    }

    public boolean isPlayerStraightFlush(String strPlayer){
        String strCard = "23456789TJQK";
        String[] strEntry = strPlayer.split(" ");
        int[] cardValue = { strCard.indexOf(strEntry[0].charAt(0)), strCard.indexOf(strEntry[1].charAt(0)),
                strCard.indexOf(strEntry[2].charAt(0)),strCard.indexOf(strEntry[3].charAt(0)),
                strCard.indexOf(strEntry[4].charAt(0)) };

        if ((strEntry[0].charAt(1) == strEntry[1].charAt(1))
                && (strEntry[1].charAt(1) == strEntry[2].charAt(1))
                && (strEntry[2].charAt(1) == strEntry[3].charAt(1))
                && (strEntry[3].charAt(1) == strEntry[4].charAt(1))
                && (strEntry[4].charAt(1) == strEntry[0].charAt(1))
        ){
            Arrays.sort(cardValue);
            if ( ( cardValue[0] + 1 == cardValue[1])
                    && ( cardValue[1] + 1 == cardValue[2])
                    && ( cardValue[2] + 1 == cardValue[3])
                    && ( cardValue[3] + 1 == cardValue[4])
            ) {
                return true;
            }
        }
        return false;
    }
}
