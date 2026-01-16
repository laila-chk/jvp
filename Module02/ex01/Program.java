import java.io.*;
import java.util.Vector;
import java.util.Vector;
import java.util.TreeMap;

public class Program {
  public static void getDict(TreeMap<String, Integer> map, File file) {

    try(BufferedReader br = new BufferedReader(new FileReader(file))){
      String line;
      while ((line = br.readLine()) != null){
        String[] words = line.split(" ");
        for (String word : words){
          word = word.trim();
          map.put(word, map.getOrDefault(word, 0) + 1);
        }
      }
    }
    catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
    }
  }

  public static void fillVecs(Vector<Integer> vA, Vector<Integer> vB,
    TreeMap<String, Integer> dict, TreeMap<String, Integer> map) {
    int i = 0;
    for (String k : dict.keySet())
      vB.add(dict.get(k) - map.getOrDefault(k, 0));
    for (String k : dict.keySet())
      vA.add(dict.get(k) - vB.get(i++));
  }

  public static double getSimilarity(Vector<Integer> vA, Vector<Integer> vB){
    int i = -1, numerator = 0;
    int vADenominator = 0, vBDenominator = 0;
    while(++i < vA.size()){
      numerator += vA.get(i) * vB.get(i);
      vADenominator += vA.get(i) * vA.get(i); 
      vBDenominator += vB.get(i) * vB.get(i); 
    }
    if (vADenominator == 0 && vBDenominator == 0)
      return 1;
    if (vADenominator == 0 || vBDenominator == 0)
      return 0;
    double denominator = Math.sqrt(vADenominator) * Math.sqrt(vBDenominator);
    return numerator / denominator;
  }

  public static void main(String[] args) {
    if (args.length != 2){
      System.err.println("Error! bad arguments.\nUsage: java Program inputA.txt inputB.txt.");
      System.exit(1);
    }
    File inpA = new File(args[0]);
    File inpB = new File(args[1]);
    if (!inpA.exists() || !inpA.isFile() || !inpA.canRead()) {
      System.err.println("Error! " + args[0] + " doesn't exist or not a readable file.");
      System.exit(1);
    }

    if (!inpB.exists() || !inpB.isFile() || !inpB.canRead()) {
      System.err.println("Error! " + args[1] + " doesn't exist or not a readable file.");
      System.exit(1);
    }
    TreeMap<String, Integer> dictionary = new TreeMap<>();
    Vector<Integer> vecA = new Vector<>();
    Vector<Integer> vecB = new Vector<>();
    getDict(dictionary, inpA);
    TreeMap<String, Integer> mapA = new TreeMap<>(dictionary);
    getDict(dictionary, inpB);
    try (FileOutputStream fout = new FileOutputStream("dictionary.txt", false)) { 
      for (String key : dictionary.keySet()) {
        String val = key + ": " + dictionary.get(key) + "\n";
        fout.write(val.getBytes());
      }
    } catch (IOException e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
    fillVecs(vecA, vecB, dictionary, mapA);
    System.out.println("Similarity = " + Math.floor(getSimilarity(vecA, vecB) * 100)/100);
  }
}
