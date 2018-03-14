package hackerrank.java.DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/java-list/problem
 */
public class ListTest {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String line = sc.nextLine();

		List<String> list = new ArrayList(Arrays.asList(line.split("\\s+")));
		// System.out.println(list);

		int q = sc.nextInt();
		sc.nextLine();
		while (q > 0) {
			String operation = sc.nextLine();

			if (operation.compareToIgnoreCase("Delete") == 0) {
				String index = sc.nextLine();
				// System.out.println(index);
				list.remove(Integer.parseInt(index));
			} else {
				String[] qline = sc.nextLine().split("\\s+");
				// System.out.println(qline);
				list.add(Integer.parseInt(qline[0]), qline[1]);
			}
			q--;
		}
		for (String s : list) {
			System.out.print(s + " ");
		}
	}
}
