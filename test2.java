package formatter;

import java.util.Map;

import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

public class StyleFormatter {
	private CodeFormatter codeFormatter; // TODO On peut le rendre static
	
	public StyleFormatter(Map<String, String> options) {
		this.codeFormatter = ToolFactory.createCodeFormatter(options);
	} 
	
	public IDocument apply(String source) throws MalformedTreeException, BadLocationException {
		IDocument document = new Document(source);
		TextEdit edit = getFormatter(source);
		edit.apply(document);
		return document;
	}
	
	private TextEdit getFormatter(String source) {
		return codeFormatter.format(
		        CodeFormatter.K_COMPILATION_UNIT, // format a compilation unit
		        source, // source to format
		        0, // starting position
		        source.length(), // length
		        0, // initial indentation
		        System.getProperty("line.separator") // line separator
		        );
	}
}