import java.util.Scanner;
import java.util.UUID;

public class Menu {
  private TransactionsService trService = new TransactionsService();
  Scanner sc = new Scanner(System.in);

  public TransactionsService getTrService() {
    return trService;
  }

  public void menuOption(int opt){
    switch (opt) {
      case 1:
      while(true){
        try {
          System.out.println("Enter a user name and a balance");
          String userData = sc.nextLine();
          String[] params = userData.split(" ");
          User usr = new User(params[0], Integer.parseInt(params[1]));
          trService.addUser(usr);
          System.out.println("User with id = " + usr.getId() + " is added");
          break;
        } catch (Exception e) {
          System.err.println("Invalid input!");
        }
      }
      break;

      case 2:
        try {
          System.out.println("Enter a user ID");
          Integer userId = sc.nextInt();
          Integer balance = trService.getUserBalanceById(userId);
          String username = trService.getTrnsServUsers().getUserById(userId).getName();
          System.out.println(username + " - " + balance );
        } catch (Exception e) {
          System.err.println("Invalid input!");
          sc.nextLine();
        }
      break;

      case 3:
      try {
        System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
        int senderId = sc.nextInt();
        int recipId = sc.nextInt();
        int amount = sc.nextInt();
        trService.transfer(senderId, recipId, amount);
        System.out.println("The transfer is completed");
        break;
      } catch (Exception e) {
        System.err.println("The transfer failed!");
        sc.nextLine();
      }
      break;


      case 4:
        try {
          System.out.println("Enter a user ID");
          Integer userId = sc.nextInt();
          Transaction[] arr = trService.getTransactionsByUserId(userId);
          for(Transaction tr: arr){
            if(tr.getSender().getId().equals(userId))
              System.out.println("To " + tr.getRecipient().getName() + "(id = " 
                + tr.getRecipient().getId() + ") " + tr.getAmount() +" with id = " 
                + tr.getId());
            else
              System.out.println("From " + tr.getSender().getName() + "(id = " 
                + tr.getSender().getId() + ") " + tr.getAmount() +" with id = " + tr.getId());
          }
          sc.nextLine();
        } catch (Exception e) {
          System.err.println("Invalid ID!");
          sc.nextLine();
        }
      break;

      case 5:
      try {
        System.out.println("Enter a user ID and a transfer ID");
        String line = sc.nextLine();
        String[] ids = line.split(" ");
        Integer uid = Integer.parseInt(ids[0]);
        UUID tid = UUID.fromString(ids[1]);
        Transaction tr = trService.getTrnsServUsers().getUserById(uid).getTransactions().getTrnsById(tid);
        trService.removeTrsByIds(tid, uid);
        if (uid.equals(tr.getSender()))
          System.out.println("Transfer To " + tr.getRecipient().getName() + "(id = " 
            + tr.getRecipient().getId() + ") " + tr.getAmount() +" removed");
        else
          System.out.println("Transfer From " + tr.getSender().getName() + "(id = " 
            + tr.getSender().getId() + ") " + tr.getAmount() +" removed");
        break;
      } catch (Exception e) {
        System.err.println("Invalid input!");
      }
      break;

      case 6:
      try{
        Transaction[] unvalidTrs = trService.checkValidity();
        System.out.println("Check results:");
        if(unvalidTrs.length == 0){
          System.out.println("all Transactions are valid");
          break;
        }
        for (Transaction tr : unvalidTrs){
          System.out.println(tr.getRecipient().getName() + "(id = " 
            + tr.getRecipient().getId() + ") has an unacknowledged transfer id = " 
            + tr.getId() + " from " + tr.getSender().getName() + "(id = " 
            + tr.getSender().getId() + ") for " + tr.getAmount());
        }
      } catch (Exception e) {
        System.err.println("error in case 6: " + e.getMessage());
      } 
      break;

      default:
      System.err.println("Invalide option!");
    }
  }

}
