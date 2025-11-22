public class Program {
  public static void main(String[] args) {
    User john  = new User(1, "John");
    System.out.println("the user named: " + john.getName() + " his Id: "+ john.getId());
    System.out.println(john.getName() + " have a balance of: " + john.getBalance());
    System.out.println("John is fucking poor unfortunatly, let's make him rich, abraka dabra~!");
    john.setBalance(1);
    System.out.println("his new balance is: " + john.getBalance());
    System.out.println("YaaaY~! He can buy 1 coffee for his date <3, and Go back to being poor");

    User jake = new User("Jake");
    jake.setBalance(1000);
    System.out.println(jake.getName() + " have a balance of: " + jake.getBalance());
    System.out.println("because he had logtime, john wants to borrow money from jake\njake sent 50dh");
    Transaction trs = new Transaction();
    trs = jake.transfer(john, 50);
    System.out.println("Transaction details:\n+-------------------+");
    trs.printTransactionDetails();
    System.out.println("+-------------------+");
    
  }
}
