package hackerrank.java.String;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/java-strings-introduction/problem
 */
public class Introduction {

	public static String capitalizeFirstLetter(String original) {
		if (original == null || original.length() == 0) {
			return original;
		}
		return original.substring(0, 1).toUpperCase() + original.substring(1);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		/* Enter your code here. Print output to STDOUT. */

		System.out.println(A.length() + B.length());
		if (A.compareTo(B) <= 0) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
		System.out.println(capitalizeFirstLetter(A) + " "
				+ capitalizeFirstLetter(B));
	}
}
