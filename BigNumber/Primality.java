package hackerrank.java.BigNumber;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/java-primality-test/problem
 */
public class Primality {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger n = in.nextBigInteger();
		in.close();
		// Write your code here.
		if (n.isProbablePrime(10)) {
			System.out.println("prime");
		} else {
			System.out.println("not prime");
		}
	}
}
