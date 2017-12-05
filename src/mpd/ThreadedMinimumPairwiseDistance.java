package mpd;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {
	static int min = Integer.MAX_VALUE;

	
	@Override
	public int minimumPairwiseDistance(int[] values) {

		min = Integer.MAX_VALUE;

		Thread one = new Thread(new one(min, values));
	   	Thread two = new Thread(new two(min, values));
	    	Thread three = new Thread(new three(min, values));
	    	Thread four = new Thread(new four(min, values));
		
		//start thread
		one.start();
	    	two.start();
	    	three.start();
	    	four.start();
		
		try {
			one.join();
		    	two.join();
		    	three.join();
		    	four.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	    return min;
    }

    public void updateGlobalResult(int lastResult) {
	    if(lastResult < min){
		    min = lastResult;
	    }
    }
    
    class one implements Runnable {
	    private int lastMinimum;
	    private int [] values;
	    
	    one(int mins, int[] value) {
		    lastMinimum = mins;
		    values = value;
	    }
	    
	    public void run() { 
		    int result = Integer.MAX_VALUE;
		    for (int i = 0; i < values. length/2; i++) {
			    for (int j = 0; j < i; j++) {
				    int diff = Math.abs(values[i] - values[j]);
				    if (diff < result) {
					    result = diff;
				    }
			    }
		    }
		    updateGlobalResult(result);
	    }
    }
    class two implements Runnable {
	    private int lastMinimum;
	    private int [] values;

	    two(int mins, int[] value) {
		    lastMinimum = mins;
		    values = value;
	    }

	    public void run() {
		    int result = Integer.MAX_VALUE;
		    for (int i = values.length/2; i < values.length; ++i) {
			    for (int j = 0; j < i-values.length/2; ++j) {
				    int dif = Math.abs(values[i] - values[j]);
				    if (diff < result) {
					    result = diff;
				    }
			    }
		    }
		    updateGlobalResult(result);
	    }
    }
    
    class three implements Runnable {
	    private int lastMinimum;
	    private int [] values;
	    
	    three(int minis, int[] value) {
		    lastMinimum = mins;
		    values = value;
	    }
	    
	    public void run() {
		    int result = Integer.MAX_VALUE;
		    for (int i = values.length/2; i < values.length; ++i) {
			    for (int j = values.length/2; j < i; ++j) {
				    int diff = Math.abs(values[i] - values[j]);
				    if (diff < result) {
					    result = diff;
				    }
			    }
		    }
		    updateGlobalResult(result);
	    }
    }
    
    class four implements Runnable {
	    private int lastMinimum;
	    private int [] values;
	    
	    four(int mins, int[] value) {
		    lastMinimum = mins;
		    values = value;
	    }
	    
	    public void run() {
		    int result = Integer.MAX_VALUE;
		    for (int j = 0; j < values.length/2; j++) {
			    for (int i = values.length/2; i < j+values.length/2; ++i) {
				    int diff = Math.abs(values[i] - values[j]);
				    if (diff < result) {
					    result = diff;
				    }
			    }
		    }
		    updateGlobalResult(result);
	    }
    }
}

