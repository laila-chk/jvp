import java.util.UUID;

public class TransactionsService {
  private UsersList users = new UsersArrayList();

  private TransactionsLinkedList allTrns = new TransactionsLinkedList();

  public TransactionsService() {}

  public UsersList getTrnsServUsers() {
    return users;
  }

  public void addUser(User user) {
    users.addUser(user);
  }

  public Integer getUserBalanceById(Integer id){
    return users.getUserById(id).getBalance();
  }

  public Integer getUserBalanceByUser(User user){
    return user.getBalance();
  }

  public void transfer(Integer senderId, Integer recipientId, Integer amount){
    if (amount <= 0){
      System.err.println("Error! amount should be bigger than 0.");
      return;
    }
    if (senderId.equals(recipientId)){
      System.err.println("Error! sender and recipient shouldn't be the same User.");
      return;
    }

    User sender = users.getUserById(senderId);
    User recipient = users.getUserById(recipientId);
    if(sender.getBalance() < amount)
      throw new IllegalTransactionException("sender's balance is not sufficiant");
    sender.setBalance(sender.getBalance() - amount);
    recipient.setBalance(recipient.getBalance() + amount);

    Transaction trs = new Transaction();
    trs.setTransactionDetails(sender, recipient, amount);
    recipient.getTransactions().addTransaction(trs);

    Transaction senderTrns = new Transaction(trs);
    senderTrns.setTransactionDetails(sender, recipient, -1*amount);
    sender.getTransactions().addTransaction(senderTrns);
    allTrns.addTransaction(new Transaction(trs));
    allTrns.addTransaction(new Transaction(senderTrns));
  }

  public Transaction[] getTransactionsByUser(User user){
    return user.getTransactions().toArray();
  }

  public Transaction[] getTransactionsByUserId(Integer id){
    return users.getUserById(id).getTransactions().toArray();
  }

  public void removeTrsByIds(UUID transactionId, Integer userId){
    users.getUserById(userId).getTransactions().removeTrnsById(transactionId);
    allTrns.removeTrnsById(transactionId);
  }


  public Transaction[] checkValidity() {
    TransactionsLinkedList trs = new TransactionsLinkedList();
    Transaction tr = allTrns.getHead();
    if(tr != null && tr.getNext() == null){
      trs.addTransaction(new Transaction(tr));
      return trs.toArray();
    }
    while(tr != null){
      System.out.println("ig hna");
      if(!tr.getId().equals(tr.getNext().getId())){
        trs.addTransaction(new Transaction(tr));
        tr = tr.getNext();
      }
      else { // the case of the same id but diff data (sender/amount..)
        // we need to skip twice to skip trs with same IDs.
        if(!tr.getRecipient().equals(tr.getNext().getRecipient()) || 
            !tr.getSender().equals(tr.getNext().getSender()) ||
            tr.getCategory().equals(tr.getNext().getCategory()) ||
            !tr.getAmount().equals(-1 * tr.getNext().getAmount())) {
              trs.addTransaction(new Transaction(tr));
          }
          tr = tr.getNext();
          if (tr == null)
            break;
          tr = tr.getNext();
      }
    }
    return trs.toArray();
  }



}
