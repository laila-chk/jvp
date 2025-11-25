import java.util.ArrayList;
//mentioned: Nested ArrayList<T>, does that mean we should stupidely
//store the users in an array and the users data in an array inside it?

public class UsersArrayList implements UsersList {
  private ArrayList<User> users = new ArrayList<>(10);

  public void addUser(User newUser){
    users.add(newUser);
  }

  public User getUserById(Integer id){
    for (User u : users){
      if (u.getId().equals(id))
        return u;
    }
    throw new UserNotFoundException("User ain't here ha!");
  }
  
  public User getUserByIndex(Integer index){
    return users.get(index);
  }

  public Integer getTotalUsers(){
    return users.size();
  }

  public ArrayList<User> getUsers(){
    return users;
  }

}
