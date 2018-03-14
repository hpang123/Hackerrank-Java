package hackerrank.java.DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/java-1d-array/problem
 */
public class JumpGame {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		while (q-- > 0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();

			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}

			System.out.println((canWin(leap, game)) ? "YES" : "NO");
		}
		scan.close();
	}
	
	public static boolean jump(List<Integer> startPositions, int leap,
			int[] game) {
		List<Integer> newPositions = new ArrayList<Integer>();
		for (Integer p : startPositions) {
			if (leap + p > game.length - 1) {
				return true;
			}
			if (game[leap + p] == 0) {
				newPositions.add(leap + p);
				game[leap + p] = 1;

				for (int i = p + leap - 1; i > 0; i--) {
					if (game[i] == 0) {
						newPositions.add(i);
						game[i] = 1;
						continue;
					}
					break;
				}
				for (int i = p + leap + 1; i < game.length; i++) {
					if (game[i] == 0) {
						newPositions.add(i);
						game[i] = 1;
						continue;
					}
					break;
				}
			}
		}
		if (newPositions.size() == 0) {
			return false;
		}
		return jump(newPositions, leap, game);
	}

	public static boolean canWin(int leap, int[] game) {
		// Return true if you can win the game; otherwise, return false
		List<Integer> startPositions = new ArrayList<Integer>();
		// assume start always be zero
		for (int i = 0; i < game.length; i++) {
			if (game[i] == 0) {
				startPositions.add(i);
				game[i] = 1;
				continue;
			}
			break;
		}
		// In case leap =0
		if (startPositions.size() == game.length) {
			return true;
		}
		return jump(startPositions, leap, game);
	}
}
