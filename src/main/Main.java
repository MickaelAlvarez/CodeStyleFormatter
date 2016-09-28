package main;

import java.io.File;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.text.edits.MalformedTreeException;

import formatter.StyleFormatter;
import parser.OptionFileParser;

public class Main {

	public static void main(String[] args) {
		String parserOptionPath;
		File parserOptionFile;
		
//		parserOptionPath = args[0]; // Used in command line
		parserOptionPath = "test.xml";
		
		System.out.println("Fichier : " + parserOptionPath);

		parserOptionFile = new File(parserOptionPath);

		if (parserOptionFile.exists() && parserOptionFile.isFile()) {
			String source = "public enum X { A,B,C,D,E,F}; private static String pouette = null;";
			OptionFileParser parser = new OptionFileParser(parserOptionPath);
			StyleFormatter formatter = new StyleFormatter(parser.parse());

			try {
				System.out.println(formatter.apply(source).get());
			} catch (MalformedTreeException | BadLocationException e) {
				e.printStackTrace();
			}
		}
	}

}
