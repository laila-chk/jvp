import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.Callable;


public class MyCallable implements Callable <String>{

  private String src ;
  private int fileNumber;
  private String fileName;
  
  public MyCallable(String src, int i){
    this.src = src;
    this.fileNumber = i;
    this.fileName = src.substring(src.lastIndexOf('/'));
  }
  @Override
  public String call() {
    System.out.println(Thread.currentThread().getName() + " download file number " + fileNumber);

    try (InputStream inp = new URI(src).toURL().openStream()) {
      Files.copy(inp, Paths.get("Downloads", fileName), StandardCopyOption.REPLACE_EXISTING);
    } catch (Exception e) {
      System.err.println("Error occured while trying to download file number: " + fileNumber);
      System.err.println("Error msg: " + e.getMessage());
    }
    System.out.println(Thread.currentThread().getName() + " finish download file number " + fileNumber);
    return src;
  } 
  
}
