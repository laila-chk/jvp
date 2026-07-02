public class MyRunnable implements Runnable {

  private int start, end;
  private int[] arr;
  private int totalSum;

  MyRunnable(int start, int end, int[] arr, int totalSum) {
    this.start = start;
    this.end = end;
    this.arr = arr;
    this.totalSum = totalSum;
  }

  @Override
  public void run() {
    int sum = 0;
    int i = 0;
    while (start + i <= end ) {
      sum += arr[start + i];
      i++;
    }
    System.out.println(Thread.currentThread().getName() +": from " + start +" to "+ end +" sum is " + sum);

    synchronized(this){
      totalSum += sum;
      System.out.println(totalSum + "**");
    }
  }
  
}
