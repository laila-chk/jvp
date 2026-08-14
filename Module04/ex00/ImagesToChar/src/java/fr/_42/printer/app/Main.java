package fr._42.printer.app;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Main {
  public static void main(String[] args) {
    if (args.length != 3){
      System.err.println("Error, Wrong arguments!\nUsage example: java Main . 0 /full/path/to/BMP\n"
        + "for '.' replacing white pixels and '0' replacing black ones");
      System.exit(1);
    }
    try {
      File imgFile = new File(args[2]);
      BufferedImage img = ImageIO.read(imgFile);

      if (img != null) {
        int maxX, maxY;
        maxX = img.getHeight();
        maxY = img.getWidth();
        for (int i = 0; i < maxX; i++){
          for (int j = 0; j < maxY; j++){
            if (img.getRGB(j, i) == -1)
              System.out.print(".");
            else
              System.out.print("0");
          }
          System.out.println("");
        }
      }else {
        System.err.println("Failed to read BMP image!");
        System.exit(1);
      }

    } catch (Exception e) {
        System.err.println("Error! " + e.getMessage());
        System.exit(1);
    }
  }
}
