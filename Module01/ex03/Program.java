import java.util.LinkedList;

public class Program {
  public static void main(String[] args) {

    User jake = new User("Jake");
    User fen = new User("Fen");
    User lemongrab = new User("Lemongrab");
    User marceline = new User("Marceline");
    System.out.println(">Jake Found a Treasure");
    jake.setBalance(20);
    System.out.println(">[+20 coins] in Jake's Balance");
    System.out.println("> Jake is so generous so he decided to share!");


    TransactionsLinkedList trsList = jake.getTransactions();
    Transaction trs = new Transaction();

    trs.send(jake, fen, 7);
    System.out.println(">Jake gifted fen 7 coins");
    trsList.addTransaction(trs);
    trs = new Transaction();

    trs.send(jake, marceline, 3);
    System.out.println(">Jake gifted Marceline 3 coins");
    trsList.addTransaction(trs);
    trs = new Transaction();
    
    System.out.println(">Jake tried to gift Lemongrab 0 coins");
    trs.send(jake, lemongrab, 0);
    System.out.println(">Jake tried to gift Lemongrab -1 coins");
    trs.send(jake, lemongrab, -1);
    System.out.println(">Jake screamed: screw you Lemongrab! you don't deserve a penney! but here's One >:(");
    trs.send(jake, lemongrab, 1);
    trsList.addTransaction(trs);
    
    LinkedList<Transaction> transactionsLinkedList = jake.getTransactions().getTransactionsLinkedList();

    for (Transaction tr : transactionsLinkedList ){
      System.out.println("----------------------------------------");
      tr.printTransactionDetails();
    }
  }
}
