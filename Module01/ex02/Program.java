public class Program {
  public static void main(String[] args) {
    User jake = new User("Jake");
    User fen = new User("Fen");

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
        System.out.println("user of ID " + i + " is: " + database.getUserById(i).getId());
      } catch (Exception e) {
        System.out.println("Oops out of range! Exception says: "+ e.getMessage());
        break;
      }
    }
    System.out.print("We can use Indexs as well, for example user of index 2 is: ");
    System.out.println(database.getUserByIndex(2).getName());

  }
}
