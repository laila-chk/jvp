import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
  public Transaction head;
  private int size;

  public TransactionsLinkedList(){}

  public void addTransaction(Transaction trs){
    if (head == null){
      head = trs;
      size = 1;
      return;
    }
    Transaction tr = head;
    while(tr.getNext() != null)
      tr = tr.getNext();
    tr.setNext(trs);
    size++;
  }

  public Transaction getTrnsById(UUID id){
    Transaction tr = this.head;
    while (tr != null){
      if (tr.getId().equals(id)){
        return new Transaction(tr);
      }
      tr = tr.getNext();
    }
    throw new TransactionNotFoundException("Invalid UUID");
  }

  public void removeTrnsById(UUID id){
    if(this.head == null)
      return;
    if(this.head.getId().equals(id)){
      head = head.getNext();
      size--;
      return;
    } 
    Transaction prev = this.head;
    Transaction tr = this.head.getNext();
    while (tr != null){
      if (tr.getId().equals(id)){
        prev.setNext(tr.getNext());
        size--;
        return;
      }
      prev = prev.getNext();
      tr = tr.getNext();
    }
    throw new TransactionNotFoundException("Invalid ID");
  }
  
  public Transaction[] toArray() {
    Transaction[] ret = new Transaction[size];
    Transaction tr = head;
    int i = 0;
    while(tr != null){
      ret[i++] = tr;
      tr = tr.getNext();
    }
    return ret;
  }

  public TransactionsLinkedList getTransactionsLinkedList(){
    return this;
  }
  
  public Transaction getHead() {
    return head;
  }

  public void setHead(Transaction head) {
    this.head = head;
  }

  public int getSize() {
    return size;
  }
}
