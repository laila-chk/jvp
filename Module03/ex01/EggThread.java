import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class EggThread extends Thread {
  private final AtomicInteger count;
  BlockingQueue<Integer> ticket;

  EggThread(AtomicInteger counter, BlockingQueue<Integer> ticket) {
    this.count = counter;
    this.ticket = ticket;
  }
  @Override 
  public void run(){
    try {
      while (count.get() > 0) {
        ticket.put(1);
        System.out.println("Egg");
        count.decrementAndGet();
      }
    } catch (Exception e) {
      System.err.println("Error occured! " + e.getMessage());
    }
  }
}
