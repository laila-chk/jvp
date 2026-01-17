import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.*;

public class Program {
  public static String argsValidator(String[] args) {
    if (args.length != 1){
      System.err.println("Error!\nUsage: java Program --current-folder=/current/folder/absolute/path");
      System.exit(1);
    }
    if(!args[0].startsWith("--current-folder")){
      System.err.println("Error! flag: --current-folder is missing!");
      System.exit(1);
    }
    String[] splitedArg = args[0].split("=");
    if (splitedArg.length < 2){
      System.err.println("Error! please provide absolute path\nUsage: java Program --current-folder=/current/folder/path");
      System.exit(1);
    }
    String wd = System.getProperty("user.dir");
    if(!wd.equals(splitedArg[1])){
      System.err.println("Error! Wrong path idiot.");
      System.exit(1);
    }
    System.out.println(wd);
    return wd;
  }
  public static void main(String[] args) {
    String path = argsValidator(args);
    String line;
    Scanner sc = new Scanner(System.in);
    File file = new File(path);
    while (sc.hasNextLine()) {
      line = sc.nextLine();
      if (line.trim().equals("exit"))
        System.exit(0);
      else if (line.trim().equals("ls")){
        String[] files = file.list();
        for (String s : files)
          System.out.println(s + " " + Math.floor((float)(new File(path+"/"+s).length()) / 100) /10 + " KB");
      }
      // cd ../folder2
      else if(line.trim().startsWith("cd")){
        String[] splitedCd = line.split(" ");
        if(splitedCd.length != 2){
          System.err.println("Invalide command!");
        }else {
          if(!Files.exists(Paths.get(path, splitedCd[1].trim()))){
            System.err.println("Bad path! please enter a correct relative path.");
          }else{
            System.err.println("path was : " + path);
            file = Paths.get(path, splitedCd[1].trim()).normalize().toFile();
            path = file.getAbsolutePath();
            System.err.println("hurraaay new path: " + path);
          }
        }
        
      }
    }
  }
}
