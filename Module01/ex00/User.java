import java.util.UUID;
import java.util.Random;

//Integer, String, UUID, enumerations

public class User {
  // private UUID id;
  private Integer id;
  private String name;
  private Integer balance;

  public Integer getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public Integer getBalance() {
    return this.balance;
  }
  
  public void setBalance(Integer newBalance) {
    this.balance = newBalance;
  }
  
  public User(String userName){
    Random rn = new Random();
    this.id = rn.nextInt(1000);
    this.name = userName;
    this.balance = 0;
  }

  public User(Integer userId, String userName){
    this.id = userId;
    this.name = userName;
    this.balance = 0;
  }

  public Transaction transfer(User receiver, Integer amount) {
    Transaction trns = new Transaction();
    if(amount <= 0)
      System.out.println("please Enter a valid amount");

    else if (this.getBalance() < amount)
      System.out.println("Unable to transfer this amount, please make sure that the sender have enough balance!");

    else {
      this.setBalance(this.getBalance() - amount);
      receiver.setBalance(receiver.getBalance() + amount);
      trns.setTransactionDetails(this, receiver, amount);
    }
    return trns;
  }
}
