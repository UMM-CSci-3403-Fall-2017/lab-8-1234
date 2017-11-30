package mpd;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {

	public int globalResult = Integer.MAX_VALUE;

	public synchronized int updateGlobalResult(int last) {
		if(globalResult > last) {
			globalResult = last;
		}
		return globalResult;
	}
    @Override
    public int minimumPairwiseDistance(int[] values) {
	    Thread one = new Thread(new one(globalResult, values));
	    Thread two = new Thread(new two(globalResult, values));
	    Thread three = new Thread(new three(globalResult, values));
	    Thread four = new Thread(new four(globalResult, values));

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
	    return globalResult;

	    class one implements Runnable {
		    private int[] mininumVal;
		    private int minimums;

		    private one(int min, int[] value) {
			    mininumVal = min;
			    minimums = value;
			    
			   // this.mininumVal = mininumVal;
			   //this.minimum = minimum;
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
		    private int[] mininumVal;
		    private int minimums;
		    
		    private two(int min, int[] value) {
			    mininumVal = min;
			    minimums = value;
		    }
		    

		    public void run() {
			    int result = Integer.MAX_VALUE;
			    for (int i = 0; i < values.length/2; i++) {
				    for (int j = 0; j < i; j++) {
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
		    private int[] mininumVal;
		    private int minimums;
		    
		    private three(int min, int[] value) {
			    mininumVal = min;
			    minimums = value;
		    }
		    

		    public void run() {
			    int result = Integer.MAX_VALUE;
			    for (int i = 0; i < values.length/2; i++) {
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

	    class four implements Runnable {
		    private int[] mininumVal;
		    private int minimums;

		    private four(int min, int[] value) {
			    mininumVal = min;
			    minimums = value;
		    
		    }
		    

		    public void run() {
			    int reuslt = Integer.MAX_VALUE;
			    for (int i = 0; i < values.length/2; i++) {
				    for (int j = 0; j < i; j++) {
					    int diff = math.abs(values[i] - values[j]);
					    if (diff < result) {
						    result = diff;
					    }
				    }
			    }
			    updateGlobalResult(result);
		    }
	    }
    }
}

