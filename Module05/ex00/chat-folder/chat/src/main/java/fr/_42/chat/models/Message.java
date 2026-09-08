package main.java.fr._42.chat.models;

import java.time.OffsetDateTime;

@Entity
@Table(name = "messages")
public class Message {

  @Id
  private long id;
  private User author;
  private Room room;
  private String text;
  private OffsetDateTime timeSent;

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public User getAuthor() {
    return author;
  }
  public void setAuthor(User author) {
    this.author = author;
  }
  public Room getRoom() {
    return room;
  }
  public void setRoom(Room room) {
    this.room = room;
  }
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }
  public OffsetDateTime getTimeSent() {
    return timeSent;
  }
  public void setTimeSent(OffsetDateTime timeSent) {
    this.timeSent = timeSent;
  }

}
