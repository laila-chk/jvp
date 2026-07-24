
public class Program {
  public static void main(String[] args) {
    if (args.length != 1){
      System.err.println("Error!\nUsage: 'java Program.java --threadsCount=3'");
      System.exit(1);
    }
    try {
      if(!args[0].startsWith("--threadsCount=")) 
        throw new Exception("bad arg");
        Integer.parseInt(args[0].split("=")[1]);
    } catch (Exception e) {
      System.err.println("Error!\nUsage: 'java Program.java --threadsCount=3'");
      System.exit(1);
    }
  }
}
