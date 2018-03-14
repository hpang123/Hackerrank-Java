package hackerrank.java.Advanced;

/*
 * https://www.hackerrank.com/challenges/simple-addition-varargs/problem
 */
public class VarargsAddition {
	public void add(int... args) {
		int sum = 0;
		int count = 1;
		int length = args.length;
		String s = "";
		if (length < 2) {
			return;
		}

		for (int i : args) {
			if (count < length) {
				s += i + "+";
			} else {
				s = s + i;
			}
			count++;
			sum += i;
		}
		System.out.println(s + "=" + sum);
	}
}
