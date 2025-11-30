public class Program {
  public static void main(String[] args) {
    User jake = new User("Jake");
    User fen = new User("Fen");
    User lemongrab = new User("Lemongrab"); //will not be added just to modify IDs

    UsersArrayList database = new UsersArrayList();
    database.addUser(jake);
    database.addUser(fen);
    database.addUser(new User("Marceline"));
    database.addUser(new User("Bubble"));
    System.out.println("printing all users ..");
    for (User u : database.getUsers())
      System.out.println(" .Name: " + u.getName() + " - ID: " + u.getId());
    System.out.println("getting users by IDs ..");
    for (int i = 0; i < 10; i++){
      try {
        System.out.println("user of ID " + i + " is: " + database.getUserById(i).getName());
      } catch (Exception e) {
        System.out.println("Ooops Bad ID! Exception says: "+ e.getMessage());
        if(i >= database.getTotalUsers())
          break;
      }
    }
    System.out.print("We can use Indexs as well, for example user of index 2 is: ");
    System.out.println(database.getUserByIndex(2).getName());

  }
}
