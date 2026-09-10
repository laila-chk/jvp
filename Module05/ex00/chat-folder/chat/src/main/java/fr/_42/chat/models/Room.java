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
  //maybe we should add list users of a room?

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

  @Override
  public String toString() {
    return "Room [id = " + id + ", name = " + name + ", owner = " +
      owner + ", messages = " + messages + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Room room = (Room) o;
    return id == room.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
