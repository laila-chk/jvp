//this is a singleton

public class UserIdsGenerator {
  private static final UserIdsGenerator Instance = new UserIdsGenerator();
  private Integer lastId;

  private UserIdsGenerator() {
    lastId = 1;
  }

  public static UserIdsGenerator getInstance() {
    return Instance;
  }

  public Integer generateId() {
    return lastId++;
  }
}
