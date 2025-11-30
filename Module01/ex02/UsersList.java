
interface UsersList {
  public void addUser(User newUser);
  public User getUserById(Integer id);
  public User getUserByIndex(Integer index);
  public int getTotalUsers();
}
