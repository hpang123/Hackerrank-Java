package hackerrank.java.DataStructures;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/java-negative-subarray/problem
 * 
 */
public class SubArray {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int count = 0;
		while (count < n) {
			a[count] = sc.nextInt();
			count++;
		}

		int num = 0;
		for (int i = 0; i < n; i++) {
			int sum = a[i];
			if (sum < 0) {
				num++;
			}
			for (int j = i + 1; j < n; j++) {
				sum += a[j];
				if (sum < 0) {
					num++;
				}
			}
		}
		System.out.println(num);
	}

}
