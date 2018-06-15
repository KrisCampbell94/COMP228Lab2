package exercise2;

import javax.swing.*;

public class LottoDriver {
    public static void main(String[] args) {
        // The player's input to the computer
        String input = "";
        // The sum from the input
        int guess = 0;
        // A for loop to continually ask the player until the answer is acceptable
        for (int i = 0; i < 1; i++) {
            input = JOptionPane.showInputDialog("Pick a number between 3 and 27");
            try{
                // Try to make sum read input
                guess = Integer.parseInt(input);
            }
            catch(NumberFormatException e){
                // Prompt a message box that reads Incorrect Response
                JOptionPane.showMessageDialog(null,"Incorrect Response");
                i--;
                continue; // Use to skip the rest of the code and go back to the beginning (sum is already 0)
            }
            // The same message box but if the sum is lower or higher.
            if(guess < 3 || guess > 27){
                JOptionPane.showMessageDialog(null,"Incorrect Value");
                i--;
            }
        }// End For Loop

        // Make a lotto initializer 5 times
        Lotto[] lottos = new Lotto[5];
        // A string to showcase the entire result of the 5 lottos
        String result = "Results: \nLOTTO #       SUM\n";
        // A integer array to carry the sums found in each lotto
        int[] sums = new int[5];
        // Make a player status enum
        playerStatus status = playerStatus.LOSE;

        for (int i = 0; i < lottos.length; i++) {
            // Start the constructor to activate the random number generator
            lottos[i] = new Lotto();
            // Set the num array to the current lotto values
            int[] num = lottos[i].getLottoValues();
            // Set the current sum array to the newly created values from the lotto
            sums[i] = num[0]+num[1]+num[2];
            // Put it altogether into the string result
            result += String.format("   %d  %d  %d           %d %n"
                    ,num[0],num[1],num[2],sums[i]);
        } // End of For Loop
        result += String.format("%nYour guess was : %d",guess);
        // Check to see if a sum matches with the player's guess
        for (var sum: sums) {
            if(sum == guess){
                status = playerStatus.WIN;
                break; // If the player wins, don't check the rest and break out the foreach loop
            }
        }// End of For Each Loop
        switch(status) {
            case LOSE:
                result += "\n      THE COMPUTER WINS!";
                // If the player lost, then print out the above message
                break;
            case WIN:
                result += "\n           YOU WIN!";
                // If the player wins, then print out the above congratulatory message
                break;
            default:
                result += "\n           ERROR!";
                // If something else happens, then print out an error message
                break;
        } // End of switch statement
        // Show the final result in a message dialog
        JOptionPane.showMessageDialog(null,result);
    }// End of Main function

    private enum playerStatus{
        WIN,LOSE
    }
}
