package MultiThread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ListFile {

	public  BufferedReader ListFileInFolder(final File folder) throws FileNotFoundException{
		BufferedReader readfile = null;
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	ListFileInFolder(fileEntry);
	        } else {
	            
	            readfile = new BufferedReader(new FileReader(fileEntry));
	        }
		
	}
		return readfile;
  }
}