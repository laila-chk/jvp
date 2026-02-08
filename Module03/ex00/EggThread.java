import java.util.concurrent.atomic.AtomicInteger;

public class EggThread extends Thread {
  private final AtomicInteger count;

  EggThread(AtomicInteger counter) {
    this.count = counter;
  }
  @Override 
  public void run(){
    int val; 
    while ((val = count.getAndDecrement()) > 0) {
      System.out.println("Egg");
      val--;
    }
  }
}
