package Thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class TestThread extends Thread{
	private String str="";
	public TestThread(String p){
		str= p;
		
	}
	public static String[] splitWord(String input){
		return input.toLowerCase().split("\\W+");
	}
	
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(str+" "+ i);
		}
	}
	
	
	public static <String,Iteger extends Comparable<? super Integer>> Map<String,Integer> sortByValue(Map<String,Integer> map) {
	    return map.entrySet()
	              .stream()
	              .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
	              .collect(Collectors.toMap(
	                Map.Entry::getKey, 
	                Map.Entry::getValue, 
	                (e1, e2) -> e1, 
	                LinkedHashMap::new
	              ));
	}
	
	@SuppressWarnings("unchecked")
	public void listFilesForFolder(final File folder){
		 Map<String, Integer> dict = new ConcurrentHashMap<String, Integer>();
		List<Entry<String,Integer>> sortentries = Collections.synchronizedList(new ArrayList());
		 Stack<Entry<String, Integer>> listfinal= new Stack<>();
		 FileWriter out= null;
		 try {
				out= new FileWriter("02.txt");
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
		 for (final File fileEntry : folder.listFiles()) {
		        if (fileEntry.isDirectory()) {
		            listFilesForFolder(fileEntry);
		        } else {
		            System.out.println(fileEntry.getName());
		           
		            
		    		BufferedReader readfile = null;
		    		
				    
		    		try {
		    			readfile = new BufferedReader(new FileReader(fileEntry));
		    		} catch (FileNotFoundException e1) {
		    			// TODO Auto-generated catch block
		    			e1.printStackTrace();
		    		}
		    		 String strline="";
		    			String[] splited;
		    			try {
		    				while((strline=readfile.readLine())!= null){
		    					splited= splitWord(strline);
		    					for(String key:splited){
		    						if(key!=""){
		    						if(!dict.containsKey(key)){
		    							dict.put(key,0);
		    						}
		    						dict.put(key,dict.get(key)+1);
		    					 }
		    					}
		    				}
		    				for(Map.Entry<String,Integer> entry: dict.entrySet()){
		    					out.write(entry.getKey()+ " "+ entry.getValue() + " \n");
    				
			    			}
		    				
		    					
		    				
		 
		    				
		    			} catch (IOException e) {
		    				// TODO Auto-generated catch block
		    				e.printStackTrace();
		    			}
		    			
		    			
		    			
		    			
//		    			Map<String,Integer> topTen =
//	    					    sortentries.stream()
//	    					       .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
//	    					       .limit(10)
//	    					       .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	    				
		    			for(Map.Entry<String, Integer> entry1 : sortentries ){
		    				System.out.print(entry1.getKey() + " "+ entry1.getValue()+ " \n");
		    			}
		  
		        }
		    }
	}
	
	   public static void main(String args[]) throws IOException {
		   
		   Map<String, String> map = new HashMap<String, String>();
	       BufferedReader in= new BufferedReader(new FileReader("02.txt"));
	       String line= "";
		   String s;
		   final File folder= new File("input3");
		   Set<File> listfile= new HashSet<>();
		   
		   
		  
		   
//		   BufferedReader br= new BufferedReader(new FileReader(folder));

		 
//		  t1.listFilesForFolder(folder);
//		  t2.listFilesForFolder(folder);
//		  t3.listFilesForFolder(folder);
		  
		  ExecutorService executorService= Executors.newFixedThreadPool(3);
		  executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				
				
			}
		});
		  
		  executorService.shutdown();
		  
		  while((line= in.readLine())!=null){
			   String parts[]= line.split("\t");
			   map.put(parts[0],parts[1]);
		   }
		  
		  
//			BufferedReader read= new BufferedReader(new FileReader("02.txt"));
		 
		  
		  
	     
	}

	
	   
}
