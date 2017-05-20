package Thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Practice1 {
	
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

	public static void main(String[] args){
		Map<String,Integer > list1= new HashMap<String,Integer>();
		Map<String, Integer> list3= new HashMap<>();
		
		list1.put("hieu",5);
		list1.put("hie",1);
		list1.put("hi",2);
		list1.put("hieu1",3);
		list1.put("hieu2",4);
		
		 list3 = sortByValue(list1);
		
		for(Map.Entry list2: list3.entrySet()){
			System.out.println(list2.getKey()+ " "+ list2.getValue()+ " \n");
		}
	}
}
