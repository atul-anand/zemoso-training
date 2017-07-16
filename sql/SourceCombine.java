import java.io.*;
import java.util.*;
public class SourceCombine{
	static void combineSchemas(String path, String prefix, String fileName){
		String inFilePath = path + "/" + fileName + ".sql";
		String outFilePath = path + "/" + prefix + "_" + fileName + ".sql";
		try{
			File inFile = new File(inFilePath);
			FileReader fileReader = new FileReader(inFile);
			BufferedReader in = new BufferedReader(fileReader);
			File outFile = new File(outFilePath);
			FileWriter fileWriter = new FileWriter(outFile.getAbsolutePath());
			BufferedWriter out = new BufferedWriter(fileWriter);
			PrintWriter o = new PrintWriter(out,true);
			String line;
			// System.out.println(outFile.getAbsolutePath());
			while((line=in.readLine())!=null){
				if(line.startsWith("source")){
					String subFilePath = line.split(" ")[1];
					subFilePath = subFilePath.substring(0,subFilePath.length()-1);
					subFilePath = subFilePath.substring(2);
					subFilePath = path + "/" + subFilePath;
					File subFile = new File(subFilePath);
					FileReader subFileReader = new FileReader(subFile);
					BufferedReader subIn = new BufferedReader(subFileReader);
					// System.out.println(subFile.getAbsolutePath());
					String subLine;
					while((subLine = subIn.readLine())!=null){
						// System.out.println(subLine);
						o.println(subLine);
					}
				}
				else{
					// System.out.println(line);
					o.println(line);
				}
			}
		} catch (Exception  e) {
			e.printStackTrace();
		} finally {
			// in.close();
			// o.close();
		}
	}
	public static void main(String[] args){
		// combineSchemas("EmpProj","EmpProj","schema");
		// combineSchemas("CabRental","CabRental","schema");
		// combineSchemas("IRCTC","IRCTC","schema");
		// combineSchemas("FoodDelivery","FoodDelivery","schema");
		// combineSchemas("HotelBooking","HotelBooking","schema");
		// combineSchemas("IMDB","IMDB","schema");
		// combineSchemas("ECommerce","ECommerce","schema");
		combineSchemas("Paytm","Paytm","schema");
	}
}