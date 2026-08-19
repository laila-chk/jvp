package fr._42.printer.logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;


public class ReadAndPrint {
  // private String[] args;
  private String whitePixel;
  private String blackPixel;

  public ReadAndPrint(String[] args){
    // this.args = args;
    if (args.length == 2){
      this.whitePixel = args[0];
      this.blackPixel= args[1];
    } else {
      this.whitePixel ="O";
      this.blackPixel= " ";
    }
  }

  public void process() {
    try {
      String imgPath = System.getProperty("user.dir");
      while (!imgPath.isEmpty() && !imgPath.endsWith("ImagesToChar"))
        imgPath = imgPath.substring(0, imgPath.lastIndexOf("/"));
      imgPath += "/target/resources/image.bmp";

      File imgFile = new File(imgPath);
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
