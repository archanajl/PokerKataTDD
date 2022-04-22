package com.archanajl.pokerkata;

public class Mymain {
    public static void main(String[] args){
        WinnerPoker poker = new WinnerPoker();
        poker.decalreWinner("Black: 2H 3H 4H 5H 6H  White: 2C 3H 4S 8C AH\n" +
                "Black: 2H 3D 5S 9C KD  White: AC AH AD 4A 4D\n"+
                "Black: 5H 5C 5D TA 6H White: 5H 3H 4D 8H TD\n" +
                "Black: 7H 9S 5D 6C 9D White: 9H 8C 9C 3C 2H"
        );
    }

}
