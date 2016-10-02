package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FolderExplorer {
    private static final String javaExtension = ".java";

    public static List<String> getJavaFiles(String folderPath) {
	ArrayList<String> res = new ArrayList<>();
	File rootFolder = new File(folderPath);
	
	if(rootFolder.exists() && rootFolder.isDirectory()) {
	    setFilePathsFromFolder(rootFolder, res);
	}
	
	return res;
    }
    
    private static void setFilePathsFromFolder(File rootFolder, Collection<String> files) {
	File[] children = rootFolder.listFiles();
	if(children != null) {
	    for(File child : children) {
		if(child.isDirectory()) {
		    setFilePathsFromFolder(child, files);
		} else if (child.isFile() && checkExtension(child)){
		    files.add(child.getAbsolutePath());
		}
	    }
	}
    }
    
    private static boolean checkExtension(File file) {
	String path = file.getAbsolutePath();
	return path.endsWith(javaExtension);
    }
    
    public static void writeFile(String path, String source) throws SecurityException, IOException {
	byte[] sourceBytes = source.getBytes();
	FileOutputStream out = new FileOutputStream(path);
	out.write(sourceBytes);
	out.close();
    }
}
