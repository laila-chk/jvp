
public class Program {
  public static void main(String[] args) {

    int sixdigit = 479598;
    int res = 0;

    if (sixdigit < 0)
      sixdigit *= -1;
    while (sixdigit > 0){
      res += sixdigit % 10;
      sixdigit /= 10;
    }
    System.out.println(res);
  }
}
