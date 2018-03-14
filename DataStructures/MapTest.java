package hackerrank.java.DataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/phone-book/problem
 */
public class MapTest {

	public static void main(String[] argh) {
		Map<String, Integer> phoneMap = new HashMap<String, Integer>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for (int i = 0; i < n; i++) {
			String name = in.nextLine();
			int phone = in.nextInt();
			phoneMap.put(name, phone);
			in.nextLine();
		}
		Integer phone = null;
		while (in.hasNext()) {
			String s = in.nextLine();
			phone = phoneMap.get(s);
			if (phone == null) {
				System.out.println("Not found");
			} else {
				System.out.println(s + "=" + phone);
			}

		}
	}
}
