package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListFileNameParser {
	
	public static List<String> parse(File file) {
		ArrayList<String> listFile = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			while(line != null) {
				listFile.add(getDataFromLine(line));
				line = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listFile;
	}
	
	private static String getDataFromLine(String line) {
		String[] lineSplitted = line.split("\\\t");
		return lineSplitted[1];
	}
}
