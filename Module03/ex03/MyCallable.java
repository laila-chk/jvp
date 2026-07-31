import java.util.concurrent.Callable;

public class MyCallable implements Callable <String>{

  public String src ;
  public MyCallable(String src){
    this.src = src;
  }
  @Override
  public String call() {
    System.out.println("downloading from " + src +".. by "+ Thread.currentThread().getName());
    System.out.println();
    return src;
  } 
  
}
