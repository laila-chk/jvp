
public class UsersArrayList implements UsersList {
  private User[] users = new User[10];
  private int size = 0;
  private int capacity = 10;

  public void addUser(User newUser){
    if(size == capacity){
      User[] tmp = new User[size + size/2];
      for (int i = 0; i < size; i++)
        tmp[i] = users[i];
      users = tmp;
      capacity = size + size/2;
    }
    users[size++] = newUser;
  }

  public User getUserById(Integer id){
    for (int i = 0; i < size; i++){
      if (users[i].getId().equals(id))
        return users[i];
    }
    throw new UserNotFoundException("User ain't here ha!");
  }
  
  public User getUserByIndex(Integer index){
    return users[index];
  }

  public int getTotalUsers(){
    return size;
  }

  public User[] getUsers(){
    User[] tmp = new User[size];
    for (int i = 0; i < size; i++)
      tmp[i] = users[i];
    return tmp;
  }

  public UsersArrayList(){

  }

}
