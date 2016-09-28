package parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class OptionFileParser {
	private static final String FIRST_NODE = "profiles";
	private String filePath;
	private XStream xStream;
	
	public OptionFileParser(String filePath) {
		this.filePath = filePath;
		xStream = new XStream(new DomDriver());
		xStream.registerConverter(new MapEntryConverter());
		xStream.alias(FIRST_NODE, java.util.Map.class);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> parse() {
		return (HashMap<String, String>) xStream.fromXML(getFile(filePath));
	}
	
	private String getFile(String fileName) {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		
		try {
			String sCurrentLine;

			br = new BufferedReader(new FileReader(fileName));

			while ((sCurrentLine = br.readLine()) != null) {
				sb.append(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return sb.toString();
	}
}
