package exercise1;

import javax.swing.*;

public class TestDriver {
    public static void main(String[] args) {
        // Initialize test object
        Test testA = new Test();
        startTest(testA);
    } // End of Main Method
    // Method to start the test object
    private static void startTest(Test aTest){
        for (int i = 0; i < 5; i++) {
            // Repeat the methods below 5 times for each question
            aTest.simulateQuestion(i);
            aTest.checkAnswer(i,aTest.inputAnswer(i));
        } // End of For loop
        // Calculates the percentage of the correct answers
        double percentage = (aTest.getCorrectAnswers() / 5) *100;
        // The string use for the Message Dialog which showcases the player's score
        String result = String.format("RESULT%n%n   Correct Answers : %.2f%n " +
                "   Incorrect Answers : %.2f%n%n" +
                "Percentage : %.2f%%",aTest.getCorrectAnswers(),
                aTest.getIncorrectAnswers(), percentage);
        // The message dialog to show the result string.
        JOptionPane.showMessageDialog(null,result);
    } // End of startTest method
}
