//: atul/assignment8/TextMap.java

import java.io.*;
import java.util.*;
import java.nio.charset.*;
public class TextMap{
	static Map<Character,Integer> textMap = new HashMap<Character,Integer>();
	static Comparator<Map.Entry<Character,Integer>> customComparator = new Comparator<Map.Entry<Character,Integer>>() {
	        @Override public int compare(Map.Entry<Character,Integer> s1, Map.Entry<Character,Integer> s2) {
			return s1.getKey().toString().compareTo(s2.getKey().toString());
        	}
    	};
	static void handleCharacters(Reader reader) throws IOException {
		int r;
		Integer one = new Integer(1);
		while((r=reader.read())!=-1){
			Character ch = (char)r;
			if(textMap.get(ch)!=null)
				textMap.put(ch,new Integer(textMap.get(ch)+1));
			else
				textMap.put(ch,one);
		}
	}
	static void handleFile(File file, Charset encoding) throws IOException {
		try (
			InputStream in = new FileInputStream(file);
			Reader reader = new InputStreamReader(in,encoding);
			Reader buffer = new BufferedReader(reader)){
				handleCharacters(buffer);
		}
	}
	static void write(String filename) throws IOException {
		try {
			File file = new File(filename).getAbsoluteFile();
			PrintWriter out = new PrintWriter(file);
			try {
				for(Map.Entry<Character,Integer> name:textMap.entrySet())
					out.println(name.getKey()+"  " + name.getValue());
			} finally {
			out.close();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter input filename(Make sure this exists): ");
		String filename = scanner.nextLine();
		Charset encoding  = Charset.defaultCharset();
		File file = new File(filename);
		handleFile(file,encoding);
		for (Map.Entry<Character,Integer> name: textMap.entrySet())
			System.out.println(name.getKey() + " " + name.getValue());
//		Collection.sort(textMap,customComparator);
		for (Map.Entry<Character,Integer> name: textMap.entrySet())
                        System.out.println(name.getKey() + " " + name.getValue());
		System.out.print("Enter output filename: ");
		String outputFile = scanner.nextLine();
		write(outputFile);
	}
}
