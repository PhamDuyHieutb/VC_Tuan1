package Thread;

class RunnableDemo extends Thread {
	   private Thread t;
	   private String threadName;
	   private int time;
	   
	   RunnableDemo( String name, int time){
	       threadName = name;
	       this.time=time;
	       System.out.println("Creating " +  threadName );
	   }
	   public void run() {
	      System.out.println("Running " +  threadName );
	      try {
	         for(int i = 4; i > 0; i--) {
	            System.out.println("Thread: " + threadName + ", " + i);
	            // De thread ngung trong choc lat.
	            Thread.sleep(time);
	         }
	     } catch (InterruptedException e) {
	         System.out.println("Thread " +  threadName + " interrupted.");
	     }
	     System.out.println("Thread " +  threadName + " exiting.");
	   }
	   
	   public void start ()
	   {
	      System.out.println("Starting " +  threadName );
	      if (t == null)
	      {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }

	}

	