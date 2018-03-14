package hackerrank.java.BigNumber;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/java-biginteger/problem
 */
public class BigIntegerOperation {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();

		System.out.println(a.add(b));
		System.out.println(a.multiply(b));
	}
}
