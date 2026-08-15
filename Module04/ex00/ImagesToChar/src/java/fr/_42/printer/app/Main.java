package fr._42.printer.app;

import fr._42.printer.logic.ReadAndPrint;

public class Main {
  public static void main(String[] args) {
    if (args.length != 3){
      System.err.println("Error, Wrong arguments!\nUsage example: java Main . 0 /full/path/to/BMP\n"
        + "for '.' replacing white pixels and '0' replacing black ones");
      System.exit(1);
    }
    ReadAndPrint readAndPrint = new ReadAndPrint(args);
    readAndPrint.process();
  }
}
