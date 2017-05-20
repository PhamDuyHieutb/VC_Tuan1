package Bai4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.text.Position;

public class RandomTest {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Set<Point> set= new HashSet<Point>();
		Random position= new Random();
		Point test;
		int x=0,y=0;
		File out= new File("output4.txt");
		BufferedWriter fout= new BufferedWriter(new FileWriter(out));
		Dictance a= new Dictance();
		Dictance b= new Dictance();
		Dictance c= new Dictance();
		do{
			test= new Point();
			test.x=position.nextInt(600)+518;
		    test.y=position.nextInt(600)+518;
		    if(a.Dic(x,y)<400)
		    {
		    	test.x = x;
		    	test.y = y;
		    }
			set.add(test);
		}
		while(set.size()<8000);
		
		do{
			test= new Point();
			test.x=position.nextInt(706)+3647;
		    test.y=position.nextInt(706)+3647;
		    if(b.Dic2(x,y)<500)
		    {
		    	test.x = x;
		    	test.y = y;
		    }
			set.add(test);
		}
		while(set.size()<18000);
		
		
		do{
			test= new Point();
			test.x=position.nextInt(1200)+1800;
		    test.y=position.nextInt(600)+1800;
		    if(c.Dic3(x,y)<600)
		    {
		    	test.x = x;
		    	test.y = y;
		    }
			set.add(test);
		}
		while(set.size()<30000);
		
		List<Object> list= new ArrayList<Object>(set);
		Object[] coord= list.toArray();
		
		for(int i=0;i<list.size();i++){
//			System.out.println("\n" +list.get(i));
			fout.write(list.get(i).toString()+" \n");
		}
		fout.close();
		
		
	}

}
