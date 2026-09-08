package main.java.fr._42.chat.models;

import java.util.ArrayList;

@Entity
@Table(name = "rooms")
public class Room {

  @Id
  private long id;
  private String name;
  private User owner;
  private ArrayList<Message> messages;

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public User getOwner() {
    return owner;
  }
  public void setOwner(User owner) {
    this.owner = owner;
  }
  public ArrayList<Message> getMessages() {
    return messages;
  }
  public void setMessages(ArrayList<Message> messages) {
    this.messages = messages;
  }


}
