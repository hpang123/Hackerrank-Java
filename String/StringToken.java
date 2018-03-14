package hackerrank.java.String;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/java-string-tokens/problem
 */
public class StringToken {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		// Write your code here.
		// [ .,?!'@_]+
		// [\\s!,?._'@]+

		if (s.trim().length() == 0) {
			System.out.println("0");
		} else {
			String[] result = s.trim().split("[\\s!,?._'@]+");
			System.out.println(result.length);

			for (int x = 0; x < result.length; x++)
				System.out.println(result[x]);
		}

		scan.close();
	}
}
