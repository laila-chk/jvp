import java.util.concurrent.atomic.AtomicInteger;

public class HenTask implements Runnable {

  private final AtomicInteger count;

  HenTask(AtomicInteger counter) {
    this.count = counter;
  }
  @Override
  public void run() {
    int val; 
    while ((val = count.getAndDecrement()) > 0){
      System.out.println("Hen");
      val--;
    }
  }
}
