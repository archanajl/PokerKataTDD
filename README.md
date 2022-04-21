# _PokerKataTDD_

### <ins>Goal of the application</ins>

PokerKataTDD determines the winner of the poker game. It compares several pairs of poker hands and indicates which, 
if either, has a higher rank for each pair. Click [here](https://codingdojo.org/kata/PokerHands/) to have more details.

### <ins>Rules of the game</ins>

A poker deck contains 52 cards - each card has a suit which is one of clubs, diamonds, hearts, or spades (denoted C, D, H, and S in the input data). Each card also has a value which is one of 2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, king, ace (denoted 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A). For scoring purposes, the suits are unordered while the values are ordered as given above, with 2 being the lowest and ace the highest value.

A poker hand consists of 5 cards dealt from the deck. Poker hands are ranked by the following partial order from lowest to highest.

- High Card: Hands which do not fit any higher category are ranked by the value of their highest card. If the highest cards have the same value, the hands are ranked by the next highest, and so on.
- Pair: 2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the cards forming the pair. If these values are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.
- Two Pairs: The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their highest pair. Hands with the same highest pair are ranked by the value of their other pair. If these values are the same the hands are ranked by the value of the remaining card.
- Three of a Kind: Three of the cards in the hand have the same value. Hands which both contain three of a kind are ranked by the value of the 3 cards.
- Straight: Hand contains 5 cards with consecutive values. Hands which both contain a straight are ranked by their highest card.
- Flush: Hand contains 5 cards of the same suit. Hands which are both flushes are ranked using the rules for High Card.
- Full House: 3 cards of the same value, with the remaining 2 cards forming a pair. Ranked by the value of the 3 cards. 
- Four of a kind: 4 cards with the same value. Ranked by the value of the 4 cards.
- Straight flush: 5 cards of the same suit with consecutive values. Ranked by the highest card in the hand.

### <ins>Key Features of the application</ins>

The application expects the poker hands in the form of a string separated by lines to indicate each pair.

then it determines the winner and gives the result. It implements the above rules specified.

### <ins>Approach to the solution</ins>

- Step One:

As it is a TDD based application, I started off by writing a method to receive the input and split it into pairs.
This helped me to test whether I have able to get the required player values to declare the winner.

- Step Two:

Check for Straight Flush. The numbers should be consecutive and should belong to the same set. 
Test it by giving the string in different combinations.

- Step Three:

Check for Four of a kind. 4 cards with the same value. Ranked by the value of the 4 cards.
Test it by giving the string by both losers, each winner, both winners and also tie.

### <ins> Testcases </ins>

Please click [here](https://htmlpreview.github.io/?https://github.com/archanajl/BowlingKataTDD/blob/master/docs/Test%20Results%20-%20WinnerPokerTest.html) to see the test results.
### <ins>Technologies Used</ins>

    Java
    maven
    JUnit 5

### <ins>How to run the application and tests</ins>

To run the tests, use the following command:

    mvn test
    
