package MultiThread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main extends Thread {

	public static void main(String[] args) throws IOException {
		
		Map<String, Integer> listfinally = new HashMap<>();
		int countOfThread =4;
		int part =0;
		File in = new File(".\\input3");
		File[] arrfile = in.listFiles();
		System.out.println(arrfile.length);
		File out = new File("output3.txt");
		BufferedWriter fout = new BufferedWriter(new FileWriter(out));
		
		
		ArrayList<ArrayList<File>> listFileOneOfThread = new ArrayList<>();
		
		part = arrfile.length/countOfThread;
		for(int i=0;i<countOfThread;i++){
			ArrayList<File> raw = new ArrayList<>();
			int leng=0;
			if(i==countOfThread-1){
				leng = part+ arrfile.length%countOfThread;
			}else
			{
				leng= part;
			}
			
			for(int j=0;j<leng;j++){
				raw.add(arrfile[i*part+j]);
			}
			
			listFileOneOfThread.add(raw);
		}
		
		
		// sinh 4 thread
		  ExecutorService executor= Executors.newCachedThreadPool();
		  for(int i=0;i<4;i++){
			  executor.execute(new ThreadModel("Thread"+ i,(ArrayList<File>)listFileOneOfThread.get(i)));
		  }
		  executor.shutdown();
		  while(!executor.isTerminated()){
		  }
		  
		  System.out.println(ElementStack.getSize());

		  ArrayList<Word> lis = new ArrayList<>();
		  lis= ElementStack.SumArray();
		  System.out.println(lis.size());
		 
		  fout.write("Danh sach tu xuat hien nhieu nhat: \n");
			  for(int i=lis.size()-10;i<lis.size();i++){
				  Word w=lis.get(i);
				  fout.write(w.getKey()+" "+ w.getValue()+" \n");
		  }
		    fout.write("Danh sach tu xuat hien it nhat: \n");
			  for(int i=0;i<10;i++){
				  Word w=lis.get(i);
				  fout.write(" \n"+ w.getKey()+" "+ w.getValue()+" ");
		  }
//		  for(Word w : lis){
//			  fout.write(w.getKey()+" "+ w.getValue()+"\n");
//		  }
			 fout.close(); 
	}

}
