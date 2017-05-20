package Bai2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class test {
	
	public static String[] splitWord(String input){
		return input.toLowerCase().split("\\W+");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> dict = new LinkedHashMap<String, Integer>();
		
		
		try{
			File file= new File("01.txt");
			BufferedReader readfile= new BufferedReader(new FileReader(file));
			File out= new File("02.txt");
			BufferedWriter outfile= new BufferedWriter(new FileWriter(out));
			
			String strline="";
			String[] splited;
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
			for(Map.Entry<String,Integer> entry:  dict.entrySet() ){
//				String value = Integer.toString(entry.getValue());
				outfile.write(entry.getKey()+ " "+ entry.getValue() + " \n");
				System.out.println(entry.getKey()+ " "+ entry.getValue());
			}
			
			
			readfile.close();
			outfile.close();
		}catch(Exception e){
			System.out.println("Error");
		}

		
	}

}
