package hackerrank.java.DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/java-arraylist/problem
 */
public class ArrayListTest {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<String> lines = new ArrayList<String>();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			lines.add(sc.nextLine());
		}

		n = sc.nextInt();
		sc.nextLine();
		List<String> queries = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			queries.add(sc.nextLine());
		}

		for (String query : queries) {
			String[] q = query.split("\\s+");
			// System.out.println(q[0] + " " + q[1]);
			int l = Integer.parseInt(q[0]);
			int p = Integer.parseInt(q[1]);
			String line = lines.get(l - 1);
			String[] num = line.split("\\s+");
			if (p > Integer.parseInt(num[0]) || p < 1) {
				System.out.println("ERROR!");
				continue;
			}
			System.out.println(num[p]);
		}
	}
}
