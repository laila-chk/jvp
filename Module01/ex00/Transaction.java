import java.util.UUID;

public class Transaction {
//  • Identifier
//  • Recipient (User type)
//  • Sender (User type)
//  • Transfer category (debits, credits)
//  • Transfer amount

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

  public void setTransactionDetails(User sender, User recipient, Integer amount) {
    this.sender = sender;
    this.recipient = recipient;
    this.amount = amount;
    this.category = categ.debit;
  }

}
