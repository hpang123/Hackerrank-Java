package hackerrank.java.String;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * https://www.hackerrank.com/challenges/tag-content-extractor/problem
 * 
 * Input:
 * 4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crush</SA premium>

Output:
Nayeem loves counseling
Sanjay has no watch
So wait for a while
None
Imtiaz has a secret crush
 * 
 */
public class TagContgent{
   public static void main(String[] args){
      
      Scanner in = new Scanner(System.in);
      int testCases = Integer.parseInt(in.nextLine());
      while(testCases>0){
         String line = in.nextLine();
         
            
         //([^<>]+) mean the content doesn't include '<' or '>', </\\1> means </same as this group>
          //Pattern pattern = Pattern.compile("<(.+)>([^<>]+)</\\1>");// work too
         Pattern pattern = Pattern.compile("<([A-Za-z][A-Za-z0-9\\s]*)\\b[^>]*>([^<>]+)</\\1>");
          Matcher matcher = pattern.matcher(line);
          boolean findFlag = false;
          while (matcher.find()) {
              findFlag = true;
            System.out.println(matcher.group(2));
           }
           if(findFlag == false){
               System.out.println("None");
           }
          findFlag = false;
         testCases--;
      }
   }
}
