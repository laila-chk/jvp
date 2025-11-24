import java.util.UUID;
import java.util.Random;

//Integer, String, UUID, enumerations

public class User {
  
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
    this.id = UserIdsGenerator.getInstance().generateId();
    this.name = userName;
    this.balance = 0;
  }

}
