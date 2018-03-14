package hackerrank.java.String;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
 * https://www.hackerrank.com/challenges/duplicate-word/problem
 * 
 * Input
 * 5
 Goodbye bye bye world world world
 Sam went went to to to his business
 Reya is is the the best player in eye eye game
 in inthe
 Hello hello Ab aB

 */

public class RemoveDuplicateWords {

	public static void main(String[] args) {

		
		String regex = "(?i)\\b(\\w+)(\\b\\W+\\1\\b)+";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		Scanner in = new Scanner(System.in);
		int numSentences = Integer.parseInt(in.nextLine());

		while (numSentences-- > 0) {
			String input = in.nextLine();

			// Solution 1:
			/*
			 * (?i)     # Mode: case-insensitive
			 * \b       # Match the start of a word
			 * ([a-z]+) # Match one ASCII "word", capture it in group 1
			 * \b       # Match the end of a word
			 * (?:      # Start of non-capturing group:
			 *  \s+     # Match at least one whitespace character
			 *  \1      # Match the same word as captured before (case-insensitively)
			 *  \b      # and make sure it ends there.
			 * )+       # Repeat that as often as possible
			 */
			String result = input.replaceAll(
					"(?i)\\b([a-z]+)\\b(?:\\s+\\1\\b)+", "$1");
			System.out.println("Solution 1:" + result);

			Matcher m = p.matcher(input);

			// Check for subsequences of input that match the compiled pattern
			while (m.find()) {
				input = input.replaceAll(regex, "$1");
			}

			// Prints the modified sentence.
			System.out.println(input);
		}

		in.close();

	}
}
