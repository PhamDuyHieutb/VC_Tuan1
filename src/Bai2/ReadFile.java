package Bai2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadFile {

	public static String[] split_word(String input) {
		return input.toLowerCase().split("\\W+");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("begin");
		Map<String, Integer> dict = new LinkedHashMap<String, Integer>();

		try {
			File fin = new File("01.txt");
			BufferedReader filein = new BufferedReader(new FileReader(fin));
			File fout = new File("output2.txt");
			BufferedWriter fileout = new BufferedWriter(new FileWriter(fout));

			String s = "";
			String[] rawDict;
			while ((s = filein.readLine()) != null) {
				rawDict = split_word(s);
				for (String key : rawDict) {
					if (key != "") {
						if (!dict.containsKey(key)) {
							dict.put(key, 1);
						}else{
						dict.put(key, dict.get(key) + 1);
						}
					}
				}
			}

			for (Map.Entry<String, Integer> entry : dict.entrySet()) {
				String key = entry.getKey();
				String value = Integer.toString(entry.getValue());
				fileout.write(key + " : " + value + " \n");
			}
			fileout.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		
	

		System.out.println("end");
	}

}
