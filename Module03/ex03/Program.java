import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Program {
  public static int getThreadsCount(String[] args){
    int count = 0;
    if (args.length != 1){
      System.err.println("Error!\nUsage: 'java Program.java --threadsCount=3'");
      System.exit(1);
    }
    try {
      if(!args[0].startsWith("--threadsCount=")) 
        throw new Exception("bad arg");
      count = Integer.parseInt(args[0].split("=")[1]);
    } catch (Exception e) {
      System.err.println("Error!\nUsage: 'java Program.java --threadsCount=3'");
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

  }
}
