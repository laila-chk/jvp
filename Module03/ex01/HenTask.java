import java.util.concurrent.atomic.AtomicInteger;

public class HenTask implements Runnable {

  private final AtomicInteger count;

  HenTask(AtomicInteger counter) {
    this.count = counter;
  }
  @Override
  public void run() {
    while (count.getAndDecrement() > 0){
      System.out.println("Hen");
    }
  }
}
