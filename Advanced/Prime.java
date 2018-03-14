package hackerrank.java.Advanced;

/*
 * https://www.hackerrank.com/challenges/prime-checker/problem
 */
import java.math.BigInteger;

public class Prime {
	void checkPrime(int... args){
        String primeString ="";
        for(int i : args){
            if (BigInteger.valueOf(i).isProbablePrime(50)) {
                primeString += i + " ";
            }
        }
        System.out.println(primeString);
    }
}
