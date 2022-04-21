package com.archanajl.pokerkata;

public class Mymain {
    public static void main(String[] args){
        WinnerPoker poker = new WinnerPoker();
        //poker.getInputPlayersArray("Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH\nBlack: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH");
        poker.sortInput("Black: 2H 3H 4H 5H 6H  White: 2C 3H 4S 8C AH");
    }

}
