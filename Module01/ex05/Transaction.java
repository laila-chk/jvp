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
  private Transaction next;

  public Transaction(){
    id = UUID.randomUUID();
    next = null;
  }

  public Transaction(Transaction tr){
    id = tr.getId();
    recipient = tr.getRecipient();
    sender = tr.getSender();
    category = tr.getCategory();
    amount = tr.getAmount();
    next = null;
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
    this.amount = amount;
    if(amount > 0){
      // this.amount = amount;
      this.category = categ.debit;
    } else {
      // this.amount = -1 * amount;
      this.category = categ.credit;
    }
  }

  public Transaction getNext() {
    return this.next;
  }  

  public void setNext(Transaction tr){
    this.next = tr;
  }

  public Integer getAmount() {
    return amount;
  }

}
