import java.util.Random;

import java.util.ArrayList;
public class Program {

  static int arrSize = 0;
  static int threadsCount = 0;

  public static void getParams(String[] args){
    if(args.length != 2 || !args[0].startsWith("--arraySize=") || !args[1].startsWith("--threadsCount=")){
      System.err.println("Error! bad arguments!\nUsage: java Program --arraySize=13 --threadsCount=3");
      System.exit(1);
    }
    if (!(args[0].length() <= "--arraySize=".length() || args[1].length() <= "--threadsCount=".length())){
      int i = 0;
      String[] splitedArg;
      while (i < 2){
        splitedArg = args[i++].split("=");
        if(splitedArg.length != 2 ){
          System.err.println("Error! bad arguments!\nUsage: java Program --arraySize=13 --threadsCount=3");
          System.exit(1);
        }
        try {
          if (i == 1)
          arrSize = Integer.parseInt(splitedArg[1]);
          else
          threadsCount = Integer.parseInt(splitedArg[1]);
        } catch (Exception e){
          System.err.println("Error! arraySize and threadsCount should be a number.");
          System.exit(1);
        }
      }
    }else {
      System.err.println("Error! arraySize and threadsCount should be a number.");
      System.exit(1);
    }
  }

  public static int[] generateArray(){
    int i = 0;
    int[] arr = new int[arrSize];
    Random rand = new Random();
    while (i < arrSize){
      arr[i++] = rand.nextInt(1000);
    }
    return arr;
  }

  public static void main(String[] args) {
    getParams(args);
    Total total = new Total();
    int start = 0, i = 1, sum = 0;
    int[] arr = generateArray();
    ArrayList<Thread> threads = new ArrayList<>();
    for (int n : arr)
      sum += n;
    System.out.println("Sum: " + sum);
    int chunckSize = arrSize / threadsCount;
    boolean lastThread = false;
    while (start + chunckSize <=  arrSize) {
      Thread thread = new Thread(new MyRunnable(start, start + chunckSize, arr, total), "Thread " + i++);
      thread.start();
      threads.add(thread);
      start += chunckSize + 1;
      if(start + chunckSize > arrSize && !lastThread){
        lastThread = true;
        chunckSize = arrSize - start - 1;
      }
    }
    for(Thread th : threads){
      try {
        th.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    System.out.println("Sum by threads: " + total.totalSum);
  }
}
