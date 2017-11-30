package mpd;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {

	public int globalResult = Integer.MAX_VALUE;

	public synchronized int updateGlobalResult(int last) {
		if(globalResult > last) {
			globalResult = last'
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

	    private class one implements Runnable {
		    @Override
		    public void run() {
			    int localResult = Integer.MAX_VALUE;

