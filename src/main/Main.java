package main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.text.edits.MalformedTreeException;

import formatter.StyleFormatter;
import parser.FolderExplorer;
import parser.OptionFileParser;

public class Main {

    public static void main(String[] args) {
	String parserOptionPath, rootFolderPath;
	File parserOptionFile;

	// parserOptionPath = args[0]; // Used in command line
	// rootFolderPath = args[1]; // Used in command line
//	parserOptionPath = "profiles/1/profile1.xml"; // Pour tester
	parserOptionPath = "profiles/2/profile2.xml"; // Pour tester
	rootFolderPath = "test"; // Pour tester

	parserOptionFile = new File(parserOptionPath);

	if (parserOptionFile.exists() && parserOptionFile.isFile()) {
	    List<String> filesToFormatPaths = FolderExplorer.getJavaFiles(rootFolderPath);
	    OptionFileParser parser = new OptionFileParser(parserOptionPath);
	    StyleFormatter formatter = new StyleFormatter(parser.parse());

	    for (String filePath : filesToFormatPaths) {
		System.out.println(filePath);
		
		try {
		    FolderExplorer.writeFile(filePath, formatter.apply(filePath).get());
		} catch (SecurityException | MalformedTreeException | IOException | BadLocationException e1) {
		    e1.printStackTrace();
		}
	    }
	}
    }

}
