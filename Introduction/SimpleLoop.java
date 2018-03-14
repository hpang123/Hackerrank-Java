package hackerrank.java.Introduction;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/java-loops/problem
 */
public class SimpleLoop {

	private static void printSeries(int a, int b, int n) {
		long sum = a;
		for (int i = 0; i < n; i++) {
			sum += Math.pow(2, i) * b;
			System.out.print(sum + " ");
		}
	}

	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			printSeries(a, b, n);
			System.out.println();
		}
		in.close();
	}
}
