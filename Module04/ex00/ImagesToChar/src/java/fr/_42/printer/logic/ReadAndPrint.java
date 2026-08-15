package fr._42.printer.logic;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class ReadAndPrint {
  //param constr with at=rgs
  private String[] args;
  private String whitePixel;
  private String blackPixel;

  public ReadAndPrint(String[] args){
    this.args = args;
    this.whitePixel = args[0];
    this.blackPixel= args[1];
  }

  public void process() {
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
              System.out.print(whitePixel);
            else
              System.out.print(blackPixel);
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
