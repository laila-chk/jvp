import java.util.Scanner;
import java.io.*;
import java.util.HashMap;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HexFormat;

import java.io.FileInputStream;
public class Program {

  public static String processFile(String path) {
    try (FileInputStream fis = new FileInputStream(path)) {
      int ch;
      StringBuilder sb = new StringBuilder();

      int i = 0;
      while ((ch = fis.read()) != -1 && i++ < 16)
        sb.append(String.format("%02X ", ch & 0xFF));
      if(i == 0){
        System.err.println("Error! file doens't have a signature!");
        return "";
      }
      return sb.toString();
    } catch (FileNotFoundException e) {
      System.err.println("Error! File does not exist. make sure the given path is correct.");
    } 
    catch (IOException e){
      System.out.println("An error occurred while reading the file!");
      System.err.println("Details: " + e.getMessage());
    }
    return "";
  }

  public static HashMap<String, String> getSignatures() {
    try (BufferedReader reader =
    Files.newBufferedReader(Paths.get("signatures.txt"))) {

      HashMap<String, String> sigMap = new HashMap<>();
      String line;
      while ((line = reader.readLine()) != null) {
        String[] vals= line.split(",");
        sigMap.put(vals[0], vals[1].trim());
      }
      if (sigMap.size() < 9){
        System.err.println("Error! signatures file shall contain at least 10 different formats.");
        System.exit(1);
      }
      return sigMap;
    } catch (IOException e){
      System.err.println("Error! signatures.txt Not found.");
      System.exit(1);
    }
    return null;
  }

  public static void getType(String signature, HashMap<String, String> sigMap) {
    for (String val : sigMap.keySet()){
      String sig = sigMap.get(val);
      for(int i = 0; i < sig.length() ; i++){
        if(sig.charAt(i) != signature.charAt(i) && sig.charAt(i) != '?')
          break;
        if(i == sig.length() - 1) {
          System.out.println("PROCESSED");
          String wd = System.getProperty("user.dir");
          try (FileOutputStream fout = new FileOutputStream("result.txt", true)) { 
            val += "\n";
            fout.write(val.getBytes());
          } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
          }
          return;
        }
      }
    }
    System.err.println("Error! No matching signature in signatures.txt ¯\\_(ツ)_/¯." );
  }

  public static void main(String[] args) {
    HashMap<String, String> sigMap = getSignatures();
    String signature = "", path;
    Scanner sc = new Scanner(System.in);
    while (true){
      if (!sc.hasNextLine())
        break;
      path = sc.nextLine();
      if(path.equals("42"))
        break;
      signature = processFile(path);
      if(!signature.equals("")) {
        getType(signature, sigMap);
      } 
    }
    sc.close();
  }
}
