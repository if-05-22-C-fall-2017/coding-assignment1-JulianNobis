/*
 * This might not be an elegant solution because I just copied the code for another test example with a negative number (if-else blocks)
 */
package gcd_nobis.julian;

/**
 *
 * @author Julian Nobis
 */
public class Gcd_nobisJulian {
    public static void main(String[] args) {
        int number1 = 1989, number2 = 867; // exact same numbers like in school
        int number3 = -3, number4 = 111; 
        System.out.println("This is the solution of Julian Nobis\n");
        
        // method 1: eucledian algorithm
        int resultEucledian = gcdEucledian(number1, number2);
        if (resultEucledian == -1){ // invalid number
            System.out.println("An error occured, sorry! No negative numbers allowed!");
        }
        else{
            System.out.println("EUCLEDIAN ALGORITHM:\ngcd of " + number1 + " and " + number2 + " is: " + resultEucledian);
        }
        resultEucledian = gcdEucledian(number3, number4); // negative example
        if (resultEucledian == -1){ // invalid number
            System.out.println("An error occured, sorry! No negative numbers allowed!");
        }
        else{
            System.out.println("EUCLEDIAN ALGORITHM:\ngcd of " + number1 + " and " + number2 + " is: " + resultEucledian);
        }
        
        // method 2: prime-factors algorithm
        int resultPrimeFactors = gcdPrimeFactors(number1, number2);
        if (resultPrimeFactors == -1){ // invalid number
            System.out.println("An error occured, sorry! No negative numbers allowed!");
        }
        else{
            System.out.println("\nPRIME-FACTORS ALGORITHM:\ngcd of " + number1 + " and " + number2 + " is: " + resultPrimeFactors);
        }
        resultPrimeFactors = gcdPrimeFactors(number3, number4); // negative example
        if (resultPrimeFactors == -1){ // invalid number
            System.out.println("An error occured, sorry! No negative numbers allowed!");
        }
        else{
            System.out.println("PRIME-FACTORS ALGORITHM:\ngcd of " + number1 + " and " + number2 + " is: " + resultPrimeFactors);
        }
    }
    
    public static int gcdPrimeFactors(int a, int b){
        if (a <= 0|| b <= 0) return -1; // not valid
        // section for 'a' variable
        int[] remainders_A = new int[10];
        int temp_A = a-1;
        int i_A = 0;
        while (a != 1){ // find out remainders for A
            while ((a % temp_A) != 0) temp_A--;
            remainders_A[i_A] = a / temp_A--;
            a /= remainders_A[i_A++];
        }
        // section for 'b' variable
        int[] remainders_B = new int[10];
        int temp_B = b-1;
        int i_B = 0;
        while (b != 1){ // find out remainders for B
            while ((b % temp_B) != 0) temp_B--;
            remainders_B[i_B] = b / temp_B--;
            b /= remainders_B[i_B++];
        }   
        // multiply common remainders of BOTH A and B
        int result = 1;
        for (int i = 0; i < remainders_A.length && remainders_A[i] != 0; i++){ // array is partially filled with 0s, therefore check for 0
            for (int n = 0; n < remainders_B.length && remainders_B[n] != 0; n++){ // array is partially filled with 0s, therefore check for 0
                if (remainders_A[i++] == remainders_B[n++]){
                    result *= remainders_A[i]; // "primfaktorenzerlegung multiplizieren"
                }
            }
        }
       return result; 
    }
    
    public static int gcdEucledian(int a, int b){
       if (a <= 0 || b < 0) return -1; // not valid
       while (b != 0){ // we know that the gcd(a, 0) = a
           int c = a;
           a = b;
           b = c % b;
       }
       return a;
    }
    
}
