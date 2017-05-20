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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

public class ThreadModel implements Runnable{
	ArrayList<File> listFile = new ArrayList<>();
	String name ="";
	
	
	public ThreadModel(String name,ArrayList<File> listFile) {
		super();
		this.listFile = listFile;
		this.name = name;
	}


	public void run(){
		System.out.println(listFile.size());
		HashMap<String, Integer> dict = new HashMap<>();
		ReadFile file = new ReadFile();
		
		try{
			dict= file.ReadAll(listFile);
		}catch(IOException e){
			System.out.println(e);
		}
		ElementStack.AddElement(dict);
		
		System.out.println(name+ " done ");
		
	}
	


	
}
