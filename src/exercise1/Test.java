package exercise1;

import javax.swing.*;
import java.security.SecureRandom;

public class Test {
    // String Array to contain the questions
    private String questions[] = {
            "Question 1: Which company currently owns Java?",
            "Question 2: Which print function is used for formatting?",
            "Question 3: Why do we declare privates in Java?",
            "Question 4: What keys are used at the end of a Constructor?",
            "Question 5: A static is a method of field without _________ on an object."};
    // Object Array to store the questions in different sections each time.
    private Object[] questionOptions = new Object[4];
    // The default options of each question.
    private String[] options1 = {"Microsoft","Google","Oracle","Sun"};
    private String[] options2 = {"printf()", "print()","println()","None of the Options"};
    private String[] options3 = {"MANAGEMENT", "None of the Options","Not use PROTECTED","RULES"};
    private String[] options4 = {"{}", "[]","()","<>"};
    private String[] options5 = {"CONTROL", "OPTIONS","USAGE","DEPENDENCE"};
    // An int array to contain the answer options
    private int answers[] = new int[4];
    // The correct answer to be initialize for each question.
    private int correctAnswer;
    // A random number object
    private SecureRandom randomNumber;
    // An enumerable for simple correct or incorrect response
    private enum questionResult {CORRECT, INCORRECT}
    // To set the player's result as either correct or incorrect
    private questionResult result;
    // Tallies up the correct or incorrect answers
    private double correctAnswers;
    private double incorrectAnswers;
    // Gets the correctAnswers or incorrectAnswers for Driver usage
    public double getCorrectAnswers() {
        return correctAnswers;
    }
    public double getIncorrectAnswers() {
        return incorrectAnswers;
    }


    // Method to simulate the questions
    public void simulateQuestion(int questionNo){
        randomNumber = new SecureRandom();
        System.out.println("Activating Simulate Question");
        // Displays a message dialog of the called question
        JOptionPane.showMessageDialog(null,questions[questionNo]);
        // A for loop to setup the options for inputAnswer method
            // and the answer for checkAnswer method
        for (int i = 0; i < 4; i++) {
            // Sets a random number between 0 and 3
            int question = randomNumber.nextInt(4);
            // Activates the switch statement for i
            switch(i){
                case 0:
                    answers[i] = question;
                    questionSetup(questionNo,questionOptions,i,question,
                            options1,options2,options3,options4,options5);
                    break;
                case 1:
                    // Checks to see if the current number matches with the previous number
                    if(question == answers[0])
                        i--;
                    else {
                        answers[i] = question;
                        questionSetup(questionNo,questionOptions,i,question,
                                options1,options2,options3,options4,options5);
                    }
                    break;
                case 2:
                    // Checks to see if the current number matches with the previous numbers
                    if(question == answers[0] ||
                            question == answers[1])
                        i--;
                    else {
                        answers[i] = question;
                        questionSetup(questionNo,questionOptions,i,question,
                                options1,options2,options3,options4,options5);
                    }
                    break;
                case 3:
                    if(question == answers[0] ||
                            question == answers[1] ||
                            question == answers[2])
                        i--;
                    else {
                        answers[i] = question;
                        questionSetup(questionNo,questionOptions,i,question,
                                options1,options2,options3,options4,options5);
                    }
                    break;
            }// End switch statement
        } // End for loop
    }
    // Method to check the answer
    public void checkAnswer(int questionNo, int input){
        System.out.println("Activating Check Answer");
        // Checks each question to match with the question number
        // Checks to see if the user's input matches with the correctAnswer
        // Sets the result based on input
        if(questionNo == 0){
            if(input == correctAnswer)
                result = questionResult.CORRECT;
            else
                result = questionResult.INCORRECT;
        }
        else if(questionNo == 1){
            if(input == correctAnswer)
                result = questionResult.CORRECT;
            else
                result = questionResult.INCORRECT;
        }
        else if(questionNo == 2){
            if(input == correctAnswer)
                result = questionResult.CORRECT;
            else
                result = questionResult.INCORRECT;
        }
        else if(questionNo == 3){
            if(input == correctAnswer)
                result = questionResult.CORRECT;
            else
                result = questionResult.INCORRECT;
        }
        else if(questionNo == 4){
            if(input == correctAnswer)
                result = questionResult.CORRECT;
            else
                result = questionResult.INCORRECT;
        }
        // Generates the message by calling the generateMessage method
        JOptionPane.showMessageDialog(null,generateMessage(result));
    }
    // Method to display a random message
    private String generateMessage(questionResult finalResult){
        System.out.println("Activating Generating Message");
        // Use to generate a random message
        SecureRandom randomMessage = new SecureRandom();
        // If the user got the answer right, print 1 out of the 4 choices through random generating
        if(finalResult == questionResult.CORRECT){
            correctAnswers++;
            switch(randomMessage.nextInt(4)){
                case 0:
                    return("Excellent!");
                case 1:
                    return("Good!");
                case 2:
                    return("Keep up the good work!");
                case 3:
                    return("Nice work!");
            }
        } // End of If statement
        // If the user got the answer wrong, print 1 out of the 4 choices through random generating
        else{
            incorrectAnswers++;
            switch(randomMessage.nextInt(4)){
                case 0:
                    return("No. Please try again.");
                case 1:
                    return("Wrong. Try once more.");
                case 2:
                    return("Don't give up!");
                case 3:
                    return("Keep trying!");
            }
        } // End of Else statement
        return("ERROR"); // If all else fails, return error string
    }
    // Method to interact with the user
    public int inputAnswer(int questionNo){
        System.out.println("Activating Input Answer");
        // Sets up the different options from the simulateQuestion
        int answer = JOptionPane.showOptionDialog(null,
                questions[questionNo],null,
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, questionOptions,questionOptions[0]);
        System.out.println(answer);
        return answer; // Returns the answer
    }
    // Method to setup each question, option, and answer
    private void questionSetup(int number, Object[] options, int i, int quest,
                               String[] a, String[] b, String[] c,
                               String[] d, String[] e){
        // The randomized setup for each option to be put in a different position
        if(number == 0) options[i] = a[quest];
        else if(number == 1) options[i] = b[quest];
        else if(number == 2) options[i] = c[quest];
        else if(number == 3) options[i] = d[quest];
        else if(number == 4) options[i] = e[quest];

        // The setup to make sure that the correct answer matches
        if(number == 0){ if(quest == 2) correctAnswer = i; }
        else if(number == 1){ if(quest == 0) correctAnswer = i; }
        else if(number == 2){ if(quest == 1) correctAnswer = i; }
        else if(number == 3){ if(quest == 2) correctAnswer = i; }
        else if(number == 4){ if(quest == 3) correctAnswer = i; }

    }
}
