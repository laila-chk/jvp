
public class MyRunnable implements Runnable {

  private int count;

  MyRunnable(int counter) {
    this.count = counter;
  }

  @Override
  public void run() {
    while (count > 0){
      synchronized(this){
        count--;
        System.out.println(Thread.currentThread().getName());
      }
      try {
        Thread.sleep(200); 
      } catch (InterruptedException e) {
        System.err.println("The sleep was interrupted.");
      }

    }
  }
}
