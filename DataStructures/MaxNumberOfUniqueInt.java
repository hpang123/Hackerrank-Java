package hackerrank.java.DataStructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

	
/*
 * https://www.hackerrank.com/challenges/java-dequeue/problem
 * 
 * Input Format

The first line of input contains two integers N and M: 
representing the total number of integers and the size of the subarray, respectively. 
The next line contains N space separated integers.
6 3
5 3 5 2 3 2

Sample Output:
3
 * 
 */
public class MaxNumberOfUniqueInt {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deque deque = new ArrayDeque<>();
		int n = in.nextInt();
		int m = in.nextInt();

		long count = 0;
		if (m == 1 || n == 1) {
			System.out.println(1);
			return;
		}
		int lastNumber = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			int num = in.nextInt();

			deque.addFirst(num);
			set.add(num);

			if (i >= m - 1) {
				count = Math.max(count, set.size());

				lastNumber = (int) deque.removeLast();
				// If deque doesn't have any lastNumber, remove it from set
				if (!deque.contains(lastNumber)) {
					set.remove(lastNumber);
				}
				/*
				 * if(num != lastNumber){ count = Math.max(count,
				 * deque.stream().distinct().count()); }
				 * 
				 * lastNumber = (int) deque.removeLast();
				 */
			}

		}
		System.out.println(count);
	}
}
