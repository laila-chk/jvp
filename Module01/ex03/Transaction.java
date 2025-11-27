import java.util.UUID;

public class Transaction {
  enum categ{
    debit,
    credit;
  }

  private UUID id;
  private User recipient;
  private User sender;
  private categ category;
  private Integer amount;

  public Transaction(){
    id = UUID.randomUUID();
  }

  public UUID getId(){
    return this.id;
  }

  public User getRecipient() {
    return this.recipient;
  }

  public User getSender() {
    return this.sender;
  }

  public categ getCategory() {
    return this.category;
  }

  public Transaction getTransaction(){
    return this;
  }

  public void printTransactionDetails(){
    System.out.println("id: "+ this.id +"\nsender: " + this.sender.getName() + "\nrecipient: " +
    this.recipient.getName() + "\namount: " + this.amount + "\ncategory: " + this.category);
  }

  //credit = money out; debit = money in
  public void setTransactionDetails(User sender, User recipient, Integer amount) {
    this.sender = sender;
    this.recipient = recipient;
    if(amount > 0){
      this.amount = amount;
        this.category = categ.debit;
    } else {
      this.amount = -1 * amount;
      this.category = categ.credit;
    }
  }

  public Transaction send(User sender, User recipient, Integer amount){
    Transaction trs = new Transaction();

    if(amount <= 0){
      System.err.println("Transaction Failed ! \nplease try a valid amount.");
      return null;
    }

    else if (sender.getBalance() < amount){
      System.err.println("Transaction Failed! \nNot enough Balance for this action.");
      return null;
    }

    else {
      sender.setBalance(sender.getBalance() - amount);
      recipient.setBalance(recipient.getBalance() + amount);
      this.setTransactionDetails(sender, recipient, amount);
      trs.setTransactionDetails(sender, recipient, amount * -1);
      System.out.println("Transaction [" + this.getId() + "] successful!");
    }

    return trs;
  }

}
