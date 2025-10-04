import java.util.Scanner;


public class Program {

  public static int sumDigits(int digit){
    int res = 0;

    while (digit > 0){
      res += digit % 10;
      digit /= 10;
    }
    return res;
  }

  public static boolean isPrime(int num){
    int i = 2;

    while (i * i <= num) {
      if (num % i == 0) {
        return false;
      }
      i++;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = 0;
    int coffees = 0;

    while (num != 42){
      num = sc.nextInt();
      if(isPrime(sumDigits(num)))
        coffees++;
    }

    System.out.println("Count of coffee-request : " + coffees);

    sc.close();
  }
}
