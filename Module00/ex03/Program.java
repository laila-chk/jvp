// in order to make you apprecite a clipper, 42 decided to make us light fire with rocks.
// the subject stated clearly that arrays aren't allowed, only primitive types and String are:)
import java.util.Scanner;

public class Program {

  public static void printStats(long total) {
    long rev = 0;
    int w = 1;
    while(total > 0){
      rev = rev * 10 + (total % 10);
      total /= 10;
    }
    while (rev > 0){
      System.out.print("Week " + w++ + " ");
      for(int i = (int)(rev % 10); i > 0; i--){
        System.out.print("=");
      }
      rev /= 10;
      System.out.println(">");
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Scanner gr = new Scanner(System.in);
    int grade, minGrade;
    int i = 1;
    long total = 0L;
    while (i <= 18){
      minGrade = 9;
      String week = sc.nextLine();
      if (week.equals("42"))
        break;
      if(!week.equals("Week " + i)){
        System.err.println("IllegalArgument!");
        sc.close();
        System.exit(-1);
      }
      
      //taking grades
      for(int j = 0; j < 5; j++){
        grade = gr.nextInt();
        if (minGrade > grade)
          minGrade = grade;
      }
      total = total * 10 + minGrade;
      i++;
    }
    printStats(total);
    sc.close();
    gr.close();
  }
}

