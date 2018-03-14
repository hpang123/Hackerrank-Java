package hackerrank.java.String;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/java-string-reverse/problem
 */
public class Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		/* Enter your code here. Print output to STDOUT. */
		int i = 0;
		while (true) {
			if (i > A.length() / 2) {
				System.out.println("Yes");
				break;
			}
			if (A.charAt(i) != A.charAt(A.length() - 1 - i)) {
				System.out.println("No");
				break;
			}
			i++;
		}
	}
}
