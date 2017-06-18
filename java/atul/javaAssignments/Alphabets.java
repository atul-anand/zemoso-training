//: atul/javaAssignments/Alphabets.java

import java.lang.*;
import java.util.*;

public class Alphabets {
	static boolean containAllAlphabets(String s){
		boolean[] arr = new boolean[26];
		s = s.toLowerCase();
		for(char ch : s.toCharArray())
			if(Character.isAlphabetic(ch))
				arr[(int)ch - (int)'a'] = true;
		for(boolean b : arr)
			if(b==false)
				return false;
		return true;
	}
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
                while(true){
                        String expression = scanner.nextLine();
                        if(expression.equals("exit"))
                                break;
                       	System.out.println(containAllAlphabets(expression));
                }
	}
}
