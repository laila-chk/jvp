import java.util.Scanner;

public class Program {

  public static int[][] getMostFreq(int[] bucket, int len) {
    int ret[][] = new int[10][2];
    int sorted[][] = new int[len][2];
    int k = 0;
    for(int i = 0; i < 65536; i++){
      if(bucket[i] != 0){
        sorted[k][0] = i;
        sorted[k++][1] = bucket[i];
      }
    }
    for (int i = 0; i < len; i++){
      for (int j = 0; j < len - 1; j++) {
        if(sorted[j][1] < sorted[j + 1][1]){
          int tmp = sorted[j][0];
          int tmp1 = sorted[j][1];
          sorted[j][0] = sorted[j + 1][0];
          sorted[j][1] = sorted[j + 1][1];
          sorted[j+1][0] = tmp;
          sorted[j+1][1] = tmp1;
        }
      }
    }
    len = len > 10 ? 10 : len;
    for (int i = 0; i < len; i++){
      ret[i][0] = sorted[i][0];
      ret[i][1] = sorted[i][1];
    }
    return ret;
  }

  public static void printHistogram(int[][] data){
    int[] vals = new int[10];
    for (int i = 0; i < 10; i++)
      vals[i] = (data[i][1] * 10)/data[0][1];

    for (int i = 10; i >= 0; i--){
      for (int j = 0; j < 10; j++){
        if (vals[j] == i){
          if(data[j][1] < 10)
            System.out.print("  ");
          if(data[j][1] > 9 && data[j][1] < 99)
            System.out.print(" ");
          if(data[j][1] > 0)
            System.out.print(" " + data[j][1]);

        }
        else if(vals[j] >= i)
          System.out.print("   #");
      }
      System.out.println("");
    }
    for (int i = 0; i < 10; i++)
      if(data[i][1] > 0)
        System.out.print("   " + (char)data[i][0] );
  }

  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);

    String str = inp.nextLine();
    if(str.equals("")){
      System.err.println("Error! no string was inserted.\nExiting..");
      System.exit(-1);
    }
    int bucket[] = new int[65536];
    for(char c : str.toCharArray()){
      bucket[c]++;
    }
    
    int mostFreq[][] = getMostFreq(bucket, str.length()); 
    printHistogram(mostFreq);

  }
}

