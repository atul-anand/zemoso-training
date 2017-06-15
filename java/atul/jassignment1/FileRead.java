//: atul/jassignment1/FileRead.java

package atul.jassignment1.fileread;

import java.io.*;
import java.util.*;
import java.util.regex.*;
public class FileRead {
	static void matchRegExp(String filePath, String expression){
		Pattern pattern = Pattern.compile(expression);
                Matcher matcher = pattern.matcher(filePath);
                if(matcher.find())
                        System.out.println(filePath);
	}
	static void listFilesDirectory(File dir, String expression){
		try {
			File[] files = dir.listFiles();
			for(File file:files){
				if(file.isDirectory())
					listFilesDirectory(file,expression);
				matchRegExp(file.getCanonicalPath().toString(), expression);
			}
		} catch (IOException e) {
		}
	}
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(true){
			String expression = scanner.nextLine();
			System.out.println(expression);
			if(expression.equals("11"))
				break;
			File[] files = new File(".").listFiles();
			for(File f:files)
				listFilesDirectory(f,expression);
		}
	}
}
