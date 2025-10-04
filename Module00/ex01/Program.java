import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int i = 2;

    if (num <= 1){
      System.err.println("IllegalArgument");
      sc.close();
      System.exit(-1);
    }

    //we could've used an int initilsed by 1 to count the number of iterations
    //but we have i initilsed with 2 so it is wiser to use it ¯\_(ツ)_/¯
    while (i * i <= num) {
      if (num % i == 0) {
        System.out.println("false " + (i-1));
        break;
      }
      i++;
    }
    System.out.println("true " + (i-1));

    sc.close();
    
  }
}
