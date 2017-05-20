package Bai1;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class bai1 {


	public static Integer randint (Integer min, Integer max) {
		Random random = new Random();
		int result = random.nextInt(max-min+1) + min;
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("started");
		Set<Integer> a = new TreeSet<Integer>();
		while(a.size() < 100) {
			a.add(randint(1,10000));
		}
		
		Set<Integer> set1 = new TreeSet<Integer>();
		Set<Integer> set2 = new TreeSet<Integer>();
		set1.addAll(a);
		set2.addAll(a);
		
		
		int min = 1, max = 5;
		while(set1.size() < 2000 || set2.size() < 2000) {
			int raw = randint(min,max);
			if(set1.size() < 2000) set1.add(raw);
			if(set2.size() < 2000) set2.add(raw + 1);
			min = max + 2;
			max = min + 5;
		}
		System.out.println(set1.size());
		System.out.println(set2.size());
		
		Set<Integer> set_add = new TreeSet<Integer>();
		Set<Integer> set_add1 = new TreeSet<Integer>();
		Set<Integer> set_remove = new TreeSet<Integer>();
		Set<Integer> set_raw = new TreeSet<Integer>();
		
		// tim hop tap hop
		set_add.addAll(set1);
		set_add.addAll(set2);
		
		// tim giao tap hơp
		set_raw.addAll(set_add);
		set_raw.removeAll(set1);
		set_remove.addAll(set2);
		set_remove.removeAll(set_raw);
		
		
		
		System.out.println(set1);
		System.out.println(set2);
		System.out.println(set_remove);
		System.out.println(set_add);

		System.out.print("ended");

		
	}

}
