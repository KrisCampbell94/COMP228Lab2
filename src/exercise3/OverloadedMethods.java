package exercise3;

public class OverloadedMethods {
    // Main Method
    public static void main(String[] args) {
        double answerA, answerB, answerC;

        // Factorial
        answerA = multiplication(8);
        // Exponential
        answerB = multiplication(2,6);
        // Geometric
        answerC = multiplication(2,3,5);

        // Print out all the results for each answer
        System.out.printf("Factorial result of 8!        = %.2f%n", answerA);
        System.out.printf("Exponential result of 2^6     = %.2f%n", answerB);
        System.out.printf("Geometric result of 2*3^(5-1) = %.2f%n", answerC);

    }
    // Exponential numbers
    private static double multiplication(double number, double power){
        //a^r
        return Math.pow(number, power); // Returns the power of number and power
    }
    // Factorial numbers
    private static double multiplication(double number){
        // n!
        double answer = 1;
        for (int i = 1; i <= number; i++) {
            answer = answer * i; // Multiplies each number by i
        }// End of for loop
        return answer; // Return the factorial result
    }
    // Geometric sequence
    private static double multiplication(double a, double r, double n){
        // an = ar^(n-1)
        return a*Math.pow(r,(n-1)); // return the geometric sequence
    }

}
