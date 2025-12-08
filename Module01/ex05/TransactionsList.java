import java.util.UUID;
import java.util.ArrayList;

interface TransactionsList{

  public void addTransaction(Transaction trs);
  public void removeTrnsById(UUID id);
  public Object[] toArray();
  // public ArrayList<Transaction> toArray();


}
