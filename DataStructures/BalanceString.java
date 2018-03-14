package hackerrank.java.DataStructures;

import java.util.Scanner;
import java.util.Stack;

/*
 * https://www.hackerrank.com/challenges/java-stack/problem
 */
public class BalanceString {

	public static boolean isBalanceString(String s) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '{':
				stack.push('}');
				break;
			case '[':
				stack.push(']');
				break;
			case '(':
				stack.push(')');
				break;
			case '}':
			case ']':
			case ')':
				if (stack.empty() || c != stack.pop().charValue()) {
					return false;
				}
				break;
			}
		}

		return stack.empty();
	}

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input = sc.next();
			// Complete the code
			System.out.println(isBalanceString(input));
		}

	}
}
