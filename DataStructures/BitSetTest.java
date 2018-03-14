package hackerrank.java.DataStructures;

import java.util.BitSet;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/java-bitset/problem
 */
public class BitSetTest {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        BitSet B[] = new BitSet[2];
        B[0] = b1;
        B[1] = b2;
        
        while(m>0){
            String op = sc.next();
            int value1 = sc.nextInt();
            int value2 = sc.nextInt();
            if(op.equals("AND")){
                B[value1-1].and(B[value2-1]);
            }
            else if(op.equals("OR")){
                B[value1-1].or(B[value2-1]);
            }
            else if(op.equals("XOR")){
                B[value1-1].xor(B[value2-1]);
            }
            else if(op.equals("SET")){
                B[value1-1].set(value2);
            }
            else if(op.equals("FLIP")){
                B[value1-1].flip(value2);
            }
            
            //System.out.println(op + value1+ value2);
            System.out.println(B[0].cardinality() + " " + B[1].cardinality());
            m--;
        }
    }
}
