package fr._42.printer.app;

import fr._42.printer.logic.ReadAndPrint;

public class Main {
  public static void main(String[] args) {
    ReadAndPrint readAndPrint = new ReadAndPrint(args);
    readAndPrint.process();
  }
}
