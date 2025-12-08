import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    if(args.length != 1){
      System.err.println("Error! missing parameter, please use:\n    --profile=prod (for production Mode)\nOr:\n    --profile=dev (for developement Mode)");
      return;
    }
    if (!args[0].equals("--profile=dev") && !args[0].equals("--profile=prod")){
      System.err.println("Error! unknown flag, please use:\n\n    --profile=prod (for production Mode)\nOr:\n    --profile=dev (for developement Mode)");
      return;
    }
    String mode = args[0].equals("--profile=prod") ? "prod" : "dev";

    String[] menu = {
      "Add a user",
      "View user balances",
      "Perform a transfer",
      "View all transactions for a specific user",
      "DEV - remove a transfer by ID",
      "DEV - check transfer validity",
      "Finish execution"
    };

    Scanner sc = new Scanner(System.in);
    Menu myMenu = new Menu();

    try {
      while (true){
        for (int i = 0; i < menu.length; i++) {
          if (i == 4 && mode.equals("prod")){
            System.out.println((i + 1) + ". " + menu[i+2]);
            break;
          }
          System.out.println((i + 1) + ". " + menu[i]);
        }
        try {
          int option = sc.nextInt();
          if (option == 7 || (option == 5 && mode.equals("prod")))
            break;
          myMenu.menuOption(option);
        }
        catch (Exception e) {
          System.err.println("Invalide Menu Input!");
          sc.nextLine();
        }
        System.out.println("---------------------------------------------------------");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }
}
