public class Program {
  public static void main(String[] args) {
    User jake = new User("Jake");
    User fen = new User("Fen");
    User lemongrab = new User("Lemongrab");
    User marceline = new User("Marceline");
    User bubble = new User("Bubble");

    TransactionsService database = new TransactionsService();
    database.addUser(jake);
    database.addUser(fen);
    database.addUser(lemongrab);
    database.addUser(bubble);
    database.addUser(marceline);

    jake.setBalance(90);
    Integer jakeB = database.getUserBalanceByUser(jake);
    System.out.println("jake have : " + jakeB);
    database.transfer(jake.getId(), lemongrab.getId(), 10);
    database.transfer(jake.getId(), marceline.getId(), 10);
    database.transfer(jake.getId(), 3, 10);
    // database.transfer(jake.getId(), fen.getId(), 10);
    // database.transfer(jake.getId(), fen.getId(), 10);
    // database.transfer(jake.getId(), fen.getId(), 10);
    // database.transfer(jake.getId(), bubble.getId(), 10);

    jakeB = database.getUserBalanceByUser(jake);
    System.out.println(" now jake have : " + jakeB);
    Integer fennB = database.getUserBalanceByUser(fen);
    System.out.println(" and fenn have : " + fennB);

    Transaction[] jtrs = jake.getTransactions().toArray();

    for(Transaction tr : jtrs){
      tr.printTransactionDetails();
      System.out.println("++++++++++++++++++++++++++++++");
    }
    
    System.out.println("__________________________________________");
    database.removeTrsByIds(jake.getTransactions().getHead().getId(), jake.getId());
    Transaction[] ftrs = database.checkValidity();

    jtrs = jake.getTransactions().toArray();
    for(Transaction tr : jtrs){
      tr.printTransactionDetails();
      System.out.println("++++++++++++++++++++++++++++++");
    }
    System.out.println("__________________________________________");
    for(Transaction tr : ftrs)
      tr.printTransactionDetails();
    System.out.println("__________________________________________");

  }
}
