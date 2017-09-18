/*
 * This might not be the most elegant solution out there
 */
package gcd_nobis.julian;

/**
 *
 * @author Julian Nobis
 */
public class Gcd_nobisJulian {
    static int number1 = 1989, number2 = 867; // exact same numbers like in school
    static int number3 = -3, number4 = 111; // should get a message because number3 is negative
    public static void main(String[] args) {
        System.out.println("This is the solution of Julian Nobis\n");
        eucledianStructure();
        primeFactorsStructure();
    } 
    // method 1: eucledian algorithm
    public static void eucledianStructure(){
        int resultEucledian = gcdEucledian(number1, number2);
        output(1, resultEucledian);
    }
    // method 2: prime-factors algorithm
    public static void primeFactorsStructure(){
        int resultPrimeFactors = gcdPrimeFactors(number1, number2);
        output(2, resultPrimeFactors);
    }
    
    public static void output(int number, int result){
        if (number == 1){ // eucledian algorithm
            if (result == -1){ // invalid number
                System.out.println("No negative numbers allowed! Sorry!");
            }
            else{
                System.out.println("EUCLEDIAN ALGORITHM:\ngcd of " + number1 + " and " + number2 + " is: " + result);
            }
            result = gcdEucledian(number3, number4); // negative example
            if (result == -1){ // invalid number
                System.out.println("No negative numbers allowed! Sorry!");
            }
            else{
                System.out.println("EUCLEDIAN ALGORITHM:\ngcd of " + number1 + " and " + number2 + " is: " + result);
            }
        }
        else{ // prime-factors algorithm
            if (result == -1){ // invalid number
                System.out.println("No negative numbers allowed! Sorry!");
            }
            else{
                System.out.println("\nPRIME-FACTORS ALGORITHM:\ngcd of " + number1 + " and " + number2 + " is: " + result);
            }
            result = gcdPrimeFactors(number3, number4); // negative example
            if (result == -1){ // invalid number
                System.out.println("No negative numbers allowed! Sorry!");
            }
            else{
                System.out.println("PRIME-FACTORS ALGORITHM:\ngcd of " + number1 + " and " + number2 + " is: " + result);
            }
        }
    }
    
    public static int gcdPrimeFactors(int a, int b){
        if (a <= 0|| b <= 0) return -1; // not valid
        int[] primeFactors_A = new int[10], primeFactors_B = new int[10];
        sectionA(a, primeFactors_A);
        sectionB(b, primeFactors_B);
        int result = multiplyPrimeFactors(primeFactors_A, primeFactors_B);
        return result; 
    }
    
    private static void sectionA(int a, int[] primefac_A){
        int temp_A = a-1;
        int i_A = 0;
        while (a != 1){ // find out primeFactors for A
            while ((a % temp_A) != 0) temp_A--;
            primefac_A[i_A] = a / temp_A--;
            a /= primefac_A[i_A++];
        }
    }
    
    private static void sectionB(int b, int[] primefac_B){ 
        int temp_B = b-1;
        int i_B = 0;
        while (b != 1){ // find out primeFactors for B
            while ((b % temp_B) != 0) temp_B--;
            primefac_B[i_B] = b / temp_B--;
            b /= primefac_B[i_B++];
        }   
    }
    
    // multiply common primeFactors of BOTH arrayA and arrayB
    public static int multiplyPrimeFactors(int[]array_A, int[]array_B){
        int result = 1;
        for (int i = 0; i < array_A.length && array_A[i] != 0; i++){ // array is partially filled with 0s, therefore check for 0
            for (int n = 0; n < array_B.length && array_B[n] != 0; n++){ // array is partially filled with 0s, therefore check for 0
                if (array_A[i] == array_B[n++]){
                    result *= array_A[i++]; // "primfaktorenzerlegung multiplizieren"
                }
            }
        }
        return result;
    }
    
    public static int gcdEucledian(int a, int b){
       if (a == 0 || b == 0) return a+b;
       if (a < 0 || b < 0) return -1;
       return gcdEucledian(b, a % b);
    }
    
}
