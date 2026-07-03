public class MyRunnable implements Runnable {

  private int start, end;
  private int[] arr;
  // private int totalSum;
  private final Total total;

  MyRunnable(int start, int end, int[] arr, Total total) {
    this.start = start;
    this.end = end;
    this.arr = arr;
    // this.totalSum = totalSum;
    this.total = total;
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

    synchronized(total){
      total.totalSum += sum;
    }
  }
  
}
