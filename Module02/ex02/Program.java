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
    Path path = Paths.get(splitedArg[1].trim());
    if(!Files.exists(path) || !Files.isDirectory(path)){
      System.err.println("Invalide directory!");
      System.exit(1);
    }
    System.out.println(splitedArg[1].trim());
    return splitedArg[1].trim();
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
      else if(line.trim().startsWith("cd ")){
        String[] splitedCd = line.split(" ");
        if(splitedCd.length != 2){
          System.err.println("Invalide command!");
        }else {
          if(!Files.exists(Paths.get(path, splitedCd[1].trim()))){
            System.err.println("Bad path! please enter a correct relative path.");
          }else{
            file = Paths.get(path, splitedCd[1].trim()).normalize().toFile();
            path = file.getAbsolutePath();
            System.err.println(path);
          }
        }
        
      }else if(line.trim().startsWith("mv ")){
        String[] splitedMv = line.split(" ");
        if (splitedMv.length != 3){
          System.err.println("mv: missing parameter\nUsage: mv WHAT WHERE");
        }else{
          Path path1 = Paths.get(path, splitedMv[1].trim());
          Path path2 = Paths.get(path, splitedMv[2].trim());
          if(!Files.exists(path1))
            System.err.println("Error! invalide file: " + splitedMv[1].trim());
          else{
            try {
              if(Files.isDirectory(path2))
                path2 = Paths.get(path, splitedMv[2].trim(), splitedMv[1].trim());
              Files.move(path1, path2);
            } catch (Exception e) {
              System.err.println("Error while using mv command.");
            }
          }
        }
      }
    }
  }
}
