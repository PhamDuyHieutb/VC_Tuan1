package MultiThread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadFile {
	public Map<String,Integer> dict= new HashMap<>();
	
	public static String[] split_word(String input) {
		return input.toLowerCase().split("\\W+");
	}

	public void Read(File file) throws IOException {
		BufferedReader filein= new BufferedReader(new FileReader(file));
		String s="";
		String[] rawword;
		
		while((s= filein.readLine())!=null){
			rawword=split_word(s);
			for(String key :rawword){
				if(!dict.containsKey(key)){
					dict.put(key,1);
				}else
				{
					dict.put(key,dict.get(key)+1);
				}
			}
		}
		
		filein.close();
		
		
	}
	
	public HashMap<String, Integer> ReadAll(ArrayList<File> allfile) throws IOException{
		for(File f: allfile){
			Read(f);
		}
		
		return (HashMap<String, Integer>) dict;
	}

}
