public class Program {
  public static void main(String[] args) {
    User jake = new User("Jake");
    User fen = new User("Fen");
    System.out.println("jake and fen are friends, the have the ids: " +jake.getId() + " - " + fen.getId());
  }
}
