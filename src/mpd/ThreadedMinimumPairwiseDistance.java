package mpd;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {

  
  public int result = Integer.MAX_VALUE;
  
    @Override
    public int minimumPairwiseDistance(int[] values) {
//create thread       
        Thread one = new Thread(new one(values, result));
        Thread two = new Thread(new two(values, result));
        Thread three = new Thread(new three(values, result));
        Thread four = new Thread(new four(values, result));
//start threads
        one.start();
        two.start();
        three.start();
        four.start();
//join thread         
        try{
          one.join();
          two.join();
          three.join();
          four.join();
        }catch (InterruptedException e){
          e.printStackTrace();
        }
        return result;
    }
    //below write the thread class method to run threads.
    public class one implements Runnable{
      int possibleMin = Integer.MAX_VALUE;
      int[] values;
      
      public one(int[] myValues, int result){
        this.values = myValues;
        result = Integer.MAX_VALUE;
      }
      
      public void run(){
        for(int i = 0; i < values.length/2; i++){
          for(int j = 0; j < i; j++){
            if(Math.abs(values[i] - values[j]) < possibleMin) {
              possibleMin = Math.abs(values[i] - values[j]);
            }
            else{
              System.out.println("Approached to Error");
      }
        }
        minimize(possibleMin);
      }
    }
    }
    
    public class two implements Runnable{
      int possibleMin = Integer.MAX_VALUE;
      int[] values;
      
      public two(int[] myValues, int result){
        this.values = myValues;
        result = Integer.MAX_VALUE;
      }
      
      public void run(){
        for(int i = 0; i < values.length/2; i++){
          for(int j = 0; j < i; j++){
            if(Math.abs(values[i] - values[j]) < possibleMin) {
              possibleMin = Math.abs(values[i] - values[j]);
            }
      }
        }
        minimize(possibleMin);
      }
    }
    
    public class three implements Runnable{
      private int possibleMin = Integer.MAX_VALUE;
      int[] values;
      
      public three(int[] myValues, int result){
        this.values = myValues;
        result = Integer.MAX_VALUE;
      }
      
      public void run(){
        for(int i = 0; i < values.length/2; i++){
          for(int j = 0; j < i; j++){
            if(Math.abs(values[i] - values[j]) < possibleMin) {
              possibleMin = Math.abs(values[i] - values[j]);
            }
      }
        }
        minimize(possibleMin);
      }
    }
    
    private class four implements Runnable{
      int possibleMin = Integer.MAX_VALUE;
      int[] values;
      
      public four(int[] myValues, int result){
        this.values = myValues;
        result = Integer.MAX_VALUE;
      }
      
      public void run(){
        for(int i = 0; i < values.length/2; i++){
          for(int j = 0; j < i; j++){
            if(Math.abs(values[i] - values[j]) < possibleMin) {
              possibleMin = Math.abs(values[i] - values[j]);
            }
      }
        }
        minimize(possibleMin);
      }
    }
    
    public void minimize(int i) {
      if(i < result) {
        result = i;
      }
    }
}
