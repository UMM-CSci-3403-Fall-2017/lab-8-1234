package mpd;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {
	static int mincost = Integer.MAX_VALUE;

	
	@Override
	public int minimumPairwiseDistance(int[] values) {
		Thread one = new Thread(new one(min, values));
		Thread two = new Thread(new two(min, values));
		Thread three = new Thred(new three(min, values));
		Thread four = new Thread(new four(min, values));

		one.start();
		two.start();
		three.start();
		four.start();

		try{
			one.join();
			two.join();
			three.join();
			four.join();
		} catch (IOException e){
			e.printStackTrace();
		}
		return mincost;
	}

	public synchronized void mySync(int minPairDist){
		if(minPairDist < mincost){
			mincost = minPairDist;
		}
	}
	
	private class one implements Runnable{
		public one(int min, int[] values){
			int min = min;
			values = values;
		}

		public void run() {
			int result = Integer.MAX_VALUE;
			for (int i = 0; i < values.length/2; ++i) {
				for (int j = 0; j < i; ++j) {
					int diff = Math.abs(values[i] - values[j]);
					if (diff < result) {
						result = diff;
					}
				}
			}
			mySync(result);
		}	
	}

	private class two implements Runnable{
		public two(int min, int[] values){
			int min = min;
			values = values;
		}

		public void run() {
			int result = Integer.MAX_VALUE;
			for (int i = values.length/2; i < values.length; ++i) {
				for (int j = 0; j < i-values.length/2; ++j) {
					int diff = Math.abs(values[i] - values[j]);
					if (diff < result) {
						result = diff;
					}
				}
			}
			mySync(result);
		}
	}

	private class three implements Runnable{
		public three(int min, int[] values){
			int min = min;
			values = values;
		}
		public void run() {
			int result = Integer.MAX_VALUE;
			for(int i = values.length/2; i < values.length; ++i){
				for(int j = values.length/2; j < i; ++j) {
					int diff = Math.abs(values[i] - values[j]);
					if(diff < result) {
						result = diff;
					}
				}
			}
			mySync(result);
		}
	}

	private class four implements Runnable{
		public void run(){
			int result = integer.MAX_VALUE;
			for(int i = values.length/2; i < values.length; ++i){
				for(int j = values.length/2; j < i; ++j) {
					int diff = Math.abs(values[i] - values[j]);
					if(diff < result) {
						result = diff;
					}
				}	
			}
			mySync(result);
		}
	}
}
