package com.archanajl.pokerkata;

public class GetWinnerPoker {

    private final String strCard = "23456789TJQKA";

    private final int INVALID_VALUE = 99;

    public String decalreWinner(){
        return "";
    }

    public void decalreWinner(String input){
        SetRulesPoker rules = new SetRulesPoker();
        String[][] inputArr = getInputPlayersArray(input);
        int numberofentry = inputArr.length;
        String strPlayer1 ;
        String strPlayer2;
        String winner;
        for (int i=0; i <= numberofentry - 1; i++ ){
            strPlayer1 = inputArr[i][0];
            strPlayer2 = inputArr[i][1];
            winner = rules.checkWinner(strPlayer1,strPlayer2);
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


}
