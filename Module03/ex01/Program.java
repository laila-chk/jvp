
public class Program {
  public static int inptValidator(String[] args) {
    if (args.length != 1){
      System.err.println("Error!\nUsage: java Program --count=50");
      System.exit(1);
    }
    if(!args[0].startsWith("--count=")){
      System.err.println("Error! flag count is mandatory!");
      System.err.println("Usage: java Program --count=50");
      System.exit(1);
    }
    if(args[0].equals("--count=")){
      System.err.println("Error! Value required\nUsage: java Program --count=50");
      System.exit(1);
    }
    StringBuilder sb = new StringBuilder();
    for(int i = "--count=".length(); i < args[0].length(); i++)
    sb.append(args[0].charAt(i));
    int reps = -1; 
    try {
      reps = Integer.parseInt(sb.toString());
    } catch (Exception e) {
      System.err.println("Error! count should be a number greater than 0.");
      System.exit(1);
    }
    if (reps <= 0){
      System.err.println("Error! count should be a number greater than 0.");
      System.exit(1);
    }
    return reps;
  }

  public static void main(String[] args) {
    Integer reps = inptValidator(args);

    MyRunnable runn = new MyRunnable(reps);
    Thread egg = new Thread(runn, "Egg");
    Thread hen = new Thread(runn, "Hen");

    egg.start();
    try {
      Thread.sleep(100); 
    } catch (InterruptedException e) {
      System.err.println("The sleep was interrupted.");
    }
    hen.start();

  }
}
