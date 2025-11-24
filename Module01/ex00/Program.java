public class Program {
  public static void main(String[] args) {
    User darwen  = new User("Darwen");
    User gumball = new User("Gumball");
    Transaction Gtrs = new Transaction();
    Transaction Dtrs = new Transaction();

    System.out.println(darwen.getName() + " and " + gumball.getName() + " finally opened a bank account");
    System.out.println("their hardcoded ids are: " + darwen.getId() + " and " + gumball.getId());
    System.out.println("Gumball tried to send money from his empty account:");
    Gtrs = Dtrs.send(gumball, darwen, 10); 
    System.out.println("\nNicol gifted Gumball 50$ so he can send Money to his Bro!");
    gumball.setBalance(50);
    Gtrs = Dtrs.send(gumball, darwen, 10); 
    System.out.println("\nTransaction Details, On 1st account:\n---------------------------------------------");
    Gtrs.printTransactionDetails();
    System.out.println("---------------------------------------------");
    System.out.println("\nTransaction Details, On 2st account:\n---------------------------------------------");
    Dtrs.printTransactionDetails();
    System.out.println("---------------------------------------------");
    System.out.println("\nThe new Balances for Darwen and Gumball are: ");
    System.out.println(darwen.getBalance() + "$ in Darwen's account");
    System.out.println(gumball.getBalance() + "$ in Gumball's account");

  }
}
