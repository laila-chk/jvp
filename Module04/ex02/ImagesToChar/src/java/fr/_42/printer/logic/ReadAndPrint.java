package fr._42.printer.logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import fr._42.printer.app.Args;
import com.beust.jcommander.*;


public class ReadAndPrint {
  private String[] argv;
  // private String whitePixel;
  // private String blackPixel;

  public ReadAndPrint(String[] argv){
    this.argv = argv;
    // if (argv.length == 2){
    //   this.whitePixel = argv[0];
    //   this.blackPixel= argv[1];
    // } else {
    //   this.whitePixel ="O";
    //   this.blackPixel= " ";
    // }
  }

  public void process() {
    Args args = new Args();
    JCommander.newBuilder()
      .addObject(args)
      .build()
      .parse(this.argv);

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
              System.out.print(args.whitePixel);
            else
              System.out.print(args.blackPixel);
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
