package main;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.text.edits.MalformedTreeException;

import formatter.StyleFormatter;
import parser.OptionFileParser;

public class Main {
	// Purge equinox

	public static void main(String[] args) {
		String source = "public enum X { A,B,C,D,E,F}; private static String pouette = null;";
		OptionFileParser parser = new OptionFileParser("test.xml");
		StyleFormatter formatter = new StyleFormatter(parser.parse());
		
		try {
			System.out.println(formatter.apply(source).get());
		} catch (MalformedTreeException | BadLocationException e) {
			e.printStackTrace();
		}
	}

}
