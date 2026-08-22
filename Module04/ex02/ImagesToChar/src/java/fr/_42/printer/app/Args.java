package fr._42.printer.app;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters (separators = "=")
public class Args {

  @Parameter(names = "--white", required = true)
  public String whitePixel;
  
  @Parameter(names = "--black", required = true)
  public String blackPixel;

}
