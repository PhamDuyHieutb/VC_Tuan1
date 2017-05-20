package Bai1;

import java.util.*;

public class testSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> set1= new HashSet<Integer>() ;
		set1.add(1);
		set1.add(8);
		set1.add(4);
		System.out.println(set1);
		
		Set<Integer> set2= new HashSet<Integer>() ;
		set2.add(1);
		set2.add(3);
		set2.add(6);
		
		System.out.println(set1.addAll(set2)); 
		
		System.out.println(set1);
		

	}

}
