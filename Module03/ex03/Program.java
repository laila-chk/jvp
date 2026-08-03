import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class Program {
  public static int getThreadsCount(String[] args){
    int count = 0;
    if (args.length != 1){
      System.err.println("Error!\nUsage: 'java Program.java --threadsCount=3'");
      System.exit(1);
    }
    try {
      if(!args[0].startsWith("--threadsCount=")) 
      throw new Exception();
      count = Integer.parseInt(args[0].split("=")[1]);
      if (count <= 0)
      throw new Exception();
    } catch (Exception e) {
      System.err.println("Error!\nUsage: 'java Program.java --threadsCount=3'\nwith Threads count > 0.");
      System.exit(1);
    }
    return count;
  }

  public static ArrayList<String> getLinks(){
    ArrayList <String> links = new ArrayList<>();

    try (BufferedReader buff = new BufferedReader(new FileReader("files_urls.txt"))) {
      String line;
      while((line = buff.readLine()) != null) 
      links.add(line);
    } catch (Exception e) {
      System.err.println("Error! couldn't read 'files_urls.txt'");
      System.exit(1);
    }
    if(links.isEmpty()){
      System.err.println("Error! No links are available to download from.");
      System.exit(1);
    }
    return links;
  } 

  public static void main(String[] args) {
    int threadsCount = getThreadsCount(args);
    ArrayList <String> links = getLinks();
    ArrayList <MyCallable> tasks = new ArrayList<>();
    new File("Downloads").mkdir();

    ExecutorService executor = Executors.newFixedThreadPool(threadsCount);
    int i = 1;
    for (String s : links)
      tasks.add(new MyCallable(s, i++));
    try {
      List <Future<String>> future = executor.invokeAll(tasks);
    } catch (InterruptedException e) {
      System.err.println("An error occured while download..\n" + e.getMessage());
    } finally {
      executor.shutdown();
    }

  }
}
