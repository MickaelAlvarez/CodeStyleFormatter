package main;

import java.io.File;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.text.edits.MalformedTreeException;

import formatter.StyleFormatter;
import parser.ListFileNameParser;
import parser.OptionFileParser;

public class Main {

	public static void main(String[] args) {
		List<String> filesToFormatPaths;
		String parserOptionPath, filesToFormatPath;
		File parserOptionFile, filesToFormatFile;
		
//		parserOptionPath = args[0]; // Used in command line
//		filesToFormatPath = args[1]; // Used in command line
		parserOptionPath = "test.xml"; // Pour tester
		filesToFormatPath = "listFile"; // Pour tester
		
		parserOptionFile = new File(parserOptionPath);
		filesToFormatFile = new File(filesToFormatPath);

		if (parserOptionFile.exists() && parserOptionFile.isFile() && filesToFormatFile.exists() && filesToFormatFile.isFile()) {
			filesToFormatPaths = ListFileNameParser.parse(filesToFormatFile);
			OptionFileParser parser = new OptionFileParser(parserOptionPath);
			StyleFormatter formatter = new StyleFormatter(parser.parse());

			for(String filePath : filesToFormatPaths) {
				System.out.println(filePath);
				try {
					System.out.println(formatter.apply(filePath).get());
				} catch (MalformedTreeException | BadLocationException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

}
