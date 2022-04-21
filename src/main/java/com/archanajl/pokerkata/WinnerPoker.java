package com.archanajl.pokerkata;

public class WinnerPoker {

    public String decalreWinner(){
        return "";
    }

    public void sortInput(String input){
        String[][] inputArr = getInputPlayersArray(input);
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
