import java.util.UUID;
import java.util.LinkedList;

public class TransactionsLinkedList implements TransactionsList {
  public LinkedList<Transaction> transactions = new LinkedList<>();

  public TransactionsLinkedList(){

  }

  public void addTransaction(Transaction trs){
    transactions.add(trs);
  }

  public void removeTrnsById(UUID id){
    for (Transaction trs : transactions){
      if (trs.getId().equals(id)){
        transactions.remove(trs);
        return;
      }
    }
    throw new TransactionNotFoundException("Invalid ID");
  }
  
  public Object[] toArray() {
    return transactions.toArray();
  }

  public LinkedList<Transaction> getTransactionsLinkedList(){
    return transactions;
  }
  
}
